/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dados;

import java.util.List;
import loja.negocio.Marca;

/**
 *
 * @author Daniel
 */
public interface IRepoMarca {

    boolean alterar(Marca marca, int codigo);

    boolean excluir(int codigo);

    boolean inserir(Marca marca);

    List<Marca> listar();

    public Marca buscarNome(String nome);

    public Marca buscarMarca(int marca);
    
}
