package br.com.lab.dev.system.timeControl.service.mapper;

import br.com.lab.dev.system.timeControl.domain.Dia;
import br.com.lab.dev.system.timeControl.service.DTO.DiaDTO;

public class DiaMapper {

	public static Dia diaDTOToDia(DiaDTO diaDTO) {

		Dia dia = new Dia();

		dia.setIdDia(diaDTO.getIdDia());
		dia.setDataDia(diaDTO.getDataDia());
		dia.setTotalHorasDia(diaDTO.getTotalHorasDia());

		return dia;
	}

	public static DiaDTO usuarioToUsuarioDTO(Dia dia) {

		DiaDTO diaDTO = new DiaDTO();

		diaDTO.setIdDia(dia.getIdDia());
		diaDTO.setDataDia(dia.getDataDia());
		diaDTO.setTotalHorasDia(dia.getTotalHorasDia());

		return diaDTO;
	}

}
