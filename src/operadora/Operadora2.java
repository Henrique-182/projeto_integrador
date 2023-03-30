package operadora;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Operadora2 {
	
	public static void main(String[] args) throws Exception {
		Scanner entradaUsuario = new Scanner(System.in);
		
		String arquivoAreaDeTrabalho = "C:\\Users\\henri\\OneDrive\\Área de Trabalho";	
		
		Scanner arquivoPlanoAtivo = new Scanner(new FileInputStream(arquivoAreaDeTrabalho + "\\projeto_integrador\\src\\operadora\\planoAtivo.txt"));
		String planoAtivo = arquivoPlanoAtivo.nextLine();
		
		Scanner arquivoSaldo = new Scanner(new FileInputStream(arquivoAreaDeTrabalho + "\\projeto_integrador\\src\\operadora\\saldo.txt"));
		double saldo = arquivoSaldo.nextDouble();
		
		double consumo = 0;
		List<String> planos = Arrays.asList(" 1GB de internet - R$5,00", 
											" 2GB de internet - R$10,00", 
											" 3GB de internet - R$15,00", 
											" 5GB de internet - R$20,00", 
											"10GB de internet - R$30,00"
											);
		
		boolean condicao = true; 
		
		while (condicao) {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			System.out.println(" 1: Consultas");
			System.out.println(" 2: Compra/Troca");
			System.out.println(" 3: Cancelamento");
			System.out.println("-1: Sair");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			
			System.out.print("Opção: ");
			String opcao = entradaUsuario.next();
			
			switch(opcao) {
				case "1":
					System.out.println("=-=-=-=-= CONSULTAS =-=-=-=-=");
			        System.out.println("1 - voltar");
			        System.out.println("2 - consumo de internet");
			        System.out.println("3 - saldo");
			        System.out.println("4 - plano ativo");
			        System.out.println("5 - outros planos");
			        System.out.println("6 - sair");
			        opcao = entradaUsuario.next();
			        switch (opcao) {
			            case "1":
			                break;
			            case "2":
			            	System.out.println("Consumo: " + consumo + "GB");
			            	break;
			            case "3":
			            	System.out.println("Saldo: R$" + saldo);
			            	break;
			            case "4":
			            	System.out.println(planoAtivo);
			            	break;
			            case "5":
			            	for (String plano : planos) {
								if (!plano.equals(planoAtivo)) {
									System.out.println(plano);
								}
							}
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
			        opcao = entradaUsuario.next();
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
			        opcao = entradaUsuario.next();
			        switch (opcao) {
			            case "1":
			                break;
			            case "2":
			            	System.out.print("Deseja realmente cancelar? [S/N] ");
			            	String cancela = entradaUsuario.next();
			            	if (cancela == "S" || cancela == "s") {
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
		entradaUsuario.close();
		arquivoPlanoAtivo.close();
		arquivoSaldo.close();
	}
}
