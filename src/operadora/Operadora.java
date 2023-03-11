package operadora;

import java.time.LocalDate;
import java.util.Scanner;

public class Operadora {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean condicao = true; 
		
		while (condicao) {
			opcoes();
			System.out.print("Opção: ");
			String opcao = scanner.next();
			
			switch(opcao) {
				case "1":
					consumoDeInternet();
					break;
				case "2":
					planosAtivos();
					break;
				case "3":
					outrosPlanos();
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

	private static void opcoes() {		
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("1- Consumo de internet");
		System.out.println("2- Planos ativos");
		System.out.println("3- Outros planos");
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		
	}

	private static void consumoDeInternet() {
		double consumoMedio = 0.3;
		int dia = LocalDate.now().getDayOfMonth();
		System.out.println((consumoMedio * dia) + " GB");
		
	}

	private static void planosAtivos() {
		System.out.println("ativos...");
	}
	
	private static void outrosPlanos() {
		System.out.println("outros...");
		
	}
}
