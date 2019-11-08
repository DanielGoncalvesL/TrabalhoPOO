package loja.negocio;

import java.util.List;
import loja.dados.IRepoProduto;
import loja.dados.IRepoVenda;

public final class Sistema {

    private final ControladorProduto cProduto;

    private final ControladorVenda cVenda;

    private static Sistema instance;

    private Sistema(IRepoProduto repoProduto, IRepoVenda repovenda) {
        cProduto = new ControladorProduto(repoProduto);
        cVenda = new ControladorVenda(repovenda);
        init();
    }

    public static Sistema getInstance(IRepoProduto repoProduto, IRepoVenda repovenda) {
        if (instance == null) {
            instance = new Sistema(repoProduto, repovenda);
        }
        return instance;
    }

    public static Sistema getInstance() {
        if (instance == null) {
            throw new NullPointerException("Inicializar a classe Sistema primeiro");
        }
        return instance;
    }

    public boolean inserir(Produto produto) {
        return cProduto.inserir(produto);
    }

    public boolean excluir(int codigo) {
        return cProduto.excluir(codigo);
    }

    public boolean alterar(Produto produto, int codigo) {
        return cProduto.alterar(produto, codigo);
    }

    public Produto buscar(int codigo) {
        return cProduto.buscar(codigo);
    }

    public List<Produto> listar() {
        return cProduto.listar();
    }

    public List<Produto> listarNome() {
        return cProduto.listarNome();
    }

    public Produto buscarNome(String nome) {
        return cProduto.buscarNome(nome);
    }

    public List<Produto> FiltrarNome(String nome) {
        return cProduto.FiltrarNome(nome);
    }

    public Item criarItem(Produto produto, double quantidade) {
        return cVenda.criarItem(produto, quantidade);
    }

    public boolean inserirCarrinho(Item item) {
        return cVenda.inserirCarrinho(item);
    }

    public List<Venda> listarVenda() {
        return cVenda.listar();
    }

    public boolean concluirVenda(String nomeCliente) {
        Venda abaterEstoque = cVenda.concluirVenda(nomeCliente);
        return cProduto.abaterEstoque(abaterEstoque);
    }

    public List<Venda> listarData(String data) {
        return cVenda.listarData(data);
    }

    public Venda listarCodigo(int codigo) {
        return cVenda.listarCodigo(codigo);
    }

    public Carrinho listarCarrinho() {
        return cVenda.listarCarrinho();
    }

    public void limparCarrinho() {
        cVenda.limparCarrinho();
    }

    public boolean excluirItemCarrinho(int codigo) {
        return cVenda.excluirItemCarrinho(codigo);
    }

    public void init() {
        this.inserir(new Produto("Arroz", "Rei Arthur", 15, 30));
        this.inserir(new Produto("Feij�o", "Supang", 3.5, 30));
        this.inserir(new Produto("Macarr�o", "Renata", 4, 30));
        this.inserir(new Produto("Canjiquinha", "Yoki", 2, 30));
        this.inserir(new Produto("A�ucar", "Uni�o", 8, 30));

        this.inserirCarrinho(criarItem(buscarNome("Arroz"), 1));
        this.inserirCarrinho(criarItem(buscarNome("Canjiquinha"), 1));
        this.concluirVenda("Daniel");

        this.inserirCarrinho(criarItem(buscarNome("Feij�o"), 1));
        this.concluirVenda("Luciano");
    }
}
