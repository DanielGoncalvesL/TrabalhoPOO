/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.ui;

import java.awt.Color;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import loja.negocio.Sistema;
import loja.negocio.Usuario;

/**
 *
 * @author Daniel
 */
public class CRUDUsuario extends javax.swing.JDialog {

    private final Sistema sis;

    /**
     * Creates new form CRUDUsuario
     *
     * @param parent
     * @param modal
     */
    public CRUDUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        sis = Sistema.getInstance();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListar = new javax.swing.JTable();
        tfSenha = new javax.swing.JPasswordField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jNovo = new javax.swing.JMenu();
        jEditar = new javax.swing.JMenu();
        jExcluir = new javax.swing.JMenu();
        jSalvar = new javax.swing.JMenu();
        jCancelar = new javax.swing.JMenu();
        jSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Login");

        tfLogin.setEnabled(false);

        jLabel2.setText("Tipo");

        cbTipo.setEnabled(false);

        jLabel3.setText("Senha");

        tbListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Login", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListar);
        if (tbListar.getColumnModel().getColumnCount() > 0) {
            tbListar.getColumnModel().getColumn(0).setResizable(false);
            tbListar.getColumnModel().getColumn(1).setResizable(false);
            tbListar.getColumnModel().getColumn(2).setResizable(false);
        }

        tfSenha.setEnabled(false);

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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfSenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(223, 223, 223))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

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

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_edit.png"))); // NOI18N
        jEditar.setText("Editar");
        jEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jEditarMouseExited(evt);
            }
        });
        jMenuBar1.add(jEditar);

        jExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/page_delete.png"))); // NOI18N
        jExcluir.setText("Excluir");
        jExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jExcluirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jExcluirMouseExited(evt);
            }
        });
        jMenuBar1.add(jExcluir);

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

    private void jNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNovoMouseClicked
        // TODO add your handling code here:
        reiniciarMenu();
        jNovo.setEnabled(false);
        jSalvar.setEnabled(true);
        jCancelar.setEnabled(true);
        tfLogin.setEnabled(true);
        cbTipo.setEnabled(true);
        preencherSelect();
    }//GEN-LAST:event_jNovoMouseClicked

    private void jNovoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNovoMouseEntered
        // TODO add your handling code here:
        jNovo.setForeground(Color.red);
    }//GEN-LAST:event_jNovoMouseEntered

    private void jNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNovoMouseExited
        // TODO add your handling code here:
        jNovo.setForeground(Color.black);
    }//GEN-LAST:event_jNovoMouseExited

    private void jEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditarMouseClicked
        // TODO add your handling code here:
        try {
            boolean ok = true;
            if (tfLogin.getText().equals("")) {
                ok = false;
                tfLogin.setBackground(Color.PINK);
            } else {
                tfLogin.setBackground(Color.WHITE);
            }
            if (ok) {
                String nome = tfLogin.getText();
                String senha = new String(tfSenha.getPassword());
                String tipo = (String) cbTipo.getSelectedItem();
                Usuario usuario = new Usuario(nome, senha, tipo);
                 int cod = (int) tbListar.getValueAt(tbListar.getSelectedRow(), 0);
                if (sis.alterarUsuario(usuario, cod)) {
                    JOptionPane.showMessageDialog(this, "Produto Alterado com Sucesso!");
                    carregarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(this, "O Produto não foi Alterado!");
                    carregarUsuarios();
                }
                reiniciarMenu();
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Falha ao Alterar o Produto");
        }
    }//GEN-LAST:event_jEditarMouseClicked

    private void jEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditarMouseEntered
        // TODO add your handling code here:
        jEditar.setForeground(Color.red);
    }//GEN-LAST:event_jEditarMouseEntered

    private void jEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEditarMouseExited
        // TODO add your handling code here:
        jEditar.setForeground(Color.black);
    }//GEN-LAST:event_jEditarMouseExited

    private void jExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExcluirMouseClicked
        // TODO add your handling code here:
        try {
            int cod = (int) tbListar.getValueAt(tbListar.getSelectedRow(), 0);
            if (sis.excluir(cod)) {
                JOptionPane.showMessageDialog(this, "Item excluído com sucesso!");
                carregarUsuarios();
                reiniciarMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Falha ao excluir!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Selecione algum registro da tabela");
        }
    }//GEN-LAST:event_jExcluirMouseClicked

    private void jExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExcluirMouseEntered
        // TODO add your handling code here:
        jExcluir.setForeground(Color.red);
    }//GEN-LAST:event_jExcluirMouseEntered

    private void jExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jExcluirMouseExited
        // TODO add your handling code here:
        jExcluir.setForeground(Color.black);
    }//GEN-LAST:event_jExcluirMouseExited

    private void jSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalvarMouseClicked
        // TODO add your handling code here:
        boolean ok = true;
        if (tfLogin.getText().equals("")) {
            ok = false;
            tfLogin.setBackground(Color.PINK);
        } else {
            tfLogin.setBackground(Color.WHITE);
        }
        if (ok) {
            String nome = tfLogin.getText();
            String senha = new String(tfSenha.getPassword());
            String tipo = (String) cbTipo.getSelectedItem();
            Usuario usuario = new Usuario(nome, senha, tipo);
            if (sis.inserirUsuario(usuario)) {
                JOptionPane.showMessageDialog(this, "Produto Inserido com Sucesso!");
                carregarUsuarios();
            } else {
                JOptionPane.showMessageDialog(this, "O Produto não foi Inserido!");
                carregarUsuarios();
            }
            reiniciarMenu();
        }
    }//GEN-LAST:event_jSalvarMouseClicked

    private void jSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalvarMouseEntered
        // TODO add your handling code here:
        jSalvar.setForeground(Color.red);
    }//GEN-LAST:event_jSalvarMouseEntered

    private void jSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalvarMouseExited
        // TODO add your handling code here:
        jSalvar.setForeground(Color.black);
    }//GEN-LAST:event_jSalvarMouseExited

    private void jCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelarMouseClicked
        // TODO add your handling code here:
        reiniciarMenu();
    }//GEN-LAST:event_jCancelarMouseClicked

    private void jCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelarMouseEntered
        // TODO add your handling code here:
        jCancelar.setForeground(Color.red);
    }//GEN-LAST:event_jCancelarMouseEntered

    private void jCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCancelarMouseExited
        // TODO add your handling code here:
        jCancelar.setForeground(Color.black);
    }//GEN-LAST:event_jCancelarMouseExited

    private void jSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSairMouseClicked

    private void jSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseEntered
        // TODO add your handling code here:
        jSair.setForeground(Color.red);
    }//GEN-LAST:event_jSairMouseEntered

    private void jSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSairMouseExited
        // TODO add your handling code here:
        jSair.setForeground(Color.black);
    }//GEN-LAST:event_jSairMouseExited

    private void tbListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListarMouseClicked
        // TODO add your handling code here:
        try {
            jNovo.setEnabled(true);
            jSalvar.setEnabled(false);
            jCancelar.setEnabled(true);
            tfLogin.setEnabled(true);
            tfSenha.setEnabled(true);
            cbTipo.setEnabled(true);
            preencherSelect();
            tfLogin.setText((String) tbListar.getValueAt(tbListar.getSelectedRow(), 1));
            String tipo = (String) tbListar.getValueAt(tbListar.getSelectedRow(), 2);
            Usuario usuario = sis.buscarUsuario((int) tbListar.getValueAt(tbListar.getSelectedRow(), 0));
            tfSenha.setText(usuario.getSenha());
            cbTipo.setSelectedItem(tipo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbListarMouseClicked

    private void reiniciarMenu() {
        tfLogin.setEnabled(false);
        tfLogin.setText("");
        cbTipo.setEnabled(false);
        cbTipo.removeAllItems();
        jNovo.setEnabled(true);
        jSalvar.setEnabled(false);
        jCancelar.setEnabled(false);
        tfLogin.setBackground(Color.white);
    }

    private void preencherSelect() {
        cbTipo.addItem("Administrador");
        cbTipo.addItem("Atendente");
    }

    private void carregarUsuarios() {
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>) sis.listarUsuarios();
        DefaultTableModel modelo = (DefaultTableModel) tbListar.getModel();
        modelo.setNumRows(0);
        usuarios.forEach((usuario) -> {
            modelo.addRow(new Object[]{
                usuario.getId(),
                usuario.getUser(),
                usuario.getTipo()
            });
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JMenu jCancelar;
    private javax.swing.JMenu jEditar;
    private javax.swing.JMenu jExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jNovo;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu jSair;
    private javax.swing.JMenu jSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbListar;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}
