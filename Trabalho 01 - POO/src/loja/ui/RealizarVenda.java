/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.ui;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loja.negocio.Carrinho;
import loja.negocio.Item;
import loja.negocio.Produto;
import loja.negocio.Sistema;

/**
 *
 * @author marcelle
 */
public class RealizarVenda extends javax.swing.JInternalFrame {

    private Carrinho carrinho;
    private int codigo = 0;

    /**
     * Creates new form RealizarVenda
     */
    public RealizarVenda() {
        sis = Sistema.getInstance();
        sis.limparCarrinho();
        initComponents();
        btExcluirProduto.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        btAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListar = new javax.swing.JTable();
        tfTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btRealizarCompra = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluirProduto = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        jButton1.setText("jButton1");

        setBorder(null);
        setTitle("Realizar Venda");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/basket_add.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 279));

        jLabel1.setText("Nome do Produto");

        jLabel2.setText("Quantidade");

        btAdicionar.setBackground(java.awt.Color.cyan);
        btAdicionar.setText("Adicionar");
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        tbListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Produto", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbListar);

        tfTotal.setEditable(false);

        jLabel4.setText("Preço Total");

        btRealizarCompra.setBackground(java.awt.Color.green);
        btRealizarCompra.setText("Realizar Compra");
        btRealizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRealizarCompraActionPerformed(evt);
            }
        });

        btCancelar.setBackground(java.awt.Color.red);
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluirProduto.setBackground(java.awt.Color.pink);
        btExcluirProduto.setText("Excluir Produto");
        btExcluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRealizarCompra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btExcluirProduto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btAdicionar))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(31, 31, 31)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel4))
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar)
                    .addComponent(btExcluirProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar)
                    .addComponent(btRealizarCompra))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirProdutoActionPerformed
        // TODO add your handling code here:
        ExcluirProdutoCarrinho excluir = new ExcluirProdutoCarrinho(new javax.swing.JFrame(), true);
        excluir.setLocationRelativeTo(null);
        excluir.setVisible(true);
        if (excluir.getCodigo() != -1) {
            if (excluir.getCodigo() >= 0 && carrinho.getItens().size() > excluir.getCodigo()) {
                if (sis.excluirItemCarrinho(excluir.getCodigo())) {
                    JOptionPane.showMessageDialog(null, "Item Excluido com Sucesso!!");
                    CarregarItens();
                    PrecoTotal();
                    VerificarBotao();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao Excluir!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao Excluir!!");
            }
        }
    }//GEN-LAST:event_btExcluirProdutoActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        // TODO add your handling code here:
        boolean ok = true;
        if (tfNome.getText().equals("")) {
            ok = false;
            tfNome.setBackground(Color.PINK);
        } else {
            tfNome.setBackground(Color.WHITE);
        }
        if (tfQuantidade.getText().equals("")) {
            ok = false;
            tfQuantidade.setBackground(Color.PINK);
        } else {
            tfQuantidade.setBackground(Color.WHITE);
        }
        if (ok) {
            String nomeProduto = tfNome.getText();
            int quantidade = Integer.parseInt(tfQuantidade.getText());
            if (quantidade > 0) {
                Produto produto = sis.buscarNome(nomeProduto);
                if (produto != null) {
                    if (produto.getQuantEstoque() >= quantidade) {
                        Item item = sis.criarItem(produto, quantidade);
                        if (item != null) {
                            if (sis.inserirCarrinho(item)) {
                                JOptionPane.showMessageDialog(null, "Produto Adicionado com Sucesso no Carrinho!!");
                                CarregarItens();
                                PrecoTotal();
                                VerificarBotao();
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void PrecoTotal() {
        double preco = 0;
        if (carrinho != null) {
            for(int i = 0; i < carrinho.getItens().size(); i++){
                preco = (carrinho.getItens().get(i).getPreco() * carrinho.getItens().get(i).getQuantidade()) + preco;
            }
        }
        tfTotal.setText("R$ " + Double.toString(preco));
    }

    private void CarregarItens() {
        carrinho = sis.listarCarrinho();
        if (carrinho != null) {
            DefaultTableModel modelo = (DefaultTableModel) tbListar.getModel();
            modelo.setNumRows(0);
            codigo = 0;
            carrinho.getItens().forEach((_item) -> {
                modelo.addRow(new Object[]{
                    codigo,
                    _item.getProduto().getNome(),
                    "R$ " + _item.getPreco() * _item.getQuantidade(),
                    _item.getQuantidade()
                });
                codigo++;
            });
        }
    }

    private void VerificarBotao() {
        if (carrinho.getItens().size() > 0) {
            btExcluirProduto.setEnabled(true);
        } else {
            btExcluirProduto.setEnabled(false);
        }
    }

    private void ReiniciarJanela() {
        dispose();
        this.setVisible(true);
    }

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
        sis.limparCarrinho();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btRealizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRealizarCompraActionPerformed
        // TODO add your handling code here:
        CarregarItens();
        PrecoTotal();
        VerificarBotao();
        NomeClienteVenda nome = new NomeClienteVenda(new javax.swing.JFrame(), true);
        nome.setLocationRelativeTo(null);
        nome.setVisible(true);
        if (!carrinho.getItens().isEmpty()) {
            if (nome.getNome() != null && !nome.getNome().equals("")) {
                if (sis.concluirVenda(nome.getNome())) {
                    JOptionPane.showMessageDialog(null, "Venda Concluida com Sucesso!!");
                    dispose();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Naõ foi Possivel Concluir Venda!!");
            dispose();
        }
    }//GEN-LAST:event_btRealizarCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluirProduto;
    private javax.swing.JButton btRealizarCompra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListar;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
    private final Sistema sis;
}
