package loja.negocio;

import java.util.List;
import loja.dados.RepoProdutoArray;

public class ControladorProduto {
	
	private final RepoProdutoArray reproduto;

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

	public List<Produto> listar() {
		return reproduto.listar();
	}

	public List<Produto> listarNome() {
		return reproduto.listarNome();
	}
	
	public Produto buscarNome(String nome) {
		return reproduto.buscarNome(nome);
	}

	public boolean abaterEstoque(Venda abaterEstoque) {
		return reproduto.abaterEstoque(abaterEstoque);
	}
}
