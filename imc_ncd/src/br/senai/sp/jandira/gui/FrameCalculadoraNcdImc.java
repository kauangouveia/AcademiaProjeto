package br.senai.sp.jandira.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Cliente;

public class FrameCalculadoraNcdImc {
	

	public void criarTela() {
		JFrame telaCliente = new JFrame();
		telaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		telaCliente.setSize(450,400);
		telaCliente.setTitle("Calculos IMC-NCD");
		telaCliente.setLayout(null);
		telaCliente.setLocationRelativeTo(null);
		
		// *** Criando label e text field do nome
		JLabel labelNome = new JLabel();
		labelNome.setText("Nome");
		labelNome.setBounds(10, 20, 80, 30);
		JTextField textNome = new JTextField();
		textNome.setBounds(10, 45, 150, 30);
		
		// *** Criando label e textField Data de nascimento
		JLabel labelIdade = new JLabel();
		labelIdade.setText("Idade");
		labelIdade.setBounds(10, 80, 130, 30);
		JTextField textIdade = new JTextField();
		textIdade.setBounds(10, 110, 50, 30);
		
		
		// *** JRadioButton e ButtonGroup (Feminino e Masculino)
		JRadioButton radioMasculino = new JRadioButton();
		radioMasculino.setText("Masculino");
		radioMasculino.setBounds(10, 150, 120, 30);
		JRadioButton radioFeminino = new JRadioButton();
		radioFeminino.setText("Feminino");
		radioFeminino.setBounds(130, 150, 120, 30);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioMasculino);
		buttonGroup.add(radioFeminino);
		
		// *** label e textField Altura
		JLabel labelAltura = new JLabel();
		labelAltura.setText("Altura");
		labelAltura.setBounds(10, 200, 50, 30);
		JTextField textAltura = new JTextField();
		textAltura.setBounds(10, 225, 40, 30);
		
		// *** label e textField Peso
		JLabel labelPeso = new JLabel();
		labelPeso.setText("Peso(Kg)");
		labelPeso.setBounds(60, 200, 70, 30);
		JTextField textPeso = new JTextField();
		textPeso.setBounds(60, 225, 55, 30);
		
		// *** ComboBox
		JLabel labelNivelDeAtividade = new JLabel();
		labelNivelDeAtividade.setText("Nivel de Atividade");
		labelNivelDeAtividade.setBounds(10, 260, 100, 30);
		JComboBox<String> comboNivelDeAtividade = new JComboBox<String>();
		comboNivelDeAtividade.addItem("Leve");
		comboNivelDeAtividade.addItem("Moderada");
		comboNivelDeAtividade.addItem("Pesada");
		String.valueOf(comboNivelDeAtividade.getSelectedItem());
		comboNivelDeAtividade.setBounds(10, 290, 100, 20);
		
		// *** Resultado da IMC
		JLabel labelImc = new JLabel();
		labelImc.setText("IMC:");
		labelImc.setBounds(220, 20, 70, 30);
		
		// *** Status IMC
		JLabel labelStatusImc = new JLabel();
		labelStatusImc.setText("Status IMC - ");
		labelStatusImc.setBounds(220, 40, 250, 30);
		
		// *** Resultado NCD
		JLabel labelNcd = new JLabel();
		labelNcd.setText("NCD:");
		labelNcd.setBounds(220, 80, 180, 30);
		
		// *** botão calcular
		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		Color vermelho = new Color(250,128,114);
		buttonCalcular.setBackground(vermelho);
		buttonCalcular.setBounds(280, 200, 90, 90);
		
		// *** Colocar dentro do painel de conteudo
		telaCliente.getContentPane().add(labelNome);
		telaCliente.getContentPane().add(textNome);
		telaCliente.getContentPane().add(labelIdade);
		telaCliente.getContentPane().add(textIdade);
		telaCliente.getContentPane().add(radioMasculino);
		telaCliente.getContentPane().add(radioFeminino);
		telaCliente.getContentPane().add(labelAltura);
		telaCliente.getContentPane().add(textAltura);
		telaCliente.getContentPane().add(labelPeso);
		telaCliente.getContentPane().add(textPeso);
		telaCliente.getContentPane().add(labelNivelDeAtividade);
		telaCliente.getContentPane().add(comboNivelDeAtividade);
		telaCliente.getContentPane().add(buttonCalcular);
		telaCliente.getContentPane().add(labelImc);
		telaCliente.getContentPane().add(labelNcd);
		telaCliente.getContentPane().add(labelStatusImc);


		telaCliente.setVisible(true);
		
		// *** Ação do botão calcular
		buttonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliente c1 = new Cliente();
				c1.setPeso(Double.parseDouble(textPeso.getText()));
				c1.setAltura(Double.parseDouble(textAltura.getText()));
				c1.setSexo(String.valueOf(radioMasculino.isSelected()?"Masculino":"Feminino"));
				c1.setIdade(Integer.parseInt(textIdade.getText()));
				c1.setNivelDeAtividade(String.valueOf(comboNivelDeAtividade.getSelectedItem().toString()));
				
				labelImc.setText("IMC: " + String.valueOf(c1.getImc()));
				labelStatusImc.setText("Status IMC - " + c1.statusImc());
				labelNcd.setText("NCD: " + String.valueOf(c1.getNcd()));
			}
		});
	}
}

