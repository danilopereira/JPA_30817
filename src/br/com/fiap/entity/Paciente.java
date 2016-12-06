package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;


public class Paciente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cpf;
	private String nome;
	private String endereco;
	private Date dataUltimaConsulta;
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
