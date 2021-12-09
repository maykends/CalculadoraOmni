package modelo;

import java.util.ArrayList;
import java.util.List;

public class Operacao {
	
	// Define os tipos de operacação
	private enum TipoOperacao{
		PORCENTO, 
		ZERAR, 
		NUMERO, 
		DIVISAO, 
		MULTIPLICACAO, 
		SOMATORIO, 
		SUBTRACAO, 
		IGUALDADE, 
		VIRGULA, 
		MAISOUMENOS;
	};

	// Cria uma instancia
	private static Operacao instancia = new Operacao();
	
	// Cria ArrayList dos observadores
	private final List<Observador> observadores = 
			new ArrayList<>(); // Armazena todos os observadores em lista
	
	private TipoOperacao ultimaOperacao = null;
	private boolean substituir = false; // Substituir o número do display ao clicar em uma operaçao
	private String textoAtual = ""; // texto atual
	private String buffer = ""; // Texto na memória
	
	// Construtor em que controla a criacao dentro da propria classe
	private Operacao() {
	}
	
	// Método get, consigo pegar uma única instancia que foi criada na classe Operação
	public static Operacao getInstancia() {
		return instancia;
	}
	
	public void adicionaObser(Observador observador) {
		observadores.add(observador);
	}

	// Método get para pegar o textoAtual no Display
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual; // Se for verdadeiro retorna "0", se não, retorna o textoAtual = "" no display
	}
	

	// Método que processa as operações
	public void processarComando(String texto) {
		
		TipoOperacao tipoOperacao = detectaTipoOperacao(texto);
		System.out.println(tipoOperacao); // Informa o tipoOperação no terminal
		
		if(tipoOperacao == null) {
			return; // se não digitar nada, ficará zerado o display
		}else if(tipoOperacao == TipoOperacao.ZERAR) {
			textoAtual = ""; // texto atual ficará zerado
			buffer = ""; // buffer ficará zerado
			substituir = false; 
			ultimaOperacao = null;	
			
			// Se clicar uma vez ele tira o sinal
		}else if(tipoOperacao == TipoOperacao.MAISOUMENOS && textoAtual.contains("-")) {
			textoAtual = textoAtual.substring(1); // se conter o sinal de menos, ele retira
			// Caso contrário coloca-se o sinal
		}else if(tipoOperacao == TipoOperacao.MAISOUMENOS && !textoAtual.contains("-")) {
			textoAtual = "-" + textoAtual;
		}else if (tipoOperacao == TipoOperacao.NUMERO || tipoOperacao == TipoOperacao.VIRGULA) {
			textoAtual = substituir ? texto : textoAtual + texto; // se ocorrer a linha de cima, o texto atual será substituido
			substituir = false;
			// depois daqui, são as operações
			
		}else {
			substituir = true; // Ao clicar em uma operação ele vai passar a calcular o proximo numero
			textoAtual = ResultadoOperacao();
			buffer = textoAtual;
			ultimaOperacao = tipoOperacao;
		}// Primeiro se calcula, o calculo é armazenado em buffer e por fim temos o resultado da ultimaOperacao
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private String ResultadoOperacao() {
		if(ultimaOperacao == null || ultimaOperacao == TipoOperacao.IGUALDADE) {
			return textoAtual; // Método retonar uma String, caso a ultima operação tenha sido setada, será preciso realizar a converção
		}
		
//		Aqui é original
//		double numeroBuffer = Double.parseDouble(buffer.replace(",", "."));
//		double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));
//		double resultado = 0;
		
		double numeroBuffer = Double.parseDouble(buffer);
		double numeroAtual = Double.parseDouble(textoAtual);
		double resultado = 0;
		
		
		// Primeiro vem o Buffer, depois vem o numero atual
		if (ultimaOperacao == TipoOperacao.SOMATORIO) {
//			resultado = numeroBuffer + numeroAtual;
			resultado = somatorio(numeroBuffer, numeroAtual);
		}else if(ultimaOperacao == TipoOperacao.SUBTRACAO) {
//			resultado = numeroBuffer - numeroAtual;
			resultado = subtracao(numeroBuffer, numeroAtual);
		}else if(ultimaOperacao == TipoOperacao.DIVISAO) {
//			resultado = numeroBuffer / numeroAtual;
			resultado = divisao(numeroBuffer, numeroAtual);
		}else if(ultimaOperacao == TipoOperacao.MULTIPLICACAO) {
//			resultado = numeroBuffer * numeroAtual;
			resultado = multiplicacao(numeroBuffer, numeroAtual);
			}
		
	
//		Falta resumir ou melhorar a troca do ponto pela virgula, seria apenas realizar um método para esse senário
//		String texto = Double.toString(resultado).replace(".", ",");
//		boolean inteiro = texto.endsWith(",0");
//		return inteiro ? texto.replace(",0",""): texto;
		
		String texto = Double.toString(resultado);
		boolean inteiro = texto.endsWith(".0"); // Se o display terminar com .0 quer dizer que é um numero interiro
		return inteiro ? texto.replace(".0",""): texto; // se for interiro, substitui por vazio
	}
	
//	ISOLAMENTO DAS OPERAÇÕES ARITMÉTICAS
	
	// SOMA 
	private Double somatorio(Double numeroBuffer, Double numeroAtual) {
		return numeroBuffer + numeroAtual;
	}
	
	// SUBTRACAO 
	private Double subtracao(Double numeroBuffer, Double numeroAtual) {
		return numeroBuffer - numeroAtual;
	}
	
	// DIVISAO 
	private Double divisao(Double numeroBuffer, Double numeroAtual) {
		return numeroBuffer / numeroAtual;
	}
	
	// MULTIPLICACAO 
	private Double multiplicacao(Double numeroBuffer, Double numeroAtual) {
		return numeroBuffer * numeroAtual;
	}

	// Detecta o tipo da operação a ser mostrado no display, ou melhor, o tipo de comando, se é número ou operações (+, -, *, /....) valorTexto = label do teclado
	private TipoOperacao detectaTipoOperacao(String valorTexto) {
		if(textoAtual.isEmpty() && valorTexto == "0") { // Verifica se o texto atual no display for vazio e igual a zero, será uma operação nula
			return null;
		}
		try {
			Integer.parseInt(valorTexto);
			return TipoOperacao.NUMERO; // Quando for número do teclado, retorna NUMERO
		} catch(NumberFormatException e) {
			// Quando não for número...
			if("%".equals(valorTexto)) {
				return TipoOperacao.PORCENTO;
			}else if("CE".equals(valorTexto)) {
				return TipoOperacao.ZERAR;
			}else if("C".equals(valorTexto)) {
				return TipoOperacao.ZERAR;
			}else if("/".equals(valorTexto)) {
				return TipoOperacao.DIVISAO;
			}else if("X".equals(valorTexto)) {
				return TipoOperacao.MULTIPLICACAO;
			}else if("-".equals(valorTexto)) {
				return TipoOperacao.SUBTRACAO;
			}else if("+".equals(valorTexto)) {
				return TipoOperacao.SOMATORIO;
			}else if("±".equals(valorTexto)) {
					return TipoOperacao.MAISOUMENOS;	
			}else if("=".equals(valorTexto)) {
				return TipoOperacao.IGUALDADE;
			}else if(".".equals(valorTexto) && !textoAtual.contains(".")) { // Não repete a vírgula/ponto
//			}else if(",".equals(texto)) { //
				return TipoOperacao.VIRGULA;
			}
		}
		return null; // Quando for nada, sempre será nulo
		
	}
	
}
