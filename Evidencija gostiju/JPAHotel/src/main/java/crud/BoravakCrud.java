package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Boravak;
import model.Gost;
import model.Usluga;
import model.Vrstasobe;
import util.PersistenceUtil;

public class BoravakCrud {

	
	public Boravak insertBoravak(Gost gost, Vrstasobe vrstasobe, Usluga usluga, String datum, String trajanje) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		Boravak boravak = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			gost = em.merge(gost);
			vrstasobe = em.merge(vrstasobe);
			usluga = em.merge(usluga);
						
			boravak = new Boravak();
			
			boravak.setGost(gost);
			boravak.setVrstasobe(vrstasobe);
			boravak.setUsluga(usluga);
			boravak.setDatum(datum);
			boravak.setTrajanje(trajanje);
			
			gost.addBoravak(boravak);
			vrstasobe.addBoravak(boravak);
			usluga.addBoravak(boravak);
			
			em.persist(boravak);
			
			em.merge(gost);
			em.merge(vrstasobe);
			em.merge(usluga);
			
			et.commit();
				
		} catch (Exception e) {
			e.printStackTrace();
			if (et != null) {
				et.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return boravak;
	}
	
	@SuppressWarnings("unchecked")
	public List<Boravak> listaBoravka() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select b from Boravak b";
		Query q = em.createQuery(upit);
		List<Boravak> lista = q.getResultList();
		em.close();
		return lista;
		
	}
	

}
