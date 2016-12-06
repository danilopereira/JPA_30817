package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Medico;

public class MedicoHelper {
	
	EntityManager em;
	
	public MedicoHelper(EntityManager em){
		this.em = em;
	}
	
	public void salvar(Medico medico){
		em.getTransaction().begin();
		em.persist(medico);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> buscarMedicosPorHospital(int idHospital){
		Query query = em.createQuery("select m from Medico m where idHospital = :idHospital");
		query.setParameter("idHospital", idHospital);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> listarTodos(){
		Query query = em.createNamedQuery("Medico.findAll");
		return query.getResultList();
	}
	
	public Medico buscarMedicosPorCRM(String crm){
		Query query = em.createQuery("select m from Medico m where crm = :crm");
		query.setParameter("crm", crm);
		return (Medico) query.getSingleResult();
	}

}
