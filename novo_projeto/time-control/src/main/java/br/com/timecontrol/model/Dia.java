package br.com.timecontrol.model;

import static javax.persistence.GenerationType.IDENTITY;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Dia {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dataDia;
	
	@Temporal(TemporalType.TIME)
	@Column
	private Date totalHorasDia;

	public Dia() {
	}

	public Dia(Date dataDia, Date totalHorasDia) {
		this.dataDia = dataDia;
		this.totalHorasDia = totalHorasDia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

}
