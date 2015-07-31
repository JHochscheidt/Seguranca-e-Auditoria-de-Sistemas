import java.io.*;
import java.math.*;
public class cifraDeTransposicao{
	
	
	public static void main(String[] args){
		
		File arquivoOriginal = new File("textoPuro.txt");
		long tamanhoArq;
		tamanhoArq = arquivoOriginal.length();
		//System.out.println(tamanhoArq);
		int tamanhoMatrizQuadrada;
		tamanhoMatrizQuadrada = 1 + (int) Math.sqrt(tamanhoArq);
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
	
			while(linha != null){
				tamLinha = linha.length();
	
				for(int i = 0; i < row;  i++){
					for(int j = 0; j < col; j++){
						if(posicaoLinha == tamLinha){
							linha = lerBuffer.readLine();
							if(linha == null){
								for(; i < row; i++){
									for(; j < col; j++){
										matrizTransposicao[i][j] = 'x';
									}
								}
								break;
							}else{
								tamLinha = linha.length();
								posicaoLinha = 0;
							}
							
						}
						if(posicaoLinha < tamLinha){
							matrizTransposicao[i][j] = linha.charAt(posicaoLinha);
							posicaoLinha++;
						}
					}
				}
			}
		}catch(IOException e){
			System.out.println("erro de arquivo");
		}
		
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				System.out.print(matrizTransposicao[i][j]);
			}
			System.out.println();
		}		
	}	
}