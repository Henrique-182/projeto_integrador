package operadora;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class teste {
    public static void main(String[] args) throws Exception{
		File caminhoArquivoPlanoAtivo = new File("C:\\projeto_integrador\\src\\operadora\\planoAtivo.txt");
		Scanner aberturaArquivoPlanoAtivo = new Scanner(new FileInputStream(caminhoArquivoPlanoAtivo));
		String planoAtivo = aberturaArquivoPlanoAtivo.nextLine();
		FileWriter insercaoArquivoPlanoAtivo = new FileWriter(caminhoArquivoPlanoAtivo, true);


        //System.out.println(planoAtivo);
        //insercaoArquivoPlanoAtivo.write("Plano");
        //insercaoArquivoPlanoAtivo.close();

        FileWriter substituiPlanoAtivo = new FileWriter(caminhoArquivoPlanoAtivo, false);
		substituiPlanoAtivo.write("10GB de internet - R$50.00");
		substituiPlanoAtivo.close();
    }
}
