package loja.negocio;

public class Item {
    
    private int id;
    private int produto;
    private double preco;
    private int quantidade;

   public Item(int id, double preco, int quantidade, int produto){
       this.id = id;
       this.preco = preco;
       this.produto = produto;
       this.quantidade = quantidade;  
   }
    
    /**
     *
     * @return
     */
    public int getProduto() {
        return produto;
    }

    /**
     *
     * @param produto
     */
    public void setProduto(int produto) {
        this.produto = produto;
    }

    /**
     *
     * @return
     */
    public double getPreco() {
        return preco;
    }

    /**
     *
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
