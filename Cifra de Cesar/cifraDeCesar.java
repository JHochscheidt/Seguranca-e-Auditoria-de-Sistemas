import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class cifraDeCesar{
	
		
    public static void main(String[] args){

    	final int chave = 5;
        
        File arquivoTextoOriginal =  new File("textoPuro.txt"); // texto a ser cifrado/decifrado
        File arquivoTextoCifrado = new File("cifrado.txt"); // texto apos cifrado
        File arquivoTextoDecifrado = new File("decifrado.txt"); // texto apos desifrado, deve estar igual ao original
        
        try{
        	
        	
       	// parte que cifra o texto
        	arquivoTextoCifrado.createNewFile();
        	FileReader ler = new FileReader(arquivoTextoOriginal); // arquivo de leitura
        	BufferedReader lerBuffer = new BufferedReader(ler); // buffer de leitura
        	String linha = lerBuffer.readLine();
        	FileWriter escrever = new FileWriter(arquivoTextoCifrado, true);
        	BufferedWriter escreverBuffer = new BufferedWriter(escrever);
        	int valor ;
        	while(linha != null){
        		char[] aux = new char[linha.length()];
        		// passa a string LINHA para dentro de um vetor de char para poder substituir os caracteres
        		for(int cont = 0; cont < linha.length(); cont++){
        			aux[cont] = linha.charAt(cont);
        		}        		 
        		// percorre o vetor de char trocando (cifrando) o texto
        		for(int i = 0; i < aux.length; i++){
        			valor = ((int)aux[i] + chave) % 256 ;
        			aux[i] = (char) valor;
        			escrever.write(aux[i]);
        		}
        		linha = lerBuffer.readLine();
        	}
        	escreverBuffer.close();
        	escrever.close();
        	
        	// parte de decifra o texto
        	arquivoTextoDecifrado.createNewFile();
        	ler = new FileReader(arquivoTextoCifrado);
        	escrever = new FileWriter(arquivoTextoDecifrado, true);
        	linha = lerBuffer();
        	while(linha != null){
        		char[] aux = new char[linha.length()];
        		// passa a string LINHA para dentro de um vetor de char para poder substituir os caracteres
        		for(int cont = 0; cont < linha.length(); cont++){
        			aux[cont] = linha.charAt(cont);
        		}        		 
        		// percorre o vetor de char trocando (cifrando) o texto
        		for(int i = 0; i < aux.length; i++){
        			valor = ((int)aux[i] + chave) % 256 ;
        			aux[i] = (char) valor;
        			escrever.write(aux[i]);
        		}
        		linha = lerBuffer.readLine();
        	}
        	escreverBuffer.close();
        	escrever.close();
    	}catch(IOException e){
        	System.out.println("Erro na criação, escrita ou leitura de algum arquivo!!!");
        }
     }
}
