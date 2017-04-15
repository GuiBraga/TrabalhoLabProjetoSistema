package br.com.timecontrol.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.timecontrol.model.Atividade;
import br.com.timecontrol.repository.AtividadeRepository;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
 
	@Autowired
	AtividadeRepository atividadeRepository;
	
	@RequestMapping(value ="/{codigo}", method= RequestMethod.GET)
	public Atividade buscarPorCodigo(@PathVariable Integer codigo){
		Atividade atividade = atividadeRepository.consultarPorCodigo(codigo);
		return atividade;
	}
	
	@RequestMapping(value ="/todos", method= RequestMethod.GET)
	public List<Atividade> listarTodas(){
		List<Atividade> atividades = atividadeRepository.listarTodas();
		return atividades;
	}
 
	@RequestMapping(value="/", method= RequestMethod.POST)
	public @ResponseBody ResponseBuilder criar(@RequestBody Atividade atividade){
		
		try {
			atividadeRepository.salvar(atividade);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
	
	@RequestMapping(value="/", method= RequestMethod.PUT)
	public @ResponseBody ResponseBuilder alterar(@RequestBody Atividade atividade){
		
		try {
			atividadeRepository.alterar(atividade);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
	
	@RequestMapping(value="/{codigo}", method= RequestMethod.DELETE)
	public ResponseBuilder deletar(@PathVariable Integer codigo){
		
		try {
			atividadeRepository.excluir(codigo);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
}