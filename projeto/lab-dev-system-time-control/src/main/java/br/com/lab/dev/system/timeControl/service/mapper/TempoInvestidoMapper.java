package br.com.lab.dev.system.timeControl.service.mapper;

import br.com.lab.dev.system.timeControl.domain.TempoInvestido;
import br.com.lab.dev.system.timeControl.service.DTO.TempoInvestidoDTO;

public class TempoInvestidoMapper {

	public static TempoInvestido tempoInvestidoDTOToTempoInvestido(TempoInvestidoDTO tempoInvestidoDTO) {

		TempoInvestido tempoInvestido = new TempoInvestido();

		tempoInvestido.setAtividadeIdAtividade(tempoInvestidoDTO.getAtividadeIdAtividade());
		tempoInvestido.setDiaIdDia(tempoInvestidoDTO.getDiaIdDia());
		tempoInvestido.setIdTempoInvestido(tempoInvestidoDTO.getIdTempoInvestido());
		tempoInvestido.setDataInicio(tempoInvestidoDTO.getDataInicio());
		tempoInvestido.setDataFim(tempoInvestidoDTO.getDataFim());
		tempoInvestido.setHorasGastas(tempoInvestidoDTO.getHorasGastas());

		return tempoInvestido;
	}

	public static TempoInvestidoDTO tempoInvestidoToTempoInvestidoDTO(TempoInvestido tempoInvestido) {

		TempoInvestidoDTO tempoInvestidoDTO = new TempoInvestidoDTO();

		tempoInvestidoDTO.setAtividadeIdAtividade(tempoInvestido.getAtividadeIdAtividade());
		tempoInvestidoDTO.setDiaIdDia(tempoInvestido.getDiaIdDia());
		tempoInvestidoDTO.setIdTempoInvestido(tempoInvestido.getIdTempoInvestido());
		tempoInvestidoDTO.setDataInicio(tempoInvestido.getDataInicio());
		tempoInvestidoDTO.setDataFim(tempoInvestido.getDataFim());
		tempoInvestidoDTO.setHorasGastas(tempoInvestido.getHorasGastas());

		return tempoInvestidoDTO;
	}
}
