package loja.negocio;

import loja.dados.RepoVendaArray;

public class ControladorVenda {
	private RepoVendaArray repovenda;
	
	public ControladorVenda() {
		repovenda = new RepoVendaArray();
	}
	
	public boolean inserirCarrinho(Item item) {
		return repovenda.inserirCarrinho(item);
	}
	
	public Item criarItem(Produto produto, double quantidade) {
		return repovenda.criarItem(produto, quantidade);
	}
	
	public Venda[] listar() {
		return repovenda.listarVenda();
	}
	
	public Venda concluirVenda(String nomeCliente) {
		return repovenda.concluirVenda(nomeCliente);
	}
	
	public Venda[] listarData(String data) {
		return repovenda.listarData(data);
	}
	
	public Venda listarCodigo(int codigo) {
		return repovenda.listarCodigo(codigo);
	}
	
	public Carrinho listarCarrinho() {
		return repovenda.listarCarrinho();
	}
	
}
