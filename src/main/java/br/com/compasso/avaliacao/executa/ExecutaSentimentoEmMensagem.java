package br.com.compasso.avaliacao.executa;

import java.util.Scanner;

public class ExecutaSentimentoEmMensagem {

	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			while(true) {
				System.out.println("Ensira sua mensagem:");
				String msg = input.nextLine();
				String feliz = ":-)", triste = ":-(";
				int nFeliz = 0, nTriste = 0;
			
				String [] arrayString = msg.split(" ");
				
				for(int i=0;i<arrayString.length;i++){
					
					if(arrayString[i].equals(feliz)){
						nFeliz++;
					} else if(arrayString[i].equals(triste)){
						nTriste++;
					}
					
				}
//				while(msg.contains(feliz)) {
//					nFeliz++;
//					msg = msg.replaceFirst(feliz, " ");
//				}
//				
//				while(msg.contains(triste)) {
//					nTriste++;
//					msg = msg.replaceFirst(triste, " ");
//				}
				
				if(nFeliz > nTriste) System.out.println("divertido");
				else if(nFeliz < nTriste) System.out.println("chateado");
				else System.out.println("neutro\n-------------------------------");
			}
		}
	}

}
