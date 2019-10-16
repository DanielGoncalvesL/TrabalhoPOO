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
			for (int i = 0; i < carrinho.getItens().length; i++) {
				if (itens.get(i) != null && itens.get(i).getProduto().getCodigo() == item.getProduto().getCodigo()) {
					itens.get(i).setQuantidade(item.getQuantidade() + itens.get(i).getQuantidade());
					return true;
				} else {
					if (itens.get(i) == null) {
						itens.set(i, item);
						carrinho.setItens(itens.get(i));
						return true;
					}
				}
			}
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

	public Venda[] listarVenda() {
		if (vendas != null) {
			return vendas;
		}
		return null;
	}

	public Venda[] listarData(String data) {
		if (vendas != null) {
			Venda[] venda = new Venda[10];
			int j = 0;
			for (int i = 0; i < vendas.length; i++) {
				if (vendas[i] != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String date = sdf.format(vendas[i].getData());
					if (date.equals(data)) {
						if (venda[j] == null && j < venda.length) {
							venda[j] = vendas[i];
							j++;
						}
					}
				}
			}
			return venda;
		} else
			return null;
	}

	public Venda listarCodigo(int codigo) {
		if (vendas != null) {
			for (int i = 0; i < vendas.length; i++) {
				if (vendas[i] != null && vendas[i].getCodigo() == codigo) {
					return vendas[i];
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
			Venda venda = new Venda();
			venda.setItensVendidos(carrinho.getItens());
			Date data = new Date();
			venda.setData(data);
			venda.setCodigo(codigoVenda);
			codigoVenda++;
			venda.setNomeCliente(nomeCliente);
			for (int i = 0; i < vendas.length; i++) {
				if (venda != null && vendas[i] == null) {
					for (int j = 0; j < carrinho.getItens().length; j++) {
						if (carrinho.getItens()[i] != null) {
							carrinho.getItens()[i].getProduto().setVendido(1);
						}
					}
					vendas[i] = venda;
					carrinho = new Carrinho();
					itens = new Item[10];
					return venda;
				}
			}
			return null;
		}
		return null;
	}
}
