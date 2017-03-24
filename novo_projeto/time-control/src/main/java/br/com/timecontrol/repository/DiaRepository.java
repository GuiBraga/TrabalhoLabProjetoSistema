package br.com.timecontrol.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import br.com.timecontrol.model.Dia;

@Repository
public class DiaRepository{
 
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
 
	public void Salvar(Dia dia){
 
		manager.persist(dia);		
	}
 
	@javax.transaction.Transactional
	public void Alterar(Dia dia){
 
		manager.merge(dia);		
	}

	public Dia ConsultarPorCodigo(int codigo){
 
		return manager.find(Dia.class, codigo);		
	} 
 
	@javax.transaction.Transactional
	public void Excluir(int codigo){
 
		Dia dia = this.ConsultarPorCodigo(codigo);
 
		manager.remove(dia);
 
	}
 
	public List<Dia> TodosUsuarios(){
 
		return manager.createQuery("SELECT d FROM Dia d ", Dia.class).getResultList();	
	}
 
}