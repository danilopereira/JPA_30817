package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hospital", catalog="db_30817")
public class Paciente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CPF", unique=true, nullable=false)
	private String cpf;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="NOME")
	private String endereco;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_ULTIMA_CONSULTA")
	private Date dataUltimaConsulta;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="CRM_MEDICO")
	private Medico medico;
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataUltimaConsulta() {
		return dataUltimaConsulta;
	}
	public void setDataUltimaConsulta(Date dataUltimaConsulta) {
		this.dataUltimaConsulta = dataUltimaConsulta;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
