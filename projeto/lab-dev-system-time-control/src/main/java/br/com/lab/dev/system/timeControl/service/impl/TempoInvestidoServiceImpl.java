package br.com.lab.dev.system.timeControl.service.impl;

import br.com.lab.dev.system.timeControl.domain.TempoInvestido;
import br.com.lab.dev.system.timeControl.service.TempoInvestidoService;
import br.com.lab.dev.system.timeControl.service.DTO.TempoInvestidoDTO;
import br.com.lab.dev.system.timeControl.service.mapper.TempoInvestidoMapper;
import br.com.lab.dev.system.timeControl.service.repository.TempoInvestidoRepository;

public class TempoInvestidoServiceImpl implements TempoInvestidoService{

	TempoInvestidoRepository tempoInvestidoRepository;
	TempoInvestidoMapper tempoInvestidoMapper;

	/**
	 * Save a tempo investido.
	 *
	 * @param tempoInvestidoDTO
	 *            the entity to save
	 * @return the persisted entity
	 */
	@Override
	public TempoInvestidoDTO save(TempoInvestidoDTO tempoInvestidoDTO) {
		TempoInvestido tempoInvestido = tempoInvestidoMapper.tempoInvestidoDTOToTempoInvestido(tempoInvestidoDTO);
		tempoInvestido = tempoInvestidoRepository.save(tempoInvestido);
		TempoInvestidoDTO result = tempoInvestidoMapper.tempoInvestidoToTempoInvestidoDTO(tempoInvestido);

		return result;
	}

	/**
	 * Delete the tempo investido by id.
	 *
	 * @param id
	 *            the id of the entity
	 */
	@Override
	public void delete(Integer id) {
		tempoInvestidoRepository.delete(id);
	}

	/**
	 * Get one tempo investido by id.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
	@Override
	public TempoInvestidoDTO findOne(Integer id) {

		TempoInvestido tempoInvestido = tempoInvestidoRepository.findOne(id);
		TempoInvestidoDTO tempoInvestidoDTO = tempoInvestidoMapper.tempoInvestidoToTempoInvestidoDTO(tempoInvestido);
		return tempoInvestidoDTO;
	}

	@Override
	public Iterable<TempoInvestidoDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Get all tempo investido in activity.
	 *
	 * @param id
	 *            the id of the entity
	 * @return the entity
	 */
//	@Override
//	public Iterable<TempoInvestidoDTO> findAll() {
//
//		Iterable<TempoInvestido> tempoInvestidos = tempoInvestidoRepository.findAll();
//		Iterable<TempoInvestidoDTO> tempoInvestidoDTO = new ArrayList<>();
//		
//		for(TempoInvestido tempoInvestido : tempoInvestidos){
//			if(TempoInvestidoDTO == null){
//				throw new RuntimeException("Unable to recover all activities Unable to recover all times invested in this activity");
//			}
//			TempoInvestidoDTO aux = tempoInvestidoMapper.tempoInvestidoToTempoInvestidoDTO(tempoInvestido);
//			
//			tempoInvestidoDTO = (Iterable<TempoInvestidoDTO>) aux;
//		}
//				
//		return tempoInvestidoDTO;
//	}
}
