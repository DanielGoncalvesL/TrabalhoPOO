/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.ui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import loja.negocio.Produto;
import loja.negocio.Sistema;

/**
 *
 * @author Daniel
 */
public class CRUDProduto extends javax.swing.JDialog {

    private final Sistema sis;

    /**
     * Creates new form CRUDProduto
     *
     * @param parent
     * @param modal
     */
    public CRUDProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sis = Sistema.getInstance();
        initComponents();
        CarregarProdutos();
        DefaultTableModel modelo = (DefaultTableModel) tbListar.getModel();
        tbListar.setRowSorter(new TableRowSorter(modelo));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbMarca = new javax.swing.JComboBox();
        jAdicionarMarca = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfQuant = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jNovo = new javax.swing.JMenu();
        jSalvar = new javax.swing.JMenu();
        jEditar = new javax.swing.JMenu();
        jCancelar = new javax.swing.JMenu();
        jExcluir = new javax.swing.JMenu();
        jSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome do Produto");

        tfNome.setEnabled(false);

        jLabel2.setText("Marca");

        cbMarca.setEnabled(false);

        jAdicionarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        jAdicionarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAdicionarMarcaActionPerformed(evt);
            }
        });

        jLabel3.setText("Preço");

        tfPreco.setEnabled(false);

        jLabel4.setText("Quantidade");

        tfQuant.setEnabled(false);

        tbListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Produto", "Marca", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbListar);
        if (tbListar.getColumnModel().getColumnCount() > 0) {
            tbListar.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfPreco)
                                .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(cbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jAdicionarMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfQuant))
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAdicionarMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");

        jNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_white_add.png"))); // NOI18N
        jNovo.setText("Novo");
        jNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNovoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jNovoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jNovoMouseExited(evt);
            }
        });
        jMenuBar1.add(jNovo);

        jSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/table_save.png"))); // NOI18N
        jSalvar.setText("Salvar");
        jSalvar.setEnabled(false);
        jSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalvarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSalvarMouseExited(evt);
            }
        });
        jMenuBar1.add(jSalvar);

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_edit.png"))); // NOI18N
        jEditar.setText("Editar");
        jEditar.setEnabled(false);
        jEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jEditarMouseExited(evt);
            }
        });
        jMenuBar1.add(jEditar);

        jCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jCancelar.setText("Cancelar");
        jCancelar.setEnabled(false);
        jCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCancelarMouseExited(evt);
            }
        });
        jMenuBar1.add(jCancelar);

        jExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_delete.png"))); // NOI18N
        jExcluir.setText("Excluir");
        jExcluir.setEnabled(false);
        jExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jExcluirMouseExited(evt);
            }
        });
        jMenuBar1.add(jExcluir);

        jSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/link_go.png"))); // NOI18N
        jSair.setText("Sair");
        jSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSairMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSairMouseExited(evt);
            }
        });
        jMenuBar1.add(jSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAdicionarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAdicionarMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAdicionarMarcaActionPerformed

    private void jSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseEntered
        // TODO add your handling code here:
        jSair.setForeground(Color.red);
    }//GEN-LAST:event_jSairMouseEntered

    private void jSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseExited
        // TODO add your handling code here:
        jSair.setForeground(Color.black);
    }//GEN-LAST:event_jSairMouseExited

    private void jExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExcluirMouseEntered
        // TODO add your handling code here:
        jExcluir.setForeground(Color.red);
    }//GEN-LAST:event_jExcluirMouseEntered

    private void jExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExcluirMouseExited
        // TODO add your handling code here:
        jExcluir.setForeground(Color.black);
    }//GEN-LAST:event_jExcluirMouseExited

    private void jCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelarMouseEntered
        // TODO add your handling code here:
        jCancelar.setForeground(Color.red);
    }//GEN-LAST:event_jCancelarMouseEntered

    private void jCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelarMouseExited
        // TODO add your handling code here:
        jCancelar.setForeground(Color.black);
    }//GEN-LAST:event_jCancelarMouseExited

    private void jEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditarMouseEntered
        // TODO add your handling code here:
        jEditar.setForeground(Color.red);
    }//GEN-LAST:event_jEditarMouseEntered

    private void jSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSairMouseClicked

    private void jEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditarMouseExited
        // TODO add your handling code here:
        jEditar.setForeground(Color.black);
    }//GEN-LAST:event_jEditarMouseExited

    private void jSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalvarMouseEntered
        // TODO add your handling code here:
        jSalvar.setForeground(Color.red);
    }//GEN-LAST:event_jSalvarMouseEntered

    private void jSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalvarMouseExited
        // TODO add your handling code here:
        jSalvar.setForeground(Color.black);
    }//GEN-LAST:event_jSalvarMouseExited

    private void jNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNovoMouseEntered
        // TODO add your handling code here:
        jNovo.setForeground(Color.red);
    }//GEN-LAST:event_jNovoMouseEntered

    private void jNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNovoMouseExited
        // TODO add your handling code here:
        jNovo.setForeground(Color.black);

    }//GEN-LAST:event_jNovoMouseExited

    private void jNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNovoMouseClicked
        // TODO add your handling code here:
        jNovo.setEnabled(false);
        jSalvar.setEnabled(true);
        jCancelar.setEnabled(true);
        tfNome.setEnabled(true);
        tfPreco.setEnabled(true);
        tfQuant.setEnabled(true);
        cbMarca.setEnabled(true);
    }//GEN-LAST:event_jNovoMouseClicked

    private void jSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalvarMouseClicked
        // TODO add your handling code here:
        boolean ok = true;
        if (tfNome.getText().equals("")) {
            ok = false;
            tfNome.setBackground(Color.PINK);
        } else {
            tfNome.setBackground(Color.WHITE);
        }
        if (tfQuant.getText().equals("")) {
            ok = false;
            tfQuant.setBackground(Color.PINK);
        } else {
            tfQuant.setBackground(Color.WHITE);
        }
        if (tfPreco.getText().equals("") && Double.parseDouble(tfPreco.getText()) <= 0) {
            ok = false;
            tfPreco.setBackground(Color.PINK);
        } else {
            tfPreco.setBackground(Color.WHITE);
        }
        if (tfMarca.getText().equals("")) {
            ok = false;
            tfMarca.setBackground(Color.PINK);
        } else {
            tfMarca.setBackground(Color.WHITE);
        }

        if (ok) {
                String nome = tfNome.getText();
                double preco = Double.parseDouble(tfPreco.getText());
                double quant = Double.parseDouble(tfQuant.getText());
                String descricao = tfMarca.getText();
                produto = new Produto(nome, descricao, preco, quant);
                if (sis.inserir(produto)) {
                    JOptionPane.showMessageDialog(null, "Produto Inserido com Sucesso!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "O Produto não foi Inserido!");
                    dispose();
                }
        }
    }//GEN-LAST:event_jSalvarMouseClicked

    private void jCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelarMouseClicked
        // TODO add your handling code here:
        jNovo.setEnabled(true);
        jSalvar.setEnabled(false);
        jCancelar.setEnabled(false);
        tfNome.setEnabled(false);
        tfPreco.setEnabled(false);
        tfQuant.setEnabled(false);
        cbMarca.setEnabled(false);
    }//GEN-LAST:event_jCancelarMouseClicked

    private preencherSelect(){
        cbMarca.removeAllItems();
        
    }
    
    private void CarregarProdutos() {
        ArrayList<Produto> produtos = (ArrayList<Produto>) sis.listar();
        DefaultTableModel modelo = (DefaultTableModel) tbListar.getModel();
        modelo.setNumRows(0);
        produtos.forEach((_item) -> {
            modelo.addRow(new Object[]{
                _item.getCodigo(),
                _item.getNome(),
                _item.getDescricao(),
                "R$ " + _item.getPreco(),
                _item.getQuantEstoque()

            });
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbMarca;
    private javax.swing.JButton jAdicionarMarca;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jCancelar;
    private javax.swing.JMenu jEditar;
    private javax.swing.JMenu jExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu jNovo;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu jSair;
    private javax.swing.JMenu jSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListar;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfQuant;
    // End of variables declaration//GEN-END:variables

}
