package exec;

import java.util.Scanner;

public class Sistema {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 Calculadora calc = new Calculadora();
		 
		 int opcao = 0;
		 while(opcao != 7){
			 System.out.println("1 - Somar");
	         System.out.println("2 - Subtrair");
	         System.out.println("3 - Multiplicar");
	         System.out.println("4 - Dividir");
	         System.out.println("5 - Verificar Número Primo");
	         System.out.println("6 - Potencia");
	         System.out.println("7 - Sair");
	         opcao = sc.nextInt();
	         
	         switch(opcao) {
	         	
	         	case 1:
	         		System.out.println("Insira um numero, podendo ser do tipo Double: \n");
	         		calc.numA = sc.nextDouble();
	         		System.out.println("Insira outro: \n");
	         		calc.numB = sc.nextDouble();
	         		System.out.println("Soma dos números inseridos: "+ calc.soma()+"\n\n");
	         		
	         		break;
	         		
	         	case 2:
	         		System.out.println("Insira um numero, podendo ser do tipo Double: \n");
	         		calc.numA = sc.nextDouble();
	         		System.out.println("Insira outro: \n");
	         		calc.numB = sc.nextDouble();
	         		System.out.println("Subtração dos númeors inseridos: "+ calc.sub()+"\n\n");
	         		
	         		break;
	         	
	         	case 3:
	         		System.out.println("Insira um numero, podendo ser do tipo Double: \n");
	         		calc.numA = sc.nextDouble();
	         		System.out.println("Insira outro: \n");
	         		calc.numB = sc.nextDouble();
	         		System.out.println("Multiplicação dos númeors inseridos: "+ calc.mult()+ "\n\n");
	         		
	         		break;
	         	
	         	case 4:
	         		System.out.println("Insira um numero, podendo ser do tipo Double: \n");
	         		calc.numA = sc.nextDouble();
	         		System.out.println("Insira outro: \n");
	         		calc.numB = sc.nextDouble();
	         		System.out.println("Divisão dos números inseridos: "+ calc.div()+"\n\n");
	         		
	         		break;
	         	
	         	case 5:
	         		System.out.println("Insira um número Int para verificar se ele é primo: \n");
	         		int n = sc.nextInt();
	         		System.out.println("Verificação se o número inserido é primo: \n"+ calc.verificarPrimo(n)+"\n\n");
	         		
	         		break;
	         		
	         	case 6:
	         		System.out.println("Insira a Base: \n");
	         		calc.numA = sc.nextDouble();
	         		System.out.println("Insira o expoente, pode ser negativo: \n");
	         		calc.numB = sc.nextInt();
	         		System.out.println("resultado da potenciação: \n"+ calc.potencia()+"\n\n");
	         		
	         		break;
	         		
	         	case 7:
	         		System.out.println("saindo...");
	         		break;
	         		
	         	default:
	         		System.out.println("Opção Inválida");
	                break;
	         }
	            
		 }
		 		 
		 sc.close();
	}
	 
	 
}
