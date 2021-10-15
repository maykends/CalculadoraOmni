package visao;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Botao extends JButton{
	
	public Botao(String texto, Color cor) {
		setText(texto);
		setOpaque(true); 
		setFont(new Font("Segoe UI", Font.PLAIN, 20)); 
		setBackground(cor); 
		setForeground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(new Color(31,31,31)));
	}

}
