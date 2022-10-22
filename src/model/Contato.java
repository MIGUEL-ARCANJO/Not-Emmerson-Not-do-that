package model;

import java.sql.Date;

public class Contato {
	private Long id;
	private String nome;
	private String apelido;
	private Date dtNascimento;
	
	public Contato(Long id, String nome, String apelido, Date dtNascimento) {
		this.id = id;
		this.nome = nome;
		this.apelido = apelido;
		this.dtNascimento = dtNascimento;
	}
	
	public Contato() {
		//construtor default
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
}