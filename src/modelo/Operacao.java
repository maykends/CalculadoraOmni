package modelo;

import java.util.ArrayList;
import java.util.List;

public class Operacao {
	
	// Define os tipos de operaca��o
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
	private boolean substituir = false; // Substituir o n�mero do display ao clicar em uma opera�ao
	private String textoAtual = ""; // texto atual
	private String buffer = ""; // Texto na mem�ria
	
	// Construtor em que controla a criacao dentro da propria classe
	private Operacao() {
	}
	
	// M�todo get, consigo pegar uma �nica instancia que foi criada na classe Opera��o
	public static Operacao getInstancia() {
		return instancia;
	}
	
	public void adicionaObser(Observador observador) {
		observadores.add(observador);
	}

	// M�todo get para pegar o textoAtual no Display
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual; // Se for verdadeiro retorna "0", se n�o, retorna o textoAtual = "" no display
	}
	

	// M�todo que processa as opera��es
	public void processarComando(String texto) {
		
		TipoOperacao tipoOperacao = detectaTipoOperacao(texto);
		System.out.println(tipoOperacao); // Informa o tipoOpera��o no terminal
		
		if(tipoOperacao == null) {
			return; // se n�o digitar nada, ficar� zerado o display
		}else if(tipoOperacao == TipoOperacao.ZERAR) {
			textoAtual = ""; // texto atual ficar� zerado
			buffer = ""; // buffer ficar� zerado
			substituir = false; 
			ultimaOperacao = null;	
			
			// Se clicar uma vez ele tira o sinal
		}else if(tipoOperacao == TipoOperacao.MAISOUMENOS && textoAtual.contains("-")) {
			textoAtual = textoAtual.substring(1); // se conter o sinal de menos, ele retira
			// Caso contr�rio coloca-se o sinal
		}else if(tipoOperacao == TipoOperacao.MAISOUMENOS && !textoAtual.contains("-")) {
			textoAtual = "-" + textoAtual;
		}else if (tipoOperacao == TipoOperacao.NUMERO || tipoOperacao == TipoOperacao.VIRGULA) {
			textoAtual = substituir ? texto : textoAtual + texto; // se ocorrer a linha de cima, o texto atual ser� substituido
			substituir = false;
			// depois daqui, s�o as opera��es
			
		}else {
			substituir = true; // Ao clicar em uma opera��o ele vai passar a calcular o proximo numero
			textoAtual = ResultadoOperacao();
			buffer = textoAtual;
			ultimaOperacao = tipoOperacao;
		}// Primeiro se calcula, o calculo � armazenado em buffer e por fim temos o resultado da ultimaOperacao
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private String ResultadoOperacao() {
		if(ultimaOperacao == null || ultimaOperacao == TipoOperacao.IGUALDADE) {
			return textoAtual; // M�todo retonar uma String, caso a ultima opera��o tenha sido setada, ser� preciso realizar a conver��o
		}
		
//		Aqui � original
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
		
	
//		Falta resumir ou melhorar a troca do ponto pela virgula, seria apenas realizar um m�todo para esse sen�rio
//		String texto = Double.toString(resultado).replace(".", ",");
//		boolean inteiro = texto.endsWith(",0");
//		return inteiro ? texto.replace(",0",""): texto;
		
		String texto = Double.toString(resultado);
		boolean inteiro = texto.endsWith(".0"); // Se o display terminar com .0 quer dizer que � um numero interiro
		return inteiro ? texto.replace(".0",""): texto; // se for interiro, substitui por vazio
	}
	
//	ISOLAMENTO DAS OPERA��ES ARITM�TICAS
	
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

	// Detecta o tipo da opera��o a ser mostrado no display, ou melhor, o tipo de comando, se � n�mero ou opera��es (+, -, *, /....) valorTexto = label do teclado
	private TipoOperacao detectaTipoOperacao(String valorTexto) {
		if(textoAtual.isEmpty() && valorTexto == "0") { // Verifica se o texto atual no display for vazio e igual a zero, ser� uma opera��o nula
			return null;
		}
		try {
			Integer.parseInt(valorTexto);
			return TipoOperacao.NUMERO; // Quando for n�mero do teclado, retorna NUMERO
		} catch(NumberFormatException e) {
			// Quando n�o for n�mero...
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
			}else if("�".equals(valorTexto)) {
					return TipoOperacao.MAISOUMENOS;	
			}else if("=".equals(valorTexto)) {
				return TipoOperacao.IGUALDADE;
			}else if(".".equals(valorTexto) && !textoAtual.contains(".")) { // N�o repete a v�rgula/ponto
//			}else if(",".equals(texto)) { //
				return TipoOperacao.VIRGULA;
			}
		}
		return null; // Quando for nada, sempre ser� nulo
		
	}
	
}
