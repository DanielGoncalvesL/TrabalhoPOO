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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import loja.negocio.Usuario;

/**
 *
 * @author Daniel
 */
public class RepoUsuario implements IRepoUsuario{

    
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

        if (!this.listarUsuarios().stream().noneMatch((user) -> (user.getUser().equals(usuario)))) {
            return false;
        }
        try {
            stmt = conexao.prepareStatement("INSERT INTO usuario (login, senha, tipo) values (?, ?, ?)");
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getSenha());
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
    public String tipoUsuario(String usuario) {
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

    
    @Override
    public boolean excluirUsuario(int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, codigo);

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
    public List<Usuario> listarUsuarios() {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("login"), rs.getString("senha"), rs.getString("tipo"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return usuarios;
    }

    
    @Override
    public boolean alterarUsuario(Usuario usuario, int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE usuario SET login = ?, senha = ?, tipo = ? WHERE idUsuario = ?");
            stmt.setString(1, usuario.getUser());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTipo());
            stmt.setInt(4, codigo);

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
    public Usuario buscarUsuario(int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("login"), rs.getString("senha"), rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return usuario;
    }
}
