package modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
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
	private static Memoria instancia = new Memoria();
	
	private final List<MemoriaObservador> observadores = 
			new ArrayList<>();
	
	private TipoOperacao ultimaOperacao = null;
	private boolean substituir = false; 
	private String textoAtual = ""; 
	private String textoBuffer = "";
	
	// Construtor em que controla a criacao dentro da propria classe
	private Memoria() {
	}
	
	// Método get, consigo pegar uma única instancia que foi criada na classe Memoria
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}

	// Método get para pegar o textoAtual no Display
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual; // Se for verdadeiro retorna "0", se não, retorna o textoAtual = "" no display
	}
	
	public void processarComando(String texto) {
		
		TipoOperacao tipoComando = detectaTipoOperacao(texto);
		System.out.println(tipoComando);
		
		if(tipoComando == null) {
			return;
		}else if(tipoComando == TipoOperacao.ZERAR) {
			textoAtual = "";
			textoBuffer = "";
			substituir = false;
			ultimaOperacao = null;	
		}else if(tipoComando == TipoOperacao.MAISOUMENOS && textoAtual.contains("-")) {
			textoAtual = "-" + textoAtual.substring(1);
		}else if(tipoComando == TipoOperacao.MAISOUMENOS && !textoAtual.contains("-")) {
			textoAtual = "-" + textoAtual;
		}
		
		else if (tipoComando == TipoOperacao.NUMERO
				|| tipoComando == TipoOperacao.VIRGULA) {
			textoAtual = substituir ? texto : textoAtual + texto;
			substituir = false; // depois daqui, são as operações
		}else {
			substituir = true; // Ao clicar em uma operação ele vai passar a calcular
			textoAtual = obterResultadoOperacao();
			textoBuffer = textoAtual;
			ultimaOperacao = tipoComando;
		}
		
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	private String obterResultadoOperacao() {
		if(ultimaOperacao == null 
				|| ultimaOperacao == TipoOperacao.IGUALDADE) {
			return textoAtual;
		}
		
		double numeroBuffer =
				Double.parseDouble(textoBuffer.replace(",", "."));
		double numeroAtual =
				Double.parseDouble(textoAtual.replace(",", "."));
		double resultado = 0;
		
		if (ultimaOperacao == TipoOperacao.SOMATORIO) {
			resultado = numeroBuffer + numeroAtual;
		}else if(ultimaOperacao == TipoOperacao.SUBTRACAO) {
			resultado = numeroBuffer - numeroAtual;
		}else if(ultimaOperacao == TipoOperacao.DIVISAO) {
			resultado = numeroBuffer / numeroAtual;
		}else if(ultimaOperacao == TipoOperacao.MULTIPLICACAO) {
			resultado = numeroBuffer * numeroAtual;
			}
		
		String texto = Double.toString(resultado).replace(".", ",");
		boolean inteiro = texto.endsWith(",0");
		return inteiro ? texto.replace(",0",""): texto;
	}

	// Detecta o tipo da operação 
	private TipoOperacao detectaTipoOperacao(String texto) {
		if(textoAtual.isEmpty() && texto == "0") {
			return null;
		}
		try {
			Integer.parseInt(texto);
			return TipoOperacao.NUMERO;
		} catch(NumberFormatException e) {
			// Quando não for número..
			if("%".equals(texto)) {
				return TipoOperacao.PORCENTO;
			}else if("CE".equals(texto)) {
				return TipoOperacao.ZERAR;
			}else if("C".equals(texto)) {
				return TipoOperacao.ZERAR;
			}else if("/".equals(texto)) {
				return TipoOperacao.DIVISAO;
			}else if("X".equals(texto)) {
				return TipoOperacao.MULTIPLICACAO;
			}else if("-".equals(texto)) {
				return TipoOperacao.SUBTRACAO;
			}else if("+".equals(texto)) {
				return TipoOperacao.SOMATORIO;
			}else if("=".equals(texto)) {
				return TipoOperacao.IGUALDADE;
			}else if(",".equals(texto) && !textoAtual.contains(",")) {
				return TipoOperacao.VIRGULA;
			}else if("±".equals(texto)) {
				return TipoOperacao.MAISOUMENOS;
			}
		}
		return null;
		
	}
	
}
