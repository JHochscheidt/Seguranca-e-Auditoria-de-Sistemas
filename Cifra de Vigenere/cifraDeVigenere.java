import java.io.*;

public class cifraDeVigenere{
	
	public static void main(String[] args){
		
		char[] chave ={'a','b','c'};// {'V','I','G','E','N','E','R','E'};
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
			while(linha != null){
				char[] key = new char[linha.length()];
				int BYTE;
				for(int pos = 0; pos < key.length; pos++){
					key[pos] = chave[pos % chave.length];
					//System.out.print(key[pos]);
					BYTE = ((int)linha.charAt(pos) + (int)key[pos]) % 256 ;
					//System.out.print((int)linha.charAt(pos) + " ");
					//System.out.print((int)key[pos] + " ");
					//System.out.print(BYTE + " ");
					//System.out.print((char) BYTE + "	");
					escrever.write((char)BYTE);
				}
				linha = lerBuffer.readLine();
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
			while(linha != null){
				char[] key = new char[linha.length()];
				int BYTE;
				for(int pos = 0; pos < key.length; pos++){
					key[pos] = chave[pos % chave.length];
					//System.out.print(key[pos]);
					BYTE = ((int)linha.charAt(pos) - (int)key[pos]) % 256 ;
					//System.out.print((int)linha.charAt(pos) + " ");
					//System.out.print((int)key[pos] + " ");
					//System.out.print(BYTE + " ");
					//System.out.print((char) BYTE + "	");
					escrever.write((char)BYTE);
				}
				linha = lerBuffer.readLine();
			}
			escreverBuffer.close();
			escrever.close();
			
			
			
		}catch(IOException e){
			System.out.println("erro na leitura/escrita do arquivo");
		}
		
		
		
	}
	
	
	
}