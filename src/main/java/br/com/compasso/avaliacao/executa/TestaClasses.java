package br.com.compasso.avaliacao.executa;

import java.util.Scanner;

public class TestaClasses {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String divertido = ":-)";
	    String chateado = ":-(";
		String str1 = in.nextLine();
		String str2 = str1;
		int i, num_chateado = 0, num_divertido = 0;
	
		i = str1.indexOf(divertido);
		while (i != -1) {
		    num_divertido++;
		    str1 = str1.substring(i+3);
		    i = str1.indexOf(divertido);
		}   
		i = str2.indexOf(chateado);
		System.out.println(i);
		while (i != -1) {
		    num_chateado++;
		    System.out.println(str2);
		    str2 = str2.substring(i+3);
		    System.out.println(str2);
		    i = str2.indexOf(chateado);
		}
		if (num_divertido > num_chateado)
		    System.out.println("divertido");
		else if (num_divertido < num_chateado)
		    System.out.println("chateado");
		else
		    System.out.println("neutro");
	}
}

