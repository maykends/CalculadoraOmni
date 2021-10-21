package modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

	// Criando uma instância
	private static Memoria instancia = new Memoria();
	
	private final List<MemoriaObservador> observadores = 
			new ArrayList<>();
	
	private String textoAtual = ""; 
	
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
	
	public void processarComando(String valor) {
		if("CE".equals(valor)) {
			textoAtual = "";
		}else {
			textoAtual += valor;
		}
		
		//textoAtual += valor;
		//observadores.forEach(o -> o.valorAlterado(textoAtual));
		observadores.forEach(o -> o.valorAlterado(getTextoAtual()));
	}
	
}
