package br.com.timecontrol.model;

import java.util.Date;

public class TempoHistorico {
	private Long horas;
	private Long minutos;
	private Long tempoInvestidoHoras = 0L;
	private Long tempoInvestidoMinutos = 00L;
	private Long domingoHr = 0L;
	private Long domingoMin = 0L;
	private Long segundaHr = 0L;
	private Long segundaMin = 0L;
	private Long tercaHr = 0L;
	private Long tercaMin = 0L;
	private Long quartaHr = 0L;
	private Long quartaMin = 0L;
	private Long quintaHr = 0L;
	private Long quintaMin = 0L;
	private Long sextaHr = 0L;
	private Long sextaMin = 0L;
	private Long sabadoHr = 0L;
	private Long sabadoMin = 0L;
	
	private Date dataInicioSemanaAtual;
	private Date dataInicioSemanaAnterior;
	private Date dataInicioDuasSemanasAnteriores;
	private Date dataFimSemanaAtual;
	private Date dataFimSemanaAnterior;
	private Date dataFimDuasSemanasAnteriores;
	
	
	public Long getHoras() {
		return horas;
	}
	public void setHoras(Long horas) {
		this.horas = horas;
	}
	public Long getMinutos() {
		return minutos;
	}
	public void setMinutos(Long minutos) {
		this.minutos = minutos;
	}
	public Long getTempoInvestidoHoras() {
		return tempoInvestidoHoras;
	}
	public void setTempoInvestidoHoras(Long tempoInvestidoHoras) {
		this.tempoInvestidoHoras = tempoInvestidoHoras;
	}
	public Long getTempoInvestidoMinutos() {
		return tempoInvestidoMinutos;
	}
	public void setTempoInvestidoMinutos(Long tempoInvestidoMinutos) {
		this.tempoInvestidoMinutos = tempoInvestidoMinutos;
	}
	public Long getDomingoHr() {
		return domingoHr;
	}
	public void setDomingoHr(Long domingoHr) {
		this.domingoHr = domingoHr;
	}
	public Long getDomingoMin() {
		return domingoMin;
	}
	public void setDomingoMin(Long domingoMin) {
		this.domingoMin = domingoMin;
	}
	public Long getSegundaHr() {
		return segundaHr;
	}
	public void setSegundaHr(Long segundaHr) {
		this.segundaHr = segundaHr;
	}
	public Long getSegundaMin() {
		return segundaMin;
	}
	public void setSegundaMin(Long segundaMin) {
		this.segundaMin = segundaMin;
	}
	public Long getTercaHr() {
		return tercaHr;
	}
	public void setTercaHr(Long tercaHr) {
		this.tercaHr = tercaHr;
	}
	public Long getTercaMin() {
		return tercaMin;
	}
	public void setTercaMin(Long tercaMin) {
		this.tercaMin = tercaMin;
	}
	public Long getQuartaHr() {
		return quartaHr;
	}
	public void setQuartaHr(Long quartaHr) {
		this.quartaHr = quartaHr;
	}
	public Long getQuartaMin() {
		return quartaMin;
	}
	public void setQuartaMin(Long quartaMin) {
		this.quartaMin = quartaMin;
	}
	public Long getQuintaHr() {
		return quintaHr;
	}
	public void setQuintaHr(Long quintaHr) {
		this.quintaHr = quintaHr;
	}
	public Long getQuintaMin() {
		return quintaMin;
	}
	public void setQuintaMin(Long quintaMin) {
		this.quintaMin = quintaMin;
	}
	public Long getSextaHr() {
		return sextaHr;
	}
	public void setSextaHr(Long sextaHr) {
		this.sextaHr = sextaHr;
	}
	public Long getSextaMin() {
		return sextaMin;
	}
	public void setSextaMin(Long sextaMin) {
		this.sextaMin = sextaMin;
	}
	public Long getSabadoHr() {
		return sabadoHr;
	}
	public void setSabadoHr(Long sabadoHr) {
		this.sabadoHr = sabadoHr;
	}
	public Long getSabadoMin() {
		return sabadoMin;
	}
	public void setSabadoMin(Long sabadoMin) {
		this.sabadoMin = sabadoMin;
	}
	public Date getDataInicioSemanaAtual() {
		return dataInicioSemanaAtual;
	}
	public void setDataInicioSemanaAtual(Date dataInicioSemanaAtual) {
		this.dataInicioSemanaAtual = dataInicioSemanaAtual;
	}
	public Date getDataInicioSemanaAnterior() {
		return dataInicioSemanaAnterior;
	}
	public void setDataInicioSemanaAnterior(Date dataInicioSemanaAnterior) {
		this.dataInicioSemanaAnterior = dataInicioSemanaAnterior;
	}
	public Date getDataInicioDuasSemanasAnteriores() {
		return dataInicioDuasSemanasAnteriores;
	}
	public void setDataInicioDuasSemanasAnteriores(Date dataInicioDuasSemanasAnteriores) {
		this.dataInicioDuasSemanasAnteriores = dataInicioDuasSemanasAnteriores;
	}
	public Date getDataFimSemanaAtual() {
		return dataFimSemanaAtual;
	}
	public void setDataFimSemanaAtual(Date dataFimSemanaAtual) {
		this.dataFimSemanaAtual = dataFimSemanaAtual;
	}
	public Date getDataFimSemanaAnterior() {
		return dataFimSemanaAnterior;
	}
	public void setDataFimSemanaAnterior(Date dataFimSemanaAnterior) {
		this.dataFimSemanaAnterior = dataFimSemanaAnterior;
	}
	public Date getDataFimDuasSemanasAnteriores() {
		return dataFimDuasSemanasAnteriores;
	}
	public void setDataFimDuasSemanasAnteriores(Date dataFimDuasSemanasAnteriores) {
		this.dataFimDuasSemanasAnteriores = dataFimDuasSemanasAnteriores;
	}
}
