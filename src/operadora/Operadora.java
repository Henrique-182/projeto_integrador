package operadora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Operadora {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in); 
        
		String caminhoArquivoPlanoAtivo = "C:\\projeto_integrador\\src\\operadora\\planoAtivo.txt"; 
		File arquivoPlanoAtivo = new File(caminhoArquivoPlanoAtivo);
		
		String caminhoArquivoSaldo = "C:\\projeto_integrador\\src\\operadora\\saldo.txt";
		File arquivoSaldo = new File(caminhoArquivoSaldo);

		if (!arquivoPlanoAtivo.exists()) {
			arquivoPlanoAtivo.createNewFile();
			escreveEmArquivo(caminhoArquivoPlanoAtivo, "NENHUM PLANO ENCONTRADO   ");
		}

		if (!arquivoSaldo.exists()) {
			arquivoSaldo.createNewFile();
			escreveEmArquivo(caminhoArquivoSaldo, "0.0");
		}

		List<String> planos = Arrays.asList("01GB de internet - R$05.00", 
											"02GB de internet - R$10.00", 
											"03GB de internet - R$15.00", 
											"05GB de internet - R$20.00", 
											"10GB de internet - R$30.00"
											);
		
		boolean condicao = true; 
		
		System.out.println("+---------------------------------+");
		System.out.println("|        CHATBOT OPERADORA        |");
		System.out.println("|         SEJA BEM-VINDO          |");		
		while (condicao) {
			Scanner leituraArquivoPlanoAtivo = new Scanner(new FileInputStream(caminhoArquivoPlanoAtivo)); 
			String planoAtivo = leituraArquivoPlanoAtivo.nextLine(); 

			Scanner leituraArquivoSaldo = new Scanner(new FileInputStream(caminhoArquivoSaldo));
			double saldo = Double.parseDouble(leituraArquivoSaldo.next());

			System.out.println("+---------------------------------+");
			System.out.println("| 0: Sair                         |");
			System.out.println("| 1: Consultas                    |");
			System.out.println("| 2: Compra/Troca                 |");
			System.out.println("| 3: Cancelamento                 |");
			System.out.println("+---------------------------------+");
			
			System.out.print("Menu principal: ");
			String opcao = scanner.next();
			
			switch(opcao) {
				case "0":
					condicao = false;
			        System.out.println("+---------------------------------+");
			        System.out.println("|             SAINDO              |");
					System.out.println("+---------------------------------+");
			        break;
				case "1":
					System.out.println("+----------- CONSULTAS -----------+");
					System.out.println("| 0 - sair                        |");
			        System.out.println("| 1 - voltar                      |");
			        System.out.println("| 2 - consumo de internet         |");
			        System.out.println("| 3 - saldo                       |");
			        System.out.println("| 4 - plano ativo                 |");
			        System.out.println("| 5 - outros planos               |");
					System.out.println("+---------------------------------+");

					System.out.print("Menu secundário: ");
			        opcao = scanner.next();
			        switch (opcao) {
						case "0":
			                condicao = false;
							System.out.println("+---------------------------------+");
			                System.out.println("|             SAINDO              |");
							System.out.println("+---------------------------------+");
			                break;
			            case "1":
			                break;
			            case "2":
							int dia = LocalDateTime.now().getDayOfMonth();
							double consumo = 0.2 * dia;
							System.out.println("+---------------------------------+");
			            	System.out.println("| Consumo: " + consumo + " GB");
							System.out.println("+---------------------------------+");
			            	break;
			            case "3":
							System.out.println("+---------------------------------+");
			            	System.out.println("| Saldo: R$" + saldo);
							System.out.println("+---------------------------------+");
			            	break;
			            case "4":
							System.out.println("+---------------------------------+");
			            	System.out.println("| " + planoAtivo + "      |");
							System.out.println("+---------------------------------+");
			            	break;
			            case "5":
							System.out.println("+---------------------------------+");
			            	for (String plano : planos) {
								if (!plano.equals(planoAtivo)) {
									System.out.println("| " + plano + "      |");
								} 
							}
							System.out.println("+---------------------------------+");
			            	break;			            
			            default:
							System.out.println("+---------------------------------+");
			                System.out.println("|          Opção inválida         |");
							System.out.println("+---------------------------------+");
			        }
			        break;
				case "2":
					System.out.println("+---------- COMPRA/TROCA ---------+");
			        System.out.println("| 0 - sair                        |");
			        System.out.println("| 1 - voltar                      |");
			        System.out.println("| 2 - comprar plano               |");
			        System.out.println("| 3 - trocar plano                |");
					System.out.println("| 4 - recarga                     |");
					System.out.println("+---------------------------------+");

					System.out.print("Menu secundário: ");
			        opcao = scanner.next();
			        switch (opcao) {
						case "0":
			                condicao = false;
							System.out.println("+---------------------------------+");
			                System.out.println("|             SAINDO              |");
							System.out.println("+---------------------------------+");
			                break;
			            case "1":
			                break;
			            case "2":
							if (!planoAtivo.equalsIgnoreCase("NENHUM PLANO ENCONTRADO   ")) {
								System.out.println("+---------------------------------+");
								System.out.println("|      Não é possível comprar     |");
								System.out.println("|        Há um plano ativo        |");
								System.out.println("+---------------------------------+");
								break;
							}
							System.out.println("+------------- COMPRA ------------+");
							for (int i = 0; i < planos.size(); i++) {								
								if (!planos.get(i).equalsIgnoreCase(planoAtivo)) {
									System.out.println("| " + i + "º - " + planos.get(i) + " |");
								} 								
							} 
							System.out.println("+---------------------------------+");
							System.out.print("Escolha seu plano: ");
							String planoCompra = scanner.next();
							System.out.println("+---------------------------------+");
							if (planoCompra.equals("0") || planoCompra.equals("1") || planoCompra.equals("2") || planoCompra.equals("3") || planoCompra.equals("4")) {
								int planoCompraInt = Integer.parseInt(planoCompra);
								if(!planos.get(planoCompraInt).equalsIgnoreCase(planoAtivo)) {
									escreveEmArquivo(caminhoArquivoPlanoAtivo, planos.get(planoCompraInt));																		
									System.out.println("|          Plano comprado         |");
								} else {
									System.out.println("| Plano digitado já foi adquirido |");
								}
							} 	else {
									System.out.println("|      Esse plano não existe      |");
									System.out.println("|         Tente novamente         |");
							}
							System.out.println("+---------------------------------+");
			            	break;
			            case "3":
							if (planoAtivo.equalsIgnoreCase("NENHUM PLANO ENCONTRADO   ")) {
								System.out.println("+---------------------------------+");
								System.out.println("|      Não é possível trocar      |");
								System.out.println("|      Não há um plano ativo      |");
								System.out.println("+---------------------------------+");
								break;
							}							
							System.out.println("+------------- TROCA -------------+");
							for (int i = 0; i < planos.size(); i++) {
								if (!planos.get(i).equalsIgnoreCase(planoAtivo)) {
									System.out.println("| " + i + "º - " + planos.get(i) + " |");
								} 
							}
							System.out.println("+---------------------------------+");
							System.out.print("Escolha seu plano: ");
							String planoTroca = scanner.next();
							
							System.out.println("+---------------------------------+");
							if (planoTroca.equals("0") || planoTroca.equals("1") || planoTroca.equals("2") || planoTroca.equals("3") || planoTroca.equals("4")) {
								int planoTrocaInt = Integer.parseInt(planoTroca);
								if(!planos.get(planoTrocaInt).equalsIgnoreCase(planoAtivo)) {
									escreveEmArquivo(caminhoArquivoPlanoAtivo, planos.get(planoTrocaInt));
									
									System.out.println("|          Plano alterado         |");
								} else {
									System.out.println("| Plano digitado já foi adquirido |");
								}
							} else {
								System.out.println("|      Esse plano não existe      |");
								System.out.println("|         Tente novamente         |");
							} 
							System.out.println("+---------------------------------+");
			            	break;			            
						case "4":
							System.out.print("Valor recarga: R$");
							String recarga = scanner.next();	
							recarga = recarga.replace(",", ".");						
							System.out.println("+---------------------------------+");							
							try {
								double recargaDouble = Double.parseDouble(recarga);
								saldo += recargaDouble;
								String saldoString = "" + saldo;
								escreveEmArquivo(caminhoArquivoSaldo, saldoString);
								System.out.println("|         Recarga Efetuada        |");
							} catch (Exception e) {
								System.out.println("|         Valor inválido          |");
							}
							System.out.println("+---------------------------------+");
							break;	
						default:
							System.out.println("+---------------------------------+");
							System.out.println("|          Opção inválida         |");
							System.out.println("+---------------------------------+");
			        }
			        break;
				case "3":
					System.out.println("+---------- CANCELAMENTO ---------+");
					System.out.println("| 0 - sair                        |");
			        System.out.println("| 1 - voltar                      |");
			        System.out.println("| 2 - cancelar                    |");
					System.out.println("+---------------------------------+");

					System.out.print("Menu secundário: ");
			        opcao = scanner.next();
			        switch (opcao) {
						case "0":
			                condicao = false;
							System.out.println("+---------------------------------+");
			                System.out.println("|             SAINDO              |");
							System.out.println("+---------------------------------+");
			                break;
			            case "1":
			                break;
			            case "2":
							if (planoAtivo.equalsIgnoreCase("NENHUM PLANO ENCONTRADO   ")) {
								System.out.println("+---------------------------------+");
								System.out.println("|     Não é possível cancelar     |");
								System.out.println("|        Não há plano ativo       |");
								System.out.println("+---------------------------------+");
								break;
							}
			            	System.out.print("Deseja realmente cancelar? [S/N] ");
			            	String cancela = scanner.next();
							System.out.println("+---------------------------------+");
			            	if (cancela.equalsIgnoreCase("S")) {	
								escreveEmArquivo(caminhoArquivoPlanoAtivo, "NENHUM PLANO ENCONTRADO   ");
								
								System.out.println("|      Cancelamento efetuado      |");
							} else {
								System.out.println("|  Cancelamento não foi efetuado  |");
							}
							System.out.println("+---------------------------------+");
			            	break;			            
			            default:
							System.out.println("+---------------------------------+");
							System.out.println("|          Opção inválida         |");
							System.out.println("+---------------------------------+");
			        }
			        break;				
				default:
					System.out.println("+---------------------------------+");
					System.out.println("|          Opção inválida         |");
					System.out.println("+---------------------------------+");
			}
			leituraArquivoPlanoAtivo.close();
			leituraArquivoSaldo.close();
		}
		scanner.close();
	}
	
	public static void escreveEmArquivo(String caminhoArquivo, String texto) throws Exception {
		FileWriter fileWriter = new FileWriter(caminhoArquivo, false);
		fileWriter.write(texto);
		fileWriter.close();
	}
}