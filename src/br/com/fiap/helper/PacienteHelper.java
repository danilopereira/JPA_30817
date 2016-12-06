package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Paciente;

public class PacienteHelper {
	
	EntityManager em;
	
	public PacienteHelper(EntityManager em){
		this.em = em;
	}
	
	public void salvar(Paciente paciente) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(paciente);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> buscaPacientesPorMedico(String crmMedico){
		Query query = em.createQuery("select p from Paciente p where crmMedico = :crmMedico");
		query.setParameter("crmMedico", crmMedico);
		
		return query.getResultList();
	}
	
	public Paciente buscaPorCpf(String cpf){
		Query query = em.createQuery("selcet p from Paciente p where cpf = :cpf");
		query.setParameter("cpf", cpf);
		
		return (Paciente) query.getSingleResult();
	}

}
