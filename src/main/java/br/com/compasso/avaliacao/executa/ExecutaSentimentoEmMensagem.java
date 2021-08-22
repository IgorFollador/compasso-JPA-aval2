package br.com.compasso.avaliacao.executa;

import java.util.Scanner;

//EXECUÇÃO DO TERCEIRO EXERCÍCIO DA AVALIAÇÃO DA SPRINT II
//Emoticons
public class ExecutaSentimentoEmMensagem {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			while(true) {
				System.out.print("Entrada: ");
				String msg = input.nextLine(), msgCopy = msg;
				String feliz = ":-)", triste = ":-(";
				int nFeliz = 0, nTriste = 0, aux;
				
				for(int i=0;i<msg.length();i++){
					if(msg.contains(triste)){
						aux = msg.indexOf(triste);
						while(aux!=-1) {
							msg = msg.substring(aux+3);
							nTriste++;
							aux = msg.indexOf(triste);
						}
					}
					
					if(msgCopy.contains(feliz)){
						aux = msgCopy.indexOf(feliz);
						while(aux!=-1) {
							msgCopy = msgCopy.substring(aux+3);;
							nFeliz++;
							aux = msgCopy.indexOf(feliz);
						}					
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
