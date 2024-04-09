package exec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Produto;
import utils.Util;

public class Sistema {
	 private static Scanner sc = new Scanner(System.in);
	 private static ArrayList<Produto> produtos;
	 private static Map<Produto, Integer> carrinho;
	 
	 public static void main(String[] args) {
		produtos = new ArrayList<>();
		carrinho = new HashMap<>();
		menu();
	}
	 
	 private static void menu() {
		 
		 int opcao = 0;
		 while(opcao != 5) {
			 System.out.println("----------------------------------------------------");
			 System.out.println("---------- Welcome to Guiggs Market ----------");
			 System.out.println("----------------------------------------------------");
			 System.out.println("***** Selecione a operação que deseja realizar *****");
			 System.out.println("----------------------------------------------------");
			 System.out.println("|   Opção 1 - Cadastrar Produto   |");
			 System.out.println("|   Opção 2 - Listar Produto      |");
			 System.out.println("|   Opção 3 - Comprar Produto     |");
			 System.out.println("|   Opção 4 - Ver Carrinho     |");
			 System.out.println("|   Opção 5 - Sair                |");
			 opcao = sc.nextInt();
			 
			 switch(opcao) {
			 	
			 	case 1:
			 		cadastrarProdutos();
			 		break;
			 	case 2:
			 		listarProdutos();
			 		break;
			 	case 3:
			 		comprarProdutos();
			 		break;
			 	case 4:
			 		verCarrinho();
			 		break;
			 	case 5:
			 		System.out.println("Obrigabo, volte sempre!");
			 		System.exit(0);
			 	default:
			 		System.err.println("Opção inválida!");
			 		menu();
			 		break;
			 }
		 } 
	 }
	 
	 private static void cadastrarProdutos() {
		 
		 System.out.println("Nome do produto: ");
		 String nome = sc.next();
		 
		 System.out.println("Preço do produto: ");
		 double preco = sc.nextDouble();
		 
		 Produto produto = new Produto(nome, preco);
		 produtos.add(produto);
		 
		 System.out.println(produto.getNome()+ "Cadastrado com Sucesso! \n");
		 
		 menu();
	 
	 }
	 
	 private static void listarProdutos() {
		 if(produtos.size() > 0) {
			 System.out.println("Lista de produtos: \n");
			 
			 for (Produto p : produtos) {
				 System.out.println(p);
			 }
		 } else {
			 System.out.println("Nenhum Produto Cadastrado! \n");
		 }
		 
		 menu();
	 }
	 
	 private static void comprarProdutos() {
		 if(produtos.size() > 0) {
			 System.out.println("Código do produto: \n");
			 System.out.println("---------- Produtos Disponíveis ----------");
			 
			 for (Produto p : produtos) {
				 System.out.println(p + "\n");
			 }
			 
			 int id = sc.nextInt();
			 sc.nextLine();
			 Boolean estaPresente = false;
			 
			 for(Produto p : produtos) {
				 if(p.getId() == id) {
					 int quantidade = 0;
					 try {
						 quantidade = carrinho.get(p);
						 
						 // Se ja houver produto no carrinho, incrementa mais um;
						 carrinho.put(p, quantidade + 1);
					 }catch(NullPointerException e){
						 //Adiciona pela primeira vez o produto no carrinho;
						 carrinho.put(p, 1);
					 }
					 
					 System.out.println(p.getNome()+ "Adicionado ao carrinho.");
					 estaPresente = true;
					 
					 if(estaPresente) {
						 System.out.println("Quer Adicionar outro produto? \n");
						 System.out.println(" 1- sim | 0- Finalizar compra \n");
						 int opcao = sc.nextInt();
						 sc.nextLine();
						 
						 if(opcao == 1) {
							 comprarProdutos();
						 }else {
							 finalizarCompra();
							 
						 }
					 }
					 
				 }else {
					 System.out.println("Produto não encontrado!");
					 menu();
				 }
			 }
		 }else {
			 System.out.println("Não existem produtos cadastrados!");
			 menu();
		 }
	 }
	 
	 private static void verCarrinho() {
		 System.out.println("---------- Produtos no carrinho ----------");
		 if (carrinho.size() > 0) {
			 for(Produto p : carrinho.keySet()) {
				 System.out.println("Produto" + p + "\n Quantidade: "+ carrinho.get(p));
			 }
		 }else {
			 System.out.println("Carrinho vazio!");
			 menu();
		 }
	 }
	 
	 private static void finalizarCompra() {
		 Double valorCompra = 0.0;
		 System.out.println("Seus produtos: ");
		 
		 for(Produto p : carrinho.keySet()) {
			 int quantidade = carrinho.get(p);
			 valorCompra += p.getPreco() * quantidade;
			 System.out.println(p);
			 System.out.println("Quantidade: "+ quantidade);
			 System.out.println("----------------------------");
			 
		 }
		 System.out.println("O valor da sua compra é: "+ Util.doubleToString(valorCompra));
		 carrinho.clear();
		 System.out.println("Obrigado pela prefêrencia!");
		 menu();
	 }
	 
	 
	 
}
