package operadora;

import java.time.LocalDate;
import java.util.Scanner;

public class Operadora {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean condicao = true; 
		
		while (condicao) {
			System.out.print("Opção: ");
			String opcao = scanner.next();
			
			switch(opcao) {
				case "1":
					consumoDeInternet();
					break;
				case "2":
					System.out.println("2");
					break;
				case "3":
					System.out.println("3");
					break;
				default:
					System.out.println("Opção inválida");
			}
		}
		
		scanner.close();
	}

	private static void consumoDeInternet() {
		double consumoMedio = 0.3;
		LocalDate localDate = LocalDate.now();
		int dia = localDate.getDayOfMonth();
		
		System.out.println((consumoMedio * dia) + "GB");
	}

}
