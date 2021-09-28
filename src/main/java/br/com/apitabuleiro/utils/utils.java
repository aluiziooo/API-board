package br.com.apitabuleiro.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class utils {
	
	char[][] tabuleiroMatriz = new char[3][3];
	char[] tabuleiroMatriz1D = new char[9];

	
	public String bestLance(String tabuleiro) {
		tabuleiro = tabuleiro.replaceAll("%20", "-");
		System.out.println(tabuleiro+"\n");
		char[] chars = tabuleiro.toCharArray();
		matrizBuild(chars);
		String posicao = "";
		mostrarMatriz();
		//saber qual a linha ou coluna tem a maior concentração de o
			//verificar linha 1,2,3
			//verificarcoluna 1,2,3
			//00 01 02
			//10 11 12
			//20 21 22
		posicao = melhorPosicao();
		
		if(posicao.contains("col")) {
			if(posicao.contains("0")) {
				prencherJogada("col", 0);
			} else if(posicao.contains("1")) {
				prencherJogada("col", 1);
			} else if(posicao.contains("2")) {
				prencherJogada("col", 2);
			}else {
				System.out.println("Posicação invalida");
			}
		} else if(posicao.contains("row")) {
			if(posicao.contains("0")) {
				prencherJogada("row", 0);
			} else if(posicao.contains("1")) {
				prencherJogada("row", 1);
			} else if(posicao.contains("2")) {
				prencherJogada("crow", 2);
			}else {
				System.out.println("Posicação invalida");
			}
		} else if(posicao.contains("DiagLeftToRight")) {
			prencherJogada("DiagLeftToRight", -1);
		} else if(posicao.contains("DiagRightToLeft")) {
			prencherJogada("DiagRightToLeft", -1);
		}
		mostrarMatriz();
		converterArrayPara1D();
		return new String(tabuleiroMatriz1D);
		
	}
	public void prencherJogada(String where, int posic) {
		int xy =0;
		int row = 0;
		int col = 2;
		for (int i = 0; i < 3; i++) {
			if(where=="col") {
				if(tabuleiroMatriz[i][posic]=='-') {
					tabuleiroMatriz[i][posic]='o';
				}
			} else if(where=="row") {
				if(tabuleiroMatriz[posic][i]=='-') {
					tabuleiroMatriz[posic][i]='o';
				}
			} else if(where=="DiagLeftToRight") {
				if(tabuleiroMatriz[xy][xy]=='-') {
					tabuleiroMatriz[xy][xy]='o';
				}
			} else if(where=="DiagRightToLeft") {
				if(tabuleiroMatriz[row][col]=='-') {
					tabuleiroMatriz[row][col]='o';
				}
			}
			xy++;
			row++;
			col--;
		}
	}
	public void matrizBuild(char[] chars){

		int cont = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tabuleiroMatriz[i][j] = chars[cont];
				cont++;
			}
		}
	}
	
	public String melhorPosicao() {
		HashMap<String, Integer> mapTab = new HashMap<String, Integer>();
		int count = 0;
		int xy=0;
		String Posicao ="";
		
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if(tabuleiroMatriz[row][col]=='o') {
					count++;
				}
				
			}
			
			mapTab.put(Integer.toString(row)+"row", count);
			count = 0;
		}
		count = 0;
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				if(tabuleiroMatriz[row][col]=='o') {
					count++;
				}
			}
			mapTab.put(Integer.toString(col)+"col", count);
			count = 0;
		}
		
		
		count = 0;
		for (int i = 0; i < 3; i++) {
			if(tabuleiroMatriz[xy][xy]=='o') {
				count++;
				xy++;
			}
		}
		mapTab.put("DiagLeftToRight", count);
		count = 0;
		//02 11 20
		int row = 0;
		int col = 2;
		
		for (int i = 0; i < 3; i++) {
			if(tabuleiroMatriz[row][col]=='o') {
				count++;
			}
			row++;
			col--;
		}
		mapTab.put("DiagRightToLeft", count);
		System.out.println(mapTab);
		
		String key = getSingleKeyFromValue(mapTab, 2);
		return key;
	}
	public static <K, V> K getSingleKeyFromValue(Map<K, V> map, V value) {
	        for (Map.Entry<K, V> entry : map.entrySet()) {
	            if (Objects.equals(value, entry.getValue())) {
	                return entry.getKey();
	            }
	        }
	        return null;
}
	 
	public void mostrarMatriz() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				System.out.printf("%5c", tabuleiroMatriz[row][col]);
			}
			System.out.println(" ");
			
		}
	}
	public void converterArrayPara1D() {
		int index = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				tabuleiroMatriz1D[index] = tabuleiroMatriz[row][col];
				index++;
			}
		}
	}
}
