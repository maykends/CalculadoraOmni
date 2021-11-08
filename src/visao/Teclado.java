package visao;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.Memoria;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	// Definindo as cores aos botões
	private final Color COR_CINZA_ESCURO = new Color(19, 19, 19);
	private final Color COR_CINZA_CLARO = new Color(35, 35, 35);
	private final Color COR_PRETO_CLARO = new Color(11, 11, 11);
	
	public Teclado() {
		
		// Define cor de fundo
		setBackground(COR_CINZA_CLARO);
	
		// Define 5 linhas e 4 colunas
		setLayout(new GridLayout(5,4)); 
	
		// Primeira Linha
		addBotao("%", COR_CINZA_ESCURO);
		addBotao("CE", COR_CINZA_ESCURO);
		addBotao("C", COR_CINZA_ESCURO);
		addBotao("/", COR_CINZA_ESCURO);
	
		// Segunda Linha
		addBotao("7", COR_PRETO_CLARO);
		addBotao("8", COR_PRETO_CLARO);
		addBotao("9", COR_PRETO_CLARO);
		addBotao("X", COR_CINZA_ESCURO);
		
		// Terceira Linha
		addBotao("4", COR_PRETO_CLARO);
		addBotao("5", COR_PRETO_CLARO);
		addBotao("6", COR_PRETO_CLARO);
		addBotao("-", COR_CINZA_ESCURO);

		// Quarta Linha
		addBotao("1", COR_PRETO_CLARO);
		addBotao("2", COR_PRETO_CLARO);
		addBotao("3", COR_PRETO_CLARO);
		addBotao("+", COR_CINZA_ESCURO);
		
		// Quinta Linha 
		addBotao("±", COR_PRETO_CLARO);
		addBotao("0", COR_PRETO_CLARO);
		addBotao(",", COR_PRETO_CLARO);
		addBotao("=", COR_CINZA_CLARO);
		
	}

	private void addBotao(String texto, Color cor) {
		Botao botao = new Botao(texto, cor); // para cada novo botao de adicionar
		botao.addActionListener(this); // Chamada para escutar os botões do teclado
		add(botao);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource(); // faz um cast por conta que é gado um obect
			System.out.println("Executando ...");
			System.out.println(botao.getText());
			Memoria.getInstancia().processarComando(botao.getText());
		}
		
		
	}


}



