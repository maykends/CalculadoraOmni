package visao;

import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Memoria;
import modelo.MemoriaObservador;

import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador{
	
	private final JLabel label;

	public Display() {
		Memoria.getInstancia().adicionarObservador(this);
		//setBackground(Color.GREEN);
		setBackground(new Color(31,31,31));
		//label = new JLabel("123"); 
		label = new JLabel(Memoria.getInstancia().getTextoAtual()); // vamos substituir por texto atual
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
