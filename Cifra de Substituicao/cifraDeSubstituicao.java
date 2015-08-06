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
		
		
		// cifrando arquivo fonte original
		System.out.println("Cifrando arquivo...");	
		File arquivoFonte = new File("textoPuro.txt");
		
		try{
			FileReader lerFonte = new FileReader(arquivoFonte);
			BufferedReader bufferFonte = new BufferedReader(lerFonte);
			
			FileReader lerTabela = new FileReader(tabela);
			BufferedReader bufferTabela = new BufferedReader(lerTabela);
			
			
			File cifrado = new File("cifrado.txt");
			cifrado.createNewFile();
			FileWriter escreverTextoCifrado = new FileWriter(cifrado);
			BufferedWriter bufferTextoCifrado = new BufferedWriter(escreverTextoCifrado);
			
			String linha = bufferFonte.readLine();
			String linhaTabela;
			int valorC;
			while(linha != null){
				//	System.out.print("Linha");
				for(int i = 0; i < linha.length(); i++){
					//System.out.print("Caracter");
					valorC = (int)linha.charAt(i);
					System.out.print(valorC);
					linhaTabela = bufferTabela.readLine();
					
					while(linhaTabela != null){
						//System.out.print("LinhaTabela");
						String[] aux = new String[2];
						aux = linhaTabela.split(" ");
						int valorAux = Integer.parseInt(aux[0]);
						if(valorC == valorAux){
							System.out.println("aqui");
							int a = Integer.parseInt(aux[1]);
							char c = (char) a;
							escreverTextoCifrado.write(c);
							break;
						}else{
							linhaTabela = bufferTabela.readLine();
						}
						// for(int pos = 0; pos < aux.length; pos++){System.out.print(aux[pos]);} // teste de verificacao dos valores de aux
					}
				}
				linha = bufferFonte.readLine();		
			}
			bufferTextoCifrado.close();
			escreverTextoCifrado.close();					

			
		}catch(IOException e){
			System.out.println("erro no arquivo");
		}				
	}
}
