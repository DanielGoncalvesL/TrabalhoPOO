/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.ui;

import javax.swing.JOptionPane;
import loja.negocio.Produto;
import loja.negocio.Sistema;

/**
 *
 * @author Daniel
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
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

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        administrador = new javax.swing.JMenu();
        inserirProduto = new javax.swing.JMenuItem();
        excluirProduto = new javax.swing.JMenuItem();
        alterarProduto = new javax.swing.JMenuItem();
        listarProduto = new javax.swing.JMenuItem();
        listarVendas = new javax.swing.JMenuItem();
        listarVendasDia = new javax.swing.JMenuItem();
        buscarVenda = new javax.swing.JMenuItem();
        funcionario = new javax.swing.JMenu();
        realizarVenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lojinha DaniLet");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        administrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user_gray.png"))); // NOI18N
        administrador.setText("Administrador");

        inserirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/add.png"))); // NOI18N
        inserirProduto.setText("Inserir Produto");
        inserirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirProdutoActionPerformed(evt);
            }
        });
        administrador.add(inserirProduto);

        excluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        excluirProduto.setText("Excluir Produto");
        excluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirProdutoActionPerformed(evt);
            }
        });
        administrador.add(excluirProduto);

        alterarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pencil.png"))); // NOI18N
        alterarProduto.setText("Alterar Produto");
        alterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarProdutoActionPerformed(evt);
            }
        });
        administrador.add(alterarProduto);

        listarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/table.png"))); // NOI18N
        listarProduto.setText("Listar Produtos");
        listarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarProdutoActionPerformed(evt);
            }
        });
        administrador.add(listarProduto);

        listarVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/table.png"))); // NOI18N
        listarVendas.setText("Listar Vendas");
        listarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarVendasActionPerformed(evt);
            }
        });
        administrador.add(listarVendas);

        listarVendasDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/table.png"))); // NOI18N
        listarVendasDia.setText("Listar Vendas no Dia");
        listarVendasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarVendasDiaActionPerformed(evt);
            }
        });
        administrador.add(listarVendasDia);

        buscarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/zoom.png"))); // NOI18N
        buscarVenda.setText("Buscar Venda");
        buscarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarVendaActionPerformed(evt);
            }
        });
        administrador.add(buscarVenda);

        jMenuBar1.add(administrador);

        funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/user.png"))); // NOI18N
        funcionario.setText("Funcionario");

        realizarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/basket_add.png"))); // NOI18N
        realizarVenda.setText("Realizar Venda");
        funcionario.add(realizarVenda);

        jMenuBar1.add(funcionario);

        setJMenuBar(jMenuBar1);

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

    private void LimparJanelas() {
        for (int i = 0; i < jPanel1.countComponents(); i++) {
            jPanel1.remove(i);
        }
    }

    private void ReiniciarJanela() {
        dispose();
        this.setVisible(true);
    }

    private void inserirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirProdutoActionPerformed
        // TODO add your handling code here:
        LimparJanelas();
        CadastroProduto CadUser = new CadastroProduto();
        jPanel1.add(CadUser);
        CadUser.setVisible(true);
    }//GEN-LAST:event_inserirProdutoActionPerformed

    private void excluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirProdutoActionPerformed
        // TODO add your handling code here:
        LimparJanelas();
        ExcluirProduto ExcProd = new ExcluirProduto(new javax.swing.JFrame(), true);
        ExcProd.setLocationRelativeTo(null);
        ExcProd.setVisible(true);
         ReiniciarJanela();
        if (ExcProd.getCodigo() != 0) {
            if (sis.excluir(ExcProd.getCodigo())) {
                JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao Excluir!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Falha ao Excluir!");
        }
    }//GEN-LAST:event_excluirProdutoActionPerformed

    private void buscarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarVendaActionPerformed

    private void alterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarProdutoActionPerformed
        // TODO add your handling code here:
        LimparJanelas();
        CodigoAlterar CodAlt = new CodigoAlterar(new javax.swing.JFrame(), true);
        CodAlt.setLocationRelativeTo(null);
        CodAlt.setVisible(true);
        ReiniciarJanela();
        if (CodAlt.getCodigo() != 0) {
            Produto produto = sis.buscar(CodAlt.getCodigo());
            if (produto != null) {
                CadastroProduto CadUser = new CadastroProduto(produto);
                jPanel1.add(CadUser);
                CadUser.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "O Produto não foi Encotrado!");
            }
        }

    }//GEN-LAST:event_alterarProdutoActionPerformed

    private void listarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarProdutoActionPerformed
        // TODO add your handling code here:
        LimparJanelas();
        Listar listar = new Listar();
        jPanel1.add(listar);
        listar.setVisible(true);
    }//GEN-LAST:event_listarProdutoActionPerformed

    private void listarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarVendasActionPerformed
        // TODO add your handling code here:
        LimparJanelas();
        listarVenda listar = new listarVenda();
        jPanel1.add(listar);
        listar.setVisible(true);
    }//GEN-LAST:event_listarVendasActionPerformed

    private void listarVendasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarVendasDiaActionPerformed
        // TODO add your handling code here:
        LimparJanelas();
        DataVenda data = new DataVenda(new javax.swing.JFrame(), true);
        data.setLocationRelativeTo(null);
        data.setVisible(true);
        ReiniciarJanela();
        String date = data.getData();
        if(date != null){
            listarVenda listar = new listarVenda(date);
            jPanel1.add(listar);
            listar.setVisible(true);
        }
    }//GEN-LAST:event_listarVendasDiaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu administrador;
    private javax.swing.JMenuItem alterarProduto;
    private javax.swing.JMenuItem buscarVenda;
    private javax.swing.JMenuItem excluirProduto;
    private javax.swing.JMenu funcionario;
    private javax.swing.JMenuItem inserirProduto;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem listarProduto;
    private javax.swing.JMenuItem listarVendas;
    private javax.swing.JMenuItem listarVendasDia;
    private javax.swing.JMenuItem realizarVenda;
    // End of variables declaration//GEN-END:variables
    private final Sistema sis;
}
