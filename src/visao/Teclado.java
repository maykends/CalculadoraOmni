package visao;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

import modelo.Memoria;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	// Definindo as cores para os botões
	private final Color COR_CINZA_ESCURO = new Color(19, 19, 19);
	private final Color COR_CINZA_CLARO = new Color(35, 35, 35);
	private final Color COR_PRETO_CLARO = new Color(11, 11, 11);
	
	public Teclado() {
		
		// Definfindo a cor do fundo para o teclado
		setBackground(COR_CINZA_CLARO);
		
		// Definindo o Layout da Calculadora
		GridBagLayout layout = new GridBagLayout(); 
		// Inserindo Constraints
		GridBagConstraints c = new GridBagConstraints(); 
		
		//setLayout(new GridLayout(5,4)); // 5 linhas e 4 colunas do teclado
		setLayout(layout);
		
		c.weightx = 1; // Peso para o eixo X
		c.weighty = 1; // Peso para o eixo Y
		// Expande os botoes de acordo com os pesos
		c.fill = GridBagConstraints.BOTH; 
		
		// Primeira Linha
		addBotao("%", COR_CINZA_ESCURO, c, 0, 0);
		addBotao("CE", COR_CINZA_ESCURO, c, 1, 0);
		addBotao("C", COR_CINZA_ESCURO, c, 2, 0);
		addBotao("/", COR_CINZA_ESCURO, c, 3, 0);
		
		// Primeira Linha
		//c.gridwidth = 2;
		//addBotao("Limpar", COR_CINZA_ESCURO, c, 0, 0);
		//c.gridwidth = 1;
		//addBotao("%", COR_CINZA_ESCURO, c, 2, 0);
		//addBotao("/", COR_CINZA_ESCURO, c, 3, 0);
	
		// Segunda Linha
		addBotao("7", COR_PRETO_CLARO, c, 0, 1);
		addBotao("8", COR_PRETO_CLARO, c, 1, 1);
		addBotao("9", COR_PRETO_CLARO, c, 2, 1);
		addBotao("*", COR_CINZA_ESCURO, c, 3, 1);
		
		// Terceira Linha
		addBotao("4", COR_PRETO_CLARO, c, 0, 2);
		addBotao("5", COR_PRETO_CLARO, c, 1, 2);
		addBotao("6", COR_PRETO_CLARO, c, 2, 2);
		addBotao("-", COR_CINZA_ESCURO, c, 3, 2);

		// Quarta Linha
		addBotao("1", COR_PRETO_CLARO, c, 0, 3);
		addBotao("2", COR_PRETO_CLARO, c, 1, 3);
		addBotao("3", COR_PRETO_CLARO, c, 2, 3);
		addBotao("+", COR_CINZA_ESCURO, c, 3, 3);
		
		// Quinta Linha 
		addBotao("±", COR_PRETO_CLARO, c, 0, 4);
		addBotao("0", COR_PRETO_CLARO, c, 1, 4);
		addBotao(",", COR_PRETO_CLARO, c, 2, 4);
		addBotao("=", COR_CINZA_CLARO, c, 3, 4);
		
	}

	// Defindo função reponsável pelos ajustes dos botões relativos aos eixos X e Y 
	private void addBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		c.gridx = x; // linha
		c.gridy = y; // coluna
		Botao botao = new Botao(texto, cor); // para cada novo botao de adicionar
		botao.addActionListener(this); // Chamada para escutar os botões do teclado
		add(botao, c);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource(); // faz um cast por conta que é gado um obect
			//System.out.println("Executando ...");
			//System.out.println(botao.getText());
			Memoria.getInstancia().processarComando(botao.getText());
		}
		
		
	}


}



