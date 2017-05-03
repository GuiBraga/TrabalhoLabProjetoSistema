import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import br.com.timecontrol.controller.HistoricoController;
import br.com.timecontrol.model.Atividade;
import br.com.timecontrol.model.TempoHistorico;
import br.com.timecontrol.model.TempoInvestido;
import br.com.timecontrol.model.Usuario;
import junit.framework.Assert;

class HistoricoTest {
	
	@Test
	public void deveCalcularTempoInvestidoDaAtividade(){
		//Parte 1: Cenário

		Usuario usuario = new Usuario("João","joao.medeiros@email.com", "Advogado");
		Atividade atividade = new Atividade(usuario, "Correr", "Correr 1 KM em volta da orla da lagoa da pampulha","Lazer");
		
		Date dataInicio = new Date("2017-04-30 12:30:00");
		Date dataFim = new Date("2017-04-30 14:15:00");
		Date dataInicio1 = new Date("2017-05-01 11:30:00");
		Date dataFim1 = new Date("2017-05-05 14:30:00");
		
		TempoInvestido tempoInvestido = new TempoInvestido(atividade,dataInicio , dataFim, "Completar o km nesse tempo.");
		TempoInvestido tempoInvestido1 = new TempoInvestido(atividade,dataInicio1 , dataFim1, "Completar o km nesse tempo.");
		List<TempoInvestido> temposInvestidos = new ArrayList<>();
		temposInvestidos.add(tempoInvestido);
		temposInvestidos.add(tempoInvestido1);
		
		TempoHistorico tempoH = new TempoHistorico();
		
		//Parte 2: Ação
		HistoricoController historicoController = new HistoricoController();
		historicoController.calculaTempoInvestido(temposInvestidos,atividade, "historico",tempoH);
		String horasCalculadas = tempoH.getTempoInvestidoHoras() +":"+tempoH.getTempoInvestidoMinutos();
		String horasEsperadas = "4:45";
		
		//Parte 3: Validação
		Assert.assertEquals(horasEsperadas, horasCalculadas);
	}

}
