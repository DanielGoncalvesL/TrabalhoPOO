package loja.negocio;

import java.util.List;
import loja.dados.IRepoProduto;
import loja.dados.RepoProdutoArray;

public class ControladorProduto {

    private final IRepoProduto reproduto;

    public ControladorProduto(IRepoProduto repoProduto) {
        this.reproduto = repoProduto;
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
    
    public List<Produto> FiltrarNome(String nome) {
        return reproduto.FiltrarNome(nome);
    }

    public boolean abaterEstoque(Venda abaterEstoque) {
        return reproduto.abaterEstoque(abaterEstoque);
    }
}
