package modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
	
	private enum TipoComando{
		PORCENTO, ZERAR, NUMERO, DIV, MULT, SOMA, SUB, IGUAL, VIRGULA, MAISOUMENOS;
	};

	// Criando uma instância
	private static Memoria instancia = new Memoria();
	
	private final List<MemoriaObservador> observadores = 
			new ArrayList<>();
	
	private TipoComando ultimaOperacao = null;
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
		
		TipoComando tipoComando = detectarTipoComando(texto);
		//System.out.println(tipoComando);
		
		if(tipoComando == null) {
			return;
		}else if(tipoComando == TipoComando.ZERAR) {
			textoAtual = "";
			textoBuffer = "";
			substituir = false;
			ultimaOperacao = null;	
		}else if (tipoComando == TipoComando.NUMERO
				|| tipoComando == TipoComando.VIRGULA) {
			textoAtual = substituir ? texto : textoAtual + texto;
			substituir = false;
		}
		
		//if("CE".equals(texto)|| "C".equals(texto))   {
		//	textoAtual = "";
		//}else {
		//	textoAtual += texto;
		//}
		
		//textoAtual += valor;
		//observadores.forEach(o -> o.valorAlterado(textoAtual));
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}

	// Detecta o tipo de comando
	private TipoComando detectarTipoComando(String texto) {
		if(textoAtual.isEmpty() && texto == "0") {
			return null;
		}
		try {
			Integer.parseInt(texto);
			return TipoComando.NUMERO;
		} catch(NumberFormatException e) {
			// Quando não for número..
			if("%".equals(texto)) {
				return TipoComando.PORCENTO;
			}else if("CE".equals(texto)) {
				return TipoComando.ZERAR;
			}else if("C".equals(texto)) {
				return TipoComando.ZERAR;
			}else if("/".equals(texto)) {
				return TipoComando.DIV;
			}else if("*".equals(texto)) {
				return TipoComando.MULT;
			}else if("-".equals(texto)) {
				return TipoComando.SUB;
			}else if("+".equals(texto)) {
				return TipoComando.SOMA;
			}else if("=".equals(texto)) {
				return TipoComando.IGUAL;
			}else if(",".equals(texto) && !textoAtual.contains(",")) {
				return TipoComando.VIRGULA;
			}else if("±".equals(texto)) {
				return TipoComando.MAISOUMENOS;
			}
		}
		return null;
		
		
	}
	
}
