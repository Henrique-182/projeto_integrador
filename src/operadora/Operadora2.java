package operadora;

import java.util.Scanner;

public class Operadora2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean condicao = true; 
		
		while (condicao) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println(" 1: Consumo de internet");
			System.out.println(" 2: Planos ativos");
			System.out.println(" 3: Outros planos");
			System.out.println("-1: Sair");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			System.out.print("Opção: ");
			String opcao = scanner.next();
			
			switch(opcao) {
				case "1":
					System.out.println("consumo...");
			        // ---------------------------------------------------------------
			        System.out.println("1 - voltar");
			        System.out.println("2 - sair");
			        opcao = scanner.next();
			        switch (opcao) {
			            case "1":
			              break;
			            case "2":
			              condicao = false;
			              System.out.println("Saindo...");
			              break;
			            default:
			              System.out.println("Opção inválida");
			        }
			        // -----------------------------------------------------------------
			        break;
				case "2":
					System.out.println("ativos...");
			        // -----------------------------------------------------------------
			        System.out.println("1 - voltar");
			        System.out.println("2 - sair");
			        opcao = scanner.next();
			        switch (opcao) {
			            case "1":
			                break;
			            case "2":
			                condicao = false;
			                System.out.println("Saindo...");
			                break;
			            default:
			                System.out.println("Opção inválida");
			        }
			        // -----------------------------------------------------------------
			        break;
				case "3":
					System.out.println("outros...");
			          // -----------------------------------------------------------------
			        System.out.println("1 - voltar");
			        System.out.println("2 - sair");
			        opcao = scanner.next();
			        switch (opcao) {
			            case "1":
			                break;
			            case "2":
			                condicao = false;
			                System.out.println("Saindo...");
			                break;
			            default:
			                System.out.println("Opção inválida");
			        }
			        // -----------------------------------------------------------------
			        break;
				case "-1":
					condicao = false;
			        System.out.println("Saindo...");
			        // -----------------------------------------------------------------
			        System.out.println("1 - voltar");
			        System.out.println("2 - sair");
			        opcao = scanner.next();
			        switch (opcao) {
			            case "1":
			            	break;
			            case "2":
			                condicao = false;
			                System.out.println("Saindo...");
			                break;
			            default:
			                System.out.println("Opção inválida");
			        }
			        // -----------------------------------------------------------------
			        break;
				default:
					System.out.println("Opção inválida");
			}
		}
		scanner.close();
	}
}
