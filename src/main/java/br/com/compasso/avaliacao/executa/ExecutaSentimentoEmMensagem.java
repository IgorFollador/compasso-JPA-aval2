package br.com.compasso.avaliacao.executa;

import java.util.Scanner;

public class ExecutaSentimentoEmMensagem {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			while(true) {
				System.out.print("Entrada: ");
				String msg = input.nextLine();
				String feliz = ":-)", triste = ":-(";
				int nFeliz = 0, nTriste = 0;
			
				String [] arrayString = msg.split(" ");
				
				for(int i=0;i<arrayString.length;i++){
					if(arrayString[i].contains(feliz)){
						nFeliz++;
					} 
					if(arrayString[i].contains(triste)){
						nTriste++;
					}
				}
				System.out.print("Saída: ");
				if(nFeliz > nTriste) System.out.println("divertido");
				else if(nFeliz < nTriste) System.out.println("chateado");
				else System.out.println("neutro");
			}
		}
	}

}
