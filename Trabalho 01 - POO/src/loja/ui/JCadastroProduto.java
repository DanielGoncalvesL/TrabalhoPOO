package loja.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

public class JCadastroProduto extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lbNome;
	private JTextField txtNome;
	private JLabel lbQuant;
	private JTextField txtQuant;
	private JLabel lbPreco;
	private JTextField txtPreco;
	private JLabel lbMarca;
	private JFormattedTextField txtMarca;
	private JPanel panelBotoes;
	private JButton btCadastrar;
	private JButton btCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadastroProduto frame = new JCadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JCadastroProduto() {
		initGUI();
	}
	private void initGUI() {
		setTitle("CadastrarProduto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lbNome = new JLabel("Nome");
		lbNome.setBounds(10, 11, 46, 14);
		panel.add(lbNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(9, 25, 176, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		lbQuant = new JLabel("Quantidade");
		lbQuant.setBounds(221, 11, 59, 14);
		panel.add(lbQuant);
		
		txtQuant = new JTextField();
		txtQuant.setBounds(221, 25, 174, 20);
		panel.add(txtQuant);
		txtQuant.setColumns(10);
		
		lbPreco = new JLabel("Pre\u00E7o");
		lbPreco.setBounds(10, 56, 46, 14);
		panel.add(lbPreco);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(9, 70, 176, 20);
		panel.add(txtPreco);
		txtPreco.setColumns(10);
		
		lbMarca = new JLabel("Marca");
		lbMarca.setBounds(221, 56, 46, 14);
		panel.add(lbMarca);
		
		txtMarca = new JFormattedTextField();
		txtMarca.setBounds(221, 70, 174, 20);
		panel.add(txtMarca);
		
		panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		panelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		btCancelar = new JButton("Cancelar");
		btCancelar.setBackground(Color.RED);
		panelBotoes.add(btCancelar);
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setForeground(Color.BLACK);
		btCadastrar.setBackground(Color.GREEN);
		panelBotoes.add(btCadastrar);
	}
}
