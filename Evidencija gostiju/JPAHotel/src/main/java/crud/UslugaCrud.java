package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Usluga;
import util.PersistenceUtil;

public class UslugaCrud {

	
	@SuppressWarnings("unchecked")
	public List<Usluga> listaUsluga() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select u from Usluga u";
		Query q = em.createQuery(upit);
		List<Usluga> lista = q.getResultList();
		em.close();
		return lista;
		
	}
	
	public Usluga getUslugaByID(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Usluga usluga = em.find(Usluga.class, id);
		em.close();
		return usluga;
	}
}
