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
        arquivoTextoCifrado.delete();
        arquivoTextoCifrado = new File("cifrado.txt"); 
        File arquivoTextoDecifrado = new File("decifrado.txt"); // texto apos desifrado, deve estar igual ao original
        
        try{
        	arquivoTextoCifrado.createNewFile();
        	FileReader ler = new FileReader(arquivoTextoOriginal); // arquivo de leitura
        	BufferedReader lerBuffer = new BufferedReader(ler); // buffer de leitura
        	String linha = lerBuffer.readLine();
        	FileWriter escrever = new FileWriter(arquivoTextoCifrado, true);
        	BufferedWriter escreverBuffer = new BufferedWriter(escrever);
        	int valor ;
        	while(linha != null){
        		char[] aux = new char[linha.length()];
        		for(int cont = 0; cont < linha.length(); cont++){
        			aux[cont] = linha.charAt(cont);
        		}        		 
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
        	System.out.println("nao foi possivel criar cifrado.txt");
        }
        
        
     }


}
