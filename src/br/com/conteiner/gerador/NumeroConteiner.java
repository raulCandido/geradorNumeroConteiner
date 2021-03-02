package br.com.conteiner.gerador;

import java.util.HashMap;
import java.util.Random;

public class NumeroConteiner {
	
	static Random random = new Random();

	static char[] caracteres = new char[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static HashMap<Character, Integer> valores = new HashMap<Character, Integer>();

	static {
		int valorInicial = 10;
		for (int i = 0; i < caracteres.length; i++) {
			if (valorInicial % 11 == 0) {
				valorInicial++;
			}
			valores.put(caracteres[i], valorInicial);
			valorInicial++;
		}
	}
	
	public static String gerarNumeroConteiner(){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			sb.append(caracteres[random.nextInt(caracteres.length)]);
		}
		for (int i = 0; i < 6; i++) {
			sb.append(random.nextInt(10));
		}
		
		int somaTotal = 0;
		for (int i = 0; i < 10; i++) {
			if(i< 4){
				Integer valorLetra = valores.get(sb.charAt(i));
				somaTotal+=valorLetra*(Math.pow(2, i));
			}else{
				somaTotal+=Character.getNumericValue(sb.charAt(i))*(Math.pow(2, i));
			}
		}
		//sb.append("-");
		sb.append(somaTotal%11%10);

		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(gerarNumeroConteiner());
		
	}
}
