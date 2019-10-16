package loja.dados;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import loja.negocio.Carrinho;
import loja.negocio.Item;
import loja.negocio.Produto;
import loja.negocio.Venda;

public class RepoVendaArray {

    private final List<Venda> vendas = new ArrayList<>();
    private List<Item> itens = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    private int codigoVenda = 0;

    public boolean inserirCarrinho(Item item) {
        if (item != null) {
            for (int i = 0; i < carrinho.getItens().size(); i++) {
                if (carrinho.getItens().get(i) != null && carrinho.getItens().get(i).getProduto().getCodigo() == item.getProduto().getCodigo()) {
                    carrinho.getItens().get(i).setQuantidade(carrinho.getItens().get(i).getQuantidade() + item.getQuantidade());
                    return true;
                }
            }
            carrinho.getItens().add(item);
        }
        return false;
    }

    public Item criarItem(Produto produto, double quantidade) {
        if (produto != null) {
            Item item = new Item();
            item.setProduto(produto);
            item.setPreco(quantidade * produto.getPreco());
            item.setQuantidade(quantidade);
            return item;
        }
        return null;
    }

    public List<Venda> listarVenda() {
        if (vendas != null) {
            return vendas;
        }
        return null;
    }

    public List<Venda> listarData(String data) {
        if (vendas != null) {
            Venda[] venda = new Venda[10];
            int j = 0;
            for (int i = 0; i < vendas.size(); i++) {
                if (vendas.get(i) != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String date = sdf.format(vendas.get(i).getData());
                    if (date.equals(data)) {
                        if (venda[j] == null && j < venda.length) {
                            vendas.set(i, vendas.get(i));
                            j++;
                        }
                    }
                }
            }
            return venda;
        } else {
            return null;
        }
    }

    public Venda listarCodigo(int codigo) {
        if (vendas != null) {
            for (int i = 0; i < vendas.size(); i++) {
                if (vendas.get(i) != null && vendas.get(i).getCodigo() == codigo) {
                    return vendas.get(i);
                }
            }
        }
        return null;
    }

    public Carrinho listarCarrinho() {
        if (carrinho != null) {
            return carrinho;
        }
        return null;
    }

    public Venda concluirVenda(String nomeCliente) {
        if (carrinho != null) {
            Date data = new Date();
            Venda venda = new Venda(codigoVenda, data, carrinho.getItens(), nomeCliente);
            codigoVenda++;
            vendas.add(venda);
            carrinho = new Carrinho();
            itens = new ArrayList<>();
            return venda;
        }
        return null;
    }

}
