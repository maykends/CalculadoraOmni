package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{
	
	// Construtor
	public Calculadora() {
		
		// Chamada da fun��o para organizar o layout
		organizaLayout();
		
		// Dimens�o da aplicac�o (largura x altura)
		setSize(334, 503);
		// T�tulo da aplicac�o
		setTitle("Calculadora"); 
		// Encerra aplicac�o por completo
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		// Abre no centro da tela
		setLocationRelativeTo(null); 
		// Apresenta aplica��o
		setVisible(true); 
	}

	// M�todo para organizar o Layout da aplica��o
	private void organizaLayout() {
		setLayout(new BorderLayout());
	
		// instancia do Display com o BorderLayout
		DisplayCalc display = new DisplayCalc();
		// Define o tamanho do Display
		display.setPreferredSize(new Dimension(334, 170));
		// Centraliza o Display na parte superior da tela
		add(display, BorderLayout.NORTH);
		
		// instancia do Teclado para o BorderLayout
		TecladoCalc teclado = new TecladoCalc();
		// Centraliza o Teclado na parte inferior da tela
		add(teclado, BorderLayout.CENTER); 
	}

	// Chamada do M�todo principal da aplica��o
	public static void main(String[] args) {
		new Calculadora(); // chamada do contrutor
	}

}
