import java.io.*;

public class cifraDeVigenere{
	
	public static void main(String[] args){
		
		char[] chave ={'V','I','G','E','N','E','R','E'};
		File arquivoOriginal = new File("textoPuro.txt");
		File textoCifrado = new File("textoCifrado.txt");
		File textoDecifrado = new File("textoDecifrado.txt");
		
		
		try{			
			FileReader ler = new FileReader(arquivoOriginal);
			BufferedReader lerBuffer = new BufferedReader(ler);
			textoCifrado.createNewFile();
			FileWriter escrever = new FileWriter(textoCifrado);
			BufferedWriter escreverBuffer = new BufferedWriter(escrever);
		// cifrando o texto
			String linha = lerBuffer.readLine();
			String aux = "";	
			while(linha != null){
				aux = aux + linha;
				linha = lerBuffer.readLine();
			}
			char[] key = new char[aux.length()];
			for(int i = 0; i < key.length; i++){
				key[i] = chave[i % chave.length];
			}
			int b;
			for(int i = 0; i < key.length; i++){
				b = (((int)aux.charAt(i) + (int)key[i]) % 256)	;
				escrever.write(b);
			}
			escreverBuffer.close();
			escrever.close();
			
		// decifrando texto cifrado
			textoDecifrado.createNewFile();
			ler = new FileReader(textoCifrado);
			lerBuffer = new BufferedReader(ler);
			escrever = new FileWriter(textoDecifrado);
			escreverBuffer = new BufferedWriter(escrever);
			linha = lerBuffer.readLine();
			aux = "";			
			while(linha != null){
				aux = aux + linha;
				linha = lerBuffer.readLine();
			}
			key = new char[aux.length()];
			for(int i = 0; i < key.length; i++){
				key[i] = chave[i % chave.length];
			}
			
			for(int i = 0; i < key.length; i++){
				b = ((256 + (int)aux.charAt(i) - (int)key[i]) % 256) ;
				System.out.print(b + " ");
				escrever.write(b);
			}
			escreverBuffer.close();
			escrever.close();
			
		}catch(IOException e){
			System.out.println("erro na leitura/escrita do arquivo");
		}
		
		
		
	}
	
	
	
}
