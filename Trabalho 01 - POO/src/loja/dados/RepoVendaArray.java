package loja.dados;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import loja.negocio.Carrinho;
import loja.negocio.Item;
import loja.negocio.Produto;
import loja.negocio.Venda;

public class RepoVendaArray implements IRepoVenda {

    private Carrinho carrinho = new Carrinho();

    @Override
    public Item criarItem(Produto produto, int quantidade) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("INSERT INTO Item (preco, quantidade, idProduto) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, produto.getPreco());
            stmt.setInt(2, quantidade);
            stmt.setInt(3, produto.getCodigo());

            stmt.executeUpdate();
            final ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                final int lastId = rs.getInt(1);
                Item item = this.buscarItem(lastId);
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
        return null;
    }

    @Override
    public boolean inserirCarrinho(Item item) {
        if (item != null) {
            for (int i = 0; i < carrinho.getItens().size(); i++) {
                if (carrinho.getItens().get(i) != null && carrinho.getItens().get(i).getProduto() == item.getProduto()) {
                    carrinho.getItens().get(i).setQuantidade(carrinho.getItens().get(i).getQuantidade() + item.getQuantidade());
                    if (this.atualizarItens(carrinho.getItens().get(i).getId(), carrinho.getItens().get(i).getQuantidade())) {
                        return true;
                    }
                }
            }
            carrinho.getItens().add(item);
            return true;
        }
        return false;
    }

    private boolean atualizarItens(int id, int quantidade) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = conexao.prepareStatement("UPDATE item SET quantidade = ? WHERE idItem = ?");
            stmt.setInt(1, quantidade);
            stmt.setInt(2, id);

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
    public int concluirVenda(String nome) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        double precoTotal = 0;

        try {
            if (carrinho != null) {
                stmt = conexao.prepareStatement("INSERT INTO venda (precoVenda, dataVenda, nomeCliente) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                for (Item item : carrinho.getItens()) {
                    precoTotal = precoTotal + (item.getPreco() * item.getQuantidade());
                }
                stmt.setDouble(1, precoTotal);
                Date data = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                String date = sdf.format(data);
                stmt.setString(2, date);
                stmt.setString(3, nome);

                stmt.executeUpdate();
                final ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    final int lastId = rs.getInt(1);
                    limparCarrinho(lastId);
                    return lastId;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
        return -1;
    }

    @Override
    public List<Item> buscarItens(int idVenda) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Item> itens = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("select item.idItem, item.preco, item.quantidade, item.idProduto from produto inner join item on produto.idproduto = item.iditem inner join itemvenda on item.idItem = itemvenda.idItem inner join venda on venda.idvenda = itemvenda.idvenda where itemvenda.idvenda = ?");
            stmt.setInt(1, idVenda);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Item item = new Item(rs.getInt("idItem"), rs.getDouble("preco"), rs.getInt("quantidade"), rs.getInt("idProduto"));
                itens.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return itens;
    }

    @Override
    public void limparCarrinho() {
        carrinho = new Carrinho();
    }

    @Override
    public void limparCarrinho(int i) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            for (Item item : carrinho.getItens()) {
                stmt = conexao.prepareStatement("INSERT INTO ItemVenda (idItem, idVenda) values (?, ?)");
                stmt.setInt(1, item.getId());
                stmt.setInt(2, i);

                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt);
        }
        carrinho = new Carrinho();
    }

    @Override
    public Item buscarItem(int idItem) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Item item = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM item WHERE idItem = ?");
            stmt.setInt(1, idItem);
            rs = stmt.executeQuery();

            while (rs.next()) {
                item = new Item(rs.getInt("idItem"), rs.getDouble("preco"), rs.getInt("quantidade"), rs.getInt("idProduto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return item;
    }

    @Override
    public boolean excluirItemCarrinho(int codigo) {
        for(Item item : carrinho.getItens()){
            if(item.getId() == codigo){
                carrinho.getItens().remove(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Venda> listarVendas() {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda(rs.getInt("idVenda"), rs.getDate("dataVenda"), rs.getDouble("precoVenda"), rs.getString("nomeCliente"));
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return vendas;
    }

    @Override
    public List<Venda> listarData(String data) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();

        try {
            stmt = conexao.prepareStatement("SELECT * FROM venda WHERE dataVenda = ?");
            stmt.setString(1, data);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda(rs.getInt("idVenda"), rs.getDate("dataVenda"), rs.getDouble("precoVenda"), rs.getString("nomeCliente"));
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return vendas;
    }

    @Override
    public Carrinho listarCarrinho() {
        if (carrinho != null) {
            return carrinho;
        }
        return null;
    }

    @Override
    public Venda buscarVenda(int idVenda) {
        Connection conexao = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Venda venda = null;

        try {
            stmt = conexao.prepareStatement("SELECT * FROM venda WHERE idVenda = ?");
            stmt.setInt(1, idVenda);
            rs = stmt.executeQuery();

            while (rs.next()) {
                venda = new Venda(rs.getInt("idVenda"), rs.getDate("dataVenda"), rs.getDouble("precoVenda"), rs.getString("nomeCliente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepoProdutoArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao, stmt, rs);
        }

        return venda;
    }

}
