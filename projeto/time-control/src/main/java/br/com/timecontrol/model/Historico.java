package br.com.timecontrol.model;

public class Historico {

	private Atividade atividade;
	private String semanaAtual;
	private String semanaAnterior;
	private String duasSemanasAnteriores;
	
	public Historico(Atividade atividade, String semanaAtual, String semanaAnterior, String duasSemanasAnteriores){
		this.atividade = atividade;
		this.semanaAtual = semanaAtual;
		this.semanaAnterior = semanaAnterior;
		this.duasSemanasAnteriores = duasSemanasAnteriores;
	}

	public Historico() {
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getSemanaAtual() {
		return semanaAtual;
	}

	public void setSemanaAtual(String semanaAtual) {
		this.semanaAtual = semanaAtual;
	}

	public String getSemanaAnterior() {
		return semanaAnterior;
	}

	public void setSemanaAnterior(String semanaAnterior) {
		this.semanaAnterior = semanaAnterior;
	}

	public String getDuasSemanasAnteriores() {
		return duasSemanasAnteriores;
	}

	public void setDuasSemanasAnteriores(String duasSemanasAnteriores) {
		this.duasSemanasAnteriores = duasSemanasAnteriores;
	}
	
}
