package loja.dados;

import loja.negocio.Produto;
import loja.negocio.Venda;

public class RepoProdutoArray {
	private Produto[] produtos = new Produto[10];
	private int codigo = 0;

	public boolean inserir(Produto produto) {
		if (produto != null) {
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] != null && produtos[i].getNome().equals(produto.getNome())) {
					return false;
				} else {
					if (produtos[i] == null) {
						produtos[i] = produto;
						produtos[i].setCodigo(codigo);
						codigo++;
						return true;
					}
				}
			}
		} else {
			return false;
		}
		return false;
	}

	public boolean excluir(int codigo) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null && produtos[i].getCodigo() == codigo && produtos[i].getVendido() != 1) {
				produtos[i] = null;
				return true;
			} else {
				if(produtos[i] != null && produtos[i].getCodigo() == codigo && produtos[i].getVendido() == 1) {
					produtos[i].setExcluido(1);
					return true;
				}
			}
		}
		return false;
	}

	public boolean alterar(Produto produto, int codigo) {
		if (produto != null) {
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] != null && produtos[i].getCodigo() == codigo) {
					produtos[i] = produto;
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public Produto buscar(int codigo) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null && produtos[i].getCodigo() == codigo) {
				return produtos[i];
			}
		}
		return null;
	}

	public Produto[] listar() {
		if (produtos != null) {
			for (int j = 0; j < produtos.length; j++) {
				for (int i = 0; i < produtos.length - 1; i++) {
					if (produtos[i] != null && produtos[i + 1] != null
							&& produtos[i].getCodigo() > produtos[i + 1].getCodigo()) {
						Produto aux = produtos[i];
						produtos[i] = produtos[i + 1];
						produtos[i + 1] = aux;
					}
				}
			}
			return produtos;
		} else {
			return null;
		}
	}

	public Produto[] listarNome() {
		for (int j = 0; j < produtos.length; j++) {
			for (int i = 0; i < produtos.length - 1; i++) {
				if (produtos[i] != null && produtos[i + 1] != null
						&& produtos[i].getNome().compareToIgnoreCase(produtos[i + 1].getNome()) > 0) {
					Produto aux = produtos[i];
					produtos[i] = produtos[i + 1];
					produtos[i + 1] = aux;
				}
			}
		}
		return produtos;
	}

	public Produto buscarNome(String nome) {
		if (nome != null) {
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] != null && produtos[i].getNome().equals(nome)) {
					return produtos[i];
				}
			}
		}
		return null;
	}

	public boolean abaterEstoque(Venda abaterEstoque) {
		if (abaterEstoque != null && produtos != null) {
			int abateu = 0;
			for (int i = 0; i < abaterEstoque.getItensVendidos().length; i++) {
				for (int j = 0; j < produtos.length; j++) {
					if (abaterEstoque.getItensVendidos()[i] != null && produtos[j] != null
							&& abaterEstoque.getItensVendidos()[i].getProduto().getNome().equals(produtos[j].getNome())
							&& abaterEstoque.getItensVendidos()[i].getQuantidade() <= produtos[j].getQuantEstoque()) {
						produtos[j].setQuantEstoque(
								produtos[j].getQuantEstoque() - abaterEstoque.getItensVendidos()[i].getQuantidade());
						abateu = 1;
					}
				}
			}
			if (abateu == 1) {
				return true;
			}
		}
		return false;
	}

}
