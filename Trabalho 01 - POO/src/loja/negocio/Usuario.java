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
    private String senha;
    private String tipo;

    public Usuario(String nome, String senha, String tipo) {
        this.login = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(int id, String nome, String senha, String tipo) {
        this.login = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.idUsuario = id;
    }

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
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
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
