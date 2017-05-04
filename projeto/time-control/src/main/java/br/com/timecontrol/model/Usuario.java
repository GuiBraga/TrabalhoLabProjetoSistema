package br.com.timecontrol.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column
	private Integer codigo;
	
	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String senha;
	
	@Column(name="profissao")
	private String profissao;
	
	public Usuario() {
	}
	
	public Usuario(String nome) {
		super();
	}
	
	
	public Usuario(String nome, String email, String profissao) {
		super();
		this.nome = nome;
		this.email = email;
		this.profissao = profissao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
