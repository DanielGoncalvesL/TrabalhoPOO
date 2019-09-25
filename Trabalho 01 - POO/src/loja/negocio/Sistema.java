package loja.negocio;

public class Sistema {
	private ControladorProduto cProduto;

	private ControladorVenda cVenda;

	private static Sistema instance;

	public Sistema() {
		cProduto = new ControladorProduto();
		cVenda = new ControladorVenda();
		init();
	}

	public static Sistema getInstance() {
		if (instance == null)
			instance = new Sistema();
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

	public Produto[] listar() {
		return cProduto.listar();
	}

	public Produto[] listarNome() {
		return cProduto.listarNome();
	}

	public Produto buscarNome(String nome) {
		return cProduto.buscarNome(nome);
	}

	public Item criarItem(Produto produto, double quantidade) {
		return cVenda.criarItem(produto, quantidade);
	}

	public boolean inserirCarrinho(Item item) {
		return cVenda.inserirCarrinho(item);
	}

	public Venda[] listarVenda() {
		return cVenda.listar();
	}

	public boolean concluirVenda(String nomeCliente) {
		Venda abaterEstoque = cVenda.concluirVenda(nomeCliente);
		return cProduto.abaterEstoque(abaterEstoque);
	}

	public Venda[] listarData(String data) {
		return cVenda.listarData(data);
	}
	
	public Venda listarCodigo(int codigo) {
		return cVenda.listarCodigo(codigo);
	}
	
	public Carrinho listarCarrinho() {
		return cVenda.listarCarrinho();
	}

	public void init() {
		this.inserir(new Produto("Arroz", "Rei Arthur", 15, 30));
		this.inserir(new Produto("Feijão", "Supang", 3.5, 30));
		this.inserir(new Produto("Macarrão", "Renata", 4, 30));
		this.inserir(new Produto("Canjiquinha", "Yoki", 2, 30));
		this.inserir(new Produto("Açucar", "União", 8, 30));

		this.inserirCarrinho(criarItem(buscarNome("Arroz"), 1));
		this.inserirCarrinho(criarItem(buscarNome("Canjiquinha"), 1));
		this.concluirVenda("Daniel");

		this.inserirCarrinho(criarItem(buscarNome("Feijão"), 1));
		this.concluirVenda("Luciano");
	}
}