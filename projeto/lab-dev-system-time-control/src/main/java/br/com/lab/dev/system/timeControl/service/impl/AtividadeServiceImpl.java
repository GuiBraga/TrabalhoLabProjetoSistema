package br.com.lab.dev.system.timeControl.service.impl;

import br.com.lab.dev.system.timeControl.domain.Atividade;
import br.com.lab.dev.system.timeControl.service.AtividadeService;
import br.com.lab.dev.system.timeControl.service.DTO.AtividadeDTO;
import br.com.lab.dev.system.timeControl.service.mapper.AtividadeMapper;
import br.com.lab.dev.system.timeControl.service.repository.AtividadeRepository;

public class AtividadeServiceImpl implements AtividadeService {

	AtividadeRepository atividadeRepository;
	AtividadeMapper atividadeMapper;

	/**
	 * Save a atividade.
	 *
	 * @param atividadeDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public AtividadeDTO save(AtividadeDTO atividadeDTO) {
		Atividade atividade = atividadeMapper.atividadeDTOToAtividade(atividadeDTO);
		atividade = atividadeRepository.save(atividade);
		AtividadeDTO result = atividadeMapper.atividadeToAtividadeDTO(atividade);

		return result;
	}

	/**
	 * Delete the atividade by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Long id) {
		atividadeRepository.delete(id);
	}

	/**
	 * Get one atividade by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	public AtividadeDTO findOne(Long id) {

		Atividade atividade = atividadeRepository.findOne(id);
		AtividadeDTO atividadeDTO = atividadeMapper.atividadeToAtividadeDTO(atividade);
		return atividadeDTO;
	}

	@Override
	public Iterable<AtividadeDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Get all atividades.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
//	@Override
//	public Iterable<AtividadeDTO> findAll() {
//
//		Iterable<Atividade> atividades = atividadeRepository.findAll();
//		Iterable<AtividadeDTO> atividadesDTO = new ArrayList<>();
//		
//		for(Atividade atividade : atividades){
//			if(atividade == null){
//				throw new RuntimeException("Unable to retrieve all activities");
//			}
//			AtividadeDTO aux = atividadeMapper.atividadeToAtividadeDTO(atividade);
//			
//			atividadesDTO = (Iterable<AtividadeDTO>) aux;
//		}
//				
//		return atividadesDTO;
//	}
}
