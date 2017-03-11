package br.com.lab.dev.system.timeControl.service.mapper;

import br.com.lab.dev.system.timeControl.domain.Usuario;
import br.com.lab.dev.system.timeControl.service.DTO.UsuarioDTO;

public class UsuarioMapper {

	public static Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();

		usuario.setIdUsuario(usuarioDTO.getIdUsuario());
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setSenha(usuarioDTO.getSenha());
		usuario.setProfissao(usuarioDTO.getProfissao());

		return usuario;
	}

	public static UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
		
		UsuarioDTO usuarioDTO = new UsuarioDTO();

		usuarioDTO.setIdUsuario(usuario.getIdUsuario());
		usuarioDTO.setNome(usuario.getNome());
		usuarioDTO.setEmail(usuario.getEmail());
		usuarioDTO.setSenha(usuario.getSenha());
		usuarioDTO.setProfissao(usuario.getProfissao());

		return usuarioDTO;
	}

}
