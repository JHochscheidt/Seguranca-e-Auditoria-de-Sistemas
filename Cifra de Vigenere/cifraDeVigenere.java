import java.io.*;

public class cifraDeVigenere{
	
	public static void main(String[] args){
		
		char[] chave = {'V','I','G','E','N','E','R','E'};
		File arquivoOriginal = new File("textoPuro.txt");
		File textoCifrado = new File("textoCifrado.txt");
		File textoDecifrado = new File("textoDecifrado.txt");
		
		
		try{
			
		
			FileReader ler = new FileReader(arquivoOriginal);
			BufferedReader lerBuffer = new BufferedReader(ler);
			
		// cifrando o texto
			String linha = lerBuffer.readLine();
			while(linha != null){
				
				
				
				linha = lerBuffer.readLine();
			}
			
			
			
			
		}catch(IOException e){
			System.out.println("erro na leitura/escrita do arquivo");
		}
		
		
		
	}
	
	
	
}