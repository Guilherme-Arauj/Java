package app;


import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


import Utils.Utils;
import controller.AccesController;
import controller.ContatoController;


public class App {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			boolean running = true;

			
			
			
			

			while(running) {
				System.out.println("-------------------- MENU --------------------\n");
				System.out.println("1. Cadastre-se \n");
				System.out.println("2. Login \n");
				System.out.println("3. Sair \n");
				System.out.println("----------------------------------------------\n");

				int response = sc.nextInt();
				
				switch (response) {
				case 1:
					String CadastroResponse = AccesController.cadastrarCliente(sc, running);
					System.out.println(CadastroResponse + "\n\n");
					
					 System.out.println("\n1. Voltar ao menu principal");
	                 System.out.println("2. Sair");

	                 int postCadastroResponse = sc.nextInt();
	                 if (postCadastroResponse == 2) {
	                     running = false;
	                 }
	                 break;
				
				case 2:
			
					
					try {
						int nivelAcessoLogin = AccesController.LoginController(sc);
						boolean userRunning = true;
				
						while(userRunning) {
							switch(nivelAcessoLogin) {
							case -1:
								System.err.println("Erro - Usuário não encontrado");
								userRunning=false;
								break;
								
							case 0:
								System.out.println("-------------------- MENU ADMIN --------------------\n");
								System.out.println("1. Listar Usuários \n");
								System.out.println("2. Cadastrar Admins \n");
								System.out.println("3. Atualizar Informaçôes de usuários \n");
								System.out.println("4. Excluir usuário \n");
								break;
							case 1:
								System.out.println("-------------------- MENU CLIENTE --------------------\n");
								System.out.println("1. Adicionar Contato \n");
								System.out.println("2. Listar Todos Contatos \n");
								System.out.println("3. Buscar Contato pelo Nome \n");
								System.out.println("4. Buscar Contato pelo Número de Telefone \n");
								System.out.println("5. Editar Contato \n");
								System.out.println("6. Log Out \n");
								
								int userResponse = sc.nextInt();
								
							
										switch(userResponse) {
										case 1:
											String cadastroMessage = ContatoController.cadastrarContato(sc);
											
											System.out.println(cadastroMessage);
											
											int ActionOneResult = Utils.menuBackHandler(sc);
												
											
											if(ActionOneResult == 1) {
												break;
											}else if(ActionOneResult == 2) {
												System.out.println("Log Out realizado com sucesso.");
												userRunning=false;
												break;
											}else {
												System.out.println("Opção inválida");
											}
											
											break;
											
										case 2:
											System.out.println("\n Função para Listar Contato \n");
											
											int ActionTwoResult = Utils.menuBackHandler(sc);
											
											if(ActionTwoResult == 1) {
												break;
											}else if(ActionTwoResult == 2) {
												System.out.println("Log Out realizado com sucesso.");
												userRunning=false;
												break;
											}else {
												System.out.println("Opção inválida");
											}
											
											break;
											
										case 3:
											System.out.println("função para Buscar Contato pelo Nome");
											break;

										case 4:
											System.out.println("função para Buscar Contato pelo Número de Telefone");
											break;
											
										case 5:
											System.out.println("função para Editar Contato");
											break;
										case 6:
											System.out.println("Log Out realizado com sucesso.");
											userRunning=false;
											break;
										}
							}
						}
						break;
					}catch(SQLException e) {
						System.err.println("Erro ao realizar o login: ");
						e.printStackTrace();
					}
				case 3:
					System.out.println("Até a próxima");
					running = false;
					break;
					
				default:
					System.err.println("Opção inválida!");
					
					break;
				}
				
			}

		} catch(InputMismatchException e) {
			System.err.println("Opção inválida!");
			
			
		}
	}
}
