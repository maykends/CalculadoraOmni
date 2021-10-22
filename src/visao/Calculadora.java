package visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Calculadora extends JFrame{
	
	public Calculadora() {
		
		organizaLayout();
		
		setSize(334, 503);
		// Remove as Barras
		//setUndecorated(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Calculadora");
	}

	private void organizaLayout() {
		setLayout(new BorderLayout());
		
		Display display = new Display();
		display.setPreferredSize(new Dimension(334, 170));
		add(display, BorderLayout.NORTH);
		
		Teclado teclado = new Teclado();
		add(teclado, BorderLayout.CENTER); // rever isso aqui <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<,
		
	}

	public static void main(String[] args) {
		new Calculadora();

	}

}
