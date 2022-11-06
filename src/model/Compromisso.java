/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class Compromisso {
    private int id;
    private String observacao;
    private Date dataCompromisso;
    private Date horaCompromisso;
    private Contato contato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCompromisso() {
        return dataCompromisso;
    }

    public void setDataCompromisso(Date dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    public Date getHoraCompromisso() {
        return horaCompromisso;
    }

    public void setHoraCompromisso(Date horaCompromisso) {
        this.horaCompromisso = horaCompromisso;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Compromisso() {
    }

    public Compromisso(int id, String observacao, Date dataCompromisso, Date horaCompromisso, Contato contato) {
        this.id = id;
        this.observacao = observacao;
        this.dataCompromisso = dataCompromisso;
        this.horaCompromisso = horaCompromisso;
        this.contato = contato;
    }
    
    
}
