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

	public DisplayCalc() {
		Operacao.getInstancia().adicionaObser(this);
		setBackground(new Color(31,31,31));
		label = new JLabel(Operacao.getInstancia().getTextoAtual()); // Altera pelo textoAtual
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 45));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 100));
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
		
	}
}
