/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.dados;

import java.util.List;
import loja.negocio.Usuario;

/**
 *
 * @author josin
 */
public interface IRepoUsuario {

    boolean alterarUsuario(Usuario usuario, int codigo);

    Usuario buscarUsuario(int codigo);

    boolean excluirUsuario(int codigo);

    boolean inserirUsuario(Usuario usuario);

    List<Usuario> listarUsuarios();

    String tipoUsuario(String usuario);

    boolean verificarLogin(String login, String senha);
    
}
