package br.com.timecontrol.model;

public class Relatorio {

	private Atividade atividade;
	String domingo;
	String segunda;
	String terca;
	String quarta;
	String quinta;
	String sexta;
	String sabado;
	String tempoInvestidoTotal;
	
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	public String getDomingo() {
		return domingo;
	}
	public void setDomingo(String domingo) {
		this.domingo = domingo;
	}
	public String getSegunda() {
		return segunda;
	}
	public void setSegunda(String segunda) {
		this.segunda = segunda;
	}
	public String getTerca() {
		return terca;
	}
	public void setTerca(String terca) {
		this.terca = terca;
	}
	public String getQuarta() {
		return quarta;
	}
	public void setQuarta(String quarta) {
		this.quarta = quarta;
	}
	public String getQuinta() {
		return quinta;
	}
	public void setQuinta(String quinta) {
		this.quinta = quinta;
	}
	public String getSexta() {
		return sexta;
	}
	public void setSexta(String sexta) {
		this.sexta = sexta;
	}
	public String getSabado() {
		return sabado;
	}
	public void setSabado(String sabado) {
		this.sabado = sabado;
	}
	public String getTempoInvestidoTotal() {
		return tempoInvestidoTotal;
	}
	public void setTempoInvestidoTotal(String tempoInvestidoTotal) {
		this.tempoInvestidoTotal = tempoInvestidoTotal;
	}
	public Relatorio(Atividade atividade, String domingo, String segunda, String terca, String quarta, String quinta,
			String sexta, String sabado, String tempoInvestidoTotal) {
		super();
		this.atividade = atividade;
		this.domingo = domingo;
		this.segunda = segunda;
		this.terca = terca;
		this.quarta = quarta;
		this.quinta = quinta;
		this.sexta = sexta;
		this.sabado = sabado;
		this.tempoInvestidoTotal = tempoInvestidoTotal;
	}
	
	

	
}
