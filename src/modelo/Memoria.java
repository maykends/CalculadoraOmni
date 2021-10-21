package modelo;

/**
 * @author mayke
 *
 */
public class Memoria {

	// Criando uma instância
	private static Memoria instancia = new Memoria();
	
	private String textoAtual = ""; 
	
	// Construtor em que controla a criacao dentro da propria classe
	private Memoria() {
	}
	
	// Método get, consigo pegar uma única instancia que foi criada na classe Memoria
	public static Memoria getInstancia() {
		return instancia;
	}

	// Método get para pegar o textoAtual no Display
	public String getTextoAtual() {
		return textoAtual.isEmpty() ? "0" : textoAtual; // Se for verdadeiro retorna "0", se não, retorna o textoAtual = "" no display
	}

	public void setTextoAtual(String textoAtual) {
		this.textoAtual = textoAtual;
	}
	
}
