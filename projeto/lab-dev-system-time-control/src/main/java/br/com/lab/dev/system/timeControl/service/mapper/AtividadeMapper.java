package br.com.lab.dev.system.timeControl.service.mapper;

import br.com.lab.dev.system.timeControl.domain.Atividade;
import br.com.lab.dev.system.timeControl.service.DTO.AtividadeDTO;

public class AtividadeMapper {

	public Atividade atividadeDTOToAtividade(AtividadeDTO atividadeDTO) {

		Atividade atividade = new Atividade();

		atividade.setIdAtividade(atividadeDTO.getIdAtividade());
		atividade.setNome(atividadeDTO.getNome());
		atividade.setDescricao(atividadeDTO.getDescricao());
		atividade.setCategoria(atividadeDTO.getCategoria());
		atividade.setPrioridade(atividadeDTO.getPrioridade());
		atividade.setUsuarioIdUsuario(atividadeDTO.getUsuarioIdUsuario());

		return atividade;
	}

	public AtividadeDTO atividadeToAtividadeDTO(Atividade atividade) {

		AtividadeDTO atividadeDTO = new AtividadeDTO();

		atividadeDTO.setIdAtividade(atividade.getIdAtividade());
		atividadeDTO.setNome(atividade.getNome());
		atividadeDTO.setDescricao(atividade.getDescricao());
		atividadeDTO.setCategoria(atividade.getCategoria());
		atividadeDTO.setPrioridade(atividade.getPrioridade());
		atividadeDTO.setUsuarioIdUsuario(atividade.getUsuarioIdUsuario());

		return atividadeDTO;

	}

}
