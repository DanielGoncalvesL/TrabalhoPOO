package loja.negocio;

import java.util.List;
import loja.dados.IRepoMarca;
import loja.dados.IRepoProduto;
import loja.dados.IRepoUsuario;
import loja.dados.IRepoVenda;

public final class Sistema {

    private final ControladorProduto cProduto;

    private final ControladorVenda cVenda;

    private static Sistema instance;

    private final ControladorMarca cMarca;

    private final ControladorUsuario cUsuario;

    private Sistema(IRepoProduto repoProduto, IRepoVenda repovenda, IRepoMarca repoMarca, IRepoUsuario repoUsuario) {
        cProduto = new ControladorProduto(repoProduto);
        cVenda = new ControladorVenda(repovenda);
        cMarca = new ControladorMarca(repoMarca);
        cUsuario = new ControladorUsuario(repoUsuario);
    }

    public static Sistema getInstance(IRepoProduto repoProduto, IRepoVenda repovenda, IRepoMarca repoMarca, IRepoUsuario repoUsuario) {
        if (instance == null) {
            instance = new Sistema(repoProduto, repovenda, repoMarca, repoUsuario);
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

    public Item criarItem(Produto produto, int quantidade) {
        return cVenda.criarItem(produto, quantidade);
    }

    public boolean inserirCarrinho(Item item) {
        return cVenda.inserirCarrinho(item);
    }

    public boolean excluirItemCarrinho(int codigo) {
        return cVenda.excluirItemCarrinho(codigo);
    }

    public void limparCarrinho() {
        cVenda.limparCarrinho();
    }

    public List<Venda> listarVendas() {
        return cVenda.listarVendas();
    }

    public List<Venda> listarData(String data) {
        return cVenda.listarData(data);
    }

    public Carrinho listarCarrinho() {
        return cVenda.listarCarrinho();
    }

    public boolean concluirVenda(String nome) {
        int i = cVenda.concluirVenda(nome);
        List<Item> itens = buscarItens(i);
        return cProduto.abaterEstoque(itens);
    }

    public List<Item> buscarItens(int id) {
        return cVenda.buscarItens(id);
    }

    public Venda buscarVenda(int idVenda) {
        return cVenda.buscarVenda(idVenda);
    }

    public boolean verificarLogin(String login, String senha) {
        return cUsuario.verificarLogin(login, senha);
    }
    
    public String tipoUsuario(String usuario){
        return cUsuario.tipoUsuario(usuario);
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

        this.inserirCarrinho(criarItem(buscar(1), 1));
        this.inserirCarrinho(criarItem(buscar(5), 1));
        this.concluirVenda("Daniel");

        this.inserirCarrinho(criarItem(buscar(2), 1));
        this.concluirVenda("Luciano");

    }

    public Marca buscarMarca(int marca) {
        return cMarca.buscarMarca(marca);
    }

}
