package modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	// Criando uma inst�ncia
	private static Memoria instancia = new Memoria();
	
	private final List<MemoriaObservador> observadores = 
			new ArrayList<>();
	
	private String textoAtual = ""; 
	
	// Construtor em que controla a criacao dentro da propria classe
	private Memoria() {
	}
	
	// M�todo get, consigo pegar uma �nica instancia que foi criada na classe Memoria
	public static Memoria getInstancia() {
		return instancia;
	}
	
	public void adicionarObservador(MemoriaObservador observador) {
		observadores.add(observador);
	}

	// M�todo get para pegar o textoAtual no Display
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual; // Se for verdadeiro retorna "0", se n�o, retorna o textoAtual = "" no display
	}
	
	public void processarComando(String valor) {
		textoAtual += valor;
		observadores.forEach(o -> o.valorAlterado(textoAtual));
	}
	
}
