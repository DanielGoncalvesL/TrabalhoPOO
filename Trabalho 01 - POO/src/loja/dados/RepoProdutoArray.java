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
import loja.negocio.Item;
import loja.negocio.Produto;

public class RepoProdutoArray implements IRepoProduto {

    private final List<Produto> produtos = new ArrayList<>();
    private final int codigo = 1;

    @Override
    public boolean inserir(Produto produto) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO produto (nomeProduto, preco, quantidadeEstoque, idMarca) values (?, ?, ?, ?)");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantEstoque());
            stmt.setInt(4, produto.getMarca());

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
    public boolean excluir(int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
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
    public boolean alterar(Produto produto, int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE produto SET nomeProduto = ?, preco = ?, quantidadeEstoque = ?, idMarca = ? WHERE idProduto = ?");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantEstoque());
            stmt.setInt(4, produto.getMarca());
            stmt.setInt(5, codigo);

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
    public Produto buscar(int codigo) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM Produto WHERE idProduto = ?");
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                produto = new Produto(rs.getInt("idProduto"), rs.getString("nomeProduto"), rs.getInt("idMarca"), rs.getDouble("preco"), rs.getInt("quantidadeEstoque"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return produto;
    }

    @Override
    public List<Produto> listar() {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos1 = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("idProduto"), rs.getString("nomeProduto"), rs.getInt("idMarca"), rs.getDouble("preco"), rs.getInt("quantidadeEstoque"));
                produtos1.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return produtos1;
    }

    @Override
    public List<Produto> listarNome() {
        produtos.forEach((_item) -> {
            for (int i = 0; i < produtos.size() - 1; i++) {
                if (produtos.get(i).getNome().compareToIgnoreCase(produtos.get(i + 1).getNome()) > 0) {
                    Produto aux = produtos.get(i);
                    produtos.set(i, produtos.get(i + 1));
                    produtos.set(i + 1, aux);
                }
            }
        });
        return produtos;
    }

    @Override
    public Produto buscarNome(String nome) {
        if (nome != null) {
            for (Produto produto : produtos) {
                if (produto != null && produto.getNome().equals(nome)) {
                    return produto;
                }
            }
        }
        return null;
    }

    @Override
    public List<Produto> FiltrarNome(String nome) {
        if (nome != null) {
            List<Produto> prod = new ArrayList<>();
            for (Produto produto : produtos) {
                if (produto != null && produto.getNome().equals(nome)) {
                    prod.add(produto);
                    return prod;
                }
            }
        }
        return null;
    }

    @Override
    public boolean abaterEstoque(List<Item> itens) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            for (Item item : itens) {
                Produto prod = this.buscar(item.getProduto());
                if (prod.getQuantEstoque() - item.getQuantidade() >= 0) {
                    stmt = conexao.prepareStatement("UPDATE produto SET quantidadeEstoque = ? WHERE idProduto = ?");
                    stmt.setInt(1, prod.getQuantEstoque() - item.getQuantidade());
                    stmt.setInt(2, prod.getCodigo());

                    stmt.executeUpdate();
                }else
                    return false;
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
        return false;
    }
    
}
