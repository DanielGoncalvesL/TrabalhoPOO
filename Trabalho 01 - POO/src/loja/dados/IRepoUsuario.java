/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dados;

import loja.negocio.Usuario;

/**
 *
 * @author Daniel
 */
public interface IRepoUsuario {

    boolean inserirUsuario(Usuario usuario);

    boolean verificarLogin(String login, String senha);
    
    String tipoUsuario(String usuario);
    
}
