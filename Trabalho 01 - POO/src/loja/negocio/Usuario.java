/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja.negocio;

/**
 *
 * @author Daniel
 */
public class Usuario {

    private int idUsuario;
    private String login;
    private int senha;
    private String tipo;

    /**
     * @return the id
     */
    public int getId() {
        return idUsuario;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.idUsuario = id;
    }

    /**
     * @return the login
     */
    public String getUser() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setUser(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public int getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(int senha) {
        this.senha = senha;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
