
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.timecontrol.controller.HistoricoController;
import br.com.timecontrol.model.Atividade;
import br.com.timecontrol.model.Historico;
import br.com.timecontrol.model.TempoHistorico;
import br.com.timecontrol.model.TempoInvestido;
import br.com.timecontrol.model.Usuario;

public class HistoricoTest {

	@Test
	public void deveRetornarOPrimeiroDiaDaSemana() {
		// Parte 1: Cenário
		LocalDate hoje = LocalDate.now();
		/*
		 * Teste executado em uma quinta-feira. Logo o primeiro dia da semana é
		 * no Domingo. 4 dias antes de quinta-feira.
		 */
		LocalDate inicioSemanaEsperado = hoje.minusDays(4);

		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		LocalDate inicioSemana = historicoController.buscaDataInicioSemana(hoje);

		// Parte 3: Validação
		Assert.assertEquals(inicioSemanaEsperado, inicioSemana);
	}

	@Test
	public void deveRetornarOUltimoDiaDaSemana() {
		// Parte 1: Cenário
		LocalDate hoje = LocalDate.now();
		/*
		 * Teste executado pela ultima vez em uma quinta-feira. Logo o dia final da semana é no
		 * Sábado. 4 dias após a quinta-feira.
		 */
		LocalDate inicioSemanaEsperado = hoje.plusDays(2);

		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		LocalDate inicioSemana = historicoController.buscaDataFimSemana(hoje);

		// Parte 3: Validação
		Assert.assertEquals(inicioSemanaEsperado, inicioSemana);
	}

	@Test
	public void deveInicializarAsDatasDasSemanasConformeODiaAtualDoSistema() {
		// Parte 1: Cenário
		LocalDate hoje = LocalDate.now();
		LocalDate diaSemanaAnterior = hoje.minusWeeks(1);
		LocalDate diaDuasSemanasAnteriores = hoje.minusWeeks(2);

		TempoHistorico tempoEsperado = new TempoHistorico();
		TempoHistorico tempoGerado = new TempoHistorico();

		/*
		 * Teste executado pela ultima vez em uma quinta-feira. Logo o primeiro dia da semana é
		 * no Domingo. 4 dias antes de quinta-feira.
		 */
		tempoEsperado.setDataInicioSemanaAtual(
				Date.from(hoje.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		tempoEsperado.setDataInicioSemanaAnterior(
				Date.from(diaSemanaAnterior.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		tempoEsperado.setDataInicioDuasSemanasAnteriores(
				Date.from(diaDuasSemanasAnteriores.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		/*
		 * Teste executado pela ultima vez em uma quinta-feira. Logo o dia final da semana é no
		 * Sábado. 4 dias após a quinta-feira.
		 */
		tempoEsperado
				.setDataFimSemanaAtual(Date.from(hoje.plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		tempoEsperado.setDataFimSemanaAnterior(
				Date.from(diaSemanaAnterior.plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		tempoEsperado.setDataFimDuasSemanasAnteriores(
				Date.from(diaDuasSemanasAnteriores.plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		historicoController.inicializaDatas(tempoGerado);

		// Parte 3: Validação
		Assert.assertEquals(tempoEsperado.getDataInicioSemanaAtual(), tempoGerado.getDataInicioSemanaAtual());
		Assert.assertEquals(tempoEsperado.getDataInicioSemanaAnterior(), tempoGerado.getDataInicioSemanaAnterior());
		Assert.assertEquals(tempoEsperado.getDataInicioDuasSemanasAnteriores(),
				tempoGerado.getDataInicioDuasSemanasAnteriores());

		Assert.assertEquals(tempoEsperado.getDataFimSemanaAtual(), tempoGerado.getDataFimSemanaAtual());
		Assert.assertEquals(tempoEsperado.getDataFimSemanaAnterior(), tempoGerado.getDataFimSemanaAnterior());
		Assert.assertEquals(tempoEsperado.getDataFimDuasSemanasAnteriores(),
				tempoGerado.getDataFimDuasSemanasAnteriores());

	}

	@Test
	public void deveConverterUmaDataDoFimDaSemanaDoTipoLocalDateParaOTipoDate() {
		// Parte 1: Cenário
		LocalDate hoje = LocalDate.now();
		/*
		 * Teste executado em uma quinta-feira. Logo o dia final da semana é no
		 * sábado. 4 dias após a quinta-feira.
		 */
		Date dataEsperada = Date.from(hoje.plusDays(2).atStartOfDay(ZoneId.systemDefault()).toInstant());

		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		Date dataGerada = historicoController.convertDataFimSemanaToDate(hoje);

		// Parte 3: Validação
		Assert.assertEquals(dataEsperada, dataGerada);
	}

	@Test
	public void deveConverterUmaDadoDoInicioDaSemanaDoTipoLocalDateParaOTipoDate() {
		// Parte 1: Cenário
		LocalDate hoje = LocalDate.now();
		/*
		 * Teste executado em uma quinta-feira. Logo o primeiro dia da semana é
		 * no Domingo. 4 dias antes de quinta-feira.
		 */
		Date dataEsperada = Date.from(hoje.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());

		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		Date dataGerada = historicoController.convertDataInicioSemanaToDate(hoje);

		// Parte 3: Cenário
		Assert.assertEquals(dataEsperada, dataGerada);
	}

	@Test
	public void deveMontarHistoricoDeAtividade() {
		// Parte 1: Cenário
		Usuario usuario = new Usuario("Jusefina de Jesus Madalena", "juju.dalena@email.com", "Cozinheira de doces");

		Atividade atividade = new Atividade(usuario, "Correr", "Correr 1 KM em volta da orla da lagoa da pampulha", "Lazer");

		LocalDate hoje = LocalDate.now();
		LocalDate diaSemanaAnterior = hoje.minusWeeks(1);
		LocalDate diaDuasSemanasAnteriores = hoje.minusWeeks(2);

		Date dataInicioSemanaAtual = Date.from(hoje.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataInicioSemanaAtual.setHours(12);
		dataInicioSemanaAtual.setMinutes(00);
		dataInicioSemanaAtual.setSeconds(00);

		Date dataFimSemanaAtual = Date.from(hoje.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFimSemanaAtual.setHours(14);
		dataFimSemanaAtual.setMinutes(00);
		dataFimSemanaAtual.setSeconds(00);

		Date dataInicioSemanaAnterior = Date
				.from(diaSemanaAnterior.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataInicioSemanaAnterior.setHours(10);
		dataInicioSemanaAnterior.setMinutes(30);
		dataInicioSemanaAnterior.setSeconds(00);

		Date dataFimSemanaAnterior = Date
				.from(diaSemanaAnterior.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFimSemanaAnterior.setHours(12);
		dataFimSemanaAnterior.setMinutes(30);
		dataFimSemanaAnterior.setSeconds(00);

		Date dataInicioDuasSemanasAnteriores = Date
				.from(diaDuasSemanasAnteriores.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataInicioDuasSemanasAnteriores.setHours(11);
		dataInicioDuasSemanasAnteriores.setMinutes(10);
		dataInicioDuasSemanasAnteriores.setSeconds(00);

		Date dataFimDuasSemanasAnteriores = Date
				.from(diaDuasSemanasAnteriores.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFimDuasSemanasAnteriores.setHours(13);
		dataFimDuasSemanasAnteriores.setMinutes(10);
		dataFimDuasSemanasAnteriores.setSeconds(00);

		TempoInvestido tempoInvestidoSemanaAtual = new TempoInvestido(atividade, dataInicioSemanaAtual,	dataFimSemanaAtual, "Completar o km nesse tempo.");
		TempoInvestido tempoInvestidoSemanaAnterior = new TempoInvestido(atividade, dataInicioSemanaAnterior, dataFimSemanaAnterior, "Completar o km nesse tempo.");
		TempoInvestido tempoInvestidoDuasSemanasAnteriores = new TempoInvestido(atividade, dataInicioDuasSemanasAnteriores, dataFimDuasSemanasAnteriores, "Completar o km nesse tempo.");

		List<TempoInvestido> listSemanaAtual = new ArrayList<>();
		List<TempoInvestido> listSemanaAnterior = new ArrayList<>();
		List<TempoInvestido> listDuasSemanasAnteriores = new ArrayList<>();

		listSemanaAtual.add(tempoInvestidoDuasSemanasAnteriores);
		listSemanaAnterior.add(tempoInvestidoSemanaAnterior);
		listDuasSemanasAnteriores.add(tempoInvestidoDuasSemanasAnteriores);

		TempoHistorico tempoH = new TempoHistorico();
		String semanaAtual = "2:0";
		String semanaAnterior = "2:0";
		String duasSemanasAnteriores = "2:0";

		Historico historicoEsperado = new Historico(atividade, semanaAtual, semanaAnterior, duasSemanasAnteriores);

		// Parte 2: Ação

		HistoricoController historicoController = new HistoricoController();
		Historico historicoGerado = historicoController.montaHistoricoAtividade(atividade, listSemanaAtual,
				listSemanaAnterior, listDuasSemanasAnteriores, tempoH);

		// Parte 3: Validação

		Assert.assertEquals(historicoEsperado.getSemanaAtual(), historicoGerado.getSemanaAtual());
		Assert.assertEquals(historicoEsperado.getSemanaAnterior(), historicoGerado.getSemanaAnterior());
		Assert.assertEquals(historicoEsperado.getDuasSemanasAnteriores(), historicoGerado.getDuasSemanasAnteriores());
		Assert.assertEquals(historicoEsperado.getAtividade(), historicoGerado.getAtividade());

	}

	@Test
	public void deveCalcularTempoInvestidoDaAtividade() {
		// Parte 1: Cenário
		Usuario usuario = new Usuario("Jusefina de Jesus Madalena", "juju.dalena@email.com", "Cozinheira de doces");
		
		Atividade atividade = new Atividade(usuario, "Correr", "Correr 1 KM em volta da orla da lagoa da pampulha", "Lazer");
		
		LocalDate hoje = LocalDate.now();
		
		Date dataInicio = Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataInicio.setHours(12);
		dataInicio.setMinutes(00);
		dataInicio.setSeconds(00);
		
		Date dataFim = Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFim.setHours(14);
		dataFim.setMinutes(00);
		dataFim.setSeconds(00);
		
		Date dataInicio1 = Date.from(hoje.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataInicio1.setHours(12);
		dataInicio1.setMinutes(30);
		dataInicio1.setSeconds(00);
		
		Date dataFim1 = Date.from(hoje.minusDays(4).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFim1.setHours(14);
		dataFim1.setMinutes(30);
		dataFim1.setSeconds(00);
		
		TempoInvestido tempoInvestido = new TempoInvestido(atividade, dataInicio, dataFim, "Completar o km nesse tempo.");
		TempoInvestido tempoInvestido1 = new TempoInvestido(atividade, dataInicio1, dataFim1, "Completar o km nesse tempo.");
		List<TempoInvestido> temposInvestidos = new ArrayList<>();
		temposInvestidos.add(tempoInvestido);
		temposInvestidos.add(tempoInvestido1);
		
		TempoHistorico tempoH = new TempoHistorico();
		
		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		historicoController.calculaTempoInvestido(temposInvestidos, atividade, "historico", tempoH);
		String horasCalculadas = tempoH.getTempoInvestidoHoras() + ":" + tempoH.getTempoInvestidoMinutos();
		String horasEsperadas = "4:0";
		
		// Parte 3: Validação
		Assert.assertEquals(horasEsperadas, horasCalculadas);
	}
	@Test
	public void deveCalcularTempoInvestidoDaAtividadeParaGeracaoDeRelatorio() {
		// Parte 1: Cenário
		Usuario usuario = new Usuario("Jusefina de Jesus Madalena", "juju.dalena@email.com", "Cozinheira de doces");
		
		Atividade atividade = new Atividade(usuario, "Correr", "Correr 1 KM em volta da orla da lagoa da pampulha", "Lazer");
		
		LocalDate hoje = LocalDate.now();
		
		Date dataInicio = Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataInicio.setHours(12);
		dataInicio.setMinutes(00);
		dataInicio.setSeconds(00);
		
		Date dataFim = Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFim.setHours(14);
		dataFim.setMinutes(00);
		dataFim.setSeconds(00);
		
		TempoInvestido tempoInvestido = new TempoInvestido(atividade, dataInicio, dataFim, "Completar o km nesse tempo.");
		List<TempoInvestido> temposInvestidos = new ArrayList<>();
		temposInvestidos.add(tempoInvestido);
		
		TempoHistorico tempoEsperado = new TempoHistorico();
		tempoEsperado.setQuintaHr(2L);
		tempoEsperado.setQuintaMin(0L);
		
		TempoHistorico tempoGerado = new TempoHistorico();
		
		
		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		historicoController.calculaTempoInvestido(temposInvestidos, atividade, "relatorio", tempoGerado);
		String horasCalculadas = tempoGerado.getTempoInvestidoHoras() + ":" + tempoGerado.getTempoInvestidoMinutos();
		String horasEsperadas = "2:0";
		
		// Parte 3: Validação
		Assert.assertEquals(horasEsperadas, horasCalculadas);
		Assert.assertEquals(tempoEsperado.getQuintaHr(), tempoGerado.getQuintaHr());
		Assert.assertEquals(tempoEsperado.getQuintaMin(), tempoGerado.getQuintaMin());
		
	}

	@Test
	public void deveReiniciarVariaveisRelacionadasAoTempoInvestido() {
		// Parte 1: Cenário
		TempoHistorico tempoEsperado = new TempoHistorico();
		tempoEsperado.setHoras(0L);
		tempoEsperado.setMinutos(0L);
		tempoEsperado.setTempoInvestidoHoras(0L);
		tempoEsperado.setTempoInvestidoMinutos(0L);
		
		TempoHistorico tempoGerado = new TempoHistorico();
		tempoGerado.setHoras(10L);
		tempoGerado.setMinutos(10L);
		tempoGerado.setTempoInvestidoHoras(10L);
		tempoGerado.setTempoInvestidoMinutos(10L);

		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		historicoController.reiniciarVariaveisTempoInvestido(tempoGerado);
		
		// Parte 3: Validação
		Assert.assertEquals(tempoEsperado.getHoras(), tempoGerado.getHoras());
		Assert.assertEquals(tempoEsperado.getMinutos(), tempoGerado.getMinutos());
		Assert.assertEquals(tempoEsperado.getTempoInvestidoHoras(), tempoGerado.getTempoInvestidoHoras());
		Assert.assertEquals(tempoEsperado.getTempoInvestidoMinutos(), tempoGerado.getTempoInvestidoMinutos());
	}
	
	@Test
	public void deveObeterOTempoInvestidoNoDiaDaSemanaParaGerarRelatorio(){
		// Parte 1: Cenário
		Usuario usuario = new Usuario("Jusefina de Jesus Madalena", "juju.dalena@email.com", "Cozinheira de doces");

		Atividade atividade = new Atividade(usuario, "Correr", "Correr 1 KM em volta da orla da lagoa da pampulha", "Lazer");

		LocalDate hoje = LocalDate.now();
		Date dataInicio = Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataInicio.setHours(12);
		dataInicio.setMinutes(00);
		dataInicio.setSeconds(00);

		Date dataFim = Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFim.setHours(14);
		dataFim.setMinutes(00);
		dataFim.setSeconds(00);
		
		TempoInvestido tempoInvestido = new TempoInvestido(atividade, dataInicio, dataFim, "Completar o km nesse tempo.");
		TempoHistorico tempoGerado = new TempoHistorico();
		TempoHistorico tempoEsperado = new TempoHistorico();
		
		tempoEsperado.setQuintaHr(3L);
		tempoEsperado.setQuintaMin(45L);
		
		tempoGerado.setTempoInvestidoHoras(3L);
		tempoGerado.setTempoInvestidoMinutos(45L);
		
		//Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		historicoController.buscaDiaRelatorio(tempoInvestido, tempoGerado);
		
		//Parte 3: Validação
		Assert.assertEquals(tempoEsperado.getQuintaHr(), tempoGerado.getQuintaHr());
		Assert.assertEquals(tempoEsperado.getQuintaMin(), tempoGerado.getQuintaMin());
		
	}
	
	/*
	 * public String somarHorasInvestidas(TempoHistorico tempoH){ Long horas,
	 * minutos; horas = tempoH.getDomingoHr() + tempoH.getSegundaHr() +
	 * tempoH.getTercaHr() + tempoH.getQuartaHr() + tempoH.getQuintaHr() +
	 * tempoH.getSextaHr() + tempoH.getSabadoHr();
	 * 
	 * minutos = tempoH.getDomingoMin() + tempoH.getSegundaMin() +
	 * tempoH.getTercaMin() + tempoH.getQuartaMin() + tempoH.getQuintaMin() +
	 * tempoH.getSextaMin() + tempoH.getSabadoMin();
	 * 
	 * return horas + ":" + minutos;
	 * 
	 * 
	 * }
	 */
	
	@Test
	public void deveSomarTempoInvestidoPorAtividade() {
		// Parte 1: Cenário
		TempoHistorico tempoEsperado = new TempoHistorico();
		tempoEsperado.setSegundaHr(2L);
		tempoEsperado.setTercaHr(2L);
		tempoEsperado.setQuartaHr(2L);
		tempoEsperado.setQuintaHr(2L);
		tempoEsperado.setSextaHr(2L);
		tempoEsperado.setSabadoHr(2L);
		tempoEsperado.setDomingoHr(2L);
		
		tempoEsperado.setSegundaMin(0L);
		tempoEsperado.setTercaMin(0L);
		tempoEsperado.setQuartaMin(0L);
		tempoEsperado.setQuintaMin(0L);
		tempoEsperado.setSextaMin(0L);
		tempoEsperado.setSabadoMin(0L);
		tempoEsperado.setDomingoMin(0L);
		
		

		// Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		
		// Parte 3: Validação
		Assert.assertEquals(historicoController.somarHorasInvestidas(tempoEsperado), "10:00");
	}
}
