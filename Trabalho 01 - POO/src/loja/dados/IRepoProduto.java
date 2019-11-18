/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dados;

import java.util.List;
import loja.negocio.Item;
import loja.negocio.Produto;
import loja.negocio.Venda;

/**
 *
 * @author Daniel
 */
public interface IRepoProduto{

    List<Produto> FiltrarNome(String nome);

    boolean alterar(Produto produto, int codigo);

    Produto buscar(int codigo);

    Produto buscarNome(String nome);

    boolean excluir(int codigo);

    boolean inserir(Produto produto);

    List<Produto> listar();

    List<Produto> listarNome();
    
    boolean abaterEstoque(List<Item> item);
}
