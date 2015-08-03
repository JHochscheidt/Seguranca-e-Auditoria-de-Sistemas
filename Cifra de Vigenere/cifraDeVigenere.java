import java.io.*;

public class cifraDeVigenere{
	
	public static void main(String[] args){
		
		char[] chave = {'V','I','G','E','N','E','R','E'};
		
		
		
		try{
			File arquivoOriginal = new File("textoPuro.txt");
		
			FileReader ler = new FileReader(arquivoOriginal);
			BufferedReader lerBuffer = new BufferedReader(ler);
				
			String linha = lerBuffer.readLine();
			while(linha != null){
				System.out.println(linha);
				linha = lerBuffer.readLine();
			}
		}catch(IOException e){
			System.out.println("erro na leitura/escrita do arquivo");
		}
		
		
		
	}
	
	
	
}