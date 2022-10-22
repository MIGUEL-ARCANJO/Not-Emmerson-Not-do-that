/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aluno
 */
public class Endereco {
    
    private String cep, complemento, bairro;
    private int nmrCasa;
    private long id;
    
    public Endereco() {
    }

    public Endereco(String cep, String complemento, String bairro, int nmrCasa) {
        this.cep = cep;
        this.complemento = complemento;
        this.bairro = bairro;
        this.nmrCasa = nmrCasa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return complemento;
    }

    public void setRua(String rua) {
        this.complemento = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNmrCasa() {
        return nmrCasa;
    }

    public void setNmrCasa(int nmrCasa) {
        this.nmrCasa = nmrCasa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}