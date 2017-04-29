package br.com.timecontrol.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.timecontrol.model.Atividade;
import br.com.timecontrol.model.Historico;
import br.com.timecontrol.model.TempoInvestido;
import br.com.timecontrol.repository.AtividadeRepository;
import br.com.timecontrol.repository.HistoricoRepository;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

	@Autowired
	AtividadeRepository atividadeRepository;

	@Autowired
	HistoricoRepository historicoRepository;

	@RequestMapping(value = "/buscaHistorico/{codigo}", method = RequestMethod.GET)
	public List<Historico> listarTodas(@PathVariable Integer codigo) {
		String semanaAtual;
		String semanaAnterior;
		String duasSemanasAnteriores;

		Long horas;
		Long minutos;
		Long tempoInvestidoHoras = 0L;
		Long tempoInvestidoMinutos = 0L;

		LocalDate hoje = LocalDate.now();
		LocalDate diaSemanaAnterior = hoje.minusWeeks(1);
		LocalDate diaDuasSemanasAnteriores = hoje.minusWeeks(2);

		LocalDate dtInicioSemanaAtual = buscaDataInicioSemana(hoje);
		LocalDate dtInicioSemanaAnterior = buscaDataInicioSemana(diaSemanaAnterior);
		LocalDate dtInicioDuasSemanasAnteriores = buscaDataInicioSemana(diaDuasSemanasAnteriores);

		LocalDate dtFimSemanaAtual = buscaDataFimSemana(hoje);
		LocalDate dtFimSemanaAnterior = buscaDataFimSemana(diaSemanaAnterior);
		LocalDate dtFimDuasSemanasAnteriores = buscaDataFimSemana(diaDuasSemanasAnteriores);
		
		Date dataInicioSemanaAtual = Date.from(dtInicioSemanaAtual.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date dataInicioSemanaAnterior = Date.from(dtInicioSemanaAnterior.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date dataInicioDuasSemanasAnteriores = Date.from(dtInicioDuasSemanasAnteriores.atStartOfDay(ZoneId.systemDefault()).toInstant());

		Date dataFimSemanaAtual = Date.from(dtFimSemanaAtual.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date dataFimSemanaAnterior = Date.from(dtFimSemanaAnterior.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date dataFimDuasSemanasAnteriores = Date.from(dtFimDuasSemanasAnteriores.atStartOfDay(ZoneId.systemDefault()).toInstant());

		List<Atividade> atividades = atividadeRepository.listarTodasPorUsuario(codigo);
		List<Historico> historicos = new ArrayList<>();

		List<TempoInvestido> tempoInvestidoSemanaAtual = historicoRepository.buscaHistorico(codigo,
				dataInicioSemanaAtual, dataFimSemanaAtual);
		List<TempoInvestido> tempoInvestidoSemanaAnterior = historicoRepository.buscaHistorico(codigo,
				dataInicioSemanaAnterior, dataFimSemanaAnterior);
		List<TempoInvestido> tempoInvestidoDuasSemanasAnteriores = historicoRepository.buscaHistorico(codigo,
				dataInicioDuasSemanasAnteriores, dataFimDuasSemanasAnteriores);

		for (Atividade atividade : atividades) {
			for (TempoInvestido tempo : tempoInvestidoSemanaAtual) {
				if(tempo.getDataFim() != null && tempo.getDataInicio() != null && tempo.getAtividade().getCodigo() == atividade.getCodigo()){
					horas = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime()) / 3600000;
					minutos = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime() - horas * 3600000) / 60000;
					tempoInvestidoHoras += horas;
					tempoInvestidoMinutos += minutos;
				}
			}
			
			semanaAtual = tempoInvestidoHoras + ":" + tempoInvestidoMinutos;
			tempoInvestidoHoras = 0L;
			tempoInvestidoMinutos = 0L;
			horas = 0L;
			minutos = 0L;

			for (TempoInvestido tempo : tempoInvestidoSemanaAnterior) {
				if(tempo.getDataFim() != null && tempo.getDataInicio() != null && tempo.getAtividade().getCodigo() == atividade.getCodigo()){
					horas = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime()) / 3600000;
					minutos = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime() - horas * 3600000) / 60000;
					tempoInvestidoHoras += horas;
					tempoInvestidoMinutos += minutos;
				}
			}
			
			semanaAnterior = tempoInvestidoHoras + ":" + tempoInvestidoMinutos;
			tempoInvestidoHoras = 0L;
			tempoInvestidoMinutos = 0L;
			horas = 0L;
			minutos = 0L;
			
			for (TempoInvestido tempo : tempoInvestidoDuasSemanasAnteriores) {
				if(tempo.getDataFim() != null && tempo.getDataInicio() != null && tempo.getAtividade().getCodigo() == atividade.getCodigo()){
					horas = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime()) / 3600000;
					minutos = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime() - horas * 3600000) / 60000;
					tempoInvestidoHoras += horas;
					tempoInvestidoMinutos += minutos;
				}
			}
			
			duasSemanasAnteriores = tempoInvestidoHoras + ":" + tempoInvestidoMinutos;
			tempoInvestidoHoras = 0L;
			tempoInvestidoMinutos = 0L;
			horas = 0L;
			minutos = 0L;

			Historico historico = new Historico(atividade, semanaAtual, semanaAnterior, duasSemanasAnteriores);
			historicos.add(historico);
		}

		return historicos;
	}
	

	private LocalDate buscaDataInicioSemana(LocalDate data) {

		switch (data.getDayOfWeek().name()) {
		case "SUNDAY":
			return data;
		case "MONDAY":
			return data.minusDays(1);
		case "TUESDAY":
			return data.minusDays(2);
		case "FOURTH":
			return data.minusDays(3);
		case "FIFTH":
			return data.minusDays(4);
		case "FRIDAY":
			return data.minusDays(5);
		case "SATURDAY":
			return data.minusDays(6);
		default:
			break;
		}
		return data;

	}

	private LocalDate buscaDataFimSemana(LocalDate data) {

		switch (data.getDayOfWeek().name()) {
		case "SUNDAY":
			return data.plusDays(6);
		case "MONDAY":
			return data.plusDays(5);
		case "TUESDAY":
			return data.plusDays(4);
		case "FOURTH":
			return data.minusDays(3);
		case "FIFTH":
			return data.plusDays(2);
		case "FRIDAY":
			return data.plusDays(1);
		case "SATURDAY":
			return data;
		default:
			break;
		}
		return data;
	}

}