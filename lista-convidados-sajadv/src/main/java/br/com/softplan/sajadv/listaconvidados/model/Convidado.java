package br.com.softplan.sajadv.listaconvidados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "convidado")
public class Convidado implements Serializable {

	private static final long serialVersionUID = 631814537844066606L;

	@Id
	@Column(name = "cdconvidado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cdconvidado")
	@SequenceGenerator(name = "cdconvidado", sequenceName = "cdconvidado", allocationSize = 1)
	private Long cdconvidado;
	private String nome;
	private String email;
	private String telefone;

	public Convidado(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public Convidado() {

	}

	public Long getCdconvidado() {
		return cdconvidado;
	}

	public void setCdconvidado(Long cdconvidado) {
		this.cdconvidado = cdconvidado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}