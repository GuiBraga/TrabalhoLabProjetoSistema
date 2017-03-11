package br.com.lab.dev.system.timeControl.service.impl;

import br.com.lab.dev.system.timeControl.domain.Usuario;
import br.com.lab.dev.system.timeControl.service.UsuarioService;
import br.com.lab.dev.system.timeControl.service.DTO.UsuarioDTO;
import br.com.lab.dev.system.timeControl.service.mapper.UsuarioMapper;
import br.com.lab.dev.system.timeControl.service.repository.UsuarioRepository;

public class UsuarioServiceImpl implements UsuarioService {

	UsuarioRepository usuarioRepository;
	UsuarioMapper usuarioMapper;

	/**
	 * Save a usuario.
	 *
	 * @param usuarioDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {

		Usuario usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);
		usuario = usuarioRepository.save(usuario);
		UsuarioDTO result = usuarioMapper.usuarioToUsuarioDTO(usuario);

		return result;
	}

	/**
	 * Delete the usuario by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Integer id) {
		usuarioRepository.delete(id);;

	}

	/**
	 * Get one usuario by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	public UsuarioDTO findOne(Integer id) {

		Usuario usuario = usuarioRepository.findOne(id);
		UsuarioDTO usuarioDTO = usuarioMapper.usuarioToUsuarioDTO(usuario);
		return usuarioDTO;
	}
}
