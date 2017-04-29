package br.com.timecontrol.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.timecontrol.model.Usuario;

@Repository
public class UsuarioRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@javax.transaction.Transactional
	public void salvar(Usuario usuario) {

		manager.persist(usuario);
	}

	@javax.transaction.Transactional
	public void alterar(Usuario usuario) {

		manager.merge(usuario);
	}

	public Usuario consultarPorCodigo(int codigo) {

		return manager.find(Usuario.class, codigo);
	}

	@javax.transaction.Transactional
	public void excluir(int codigo) {

		Usuario usuario = this.consultarPorCodigo(codigo);

		manager.remove(usuario);

	}

	public Usuario buscarPorEmailSenha(String email, String senha) {
		Query query = manager.createQuery("SELECT c FROM Usuario c WHERE c.email = :email and c.senha = :senha ",
				Usuario.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		return (Usuario) query.getSingleResult();
	}

	public Usuario buscarPorEmail(String email) {
		Query query = manager.createQuery("SELECT c FROM Usuario c WHERE c.email = :email",
				Usuario.class);
		query.setParameter("email", email);
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Usuario buscaPorCodigo(Integer codigo){
		Query query = manager.createQuery("SELECT c FROM Usuario c WHERE c.codigo = :codigo",
				Usuario.class);
		query.setParameter("codigo", codigo);
		try {
			return (Usuario) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

}