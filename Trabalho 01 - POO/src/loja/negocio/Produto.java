package loja.negocio;

public class Produto {
	private int codigo;
	private String nome;
	private String descricao;
	private double preco;
	private double quantEstoque;
	private int Vendido;
	private int Excluido;

	public int getExcluido() {
		return Excluido;
	}

	public void setExcluido(int excluido) {
		Excluido = excluido;
	}

	public int getVendido() {
		return Vendido;
	}

	public void setVendido(int vendido) {
		Vendido = vendido;
	}

	public Produto(String nome, String descricao, double valor, double quantEstoque) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = valor;
		this.quantEstoque = quantEstoque;
	}

	public Produto(int codigo, String nome, String descricao, double valor, double quant) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = valor;
		this.quantEstoque = quant;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getQuantEstoque() {
		return quantEstoque;
	}

	public void setQuantEstoque(double d) {
		this.quantEstoque = d;
	}
}