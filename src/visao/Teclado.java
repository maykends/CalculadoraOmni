package visao;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	private final Color COR_CINZA_ESCURO = new Color(19, 19, 19);
	private final Color COR_CINZA_CLARO = new Color(35, 35, 35);
	private final Color COR_PRETO_CLARO = new Color(11, 11, 11);
	
	public Teclado() {
		
		
		setBackground(Color.BLACK);
		
		GridBagLayout layout = new GridBagLayout(); //layout flexivel
		GridBagConstraints c = new GridBagConstraints(); 
		
		//setLayout(new GridLayout(5,4)); // 5 linhas e 4 colunas do teclado
		setLayout(layout);
		
		c.weightx = 1; // peso para o eixo x
		c.weighty = 1; // peso para o eixo x
		c.fill = GridBagConstraints.BOTH; // expande os botoes de acordo com os pesos
		
		// Linha 1
		addBotao("%", COR_CINZA_ESCURO, c, 0, 0);
		addBotao("CE", COR_CINZA_ESCURO, c, 1, 0);
		addBotao("C", COR_CINZA_ESCURO, c, 2, 0);
		addBotao("/", COR_CINZA_ESCURO, c, 3, 0);
	
		// Linha 1
		//c.gridwidth = 2;
		//addBotao("C", COR_CINZA_ESCURO, c, 0, 0);
		//c.gridwidth = 1;
		//addBotao("%", COR_CINZA_ESCURO, c, 2, 0);
		//addBotao("/", COR_CINZA_ESCURO, c, 3, 0);
		
		/////////////////////////////////EXEMPLO/////////////////////////////////////////////////
		
		//c.gridy = 0;
		//c.gridx = 0;
		//add(new Botao("%", COR_CINZA_ESCURO), c);
		//
		//c.gridx = 1;
		//add(new Botao("CE", COR_CINZA_ESCURO), c);
		//c.gridx = 2;
		//add(new Botao("C", COR_CINZA_ESCURO), c);
		//c.gridx = 3;
		//add(new Botao("/", COR_CINZA_ESCURO), c);
		//c.gridx = 4;
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//JButton btnPorcento = new Botao("%", COR_CINZA_ESCURO);
		//btnPorcento.addActionListener(this);
		//add(btnPorcento);
		//
		//JButton btnCe = new Botao("CE", COR_CINZA_ESCURO);
		//btnCe.addActionListener(this);
		//add(btnCe);
		//
		//JButton btnC = new Botao("C", COR_CINZA_ESCURO);
		//btnC.addActionListener(this);
		//add(btnC);
		//
		//JButton btnDivisao = new Botao("/", COR_CINZA_ESCURO);
		//btnDivisao.addActionListener(this);
		//add(btnDivisao);
		
		//////////////////////////////////////////////////////////////////////////////////
		
		// Linha 2
		addBotao("7", COR_PRETO_CLARO, c, 0, 1);
		addBotao("8", COR_PRETO_CLARO, c, 1, 1);
		addBotao("9", COR_PRETO_CLARO, c, 2, 1);
		addBotao("X", COR_CINZA_ESCURO, c, 3, 1);
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//c.gridy = 0;
		//c.gridx = 1;
		//add(new Botao("7", COR_PRETO_CLARO), c);
		//c.gridy = 1;
		//c.gridx = 1;
		//add(new Botao("8", COR_PRETO_CLARO), c);
		//c.gridy = 2;
		//c.gridx = 1;
		//add(new Botao("9", COR_PRETO_CLARO), c);
		//c.gridy = 3;
		//c.gridx = 1;
		//add(new Botao("X", COR_CINZA_ESCURO), c);
		//c.gridy = 4;
		//c.gridx = 1;
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//JButton btnNum7 = new Botao("7", COR_PRETO_CLARO);
		//btnNum7.addActionListener(this);
		//add(btnNum7);
		//
		//JButton btnNum8 = new Botao("8", COR_PRETO_CLARO);
		//btnNum8.addActionListener(this);
		//add(btnNum8);
		//
		//JButton btnNum9 = new Botao("9", COR_PRETO_CLARO);
		//btnNum9.addActionListener(this);
		//add(btnNum9);
		//
		//JButton btnMultiplicar = new Botao("X", COR_CINZA_ESCURO);
		//btnMultiplicar.addActionListener(this);
		//add(btnMultiplicar);
		
		//////////////////////////////////////////////////////////////////////////////////	
		
		// Linha 3
		addBotao("4", COR_PRETO_CLARO, c, 0, 2);
		addBotao("5", COR_PRETO_CLARO, c, 1, 2);
		addBotao("6", COR_PRETO_CLARO, c, 2, 2);
		addBotao("-", COR_CINZA_ESCURO, c, 3, 2);
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//c.gridy = 0;
		//c.gridx = 2;
		//add(new Botao("4", COR_PRETO_CLARO), c);
		//c.gridy = 1;
		//c.gridx = 2;
		//add(new Botao("5", COR_PRETO_CLARO), c);
		//c.gridy = 2;
		//c.gridx = 2;
		//add(new Botao("6", COR_PRETO_CLARO), c);
		//c.gridy = 3;
		//c.gridx = 2;
		//add(new Botao("-", COR_CINZA_ESCURO), c);
		//c.gridy = 3;
		//c.gridx = 2;
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//JButton btnNum4 = new Botao("4", COR_PRETO_CLARO);
		//btnNum4.addActionListener(this);
		//add(btnNum4);
		//
		//JButton btnNum5 = new Botao("5", COR_PRETO_CLARO);
		//btnNum5.addActionListener(this);
		//add(btnNum5);
		//
		//JButton btnNum6 = new Botao("6", COR_PRETO_CLARO);
		//btnNum6.addActionListener(this);
		//add(btnNum6);
		//
		//JButton btnSubtratir = new Botao("-", COR_CINZA_ESCURO);
		//btnSubtratir.addActionListener(this);
		//add(btnSubtratir);
		
		//////////////////////////////////////////////////////////////////////////////////
		
		// Linha 4
		addBotao("1", COR_PRETO_CLARO, c, 0, 3);
		addBotao("2", COR_PRETO_CLARO, c, 1, 3);
		addBotao("3", COR_PRETO_CLARO, c, 2, 3);
		addBotao("+", COR_CINZA_ESCURO, c, 3, 3);
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//add(new Botao("1", COR_PRETO_CLARO), c);
		//add(new Botao("2", COR_PRETO_CLARO), c);
		//add(new Botao("3", COR_PRETO_CLARO), c);
		//add(new Botao("+", COR_CINZA_ESCURO), c);
		
		//////////////////////////////////////////////////////////////////////////////////
		
		//JButton btnNum1 = new Botao("1", COR_PRETO_CLARO);
		//btnNum1.addActionListener(this);
		//add(btnNum1);
		
		//JButton btnNum2 = new Botao("2", COR_PRETO_CLARO);
		//btnNum2.addActionListener(this);
		//add(btnNum2);
		
		//JButton btnNum3 = new Botao("3", COR_PRETO_CLARO);
		//btnNum3.addActionListener(this);
		//add(btnNum3);
		
		//JButton btnSomar = new Botao("+", COR_CINZA_ESCURO);
		//btnSomar.addActionListener(this);
		//add(btnSomar);
		
		// Linha 5
		addBotao("+/-", COR_PRETO_CLARO, c, 0, 4);
		addBotao("0", COR_PRETO_CLARO, c, 1, 4);
		addBotao(",", COR_PRETO_CLARO, c, 2, 4);
		addBotao("=", COR_CINZA_CLARO, c, 3, 4);
		
		//add(new Botao("+/-", COR_PRETO_CLARO), c);
		//add(new Botao("0", COR_PRETO_CLARO), c);
		//add(new Botao(",", COR_PRETO_CLARO), c);
		//add(new Botao("=", COR_CINZA_CLARO), c);
		
		//JButton btnMaisOuMenos = new Botao("+/-", COR_PRETO_CLARO);
		//btnMaisOuMenos.addActionListener(this);
		//add(btnMaisOuMenos);
		//
		//JButton btnNum0 = new Botao("0", COR_PRETO_CLARO);
		//btnNum0.addActionListener(this);
		//add(btnNum0);
		//
		//JButton btnVirgula = new Botao(",", COR_PRETO_CLARO);
		//btnVirgula.addActionListener(this);
		//add(btnVirgula);
		
		//JButton btnIgual = new Botao("=", COR_CINZA_CLARO);
		//btnIgual.addActionListener(this);
		//add(btnIgual);
		
	}

	private void addBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		c.gridx = x; // linha
		c.gridy = y; // coluna
		Botao botao = new Botao(texto, cor);
		add(botao, c);
		
	}

	// segunda logica
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}



