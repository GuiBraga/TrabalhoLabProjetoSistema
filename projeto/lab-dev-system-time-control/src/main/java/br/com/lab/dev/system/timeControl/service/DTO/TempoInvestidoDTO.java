package br.com.lab.dev.system.timeControl.service.DTO;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.lab.dev.system.timeControl.domain.TempoInvestido;

public class TempoInvestidoDTO {

	private Integer idTempoInvestido;
	private int diaIdDia;
	private int atividadeIdAtividade;
	private Date horasGastas;
	private Date dataInicio;
	private Date dataFim;

	public Integer getIdTempoInvestido() {
		return this.idTempoInvestido;
	}

	public void setIdTempoInvestido(Integer idTempoInvestido) {
		this.idTempoInvestido = idTempoInvestido;
	}

	public int getDiaIdDia() {
		return this.diaIdDia;
	}

	public void setDiaIdDia(int diaIdDia) {
		this.diaIdDia = diaIdDia;
	}

	public int getAtividadeIdAtividade() {
		return this.atividadeIdAtividade;
	}

	public void setAtividadeIdAtividade(int atividadeIdAtividade) {
		this.atividadeIdAtividade = atividadeIdAtividade;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTempoInvestido == null) ? 0 : idTempoInvestido.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempoInvestido other = (TempoInvestido) obj;
		if (idTempoInvestido == null) {
			if (other.getIdTempoInvestido() != null)
				return false;
		} else if (!idTempoInvestido.equals(other.getIdTempoInvestido()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TempoInvestido [idTempoInvestido=" + idTempoInvestido + ", diaIdDia=" + diaIdDia
				+ ", atividadeIdAtividade=" + atividadeIdAtividade + ", horasGastas=" + horasGastas + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + "]";
	}
}
