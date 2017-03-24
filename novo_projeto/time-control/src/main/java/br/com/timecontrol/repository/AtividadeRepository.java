package br.com.timecontrol.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import br.com.timecontrol.model.Atividade;

@Repository
public class AtividadeRepository{
 
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
 
	public void salvar(Atividade atividade){
 
		manager.persist(atividade);		
	}
 
	@javax.transaction.Transactional
	public void alterar(Atividade atividade){
 
		manager.merge(atividade);		
	}

	public Atividade consultarPorCodigo(int codigo){
 
		return manager.find(Atividade.class, codigo);		
	} 
 
	@javax.transaction.Transactional
	public void excluir(int codigo){
 
		Atividade atividade = this.consultarPorCodigo(codigo);
 
		manager.remove(atividade);
 
	}
 
	public List<Atividade> listarTodas(){
 
		return manager.createQuery("SELECT a FROM Atividade a ", Atividade.class).getResultList();	
	}
 
}