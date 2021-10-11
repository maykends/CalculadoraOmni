package visao;

import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class Display extends JPanel{
	
	private final JLabel label;

	public Display() {
		//setBackground(Color.GREEN);
		setBackground(new Color(40,42,42));
		label = new JLabel("123");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 45));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 100));
		add(label);
	}
}
