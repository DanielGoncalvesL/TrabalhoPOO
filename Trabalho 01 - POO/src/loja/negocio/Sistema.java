package loja.negocio;

import java.util.List;
import loja.dados.IRepoMarca;
import loja.dados.IRepoProduto;
import loja.dados.IRepoVenda;

public final class Sistema {

    private final ControladorProduto cProduto;

    private final ControladorVenda cVenda;

    private static Sistema instance;

    private final ControladorMarca cMarca;

    private Sistema(IRepoProduto repoProduto, IRepoVenda repovenda, IRepoMarca repoMarca) {
        cProduto = new ControladorProduto(repoProduto);
        cVenda = new ControladorVenda(repovenda);
        cMarca = new ControladorMarca(repoMarca);
        init();
    }

    public static Sistema getInstance(IRepoProduto repoProduto, IRepoVenda repovenda, IRepoMarca repoMarca) {
        if (instance == null) {
            instance = new Sistema(repoProduto, repovenda, repoMarca);
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

    /**
     *
     * @return
     */
    public Carrinho listarCarrinho() {
        return cVenda.listarCarrinho();
    }

    /**
     *
     */
    public void limparCarrinho() {
        cVenda.limparCarrinho();
    }

    /**
     *
     * @param codigo
     * @return
     */
    public boolean excluirItemCarrinho(int codigo) {
        return cVenda.excluirItemCarrinho(codigo);
    }

    /**
     *
     * @param marca
     * @return
     */
    public boolean inserirMarca(Marca marca) {
        return cMarca.inserir(marca);
    }

    /**
     *
     * @param codigo
     * @return
     */
    public boolean excluirMarca(int codigo) {
        return cMarca.excluir(codigo);
    }

    public boolean alterarMarca(Marca marca, int codigo) {
        return cMarca.alterar(marca, codigo);
    }

    public List<Marca> listarMarca() {
        return cMarca.listar();
    }

    public Marca buscarNomeMarca(String nome) {
        return cMarca.buscarNome(nome);
    }

    public void init() {
        this.inserirMarca(new Marca("Supang", "Representante Comercial"));
        this.inserirMarca(new Marca("Yoki", "Representante Comercial"));
        this.inserirMarca(new Marca("Renata", "Representante Comercial"));
        this.inserirMarca(new Marca("União", "Representante Comercial"));
        this.inserirMarca(new Marca("Rei Arthur", "Representante Comercial"));

        this.inserir(new Produto("Arroz", 5, 15, 30));
        this.inserir(new Produto("Feijão", 1, 3.5, 30));
        this.inserir(new Produto("Macarrão", 3, 4, 30));
        this.inserir(new Produto("Canjiquinha", 2, 2, 30));
        this.inserir(new Produto("Açucar", 4, 8, 30));

        this.inserirCarrinho(criarItem(buscarNome("Arroz"), 1));
        this.inserirCarrinho(criarItem(buscarNome("Canjiquinha"), 1));
        this.concluirVenda("Daniel");

        this.inserirCarrinho(criarItem(buscarNome("Feij�o"), 1));
        this.concluirVenda("Luciano");
    }

    public Marca buscarMarca(int marca) {
       return cMarca.buscarMarca(marca);
    }
}
