import java.io.*;
import java.math.*;
public class cifraDeTransposicao{
	
	
	public static void main(String[] args){
		
		File arquivoOriginal = new File("textoPuro.txt");
		File arquivoCifrado = new File("arquivoCifrado.txt");
		long tamanhoArq;
		tamanhoArq = arquivoOriginal.length();
		//System.out.println(tamanhoArq);
		int tamanhoMatrizQuadrada;
		tamanhoMatrizQuadrada = 1 + (int) Math.sqrt(tamanhoArq);
		System.out.println("Tamanho matriz" + tamanhoMatrizQuadrada);
		//System.out.println(tamanhoMatrizQuadrada);
		char[][] matrizTransposicao = new char[tamanhoMatrizQuadrada][tamanhoMatrizQuadrada];
		int row = tamanhoMatrizQuadrada;
		int col = row; 
		try{
			FileReader ler = new FileReader(arquivoOriginal);
			BufferedReader lerBuffer = new BufferedReader(ler);
			
			String linha = lerBuffer.readLine();
			int tamLinha;
			int posicaoLinha = 0;
		// para cifrar o arquivo
			while(linha != null){
				tamLinha = linha.length();
				for(int i = 0; i < row;  i++){
					for(int j = 0; j < col; j++){
						if(posicaoLinha == tamLinha){
							linha = lerBuffer.readLine();
							if(linha == null){
								for(; i < row; i++){
									for(; j < col; j++){
										matrizTransposicao[j][i] = 'x';
									}
								}
								//i = row;
								//j = col;
								break;
							}
							tamLinha = linha.length();
							posicaoLinha = 0;
						}	
						if(posicaoLinha < tamLinha){
							matrizTransposicao[j][i] = linha.charAt(posicaoLinha);
							posicaoLinha++;
						}
					}
				}
			}
			arquivoCifrado.createNewFile();
			FileWriter escrever = new FileWriter(arquivoCifrado);
			BufferedWriter escreverBuffer = new BufferedWriter(escrever);
			for(int i = 0; i < tamanhoMatrizQuadrada;i++){
				for(int j = 0; j < tamanhoMatrizQuadrada; j++){
					if(0 == (int) matrizTransposicao[i][j])
						matrizTransposicao[i][j] = (char) 32;
					escrever.write(matrizTransposicao[i][j]);				
				}
			}
			escreverBuffer.close();
			escrever.close();
		// fim cifra de arquivo
		
		// para decifrar arquivo
			
			
			
			
			
			
			
			
			
		}catch(IOException e){
			System.out.println("erro de arquivo");
		}
		// imprime a matriz de char, para fins de teste, para verificar se esta correta a escrita na matriz
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(" " + matrizTransposicao[i][j]);
			}
			System.out.println();
		} 
		
				
	}	
}