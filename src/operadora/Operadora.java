package operadora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Operadora {
	
	public static void main(String[] args) throws Exception {
		Scanner entradaUsuario = new Scanner(System.in); // Scanner que recebe as entradas do usuario

		String caminhoArquivoPlanoAtivo = "C:\\projeto_integrador\\src\\operadora\\planoAtivo.txt"; 
		File arquivoPlanoAtivo = new File(caminhoArquivoPlanoAtivo);
		
		String caminhoArquivoSaldo = "C:\\projeto_integrador\\src\\operadora\\saldo.txt";
		File arquivoSaldo = new File(caminhoArquivoSaldo);

		if (!arquivoPlanoAtivo.exists()) {
			arquivoPlanoAtivo.createNewFile();
		} // se o arquivo que contém o plano ativo do usuário não existir, será criado

		if (!arquivoSaldo.exists()) {
			arquivoSaldo.createNewFile();
		} // se o arquivo que contém o saldo do usuário não existir, será criado

		double consumo = 0;
		List<String> planos = Arrays.asList(" 1GB de internet - R$5.00", 
											" 2GB de internet - R$10.00", 
											" 3GB de internet - R$15.00", 
											" 5GB de internet - R$20.00", 
											"10GB de internet - R$30.00"
											); // lista com os todos os planos disponíveis
		
		boolean condicao = true; // enquanto condição é true, o laço continua
		
		while (condicao) {
			Scanner leituraArquivoPlanoAtivo = new Scanner(new FileInputStream(arquivoPlanoAtivo)); // abre o arquivo planoAtivo.txt
			String planoAtivo = leituraArquivoPlanoAtivo.nextLine(); 

			Scanner leituraArquivoSaldo = new Scanner(new FileInputStream(arquivoSaldo)); // abre o arquivo saldo.txt
			double saldo = leituraArquivoSaldo.nextDouble();

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
								} // se o plano ativo não for o mesmo do armazenado na volta do laço, será mostrado na tela
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
							System.out.println("compra");
			            	break;
			            case "3":
			            	System.out.println("troca");
							for (int i = 0; i < planos.size(); i++) {
								if (planos.get(i) != planoAtivo) {
									System.out.println(i + "º -" + planos.get(i));
								} 
							} // mostra os planos disponíveis que não estão ativos pelo usuário
							System.out.print("Escolha seu plano: ");
							int planoTroca = entradaUsuario.nextInt();
							if(planos.contains(planos.get(planoTroca))) {
								FileWriter substituiPlanoAtivo = new FileWriter(caminhoArquivoPlanoAtivo, false);
								substituiPlanoAtivo.write(planos.get(planoTroca));
								substituiPlanoAtivo.close();
							} else {
								System.out.println("Esse plano não existe.");
								System.out.println("Tente novamente");
							}
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

			leituraArquivoPlanoAtivo.close();
			leituraArquivoSaldo.close();
		}

		entradaUsuario.close();
	}
}
