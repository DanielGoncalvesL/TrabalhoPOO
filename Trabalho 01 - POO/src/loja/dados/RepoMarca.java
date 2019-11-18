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
import loja.negocio.Marca;

/**
 *
 * @author Daniel
 */
public class RepoMarca implements IRepoMarca {

    /**
     *
     * @param marca
     * @return
     */
    @Override
    public boolean inserir(Marca marca) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO marca (nomeMarca, representanteComercial) values (?, ?)");
            stmt.setString(1, marca.getNome());
            stmt.setString(2, marca.getRepresentanteComercial());

            int executeUpdate = stmt.executeUpdate();

            return executeUpdate == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
        return false;
    }

    /**
     *
     * @param codigo
     * @return
     */
    @Override
    public boolean excluir(int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM marca WHERE idMarca = ?");
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

    /**
     *
     * @param marca
     * @param codigo
     * @return
     */
    @Override
    public boolean alterar(Marca marca, int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE marca SET nomeMarca = ?, representanteComercial = ? WHERE idMarca = ?");
            stmt.setString(1, marca.getNome());
            stmt.setString(2, marca.getRepresentanteComercial());
            stmt.setInt(3, codigo);

            int executeUpdate = stmt.executeUpdate();

            return executeUpdate == 1;
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Marca> listar() {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM marca");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca(rs.getInt("idMarca"), rs.getString("nomeMarca"), rs.getString("representanteComercial"));
                marcas.add(marca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return marcas;
    }

    /**
     *
     * @param nome
     * @return
     */
    @Override
    public Marca buscarNome(String nome) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Marca marca = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM marca WHERE nomeMarca = '?'");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            while (rs.next()) {
                marca = new Marca(rs.getInt("idMarca"), rs.getString("nomeMarca"), rs.getString("representanteComercial"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return marca;
    }

    /**
     *
     * @param codigo
     * @return
     */
    @Override
    public Marca buscarMarca(int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Marca marca = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM marca WHERE idMarca = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                marca = new Marca(rs.getInt("idMarca"), rs.getString("nomeMarca"), rs.getString("representanteComercial"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return marca;
    }
}
