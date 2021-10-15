package visao;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Teclado extends JPanel{
	
	private final Color COR_CINZA_ESCURO = new Color(19, 19, 19);
	private final Color COR_CINZA_CLARO = new Color(35, 35, 35);
	private final Color COR_PRETO_CLARO = new Color(11, 11, 11);
	
	public Teclado() {
		//setBackground(Color.RED);
		setLayout(new GridLayout(5,4)); // 5 linhas e 4 colunas do teclado
		
		add(new Botao("%", COR_CINZA_ESCURO));
		add(new Botao("CE", COR_CINZA_ESCURO));
		add(new Botao("C", COR_CINZA_ESCURO));
		add(new Botao("/", COR_CINZA_ESCURO));

		add(new Botao("7", COR_PRETO_CLARO));
		add(new Botao("8", COR_PRETO_CLARO));
		add(new Botao("9", COR_PRETO_CLARO));
		add(new Botao("X", COR_CINZA_ESCURO));
		
		add(new Botao("4", COR_PRETO_CLARO));
		add(new Botao("5", COR_PRETO_CLARO));
		add(new Botao("6", COR_PRETO_CLARO));
		add(new Botao("-", COR_CINZA_ESCURO));
		
		add(new Botao("1", COR_PRETO_CLARO));
		add(new Botao("2", COR_PRETO_CLARO));
		add(new Botao("3", COR_PRETO_CLARO));
		add(new Botao("+", COR_CINZA_ESCURO));
		
		add(new Botao("+/-", COR_PRETO_CLARO));
		add(new Botao("0", COR_PRETO_CLARO));
		add(new Botao(",", COR_PRETO_CLARO));
		add(new Botao("=", COR_CINZA_CLARO));
		
		
	}
}
