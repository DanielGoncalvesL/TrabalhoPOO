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
public class Marca {
    private int id = 0;
    private String nome;
    private String RepresentanteComercial;

    public Marca(String nome, String representanteComercial) {
        this.id = this.id + 1;
        this.nome = nome;
        this.RepresentanteComercial = representanteComercial;
    }

    /**
     * @return the id   
     */
    public int getId() {
        return this.id;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the RepresentanteComercial
     */
    public String getRepresentanteComercial() {
        return RepresentanteComercial;
    }

    /**
     * @param RepresentanteComercial the RepresentanteComercial to set
     */
    public void setRepresentanteComercial(String RepresentanteComercial) {
        this.RepresentanteComercial = RepresentanteComercial;
    }
}
