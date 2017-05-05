package br.com.timecontrol.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.timecontrol.model.TempoInvestido;
import br.com.timecontrol.model.Usuario;

@Repository
public class HistoricoRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	public List<TempoInvestido> buscaHistorico(Integer codigoUsuario, Date dataInicio, Date dataFim) {
		Query query = manager.createQuery("SELECT ti FROM TempoInvestido ti WHERE ti.atividade.codigo IN"
				+ " (SELECT atv FROM Atividade atv WHERE atv.usuario.codigo = :codUsuario)"
				+ " AND ti.dataInicio BETWEEN :dataInicio AND :dataFim "
				+ " AND ti.dataFim BETWEEN :dataInicio AND :dataFim",
				TempoInvestido.class);
		query.setParameter("codUsuario", codigoUsuario);
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}