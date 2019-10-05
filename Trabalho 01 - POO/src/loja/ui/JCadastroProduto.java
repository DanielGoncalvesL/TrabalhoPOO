package loja.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.negocio.Produto;
import loja.negocio.Sistema;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

@SuppressWarnings("serial")
public class JCadastroProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textQuantidade;
	private JTextField textMarca;
	private Produto produto;
	private Produto produto1;
	private JTextField textPreco;

	public JCadastroProduto() {
		Sistema.getInstance();
		initGUI();
		setVisible(true);
	}

	public JCadastroProduto(Produto objeto) {
		produto1 = objeto;
		initGUI();
		setTitle("Alterar dados");
		textNome.setText(objeto.getNome());
		textPreco.setText(Double.toString(objeto.getPreco()));
		textMarca.setText(objeto.getDescricao());
		textQuantidade.setText(Double.toString(objeto.getQuantEstoque()));
		setVisible(true);
	}

	private void initGUI() {
		setModal(true);
		this.setTitle("Cadastrar Produto");
		setSize(350, 200);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		setBounds(100, 100, 450, 187);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textNome = new JTextField();
		textNome.setHorizontalAlignment(SwingConstants.LEFT);
		textNome.setBounds(10, 36, 193, 20);
		contentPanel.add(textNome);
		textNome.setColumns(10);

		JLabel lbNome = new JLabel("Nome");
		lbNome.setBounds(10, 11, 46, 14);
		contentPanel.add(lbNome);

		JLabel lbQuantidade = new JLabel("Quantidade");
		lbQuantidade.setBounds(243, 11, 87, 14);
		contentPanel.add(lbQuantidade);

		textQuantidade = new JTextField();
		textQuantidade.setBounds(243, 36, 189, 20);
		contentPanel.add(textQuantidade);
		textQuantidade.setColumns(10);

		JLabel lbPreco = new JLabel("Pre\u00E7o");
		lbPreco.setBounds(10, 67, 46, 14);
		contentPanel.add(lbPreco);

		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setBounds(243, 67, 46, 14);
		contentPanel.add(lbMarca);

		textMarca = new JTextField();
		textMarca.setBounds(243, 92, 189, 20);
		contentPanel.add(textMarca);
		textMarca.setColumns(10);

		textPreco = new JTextField();
		textPreco.setBounds(10, 92, 193, 19);
		contentPanel.add(textPreco);
		textPreco.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btCadastrar = new JButton("Cadastrar");
				btCadastrar.setBackground(Color.GREEN);
				btCadastrar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						boolean ok = true;
						if (textNome.getText().equals("")) {
							ok = false;
							textNome.setBackground(Color.PINK);
						} else {
							textNome.setBackground(Color.WHITE);
						}
						if (textQuantidade.getText().equals("")) {
							ok = false;
							textQuantidade.setBackground(Color.PINK);
						} else {
							textQuantidade.setBackground(Color.WHITE);
						}
						if (textQuantidade.getText().equals("")) {
							ok = false;
							textQuantidade.setBackground(Color.PINK);
						} else {
							textQuantidade.setBackground(Color.WHITE);
						}
						if (textQuantidade.getText().equals("")) {
							ok = false;
							textQuantidade.setBackground(Color.PINK);
						} else {
							textQuantidade.setBackground(Color.WHITE);
						}

						if (ok) {
							String nome = textNome.getText();
							double preco = Double.parseDouble(textQuantidade.getText());
							double quant = Double.parseDouble(textQuantidade.getText());
							String descricao = textMarca.getText();
							if (produto1 == null) {
								produto = new Produto(nome, descricao, preco, quant);
								JOptionPane.showMessageDialog(null, "Produto Inserido com Sucesso!");
								dispose();
							} else {
								produto = new Produto(produto1.getCodigo() ,nome, descricao, preco, quant);
								JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
								dispose();
							}
						} else {
							JOptionPane.showMessageDialog(null, "Preencha os campos destacados!");
						}
					}

				});
				buttonPane.add(btCadastrar);
				getRootPane().setDefaultButton(btCadastrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(Color.RED);
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						dispose();
					}

				});
				buttonPane.add(cancelButton);
			}
		}
	}

	public Produto getProduto() {
		// TODO Auto-generated method stub
		return produto;
	}
}