package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Hospital;

public class HospitalHelper {
	
	EntityManager em;
	
	public HospitalHelper(EntityManager em){
		this.em = em;
	}
	
	public void salvar(Hospital hospital){
		em.getTransaction().begin();;
		em.persist(hospital);
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Hospital> buscarTodos(){
		Query query = em.createNamedQuery("Hospital.findAll");
		return query.getResultList();
	}

}
