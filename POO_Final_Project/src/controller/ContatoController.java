package controller;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.ContatosPFDAO;

import entidade.ContatosPF;

public class ContatoController {
	public static String cadastrarContato(Scanner sc){
		
		System.out.println("------------------- Forumlário para novo contato -------------------\n");
		System.out.println("Nome completo:\n");
		sc.nextLine();
		String nomeCompleto = sc.nextLine();
		
		System.out.println("Telefone:                Telefone Secundário:\n");
	 	String telefone = sc.nextLine();
	 	String telefoneSec = sc.nextLine();
		
	 	System.out.println("Email: 	                 Email Secundário:\n");
	 	String email = sc.nextLine();
	 	String emailSec = sc.nextLine();
		
		System.out.println("\\\\\\\\\\ Dados de Endereço //////////");
							
		System.out.println("rua:\n");
		String rua = sc.nextLine();
		
		System.out.println("numero:\n");
		String numero = sc.nextLine();
		
		System.out.println("Complemento:\n");
		String complemento = sc.nextLine();
		
		System.out.println("Bairro:       Cidade:           Estado: \n");
	 	String bairro = sc.nextLine();	
	 	String cidade = sc.nextLine();
	 	String estado = sc.nextLine();
	 	
	 	System.out.println("CEP:\n");
	 	String cep = sc.nextLine();
	 	
	 	System.out.println("\\\\\\\\\\\\\\\\\\\\///////////////////");
	
		System.out.println("Data de Nascimento:");
		String dataNascimento = sc.nextLine();
		
		System.out.println("Por fim digite uma observação sobre seu novo contato:");
		String obs = sc.nextLine();
		
		System.out.println("-------------------------------------------------------------------\n");
		
		ContatosPF c = new ContatosPF();
		c.setNome_completo(nomeCompleto);
		c.setTelefone(telefone);
		c.setTelefone_secundario(telefoneSec);
		c.setEmail(email);
		c.setEmail_secundario(emailSec);
		c.setRua(rua);
		c.setNumero(numero);
		c.setComplemento(complemento);
		c.setBairro(bairro);
		c.setCidade(cidade);
		c.setEstado(estado);
		c.setCep(cep);
		c.setData_Nascimento(dataNascimento);
		c.setObservacao(obs);
		
		String successResponse = "Contato criado com sucesso!\n";
		String failureResponse = "Falha ao criar contato.\n";
		String error = "ERRO - Erro na função de criar contato PF\n";
		
		ContatosPFDAO contatoPFDAO = new ContatosPFDAO();
		try {
			boolean criado = contatoPFDAO.insert(c);
			 if(criado) {
				 return successResponse;
			 }else {
				 return failureResponse;
			 }
			
		}catch (SQLException e) {
			System.err.println("Erro ao cadastrar usuário no banco de dados.");
			e.printStackTrace();
		}
	
		 return error;
		
	}
}
