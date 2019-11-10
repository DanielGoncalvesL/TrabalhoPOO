package loja.negocio;

public class Produto {

    private int codigo;
    private String nome;
    private Marca marca;
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

    public Produto(String nome, Marca marca, double valor, double quantEstoque) {
        this.nome = nome;
        this.marca = marca;
        this.preco = valor;
        this.quantEstoque = quantEstoque;
    }

    public Produto(int codigo, String nome, Marca marca, double valor, double quant) {
        // TODO Auto-generated constructor stub
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
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

    public Marca getDescricao() {
        return marca;
    }

    public void setDescricao(Marca marca) {
        this.marca = marca;
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
