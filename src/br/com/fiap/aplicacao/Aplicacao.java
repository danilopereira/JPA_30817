package br.com.fiap.aplicacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Hospital;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.helper.HospitalHelper;
import br.com.fiap.helper.MedicoHelper;
import br.com.fiap.helper.PacienteHelper;

public class Aplicacao {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_30817");
		EntityManager em = emf.createEntityManager();
		
		HospitalHelper hDao = new HospitalHelper(em);
		MedicoHelper mDao = new MedicoHelper(em);
		PacienteHelper pDao = new PacienteHelper(em);
		loop:while(true){
			try {
				Object[] messages = {
						"Hospital",
						"Medico",
						"Paciente"
				};
				
				int opcao = JOptionPane.showOptionDialog(null, "O que deseja cadastrar?", "Cadastro Inicial", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, messages, messages[0]);
				
				switch(opcao){
				case 0:
					String nomeHospital =  JOptionPane.showInputDialog("Informe o nome do Hospital");
					String especialidadeHospital = JOptionPane.showInputDialog("Informe a especialidade do Hospital");
					
					Hospital hospital = new Hospital();
					hospital.setNome(nomeHospital);
					hospital.setEspecialidade(especialidadeHospital);
					
					hDao.salvar(hospital);
					
					int option = JOptionPane.showConfirmDialog(null, "Hospital adicionado com sucesso! Deseja continuar cadastrando?");
					
					if(option != JOptionPane.YES_OPTION){
						break loop;
					}
				case 1:
					List<Hospital> hospitais = hDao.buscarTodos();
					if(hospitais.isEmpty() || hospitais == null){
						JOptionPane.showMessageDialog(null, "Para cadastrar médicos, é necessário que hajam hospitais cadastrados. "
								+ "Favor cadastrar primeiro um hospital!");
						break;
					}
					else{
						String crm = JOptionPane.showInputDialog("Informe o CRM do médico");
						String nomeMedico = JOptionPane.showInputDialog("Informe o nome do médico");
						String especialidadeMedico = JOptionPane.showInputDialog("Informe a especialidade do médico");;
						Hospital hospitalMedico = (Hospital) JOptionPane.showInputDialog(null, "Selecione o hospital", "Hospitais",JOptionPane.PLAIN_MESSAGE, null, hDao.buscarTodos().toArray(), "");
						
						Medico medico = new Medico();
						medico.setCrm(crm);
						medico.setEspecialidade(especialidadeMedico);
						medico.setNome(nomeMedico);
						medico.setHospital(hospitalMedico);
						
						mDao.salvar(medico);
						
						int optionM = JOptionPane.showConfirmDialog(null, "Médico adicionado com sucesso! Deseja continuar cadastrando?");
						
						if(optionM != JOptionPane.YES_OPTION){
							break loop;
						}
					}
				case 2:
					List<Medico> medicos = mDao.listarTodos();
					if(medicos.isEmpty() || medicos == null){
						JOptionPane.showMessageDialog(null, "Para cadastrar pacientes, é necessário que hajam médicos cadastrados. "
								+ "Favor cadastrar primeiro um médico!");
						break;
					}
					else{
						String cpf = JOptionPane.showInputDialog("Infome o cpf do paciente");
						String nomePaciente = JOptionPane.showInputDialog("Informe o nome do paciente");
						String endereco = JOptionPane.showInputDialog("Informe o endereco do paciente");
						Medico pacienteMedico = (Medico) JOptionPane.showInputDialog(null, "Selecione o hospital", "Hospitais",JOptionPane.PLAIN_MESSAGE, null, mDao.listarTodos().toArray(), "");
						
						Paciente paciente = new Paciente();
						paciente.setCpf(cpf);
						paciente.setNome(nomePaciente);
						paciente.setEndereco(endereco);
						paciente.setMedico(pacienteMedico);
						
						pDao.salvar(paciente);
					}

					int optionP = JOptionPane.showConfirmDialog(null, "Paciente adicionado com sucesso! Deseja continuar cadastrando?");
					
					if(optionP != JOptionPane.YES_OPTION){
						break loop;
					}
				}				
				
			} catch (Exception e) {
				e.printStackTrace();
				break loop;
			}
		}

	}

}
