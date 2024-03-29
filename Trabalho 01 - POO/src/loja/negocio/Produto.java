package loja.negocio;

public class Produto {

    private int codigo;
    private String nome;
    private int marca;
    private double preco;
    private int quantEstoque;
    private int Vendido;
    private int Excluido;
    
    private Sistema sis;

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

    /**
     *
     * @param nome
     * @param marca
     * @param valor
     * @param quantEstoque
     */
    public Produto(String nome, int marca, double valor, int quantEstoque) {
        this.nome = nome;
        this.marca = marca;
        this.preco = valor;
        this.quantEstoque = quantEstoque;
    }

    /**
     *
     * @param codigo
     * @param nome
     * @param marca
     * @param valor
     * @param quant
     */
    public Produto(int codigo, String nome, int marca, double valor, int quant) {
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

    /**
     *
     * @return
     */
    public int getMarca() {
        return this.marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(int marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     *
     * @return
     */
    public int getQuantEstoque() {
        return this.quantEstoque;
    }

    public void setQuantEstoque(int d) {
        this.quantEstoque = d;
    }
}
