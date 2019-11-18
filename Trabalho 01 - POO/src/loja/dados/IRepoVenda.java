/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dados;

import java.util.List;
import loja.negocio.Carrinho;
import loja.negocio.Item;
import loja.negocio.Produto;
import loja.negocio.Venda;

/**
 *
 * @author Daniel
 */
public interface IRepoVenda {

    /**
     *
     * @param produto
     * @param quantidade
     * @return
     */
    public Item criarItem(Produto produto, int quantidade);

    /**
     *
     * @param item
     * @return
     */
    public boolean inserirCarrinho(Item item);

    /**
     *
     * @param nome
     * @return
     */
    public int concluirVenda(String nome);

    /**
     *
     * @param idVenda
     * @return
     */
    public List<Item> buscarItens(int idVenda);

    /**
     *
     */
    public void limparCarrinho();

    /**
     *
     * @param i
     */
    public void limparCarrinho(int i);

    /**
     *
     * @param codigo
     * @return
     */
    public boolean excluirItemCarrinho(int codigo);

    /**
     *
     * @return
     */
    public List<Venda> listarVendas();

    /**
     *
     * @param data
     * @return
     */
    public List<Venda> listarData(String data);

    /**
     *
     * @return
     */
    public Carrinho listarCarrinho();

    /**
     *
     * @param idItem
     * @return
     */
    public Item buscarItem(int idItem);
    
    /**
     *
     * @param idVenda
     * @return
     */
    public Venda buscarVenda(int idVenda);
}
