package br.com.timecontrol.controller;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.timecontrol.model.Usuario;
import br.com.timecontrol.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/validaLogin", method = RequestMethod.GET)
	public Usuario buscaAtividadeUsuario(@QueryParam(value = "email") String email,
			@QueryParam(value = "senha") String senha) {
		Usuario usuario = usuarioRepository.buscarPorEmailSenha(email, senha);
		return usuario;
	}
	
	@RequestMapping(value="/", method= RequestMethod.POST, headers = "Content-type=application/json", consumes = "application/json")
	public @ResponseBody ResponseBuilder criar(@RequestBody Usuario usuario){
		
		try {
			usuarioRepository.salvar(usuario);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}
	
	@RequestMapping(value="/", method= RequestMethod.PUT)
	public @ResponseBody ResponseBuilder alterar(@RequestBody Usuario usuario){
		
		try {
			usuarioRepository.alterar(usuario);
		}
		catch (Exception e) {
			return null;
		}
		return Response.ok("OK", "response");
	}

}