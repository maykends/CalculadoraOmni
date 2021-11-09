package visao;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.Operacao;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TecladoCalc extends JPanel implements ActionListener{
	
	// Define as cores dos bot�es
	private final Color COR_CINZA_ESCURO = new Color(19, 19, 19);
	private final Color COR_CINZA_CLARO = new Color(35, 35, 35);
	private final Color COR_PRETO_CLARO = new Color(11, 11, 11);
	
	public TecladoCalc() {
		
		// Define cor de fundo
		setBackground(COR_CINZA_CLARO);
	
		// Define GridLayout com 5 linhas e 4 colunas
		setLayout(new GridLayout(5,4)); 
	
		// 1� linha
		adcionaBotao("%", COR_CINZA_ESCURO);
		adcionaBotao("CE", COR_CINZA_ESCURO);
		adcionaBotao("C", COR_CINZA_ESCURO);
		adcionaBotao("/", COR_CINZA_ESCURO);
	
		// 2� linha
		adcionaBotao("7", COR_PRETO_CLARO);
		adcionaBotao("8", COR_PRETO_CLARO);
		adcionaBotao("9", COR_PRETO_CLARO);
		adcionaBotao("X", COR_CINZA_ESCURO);
		
		// 3� linha
		adcionaBotao("4", COR_PRETO_CLARO);
		adcionaBotao("5", COR_PRETO_CLARO);
		adcionaBotao("6", COR_PRETO_CLARO);
		adcionaBotao("-", COR_CINZA_ESCURO);

		// 4� linha
		adcionaBotao("1", COR_PRETO_CLARO);
		adcionaBotao("2", COR_PRETO_CLARO);
		adcionaBotao("3", COR_PRETO_CLARO);
		adcionaBotao("+", COR_CINZA_ESCURO);
		
		// 5� linha
		adcionaBotao("�", COR_PRETO_CLARO);
		adcionaBotao("0", COR_PRETO_CLARO);
		adcionaBotao(",", COR_PRETO_CLARO);
		adcionaBotao("=", COR_CINZA_CLARO);		
	}

	private void adcionaBotao(String textoBotao, Color cor) {
		BotaoCalc botao = new BotaoCalc(textoBotao, cor); 
		botao.addActionListener(this); // Chamada dos bot�es
		add(botao);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JButton) {
			// faz um cast por conta que � gerado um object
			JButton botao = (JButton) e.getSource(); 
			System.out.println("Executando ...");
			System.out.println(botao.getText());
			// Captura o bot�o
			Operacao.getInstancia().processarComando(botao.getText());
		}	
	}
}



