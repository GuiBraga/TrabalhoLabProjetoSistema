package br.com.lab.dev.system.timeControl.service;

import br.com.lab.dev.system.timeControl.service.DTO.AtividadeDTO;

public interface AtividadeService {

	/**
     * Save a atividade.
     *
     * @param atividadeDTO the entity to save
     * @return the persisted entity
     */
	AtividadeDTO save(AtividadeDTO atividade);

	/**
     *  Delete the "id" atividade.
     *
     *  @param id the id of the entity
     */
	void delete(Long id);

	/**
     *  Get the all atividades.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
	Iterable<AtividadeDTO> findAll();

	/**
     *  Get the "id" atividade.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
	AtividadeDTO findOne(Long id);

}
