/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.negocio;

import loja.dados.IRepoUsuario;

/**
 *
 * @author Daniel
 */
public class ControladorUsuario {

    private final IRepoUsuario repoUsuario;

    public ControladorUsuario(IRepoUsuario repoUsuario) {
        this.repoUsuario = repoUsuario;
    }
    
    public boolean verificarLogin(String login, String senha){
        return repoUsuario.verificarLogin(login, senha);
    }
    
    public String tipoUsuario(String usuario){
        return repoUsuario.tipoUsuario(usuario);
    }
}
