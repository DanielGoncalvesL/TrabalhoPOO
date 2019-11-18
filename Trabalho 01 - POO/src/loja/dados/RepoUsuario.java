/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dados;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import loja.negocio.Usuario;

/**
 *
 * @author Daniel
 */
public class RepoUsuario implements IRepoUsuario {

    @Override
    public boolean verificarLogin(String login, String senha) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return false;
    }

    @Override
    public boolean inserirUsuario(Usuario usuario) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO usuario (login, senha, tipo) values (?, ?, ?)");
            stmt.setString(1, usuario.getUser());
            stmt.setDouble(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipo());

            int executeUpdate = stmt.executeUpdate();

            return executeUpdate == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
        return false;
    }
    
    @Override
    public String tipoUsuario(String usuario){
     Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String tipo = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE login = ?");
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                tipo = rs.getString("tipo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return tipo;    
    }
}
