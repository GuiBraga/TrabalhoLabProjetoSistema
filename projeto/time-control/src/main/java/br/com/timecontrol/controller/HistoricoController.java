package br.com.timecontrol.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import br.com.timecontrol.model.Relatorio;
import br.com.timecontrol.model.TempoHistorico;
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
	public List<Historico> listarTodas(@PathVariable Integer codigo) throws ParseException {
		
		TempoHistorico tempoH = new TempoHistorico();
		inicializaDatas(tempoH);

		List<Atividade> atividades = atividadeRepository.listarTodasPorUsuario(codigo);
		List<Historico> historicos = new ArrayList<>();
		List<TempoInvestido> tempoInvestidoSemanaAtual = historicoRepository.buscaHistorico(codigo,tempoH.getDataInicioSemanaAtual(), tempoH.getDataFimSemanaAtual());
		List<TempoInvestido> tempoInvestidoSemanaAnterior = historicoRepository.buscaHistorico(codigo,tempoH.getDataInicioSemanaAnterior(), tempoH.getDataFimSemanaAnterior());
		List<TempoInvestido> tempoInvestidoDuasSemanasAnteriores = historicoRepository.buscaHistorico(codigo,tempoH.getDataInicioDuasSemanasAnteriores(), tempoH.getDataFimDuasSemanasAnteriores());

		for (Atividade atividade : atividades) {
			Historico historico = montaHistoricoAtividade(atividade, tempoInvestidoSemanaAtual,tempoInvestidoSemanaAnterior, tempoInvestidoDuasSemanasAnteriores,tempoH);
			historicos.add(historico);
		}

		return historicos;
	}

	@RequestMapping(value = "/buscaRelatorio/{codigo}", method = RequestMethod.GET)
	public List<Relatorio> BuscaRelatorio(@PathVariable Integer codigo) {
		
		TempoHistorico tempoH = new TempoHistorico();
		String domingo;
		String segunda;
		String terca;
		String quarta;
		String quinta;
		String sexta;
		String sabado;
		
		inicializaDatas(tempoH);

		List<Atividade> atividades = atividadeRepository.listarTodasPorUsuario(codigo);
		List<Relatorio> relatorios = new ArrayList<>();

		List<TempoInvestido> tempoInvestidoSemanaAtual = historicoRepository.buscaHistorico(codigo,
				tempoH.getDataInicioSemanaAtual(), tempoH.getDataFimSemanaAtual());

		for (Atividade atividade : atividades) {
			calculaTempoInvestido(tempoInvestidoSemanaAtual, atividade,"relatorio",tempoH);
			reiniciarVariaveisTempoInvestido(tempoH);
			
			domingo = tempoH.getDomingoHr() + ":" + tempoH.getDomingoMin();
			segunda = tempoH.getSegundaHr() + ":" + tempoH.getSegundaMin();
			terca = tempoH.getTercaHr() + ":" + tempoH.getTercaMin();
			quarta = tempoH.getQuartaHr() + ":" + tempoH.getQuartaMin();
			quinta = tempoH.getQuintaHr() + ":" + tempoH.getQuintaMin();
			sexta = tempoH.getSextaHr() + ":" + tempoH.getSextaMin();
			sabado = tempoH.getSabadoHr() + ":" + tempoH.getSabadoMin();

			Relatorio relatorio = new Relatorio(atividade, domingo, segunda, terca, quarta, quinta, sexta, sabado);
			relatorios.add(relatorio);
		}

		return relatorios;

	}

	public LocalDate buscaDataInicioSemana(LocalDate data) {

		switch (data.getDayOfWeek().name()) {
		case "SUNDAY":
			return data;
		case "MONDAY":
			return data.minusDays(1);
		case "TUESDAY":
			return data.minusDays(2);
		case "WEDNESDAY":
			return data.minusDays(3);
		case "THURSDAY":
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

	public LocalDate buscaDataFimSemana(LocalDate data) {

		switch (data.getDayOfWeek().name()) {
		case "SUNDAY":
			return data.plusDays(6);
		case "MONDAY":
			return data.plusDays(5);
		case "TUESDAY":
			return data.plusDays(4);
		case "WEDNESDAY":
			return data.plusDays(3);
		case "THURSDAY":
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

	public void inicializaDatas(TempoHistorico tempoH) {//testado
		LocalDate hoje = LocalDate.now();
		LocalDate diaSemanaAnterior = hoje.minusWeeks(1);
		LocalDate diaDuasSemanasAnteriores = hoje.minusWeeks(2);

		tempoH.setDataInicioSemanaAtual(convertDataInicioSemanaToDate(hoje));
		tempoH.setDataInicioSemanaAnterior(convertDataInicioSemanaToDate(diaSemanaAnterior));
		tempoH.setDataInicioDuasSemanasAnteriores(convertDataInicioSemanaToDate(diaDuasSemanasAnteriores));

		tempoH.setDataFimSemanaAtual(convertDataFimSemanaToDate(hoje));
		tempoH.setDataFimSemanaAnterior(convertDataFimSemanaToDate(diaSemanaAnterior));
		tempoH.setDataFimDuasSemanasAnteriores(convertDataFimSemanaToDate(diaDuasSemanasAnteriores));
	}

	public Date convertDataInicioSemanaToDate(LocalDate data) {//testado
		return Date.from(buscaDataInicioSemana(data).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Date convertDataFimSemanaToDate(LocalDate data) {//testado
		return Date.from(buscaDataFimSemana(data).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public Historico montaHistoricoAtividade(Atividade atividade, List<TempoInvestido> listSemanaAtual,
			List<TempoInvestido> listSemanaAnterior, List<TempoInvestido> listDuasSemanasAnteriores,TempoHistorico tempoH) {

		calculaTempoInvestido(listSemanaAtual, atividade,"historico",tempoH);
		String semanaAtual = tempoH.getTempoInvestidoHoras() + ":" + tempoH.getTempoInvestidoMinutos();
		reiniciarVariaveisTempoInvestido(tempoH);
		

		calculaTempoInvestido(listSemanaAnterior, atividade,"historico",tempoH);
		String semanaAnterior = tempoH.getTempoInvestidoHoras() + ":" + tempoH.getTempoInvestidoMinutos();
		reiniciarVariaveisTempoInvestido(tempoH);

		calculaTempoInvestido(listDuasSemanasAnteriores, atividade,"historico",tempoH);
		String duasSemanasAnteriores = tempoH.getTempoInvestidoHoras() + ":" + tempoH.getTempoInvestidoMinutos();
		reiniciarVariaveisTempoInvestido(tempoH);

		return new Historico(atividade, semanaAtual, semanaAnterior, duasSemanasAnteriores);
	}

	public void calculaTempoInvestido(List<TempoInvestido> listaTempo, Atividade atividade,String tipo,TempoHistorico tempoH) {
		Long horas = 0L;
		Long minutos = 0L;
		Long tempoInvestidoHoras = 0L;
		Long tempoInvestidoMinutos = 0L;
		
		for (TempoInvestido tempo : listaTempo) {			
			if (tempo.getDataFim() != null && tempo.getDataInicio() != null && tempo.getAtividade().getCodigo() == atividade.getCodigo()) {
				horas = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime()) / 3600000;
				minutos = (tempo.getDataFim().getTime() - tempo.getDataInicio().getTime() - horas*3600000) / 60000;
				if(minutos >= 60){
					horas += 1;
					minutos = minutos - 60; 
				}
				tempoInvestidoHoras += horas;
				tempoInvestidoMinutos += minutos;
				
			
				if(tipo.equals("relatorio")){
					buscaDiaRelatorio(tempo, tempoH);
				}
				
			}
			tempoH.setTempoInvestidoHoras(tempoInvestidoHoras);
			tempoH.setTempoInvestidoMinutos(tempoInvestidoMinutos);
			
		}
		
	}

	public void reiniciarVariaveisTempoInvestido(TempoHistorico tempoH){
		tempoH.setHoras(0L);
		tempoH.setMinutos(0L);
		tempoH.setTempoInvestidoHoras(0L);
		tempoH.setTempoInvestidoMinutos(0L);
	}
	
	public void buscaDiaRelatorio(TempoInvestido tempo,TempoHistorico tempoH){

		switch (tempo.getDataInicio().getDay()) {
		case 0:
			tempoH.setDomingoHr(tempoH.getTempoInvestidoHoras());
			tempoH.setDomingoMin(tempoH.getTempoInvestidoMinutos());
			break;
		case 1:
			tempoH.setSegundaHr(tempoH.getTempoInvestidoHoras());
			tempoH.setSegundaMin(tempoH.getTempoInvestidoMinutos());
			break;
		case 2:
			tempoH.setTercaHr(tempoH.getTempoInvestidoHoras());
			tempoH.setTercaMin(tempoH.getTempoInvestidoMinutos());
			break;
		case 3:
			tempoH.setQuartaHr(tempoH.getTempoInvestidoHoras());
			tempoH.setQuartaMin(tempoH.getTempoInvestidoMinutos());
			break;
		case 4:
			tempoH.setQuintaHr(tempoH.getTempoInvestidoHoras());
			tempoH.setQuintaMin(tempoH.getTempoInvestidoMinutos());
			break;
		case 5:
			tempoH.setSextaHr(tempoH.getTempoInvestidoHoras());
			tempoH.setSextaMin(tempoH.getTempoInvestidoMinutos());
			break;
		case 6:
			tempoH.setSabadoHr(tempoH.getTempoInvestidoHoras());
			tempoH.setSabadoMin(tempoH.getTempoInvestidoMinutos());
			break;
		default:
			break;
		}
	}
}