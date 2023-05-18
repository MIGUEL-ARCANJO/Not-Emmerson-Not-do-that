package com.example.funcionarioarrayadapter.model;

import java.util.Objects;

public class Funcionario {
    private int codigo;
    private String nome;
    private char sexo;
    private String cargo;

    public Funcionario() {

    }

    public Funcionario( String nome, String cargo,char sexo) {
        this.nome = nome;
        this.cargo = cargo;
        this.sexo = sexo;
    }

    public Funcionario(int codigo, String nome, char sexo, String cargo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.cargo = cargo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
