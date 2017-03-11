package br.com.lab.dev.system.timeControl.service.DTO;

import java.util.Date;
import java.util.Objects;

public class DiaDTO {

	private Integer idDia;
	private Date dataDia;
	private Date totalHorasDia;

	public Integer getIdDia() {
		return this.idDia;
	}

	public void setIdDia(Integer idDia) {
		this.idDia = idDia;
	}

	public Date getDataDia() {
		return this.dataDia;
	}

	public void setDataDia(Date dataDia) {
		this.dataDia = dataDia;
	}

	public Date getTotalHorasDia() {
		return this.totalHorasDia;
	}

	public void setTotalHorasDia(Date totalHorasDia) {
		this.totalHorasDia = totalHorasDia;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(idDia);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		DiaDTO diaDTO = (DiaDTO) o;
		if (diaDTO.getIdDia() == null || diaDTO == null) {
			return false;
		}
		return Objects.equals(idDia, diaDTO.getIdDia());
	}

	@Override
	public String toString() {
		return "Dia{" + "id=" + idDia + ", totalDias='" + dataDia + "'" + ", totalHorasDia='" + totalHorasDia + "'"
				+ '}';
	}

}
