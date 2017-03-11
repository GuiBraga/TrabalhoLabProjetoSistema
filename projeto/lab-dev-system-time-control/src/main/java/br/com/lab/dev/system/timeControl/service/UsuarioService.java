package br.com.lab.dev.system.timeControl.service;

import br.com.lab.dev.system.timeControl.service.DTO.UsuarioDTO;

public interface UsuarioService {

	/**
     * Save a usuario.
     *
     * @param usuarioDTO the entity to save
     * @return the persisted entity
     */
	UsuarioDTO save(UsuarioDTO usuarioDTO);
	
	/**
     *  Delete the "id" usuario.
     *
     *  @param id the id of the entity
     */
	void delete(Integer id);
	
	
	/**
     *  Get the "id" usuario.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
	UsuarioDTO findOne(Integer id);
}
