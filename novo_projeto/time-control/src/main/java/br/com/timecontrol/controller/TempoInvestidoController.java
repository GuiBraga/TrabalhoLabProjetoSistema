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

import br.com.timecontrol.model.TempoInvestido;
import br.com.timecontrol.repository.TempoInvestidoRepository;

@RestController
@RequestMapping("/tempoinvestido")
public class TempoInvestidoController {
 
	@Autowired
	TempoInvestidoRepository tempoInvestidoRepository;
 
	@RequestMapping(value ="/{codigo}", method= RequestMethod.GET, produces = "application/json")
	public TempoInvestido buscarPorCodigo(@PathVariable Integer codigo){
		TempoInvestido tempoInvestido = tempoInvestidoRepository.consultarPorCodigo(codigo);
		return tempoInvestido;
	}
	
	@RequestMapping(value ="/todos", method= RequestMethod.GET)
	public List<TempoInvestido> listarTodas(){
		List<TempoInvestido> tempoInvestidos = tempoInvestidoRepository.listarTodos();
		return tempoInvestidos;
	}
 
	@RequestMapping(value="/", method= RequestMethod.POST)
	public @ResponseBody ResponseBuilder criar(@RequestBody TempoInvestido tempoInvestido){
		
		try {
			tempoInvestidoRepository.salvar(tempoInvestido);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
	
	@RequestMapping(value="/", method= RequestMethod.PUT)
	public @ResponseBody ResponseBuilder alterar(@RequestBody TempoInvestido tempoInvestido){
		
		try {
			tempoInvestidoRepository.alterar(tempoInvestido);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.DELETE)
	public ResponseBuilder deletar(@PathVariable Integer codigo){
		
		try {
			tempoInvestidoRepository.excluir(codigo);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
}