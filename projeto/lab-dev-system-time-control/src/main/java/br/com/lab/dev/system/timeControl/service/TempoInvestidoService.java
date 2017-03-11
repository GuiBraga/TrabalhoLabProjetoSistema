package br.com.lab.dev.system.timeControl.service;

import br.com.lab.dev.system.timeControl.service.DTO.TempoInvestidoDTO;

public interface TempoInvestidoService {

	TempoInvestidoDTO save(TempoInvestidoDTO tempoInvestidoDTO);

	void delete(Integer id);

	TempoInvestidoDTO findOne(Integer id);

	Iterable<TempoInvestidoDTO> findAll();
}
