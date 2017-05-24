package br.com.timecontrol.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.timecontrol.model.Atividade;

@Repository
public class AtividadeRepository{
 
	@Autowired 
	TempoInvestidoRepository tempoInvestidoRepository;
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
 
	@javax.transaction.Transactional
	public void salvar(Atividade atividade){
		manager.persist(atividade);		
	}
 
	@javax.transaction.Transactional
	public void alterar(Atividade atividade){
 
		manager.merge(atividade);		
	}
	
	@javax.transaction.Transactional
	public Atividade consultarPorCodigo(int codigo){
 
		return manager.find(Atividade.class, codigo);		
	} 
 
	@javax.transaction.Transactional
	public void excluir(int codigo, int codigoUsuario){
 
		Atividade atividade = this.consultarPorCodigo(codigo);
		
		manager.remove(atividade);
 
	}

	public List<Atividade> listarTodasPorUsuario(Integer codigoUsuario) {
		Query query = manager.createQuery("SELECT c FROM Atividade c WHERE c.usuario.codigo = :codigoUsuario",
				Atividade.class);
		query.setParameter("codigoUsuario", codigoUsuario);
		return query.getResultList();
	}
	
	public Atividade buscarAtividadePorNome(String nome) {
		Query query = manager.createQuery("SELECT c FROM Atividade c WHERE c.nome = :nome",
				Atividade.class);
		query.setParameter("nome", nome);
		try {
			return (Atividade) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
 
}