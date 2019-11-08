package loja.negocio;

import java.util.List;
import loja.dados.IRepoVenda;
import loja.dados.RepoVendaArray;

public class ControladorVenda {

    private IRepoVenda repovenda;

    public ControladorVenda(IRepoVenda repoVenda) {
        this.repovenda = repoVenda;
    }

    public boolean inserirCarrinho(Item item) {
        return repovenda.inserirCarrinho(item);
    }

    public Item criarItem(Produto produto, double quantidade) {
        return repovenda.criarItem(produto, quantidade);
    }

    public List<Venda> listar() {
        return repovenda.listarVenda();
    }

    public Venda concluirVenda(String nomeCliente) {
        return repovenda.concluirVenda(nomeCliente);
    }

    public List<Venda> listarData(String data) {
        return repovenda.listarData(data);
    }

    public Venda listarCodigo(int codigo) {
        return repovenda.listarCodigo(codigo);
    }

    public Carrinho listarCarrinho() {
        return repovenda.listarCarrinho();
    }

    public void limparCarrinho() {
        repovenda.limparCarrinho();
    }

    public boolean excluirItemCarrinho(int codigo) {
        return repovenda.excluirItemCarrinho(codigo);
    }

}
