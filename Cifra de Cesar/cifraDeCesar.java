import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class cifraDeCesar{
	
    public static void main(String[] args){

    	
        String url = "textoPuro.txt" ; // texto a ser cifrado/decifrado
        File arquivoTexto =  new File(url);
        File arquivoTextoCifrado = new File("cifrado.txt");
        
        try{
        	arquivoTextoCifrado.createNewFile();
        	final int chave = 5;
        	FileReader ler = new FileReader(arquivoTexto); // arquivo de leitura
        	BufferedReader lerBuffer = new BufferedReader(ler); // buffer de leitura
        	String linha = lerBuffer.readLine();
        	while(linha != null){
        		for(int i = 0; i < linha.length(); i++){
        			System.out.println(linha.charAt(i));
        		}
        		linha = lerBuffer.readLine();
        	}
        }catch(IOException e){
        	System.out.println("nao foi possivel criar cifrado.txt");
        }
        
        
     }


}
