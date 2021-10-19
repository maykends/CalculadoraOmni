package visao;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{
	
	private final Color COR_CINZA_ESCURO = new Color(19, 19, 19);
	private final Color COR_CINZA_CLARO = new Color(35, 35, 35);
	private final Color COR_PRETO_CLARO = new Color(11, 11, 11);
	
	public Teclado() {
		//setBackground(Color.RED);
		setLayout(new GridLayout(5,4)); // 5 linhas e 4 colunas do teclado
		
		
		//add(new Botao("%", COR_CINZA_ESCURO));
		//add(new Botao("CE", COR_CINZA_ESCURO));
		//add(new Botao("C", COR_CINZA_ESCURO));
		//add(new Botao("/", COR_CINZA_ESCURO));
		
		JButton btnPorcento = new Botao("%", COR_CINZA_ESCURO);
		btnPorcento.addActionListener(this);
		add(btnPorcento);
		
		JButton btnCe = new Botao("CE", COR_CINZA_ESCURO);
		btnCe.addActionListener(this);
		add(btnCe);
		
		JButton btnC = new Botao("C", COR_CINZA_ESCURO);
		btnC.addActionListener(this);
		add(btnC);
		
		JButton btnDivisao = new Botao("/", COR_CINZA_ESCURO);
		btnDivisao.addActionListener(this);
		add(btnDivisao);
		
		//add(new Botao("7", COR_PRETO_CLARO));
		//add(new Botao("8", COR_PRETO_CLARO));
		//add(new Botao("9", COR_PRETO_CLARO));
		//add(new Botao("X", COR_CINZA_ESCURO));

		JButton btnNum7 = new Botao("7", COR_PRETO_CLARO);
		btnNum7.addActionListener(this);
		add(btnNum7);
		
		JButton btnNum8 = new Botao("8", COR_PRETO_CLARO);
		btnNum8.addActionListener(this);
		add(btnNum8);
		
		JButton btnNum9 = new Botao("9", COR_PRETO_CLARO);
		btnNum9.addActionListener(this);
		add(btnNum9);
		
		JButton btnMultiplicar = new Botao("X", COR_CINZA_ESCURO);
		btnMultiplicar.addActionListener(this);
		add(btnMultiplicar);
		
		//add(new Botao("4", COR_PRETO_CLARO));
		//add(new Botao("5", COR_PRETO_CLARO));
		//add(new Botao("6", COR_PRETO_CLARO));
		//add(new Botao("-", COR_CINZA_ESCURO));
		
		JButton btnNum4 = new Botao("4", COR_PRETO_CLARO);
		btnNum4.addActionListener(this);
		add(btnNum4);
		
		JButton btnNum5 = new Botao("5", COR_PRETO_CLARO);
		btnNum5.addActionListener(this);
		add(btnNum5);
		
		JButton btnNum6 = new Botao("6", COR_PRETO_CLARO);
		btnNum6.addActionListener(this);
		add(btnNum6);
		
		JButton btnSubtratir = new Botao("-", COR_CINZA_ESCURO);
		btnSubtratir.addActionListener(this);
		add(btnSubtratir);
		
		//add(new Botao("1", COR_PRETO_CLARO));
		//add(new Botao("2", COR_PRETO_CLARO));
		//add(new Botao("3", COR_PRETO_CLARO));
		//add(new Botao("+", COR_CINZA_ESCURO));
		
		JButton btnNum1 = new Botao("1", COR_PRETO_CLARO);
		btnNum1.addActionListener(this);
		add(btnNum1);
		
		JButton btnNum2 = new Botao("2", COR_PRETO_CLARO);
		btnNum2.addActionListener(this);
		add(btnNum2);
		
		JButton btnNum3 = new Botao("3", COR_PRETO_CLARO);
		btnNum3.addActionListener(this);
		add(btnNum3);
		
		JButton btnSomar = new Botao("+", COR_CINZA_ESCURO);
		btnSomar.addActionListener(this);
		add(btnSomar);
		
		
		//add(new Botao("+/-", COR_PRETO_CLARO));
		//add(new Botao("0", COR_PRETO_CLARO));
		//add(new Botao(",", COR_PRETO_CLARO));
		//add(new Botao("=", COR_CINZA_CLARO));
		
		JButton btnMaisOuMenos = new Botao("+/-", COR_PRETO_CLARO);
		btnMaisOuMenos.addActionListener(this);
		add(btnMaisOuMenos);
		
		JButton btnNum0 = new Botao("0", COR_PRETO_CLARO);
		btnNum0.addActionListener(this);
		add(btnNum0);
		
		JButton btnVirgula = new Botao(",", COR_PRETO_CLARO);
		btnVirgula.addActionListener(this);
		add(btnVirgula);
		
		JButton btnIgual = new Botao("=", COR_CINZA_CLARO);
		btnIgual.addActionListener(this);
		add(btnIgual);
		
	}

	// segunda logica
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}

// https://www.youtube.com/watch?v=ZLnIOBUcCsw

