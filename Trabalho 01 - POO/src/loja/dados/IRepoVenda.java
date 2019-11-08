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

    Venda concluirVenda(String nomeCliente);

    Item criarItem(Produto produto, double quantidade);

    boolean excluirItemCarrinho(int codigo);

    boolean inserirCarrinho(Item item);

    void limparCarrinho();

    Carrinho listarCarrinho();

    Venda listarCodigo(int codigo);

    List<Venda> listarData(String data);

    List<Venda> listarVenda();
    
}
