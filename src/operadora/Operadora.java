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
        
		File arquivoPlanoAtivo = new File("C:\\projeto_integrador\\src\\operadora\\planoAtivo.txt");
		File arquivoSaldo = new File("C:\\projeto_integrador\\src\\operadora\\saldo.txt");

		if (!arquivoPlanoAtivo.exists()) {
			arquivoPlanoAtivo.createNewFile();
			escreveEmArquivo(arquivoPlanoAtivo, "NENHUM PLANO ENCONTRADO   ");
		}

		if (!arquivoSaldo.exists()) {
			arquivoSaldo.createNewFile();
			escreveEmArquivo(arquivoSaldo, "0.0");
		}

		List<String> planos = Arrays.asList("01GB de internet - R$05.00", "02GB de internet - R$10.00",  "03GB de internet - R$15.00", "05GB de internet - R$20.00", "10GB de internet - R$30.00");
		
		boolean condicao = true; 
		
		mostraMenu("BEM-VINDO");

		while (condicao) {
			Scanner leituraArquivoPlanoAtivo = new Scanner(new FileInputStream(arquivoPlanoAtivo)); 
			String planoAtivo = leituraArquivoPlanoAtivo.nextLine(); 

			Scanner leituraArquivoSaldo = new Scanner(new FileInputStream(arquivoSaldo));
			double saldo = Double.parseDouble(leituraArquivoSaldo.next());

			mostraMenu("PRINCIPAL");
			
			System.out.print("Menu principal: ");
			String opcao = scanner.next();
			
			switch(opcao) {
				case "0":
					condicao = sair();
			        break;
				case "1":
					mostraMenu("CONSULTAS");

					System.out.print("Menu secundário: ");
			        opcao = scanner.next();
			        switch (opcao) {
						case "0":
			                condicao = sair();
			                break;
			            case "1":
			                break;
			            case "2":
							int dia = LocalDateTime.now().getDayOfMonth();
							double consumo = 0.2 * dia;
							mostraConsultas(2, ("" + consumo));
							break;
			            case "3":
							mostraConsultas(3, ("" + saldo));
			            	break;
			            case "4":
			            	mostraConsultas(4, planoAtivo);
			            	break;
			            case "5":
			            	mostraConsultas(5, planoAtivo, planos);
			            	break;			            
			            default:
							mostraMensagem("OPÇÃO-INVÁLIDA");
			        }
			        break;
				case "2":
					mostraMenu("COMPRA/TROCA");

					System.out.print("Menu secundário: ");
			        opcao = scanner.next();
			        switch (opcao) {
						case "0":
			                condicao = sair();
			                break;
			            case "1":
			                break;
			            case "2":
							if (!planoAtivo.equalsIgnoreCase("NENHUM PLANO ENCONTRADO   ")) {
								mostraMensagem("COMPRA-INVÁLIDA");
								break;
							}
							System.out.println("+------------- COMPRA ------------+");
							mostraPlanosDisponiveis(planoAtivo, planos);
							System.out.print("Escolha seu plano: ");
							String planoCompra = scanner.next();
							if (planoCompra.equals("0") || planoCompra.equals("1") || planoCompra.equals("2") || planoCompra.equals("3") || planoCompra.equals("4")) {
								int planoCompraInt = Integer.parseInt(planoCompra);
								if(!planos.get(planoCompraInt).equalsIgnoreCase(planoAtivo)) {
									escreveEmArquivo(arquivoPlanoAtivo, planos.get(planoCompraInt));																		
									mostraMensagem("PLANO-COMPRADO");
								} 
							} 	else {
									mostraMensagem("PLANO-INVÁLIDO");
							}
			            	break;
			            case "3":
							if (planoAtivo.equalsIgnoreCase("NENHUM PLANO ENCONTRADO   ")) {
								mostraMensagem("TROCA-INVÁLIDA");
								break;
							}							
							System.out.println("+------------- TROCA -------------+");
							mostraPlanosDisponiveis(planoAtivo, planos);
							System.out.print("Escolha seu plano: ");
							String planoTroca = scanner.next();
							
							if (planoTroca.equals("0") || planoTroca.equals("1") || planoTroca.equals("2") || planoTroca.equals("3") || planoTroca.equals("4")) {
								int planoTrocaInt = Integer.parseInt(planoTroca);
								if(!planos.get(planoTrocaInt).equalsIgnoreCase(planoAtivo)) {
									escreveEmArquivo(arquivoPlanoAtivo, planos.get(planoTrocaInt));									
									mostraMensagem("PLANO-ALTERADO");
								} else {
									mostraMensagem("PLANO-JA-FOI-ADQUIRIDO");
								}
							} else {
								mostraMensagem("PLANO-INVÁLIDO");
							} 
			            	break;			            
						case "4":
							System.out.print("Valor recarga: R$");
							String recarga = scanner.next();	
							recarga = recarga.replace(",", ".");		
							try {
								double recargaDouble = Double.parseDouble(recarga);
								saldo += recargaDouble;
								String saldoString = "" + saldo;
								escreveEmArquivo(arquivoSaldo, saldoString);
								mostraMensagem("RECARGA-EFETUADA");
							} catch (Exception e) {
								mostraMensagem("VALOR-INVÁLIDO");
							}
							break;	
						default:
							mostraMensagem("OPÇÃO-INVÁLIDA");
			        }
			        break;
				case "3":
					mostraMenu("CANCELAMENTO");
					System.out.print("Menu secundário: ");
			        opcao = scanner.next();
			        switch (opcao) {
						case "0":
							condicao = sair();
			                break;
			            case "1":
			                break;
			            case "2":
							if (planoAtivo.equalsIgnoreCase("NENHUM PLANO ENCONTRADO   ")) {
								mostraMensagem("CANCELAMENTO-INVÁLIDO");
								break;
							}
			            	System.out.print("Deseja realmente cancelar? [S/N] ");
			            	String cancela = scanner.next();
			            	if (cancela.equalsIgnoreCase("S")) {	
								escreveEmArquivo(arquivoPlanoAtivo, "NENHUM PLANO ENCONTRADO   ");								
								mostraMensagem("CANCELAMENTO-EFETUADO");
							} else {
								mostraMensagem("CANCELAMENTO-NÃO-EFETUADO");
							}
			            	break;			            
			            default:
							mostraMensagem("OPÇÃO-INVÁLIDA");
			        }
			        break;				
				default:
					mostraMensagem("OPÇÃO-INVÁLIDA");
			}
			leituraArquivoPlanoAtivo.close();
			leituraArquivoSaldo.close();		
		}
		scanner.close();
	}
	
	public static void mostraMenu(String nomeMenu) {
		if (nomeMenu.equalsIgnoreCase("PRINCIPAL")) {
			mostraLinha();
			System.out.println("| 0: Sair                         |");
			System.out.println("| 1: Consultas                    |");
			System.out.println("| 2: Compra/Troca                 |");
			System.out.println("| 3: Cancelamento                 |");
			mostraLinha();
		} else if (nomeMenu.equalsIgnoreCase("CONSULTAS")) {
			System.out.println("+----------- CONSULTAS -----------+");
			System.out.println("| 0 - sair                        |");
	        System.out.println("| 1 - voltar                      |");
	        System.out.println("| 2 - consumo de internet         |");
	        System.out.println("| 3 - saldo                       |");
	        System.out.println("| 4 - plano ativo                 |");
	        System.out.println("| 5 - outros planos               |");
			mostraLinha();
		} else if (nomeMenu.equalsIgnoreCase("COMPRA/TROCA")) {
			System.out.println("+---------- COMPRA/TROCA ---------+");
			System.out.println("| 0 - sair                        |");
		    System.out.println("| 1 - voltar                      |");
	        System.out.println("| 2 - comprar plano               |");
	        System.out.println("| 3 - trocar plano                |");
			System.out.println("| 4 - recarga                     |");
			mostraLinha();
		} else if (nomeMenu.equalsIgnoreCase("CANCELAMENTO")) {
			System.out.println("+---------- CANCELAMENTO ---------+");
			System.out.println("| 0 - sair                        |");
	        System.out.println("| 1 - voltar                      |");
	        System.out.println("| 2 - cancelar                    |");
			mostraLinha();
		} else if (nomeMenu.equalsIgnoreCase("BEM-VINDO")) {
			mostraLinha();
			System.out.println("|        CHATBOT OPERADORA        |");
			System.out.println("|         SEJA BEM-VINDO          |");	
		}
	}

	public static void mostraConsultas(int menu, String texto) {
		mostraLinha();
		if (menu == 2) {			
			System.out.println("| Consumo: " + texto + " GB");
		} else if (menu == 3) {
			System.out.println("| Saldo: R$" + texto);
		} else if (menu == 4) {
			System.out.println("| " + texto + "      |");
		} 
		mostraLinha();
	}

	public static void mostraConsultas(int menu, String texto, List<String> lista) {
		mostraLinha();
		if (menu == 5) {
			for (String plano : lista) {
				if (!plano.equals(texto)) {
					System.out.println("| " + plano + "      |");
				} 
			}
		}
		mostraLinha();
	}

	public static void mostraMensagem(String mensagem) {
		mostraLinha();
		if (mensagem.equalsIgnoreCase("OPÇÃO-INVÁLIDA")) {
			System.out.println("|          Opção inválida         |");

		} else if (mensagem.equalsIgnoreCase("SAINDO")) {
			System.out.println("|             SAINDO              |");

		} else if (mensagem.equalsIgnoreCase("PLANO-COMPRADO")) {
			System.out.println("|          Plano comprado         |");

		}  else if (mensagem.equalsIgnoreCase("PLANO-INVÁLIDO")) {
			System.out.println("|      Esse plano não existe      |");
			System.out.println("|         Tente novamente         |");

		} else if (mensagem.equalsIgnoreCase("PLANO-JA-FOI-ADQUIRIDO")) {
			System.out.println("| Plano digitado já foi adquirido |");

		} else if (mensagem.equalsIgnoreCase("PLANO-ALTERADO")) {
			System.out.println("|          Plano alterado         |");

		} else if (mensagem.equalsIgnoreCase("COMPRA-INVÁLIDA")) {
			System.out.println("|      Não é possível comprar     |");
			System.out.println("|        Há um plano ativo        |");

		} else if (mensagem.equalsIgnoreCase("TROCA-INVÁLIDA")) {
			System.out.println("|      Não é possível trocar      |");
			System.out.println("|      Não há um plano ativo      |");

		} else if (mensagem.equalsIgnoreCase("CANCELAMENTO-INVÁLIDO")) {
			System.out.println("|     Não é possível cancelar     |");
			System.out.println("|        Não há plano ativo       |");

		} else if (mensagem.equalsIgnoreCase("CANCELAMENTO-NÃO-EFETUADO")) {
			System.out.println("|  Cancelamento não foi efetuado  |");

		} else if (mensagem.equalsIgnoreCase("CANCELAMENTO-EFETUADO")) {
			System.out.println("|      Cancelamento efetuado      |");

		} else if (mensagem.equalsIgnoreCase("VALOR-INVÁLIDO")) {
			System.out.println("|         Valor inválido          |");

		} else if (mensagem.equalsIgnoreCase("RECARGA-EFETUADA")) {
			System.out.println("|         Recarga Efetuada        |");

		}
	mostraLinha();
	}
	
	public static void mostraPlanosDisponiveis(String planoAtual, List<String> todosPlanos) {
		for (int i = 0; i < todosPlanos.size(); i++) {
			if (!todosPlanos.get(i).equalsIgnoreCase(planoAtual)) {
				System.out.println("| " + i + "º - " + todosPlanos.get(i) + " |");
			} 
		}
		mostraLinha();
	}

	public static void mostraLinha() {
		System.out.println("+---------------------------------+");
	}

	public static boolean sair() {
		mostraMensagem("SAINDO");
		return false;
	}

	public static void escreveEmArquivo(File arquivo, String texto) throws Exception {
		FileWriter fileWriter = new FileWriter(arquivo, false);
		fileWriter.write(texto);
		fileWriter.close();
	}		
}