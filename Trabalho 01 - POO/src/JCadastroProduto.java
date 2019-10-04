import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JFormattedTextField;

@SuppressWarnings("serial")
public class JCadastroProduto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textQuantidade;
	private JTextField textMarca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JCadastroProduto dialog = new JCadastroProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JCadastroProduto() {
		setTitle("Cadastrar Produto");
		initGUI();
	}

	private void initGUI() {
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
		
		JFormattedTextField frmtdtxtfldR = new JFormattedTextField();
		frmtdtxtfldR.setText("R$_,__");
		frmtdtxtfldR.setBounds(10, 92, 193, 20);
		contentPanel.add(frmtdtxtfldR);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btCadastrar = new JButton("Cadastrar");
				btCadastrar.setBackground(Color.GREEN);
				buttonPane.add(btCadastrar);
				getRootPane().setDefaultButton(btCadastrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(Color.RED);
				buttonPane.add(cancelButton);
			}
		}
	}
}
