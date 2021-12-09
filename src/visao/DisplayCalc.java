package visao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Operacao;
import modelo.Observador;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class DisplayCalc extends JPanel implements Observador{
	
	private final JLabel label;

	// Construtor da classe
	public DisplayCalc() {
	
		Operacao.getInstancia().adicionaObser(this);
		
		// Define o Background do Display em RGB
		setBackground(new Color(31,31,31));
		
		label = new JLabel(Operacao.getInstancia().getTextoAtual()); // Altera pelo textoAtual
		//label = new JLabel("12345");
		
		// Define cor para o texto
		label.setForeground(Color.WHITE);
		// Define o tipo de fonte, estilo e tamanho
		label.setFont(new Font("Segoe UI", Font.PLAIN, 35));
	
		// Define alinhamento para direita (horiozntal 10 e  vertical 100)
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 100));
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
		
	}
}
