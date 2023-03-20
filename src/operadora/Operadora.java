package operadora;

import java.util.Scanner;

public class Operadora {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean condicao = true; 
		
		while (condicao) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println(" 1: Consultas");
			System.out.println(" 2: Compra/Troca");
			System.out.println(" 3: Cancelamento");
			System.out.println("-1: Sair");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			System.out.print("Opção: ");
			String opcao = scanner.next();
			
			switch(opcao) {
				case "1":
					System.out.println("=-=-=-=-= CONSULTAS =-=-=-=-=");
			        System.out.println("1 - voltar");
			        System.out.println("2 - consumo de internet");
			        System.out.println("3 - saldo");
			        System.out.println("4 - planos ativos");
			        System.out.println("5 - outros planos");
			        System.out.println("6 - sair");
			        opcao = scanner.next();
			        switch (opcao) {
			            case "1":
			                break;
			            case "2":
			            	System.out.println("consumo...");
			            	break;
			            case "3":
			            	System.out.println("saldo...");
			            	break;
			            case "4":
			            	System.out.println("ativos...");
			            	break;
			            case "5":
			            	System.out.println("outros...");
			            	break;
			            case "6":
			                condicao = false;
			                System.out.println("Saindo...");
			                break;
			            default:
			                System.out.println("Opção inválida");
			        }
			        break;
				case "2":
					System.out.println("=-=-=-=- COMPRA/TROCA =-=-=-=");
			        System.out.println("1 - voltar");
			        System.out.println("2 - comprar");
			        System.out.println("3 - trocar");
			        System.out.println("4 - sair");
			        opcao = scanner.next();
			        switch (opcao) {
			            case "1":
			                break;
			            case "2":
			            	System.out.println("lógica da compra a ser implementada");
			            	break;
			            case "3":
			            	System.out.println("lógica da troca a ser implementada");
			            	break;
			            case "4":
			                condicao = false;
			                System.out.println("Saindo...");
			                break;
			            default:
			                System.out.println("Opção inválida");
			        }
			        break;
				case "3":
					System.out.println("=-=-=-=- CANCELAMENTO =-=-=-=");
			        System.out.println("1 - voltar");
			        System.out.println("2 - cancelar");
			        System.out.println("3 - sair");
			        opcao = scanner.next();
			        switch (opcao) {
			            case "1":
			                break;
			            case "2":
			            	System.out.print("Deseja realmente cancelar? [S/N] ");
			            	String cancela = scanner.next();
			            	if (cancela.equalsIgnoreCase("S")) {
								System.out.println("lógica de cancelamento a ser criada...");
							} else {
								System.out.println("Cancelamento não foi efetuado");
							}
			            	break;
			            case "3":
			                condicao = false;
			                System.out.println("Saindo...");
			                break;
			            default:
			                System.out.println("Opção inválida");
			        }
			        break;
				case "-1":
					condicao = false;
			        System.out.println("Saindo...");
			        break;
				default:
					System.out.println("Opção inválida");
			}
		}
		scanner.close();
	}
}
