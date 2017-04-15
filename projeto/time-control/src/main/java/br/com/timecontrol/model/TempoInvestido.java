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
	private Dia dia;
	
	@ManyToOne
	private Atividade atividade;
	
	@Temporal(TemporalType.TIME)
	@Column
	private Date horasGastas;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataFim;

	public TempoInvestido() {
	}

	public TempoInvestido(Dia dia, Atividade atividade, Date horasGastas, Date dataInicio, Date dataFim) {
		this.dia = dia;
		this.atividade = atividade;
		this.horasGastas = horasGastas;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Dia getDia() {
		return this.dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Date getHorasGastas() {
		return this.horasGastas;
	}

	public void setHorasGastas(Date horasGastas) {
		this.horasGastas = horasGastas;
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

}