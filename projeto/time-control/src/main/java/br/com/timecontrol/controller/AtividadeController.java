package br.com.timecontrol.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.timecontrol.model.Atividade;
import br.com.timecontrol.model.TempoInvestido;
import br.com.timecontrol.model.Usuario;
import br.com.timecontrol.repository.AtividadeRepository;
import br.com.timecontrol.repository.TempoInvestidoRepository;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
 
	@Autowired
	AtividadeRepository atividadeRepository;
	
	@Autowired 
	TempoInvestidoRepository tempoInvestidoRepository;
	
	@RequestMapping(value ="/{codigo}", method= RequestMethod.GET)
	public Atividade buscarPorCodigo(@PathVariable Integer codigo){
		Atividade atividade = atividadeRepository.consultarPorCodigo(codigo);
		return atividade;
	}
	
	@RequestMapping(value ="/{codigoUsuario}/todos", method= RequestMethod.GET)
	public List<Atividade> listarTodas(@PathVariable Integer codigoUsuario){
		List<Atividade> atividades = atividadeRepository.listarTodasPorUsuario(codigoUsuario);
		return atividades;
	}
	
	@RequestMapping(value="/", method= RequestMethod.POST, headers = "Content-type=application/json", consumes = "application/json")
	public ResponseEntity<Atividade> criar(@RequestBody Atividade atividade){
	
		try {
			Atividade atividadeExistente = atividadeRepository.buscarAtividadePorNome(atividade.getNome());
			if(atividadeExistente != null){
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			atividadeRepository.salvar(atividade);
		}	
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(atividade, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.PUT, headers = "Content-type=application/json", consumes = "application/json")
	public @ResponseBody ResponseBuilder alterar(@RequestBody Atividade atividade){
		
		try {
			atividadeRepository.alterar(atividade);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
	
	@RequestMapping(value="/{codigo}", method= RequestMethod.DELETE, consumes = "application/json")
	public ResponseBuilder deletar(@PathVariable Integer codigo, @RequestBody Integer codigoUsuario){
		
		List<TempoInvestido> temposInvestidos = tempoInvestidoRepository.listarTodosPorUsuario(codigoUsuario);
		Atividade atividade = atividadeRepository.consultarPorCodigo(codigo);
		
		for(TempoInvestido tempo : temposInvestidos){
			if(tempo.getAtividade().getCodigo() == atividade.getCodigo()){
				tempoInvestidoRepository.excluir(tempo.getCodigo());
			}
		}	
		atividadeRepository.excluir(codigo,codigoUsuario);
		
		return Response.ok("OK", "response");
	}
}