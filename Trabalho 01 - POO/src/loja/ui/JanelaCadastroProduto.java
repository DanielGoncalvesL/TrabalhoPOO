package loja.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import loja.negocio.Produto;
import loja.negocio.Sistema;

@SuppressWarnings("serial")
public class JanelaCadastroProduto extends JDialog implements ActionListener{
	
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfQuant;
	private JTextField tfMarca;
	private JButton cancelar;
	private JButton salvar;

	private Produto produto;
	
	public JanelaCadastroProduto() {
		Sistema.getInstance();
		initGUI();
		setVisible(true);
	}
	
	public JanelaCadastroProduto(Produto objeto) {
		initGUI();
		setTitle("Alterar dados");
		tfNome.setText(objeto.getNome());
		tfPreco.setText(Double.toString(objeto.getPreco()));
		tfMarca.setText(objeto.getDescricao());
		tfQuant.setText(Double.toString(objeto.getQuantEstoque()));
		setVisible(true);
	}
	
	private void initGUI() {
		setModal(true);
		this.setTitle("Cadastrar Produto");
		setSize(350,200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Iniciar conteiner
		JPanel panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER); //AJEITAR AQUI
		
		//Id
		JLabel lbId = new JLabel("Código");
		panel.add(lbId);
		lbId.setBounds(10, 10, 50, 20);
		JTextField tfId = new JTextField();
		tfId.setEditable(false);
		panel.add(tfId);
		tfId.setBounds(10, 30, 50, 20);
		
		
		//Nome
		JLabel lbNome = new JLabel("Nome");
		panel.add(lbNome);
		lbNome.setBounds(80, 10, 50, 20);
		tfNome = new JTextField();
		panel.add(tfNome);
		tfNome.setBounds(80, 30, 225, 20);
		
		JLabel lbQuant = new JLabel("Estoque:");
		panel.add(lbQuant);
		lbQuant.setBounds(10, 50, 70, 20);
		tfQuant = new JTextField();
		panel.add(tfQuant);
		tfQuant.setBounds(10, 70, 75, 20);
		
		JLabel lbPreco = new JLabel("Preço:");
		panel.add(lbPreco);
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("R$_,__");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tfPreco = new JFormattedTextField(mascara);
		lbPreco.setBounds(120, 50, 50, 20);
		tfPreco = new JTextField();
		panel.add(tfPreco);
		tfPreco.setBounds(120, 70, 75, 20);
		
		JLabel lbMarca = new JLabel("Marca:");
		panel.add(lbMarca);
		lbMarca.setBounds(230, 50, 50, 20);
		tfMarca = new JTextField();
		panel.add(tfMarca);
		tfMarca.setBounds(230, 70, 75, 20);
		
		JPanel panelBotao = new JPanel();
		panelBotao.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		getContentPane().add(panelBotao, BorderLayout.SOUTH);
		
		//BOTÃO
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(this);
		panelBotao.add(cancelar);
		salvar = new JButton("Salvar");
		salvar.addActionListener(this);
		salvar.setBounds(270, 180, 90, 20);
		panelBotao.add(salvar);	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); 
		if (obj == cancelar) {
			dispose(); 			
		}else if (obj == salvar) {
			boolean ok = true;
			if (tfNome.getText().equals("")) {
				ok = false;
				tfNome.setBackground(Color.PINK);
			}else {
				tfNome.setBackground(Color.WHITE);
			}
			if (tfQuant.getText().equals("")) {
				ok = false;
				tfQuant.setBackground(Color.PINK);
			}else {
				tfQuant.setBackground(Color.WHITE);
			}
			if (tfPreco.getText().equals("")) {
				ok = false;
				tfPreco.setBackground(Color.PINK);
			}else {
				tfPreco.setBackground(Color.WHITE);
			}
			if (tfMarca.getText().equals("")) {
				ok = false;
				tfMarca.setBackground(Color.PINK);
			}else {
				tfMarca.setBackground(Color.WHITE);
			}
			
			if (ok) {
			String nome = tfNome.getText();
			double preco = Double.parseDouble(tfPreco.getText());
			double quant = Double.parseDouble(tfQuant.getText());
			String descricao = tfMarca.getText();
			produto = new Produto(nome, descricao, preco, quant);
			dispose();  
			}else {
				JOptionPane.showMessageDialog(this, "Preencha os campos destacados!");
			}
			
		}		
	}

	public Produto getProduto() {
		return produto;
	}
	
}