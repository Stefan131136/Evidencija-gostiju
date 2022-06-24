package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Vrstasobe;
import util.PersistenceUtil;

public class VrstaSobeCrud {
	
	@SuppressWarnings("unchecked")
	public List<Vrstasobe> listaVrstaSoba() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select vs from Vrstasobe vs";
		Query q = em.createQuery(upit);
		List<Vrstasobe> lista = q.getResultList();
		em.close();
		return lista;
		
	}
	
	public Vrstasobe getVrstasobeByID(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Vrstasobe vrstasobe = em.find(Vrstasobe.class, id);
		em.close();
		return vrstasobe;
	}
}
