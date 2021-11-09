package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{
	
	public Calculadora() {
		
		organizaLayout();
		
		// Dimens�o da aplicac�o
		setSize(334, 503);
		// T�tulo da aplicac�o
		setTitle("Calculadora"); 
		// Encerra aplicac�o
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		// tela central
		setLocationRelativeTo(null); 
		// Apresenta aplica��o
		setVisible(true); 
	}

	private void organizaLayout() {
		setLayout(new BorderLayout());
		
		DisplayCalc display = new DisplayCalc();
		display.setPreferredSize(new Dimension(334, 170));
		add(display, BorderLayout.NORTH);
		
		TecladoCalc teclado = new TecladoCalc();
		add(teclado, BorderLayout.CENTER); 
	}

	public static void main(String[] args) {
		new Calculadora();
	}

}
