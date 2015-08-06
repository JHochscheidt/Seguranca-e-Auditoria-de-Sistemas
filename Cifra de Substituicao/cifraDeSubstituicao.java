import java.io.*;
public class cifraDeSubstituicao{
	
	public static void main(String[] args){
		
		
		
		
		// criando arquivo com a tabela de codigos
		File tabela = new File("tabela.txt");
		int tamTabela = 256;
		try{
			tabela.createNewFile();	
			FileWriter escreverTabela = new FileWriter(tabela);
			BufferedWriter bufferTabela = new BufferedWriter(escreverTabela);
			int posicao = tamTabela-1;
			for(int i = 0; i < tamTabela; i++){
				if(i%2 == 0){
					escreverTabela.write( i + " " + i + "\n");
				}else{
					escreverTabela.write( i + " " +  ((i+2)%tamTabela) + "\n");
				}					
			}
			bufferTabela.close();
			escreverTabela.close();		
		}catch(IOException e){
			System.out.println("erro na leitura,escrita ou criacao de algum arquivo");
		}
		
		
		/*
		 try{
			FileReader lerTabela = new FileReader(tabela);	
			BufferedReader bufferTabela = new BufferedReader(lerTabela);
		
			String linha = bufferTabela.readLine();
			while(linha != null){
				System.out.println(linha + "\t" + linha.length());
				linha = bufferTabela.readLine();
				
			}
		}catch(IOException e){
				System.out.println("erro no arquivo");
		}
		*/		
		
				
	}

}
