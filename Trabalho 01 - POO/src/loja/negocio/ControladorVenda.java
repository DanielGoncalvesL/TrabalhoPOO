package loja.negocio;

import java.util.List;
import loja.dados.IRepoVenda;

public class ControladorVenda {

    private final IRepoVenda repoVenda;

    public ControladorVenda(IRepoVenda repoProduto) {
        this.repoVenda = repoProduto;
    }

    public Item criarItem(Produto produto, int quantidade) {
        return repoVenda.criarItem(produto, quantidade);
    }

    public boolean inserirCarrinho(Item item) {
        return repoVenda.inserirCarrinho(item);
    }

    public int concluirVenda(String nome) {
        return repoVenda.concluirVenda(nome);
    }

    public List<Item> buscarItens(int idVenda) {
        return repoVenda.buscarItens(idVenda);
    }

    public boolean excluirItemCarrinho(int codigo) {
        return repoVenda.excluirItemCarrinho(codigo);
    }

    public void limparCarrinho() {
        repoVenda.limparCarrinho();
    }

    public List<Venda> listarVendas() {
        return repoVenda.listarVendas();
    }

    public List<Venda> listarData(String data) {
        return repoVenda.listarData(data);
    }

    public Carrinho listarCarrinho() {
        return repoVenda.listarCarrinho();
    }
    
    public Venda buscarVenda(int idVenda){
        return repoVenda.buscarVenda(idVenda);
    }
}
