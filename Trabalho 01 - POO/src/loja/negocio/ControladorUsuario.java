/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.negocio;

import java.util.List;
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

    public boolean alterarUsuario(Usuario usuario, int codigo){
        return repoUsuario.alterarUsuario(usuario, codigo);
    }

    public Usuario buscarUsuario(int codigo){
        return repoUsuario.buscarUsuario(codigo);
    }

    public boolean excluirUsuario(int codigo){
        return repoUsuario.excluirUsuario(codigo);
    }

    public boolean inserirUsuario(Usuario usuario){
        return repoUsuario.inserirUsuario(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return repoUsuario.listarUsuarios();
    }

    public String tipoUsuario(String usuario){
        return repoUsuario.tipoUsuario(usuario);
    }

    public boolean verificarLogin(String login, String senha){
        return repoUsuario.verificarLogin(login, senha);
    }
}
