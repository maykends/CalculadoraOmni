package visao;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BotaoCalc extends JButton{
	
	public BotaoCalc(String texto, Color cor) {
		setText(texto);
		setOpaque(true); 
		setFont(new Font("Segoe UI", Font.PLAIN, 18)); 
		setBackground(cor); 
		setForeground(Color.WHITE); 
		setBorder(BorderFactory.createLineBorder(new Color(31,31,31)));
	}

}
