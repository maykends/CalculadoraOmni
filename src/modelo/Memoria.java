package modelo;

public class Memoria {

	// Criando uma inst�ncia
	private static Memoria instancia = new Memoria();
	
	private String textoAtual = ""; 
	
	// Construtor em que controla a criacao dentro da propria classe
	private Memoria() {
	}
	
	// M�todo get, consigo pegar uma �nica instancia que foi criada na classe Memoria
	public static Memoria getInstancia() {
		return instancia;
	}

	// M�todo get para pegar o textoAtual no Display
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual; // Se for verdadeiro retorna "0", se n�o, retorna o textoAtual = "" no display
	}

	public void setTextoAtual(String textoAtual) {
		this.textoAtual = textoAtual;
	}
	
}
