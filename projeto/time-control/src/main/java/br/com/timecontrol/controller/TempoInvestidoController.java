package br.com.timecontrol.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.timecontrol.model.Atividade;
import br.com.timecontrol.model.Evento;
import br.com.timecontrol.model.TempoInvestido;
import br.com.timecontrol.repository.AtividadeRepository;
import br.com.timecontrol.repository.TempoInvestidoRepository;

@RestController
@RequestMapping("/tempoinvestido")
public class TempoInvestidoController {
	
	@Autowired
	AtividadeRepository atividadeRepository;

	@Autowired
	TempoInvestidoRepository tempoInvestidoRepository;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET, produces = "application/json")
	public TempoInvestido buscarPorCodigo(@PathVariable Integer codigo) {
		TempoInvestido tempoInvestido = tempoInvestidoRepository.consultarPorCodigo(codigo);
		return tempoInvestido;
	}

	@RequestMapping(value = "/{codigoUsuario}/todos", method = RequestMethod.GET)
	public List<Evento> listarTodas(@PathVariable Integer codigoUsuario) {
		List<TempoInvestido> tempoInvestidos = tempoInvestidoRepository.listarTodosPorUsuario(codigoUsuario);
		List<Evento> eventos = new ArrayList<>();
		for (TempoInvestido tempoInvestido : tempoInvestidos) {
			Evento evento = new Evento();
			evento.setAtividade(tempoInvestido.getAtividade());
			evento.setDescricao(tempoInvestido.getDescricao());
			evento.setStart(tempoInvestido.getDataInicio());
			evento.setEnd(tempoInvestido.getDataFim());
			evento.setTitle(tempoInvestido.getAtividade().getNome());
			
			eventos.add(evento);
		}
		return eventos;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, headers = "Content-type=application/json", consumes = "application/json")
	public ResponseEntity<TempoInvestido> criar(@RequestBody TempoInvestido tempoInvestido) {

		try {
			Atividade atividade = atividadeRepository.buscarAtividadePorNome(tempoInvestido.getAtividade().getNome());
			tempoInvestido.setAtividade(atividade);
			tempoInvestidoRepository.salvar(tempoInvestido);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(tempoInvestido, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT, headers = "Content-type=application/json", consumes = "application/json")
	public ResponseEntity<TempoInvestido> alterar(@RequestBody TempoInvestido tempoInvestido) {

		try {
			tempoInvestidoRepository.alterar(tempoInvestido);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(tempoInvestido, HttpStatus.OK);
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.DELETE)
	public ResponseBuilder deletar(@PathVariable Integer codigo) {

		try {
			tempoInvestidoRepository.excluir(codigo);
		} catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
}