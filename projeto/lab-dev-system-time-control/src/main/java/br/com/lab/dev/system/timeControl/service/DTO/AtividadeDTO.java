package br.com.lab.dev.system.timeControl.service.DTO;

import java.io.Serializable;
import java.util.Objects;

import br.com.lab.dev.system.timeControl.domain.Atividade;

public class AtividadeDTO implements Serializable {

	private Integer idAtividade;
	private int usuarioIdUsuario;
	private String nome;
	private String descricao;
	private int prioridade;
	private String categoria;

	public Integer getIdAtividade() {
		return this.idAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}

	public int getUsuarioIdUsuario() {
		return this.usuarioIdUsuario;
	}

	public void setUsuarioIdUsuario(int usuarioIdUsuario) {
		this.usuarioIdUsuario = usuarioIdUsuario;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPrioridade() {
		return this.prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(idAtividade);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		AtividadeDTO atividadeDTO = (AtividadeDTO) o;
		if (atividadeDTO.getIdAtividade() == null || idAtividade == null) {
			return false;
		}
		return Objects.equals(idAtividade, atividadeDTO.getIdAtividade());
	}

	@Override
	public String toString() {
		return "Atividade{" + "id=" + idAtividade + ", nome='" + nome + "'" + ", descricao='" + descricao + "'"
				+ ", prioridade='" + prioridade + "'" + ", categoria='" + categoria + "'" + '}';
	}
}
