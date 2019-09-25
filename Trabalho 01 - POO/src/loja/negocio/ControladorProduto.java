package loja.negocio;

import loja.dados.RepoProdutoArray;

public class ControladorProduto {
	
	private RepoProdutoArray reproduto;

	public ControladorProduto() {
		reproduto = new RepoProdutoArray();
	}

	public boolean inserir(Produto produto) {
		return reproduto.inserir(produto);
	}

	public boolean excluir(int codigo) {
		return reproduto.excluir(codigo);
	}

	public boolean alterar(Produto produto, int codigo) {
		return reproduto.alterar(produto, codigo);
	}

	public Produto buscar(int codigo) {
		return reproduto.buscar(codigo);
	}

	public Produto[] listar() {
		return reproduto.listar();
	}

	public Produto[] listarNome() {
		return reproduto.listarNome();
	}
	
	public Produto buscarNome(String nome) {
		return reproduto.buscarNome(nome);
	}

	public boolean abaterEstoque(Venda abaterEstoque) {
		return reproduto.abaterEstoque(abaterEstoque);
	}
}
