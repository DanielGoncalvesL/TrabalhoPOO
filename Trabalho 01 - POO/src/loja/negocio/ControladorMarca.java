/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.negocio;

import java.util.List;
import loja.dados.IRepoMarca;
import loja.dados.RepoMarca;

/**
 *
 * @author Daniel
 */
public class ControladorMarca {
    
    private final IRepoMarca repoMarca;
    
    private RepoMarca rMarca;
    
    public ControladorMarca(IRepoMarca repoMarca){
        this.repoMarca = repoMarca;
    }
    
    public boolean inserir(Marca marca){
        return rMarca.inserir(marca);
    }
    
    public boolean excluir(int codigo){
        return rMarca.excluir(codigo);
    }
    
    public boolean alterar(Marca marca, int codigo){
        return rMarca.alterar(marca, codigo);
    }
    
    public List<Marca> listar(){
        return rMarca.listar();
    }
}
