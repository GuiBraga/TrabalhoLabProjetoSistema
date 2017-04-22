package br.com.timecontrol.model;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TempoInvestido {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column
	private Integer codigo;
	
	@ManyToOne
	private Atividade atividade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataFim;
	
	@Column
	private String descricao;
	
	public TempoInvestido() {
	}

	public TempoInvestido(Atividade atividade, Date dataInicio, Date dataFim, String descricao) {
		this.atividade = atividade;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}