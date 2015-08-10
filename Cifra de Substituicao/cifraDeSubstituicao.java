import java.io.*;
public class cifraDeSubstituicao{

	public static void main(String[] args){

		// criando arquivo com a tabela de codigos
		File tabela = new File("tabela.txt");
		File tabelaChar = new File("tabelaChar.txt");
		// verifica se tabela ja existe, caso nao exista, cria tabela
		
		int tamTabela = 256;
		try{
			tabela.createNewFile();
			tabelaChar.createNewFile();
			if(!tabela.exists() || !tabelaChar.exists()){	
				FileWriter escreverTabela = new FileWriter(tabela);
				FileWriter escreverTabelaChar = new FileWriter(tabelaChar);
				
				BufferedWriter bufferTabela = new BufferedWriter(escreverTabela);
				BufferedWriter bufferTabelaChar = new BufferedWriter(escreverTabelaChar);
				int posicao = tamTabela-1;
				char charI;
				char modCharI;
				int mod;
				for(int i = 0; i < tamTabela; i++){
					charI = (char) i;
					mod = ((i+2)%tamTabela);
					modCharI = (char) mod;
					System.out.println("valor i -->" + i + "valor charI --> " + charI + " valor modCharI -->" + modCharI + " valor mod -->" + mod);
					if(i%2 == 0){
						escreverTabela.write( i + " " + i + "\n");
						escreverTabelaChar.write(charI + " " + charI + "\n");
					}else{
						escreverTabela.write( i + " " +  ((i+2)%tamTabela) + "\n");
						escreverTabelaChar.write( charI + " " + modCharI + "\n");
					}
				}
				bufferTabela.close();
				bufferTabelaChar.close();
				escreverTabela.close();
				escreverTabelaChar.close();				
			}
		}catch(IOException e){
				System.out.println("erro na leitura,escrita ou criacao de algum arquivo");
		}
			
		
		
		try{
			
			// cifrando arquivo fonte original
			System.out.println("Cifrando arquivo...");
			File arquivoFonte = new File("textoPuro.txt");
			
			FileReader lerFonte = new FileReader(arquivoFonte);
			BufferedReader bufferFonte = new BufferedReader(lerFonte);
						
			FileReader lerTabela;
			BufferedReader bufferTabela;
			String linhaTabela;
			
			File cifrado = new File("cifrado.txt");
			cifrado.createNewFile();
			FileWriter escreverTextoCifrado = new FileWriter(cifrado);
			BufferedWriter bufferTextoCifrado = new BufferedWriter(escreverTextoCifrado);

			String linhaTextoFonte = bufferFonte.readLine();
					
			int valorIntC;
			// enquanto tiver linhas no arquivo original
			while(linhaTextoFonte != null){
				//percorre a linha atual
				for(int i = 0; i < linhaTextoFonte.length(); i++){
					valorIntC = (int)linhaTextoFonte.charAt(i);
					//System.out.print(valorC -> linhaTextoFonte.charAt(i));
					
					lerTabela = new FileReader(tabela);
					bufferTabela = new BufferedReader(lerTabela);
					linhaTabela = bufferTabela.readLine();
					//System.out.print(linhaTabela + "-");
					
					String[] aux = new String[2];
					int  intC;
					char charC;
					while(linhaTabela != null){
						aux = linhaTabela.split(" "); // separa a linha por espacos
						//System.out.println(aux[0] + " " + aux[1]);	
						intC = Integer.parseInt(aux[0]); // pega a primeira "string" da linha AUX
						//System.out.println(intC + " " + aux[0]);
						//System.out.println(valorC + " " + aux + " " + valorCchar );
						if(valorIntC == intC){
							int a = Integer.parseInt(aux[1]);
							char c = (char) a;
							//System.out.println(c + " " + a);
							escreverTextoCifrado.write(c);
							break;
						}else{
							linhaTabela = bufferTabela.readLine();
						}
						// for(int pos = 0; pos < aux.length; pos++){System.out.print(aux[pos]);} // teste de verificacao dos valores de aux
					}
				}
				linhaTextoFonte = bufferFonte.readLine();
			}
			bufferTextoCifrado.close();
			escreverTextoCifrado.close();
			
			
			// decifrando arquivo cifrado
			System.out.println("Decifrando arquivo...");
			//File arquivoFonte = new File("textoPuro.txt");
			
			FileReader lerCifrado = new FileReader(cifrado);
			BufferedReader bufferCifrado = new BufferedReader(lerCifrado);
						
			//FileReader lerTabela;
			//BufferedReader bufferTabela;
			//String linhaTabela;
			
			File decifrado = new File("decifrado.txt");
			decifrado.createNewFile();
			FileWriter escreverDecifrado = new FileWriter(decifrado);
			BufferedWriter bufferDecifrado = new BufferedWriter(escreverDecifrado);

			String linhaCifrado = bufferCifrado.readLine();
					
			//int valorIntC;
			// enquanto tiver linhas no arquivo cirado
			while(linhaCifrado != null){
				//percorre a linha atual
				for(int i = 0; i < linhaCifrado.length(); i++){
					valorIntC = (int)linhaCifrado.charAt(i);
					//System.out.print(valorC -> linhaCifrado.charAt(i));
					
					lerTabela = new FileReader(tabela);
					bufferTabela = new BufferedReader(lerTabela);
					linhaTabela = bufferTabela.readLine();
					//System.out.print(linhaTabela + "-");
					
					String[] aux = new String[2];
					int  intC;
					char charC;
					while(linhaTabela != null){
						aux = linhaTabela.split(" "); // separa a linha por espacos
						//System.out.println(aux[0] + " " + aux[1]);	
						intC = Integer.parseInt(aux[1]); // pega a segunda "string" da linha AUX
						//System.out.println(intC + " " + aux[0]);
						//System.out.println(valorC + " " + aux + " " + valorCchar );
						if(valorIntC == intC){
							int a = Integer.parseInt(aux[0]);
							char c = (char) a;
							//System.out.println(c + " " + a);
							escreverDecifrado.write(c);
							break;
						}else{
							linhaTabela = bufferTabela.readLine();
						}
						// for(int pos = 0; pos < aux.length; pos++){System.out.print(aux[pos]);} // teste de verificacao dos valores de aux
					}
				}
				linhaCifrado = bufferCifrado.readLine();
			}
			bufferDecifrado.close();
			escreverDecifrado.close();
						
		}catch(IOException e){
			System.out.println("erro no arquivo");
		}
	}
}
