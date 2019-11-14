/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import loja.negocio.Marca;

/**
 *
 * @author Daniel
 */
public class RepoMarca implements IRepoMarca {
    
    private final List<Marca> marcas = new ArrayList<>();
    int codigo = 1;
    
    @Override
    public boolean inserir(Marca marca) {
        if (marca != null) {
            for (Marca marca1 : marcas) {
                if (marca1.getNome().equals(marca.getNome())) {
                    return false;
                }
            }
            marca.setId(codigo);
            marcas.add(marca);
            codigo++;
            return true;
        }
        return false;
    }
    
    @Override
    public boolean excluir(int codigo) {
        for (int i = 0; i < marcas.size(); i++) {
            if (marcas.get(i).getId() == codigo) {
                marcas.remove(i);
                return true;
        }
    }
        return false;
    }
    
    @Override
    public boolean alterar(Marca marca, int codigo) {
        if (marca != null) {
            for (int i = 0; i < marcas.size(); i++) {
                if (marcas.get(i).getId() == codigo) {
                    marcas.set(i, marca);
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    
    @Override
    public List<Marca> listar() {
        if (marcas != null) {
            return marcas;
        } else {
            return null;
        }
    }
    
    /**
     *
     * @param nome
     * @return
     */
    public Marca buscarNome(String nome) {
        if (nome != null) {
            for (Marca marca : marcas) {
                if (marca != null && marca.getNome().equals(nome)) {
                    return marca;
                }
            }
        }
        return null;
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    @Override
    public Marca buscarMarca(int codigo) {
        for (Marca marca : marcas) {
            if (marca.getId() == codigo) {
                return marca;
            }
        }
        return null;
    }
}
