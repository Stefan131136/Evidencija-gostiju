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

public class GostCrud {
	
	public void insertGost(Gost gost) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			em.persist(gost);
			gost = em.merge(gost);
			
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
	}
	
	@SuppressWarnings("unchecked")
	public List<Gost> listaGostiju() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select g from Gost g";
		Query q = em.createQuery(upit);
		List<Gost> lista = q.getResultList();
		em.close();
		return lista;
		
	}
	
	public void deleteGost(Gost gost) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			gost = em.merge(gost);
			
			List<Boravak> boravci = gost.getBoravaks();
			
			for (Boravak boravak : boravci) {
				boravak = em.merge(boravak);
				
				Usluga usluga = boravak.getUsluga();
				usluga = em.merge(usluga);
				usluga.removeBoravak(boravak);
				em.merge(usluga);
				
				Vrstasobe vrstasobe = boravak.getVrstasobe();
				vrstasobe = em.merge(vrstasobe);
				vrstasobe.removeBoravak(boravak);
				em.merge(vrstasobe);
				
				boravak.setUsluga(null);
				boravak.setVrstasobe(null);
				boravak.setGost(null);
				
				em.remove(boravak);
			}
			
			
			em.remove(gost);
			
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
	}
	
	public Gost getGostByID(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Gost gost = em.find(Gost.class, id);
		em.close();
		return gost;
	}
	
	

}
