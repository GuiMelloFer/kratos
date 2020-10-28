package kratos;

import java.util.Random;
import java.util.Scanner;

public class Sprints3 {

	public static void main(String[] args) {
		int [] lista1 = new int [6];
		int [] lista2 = new int [8];
		int [] lista3 = new int [5];
		int [] minutos = new int[99];
		
		
		Scanner R = new Scanner(System.in);
		Random random = new Random();
		
		//Insere os valores na lista
		System.out.println("Insira as salas que precisam de desinfetação da Lista 1:");
		for(int i=0; i<lista1.length; i++) {
			lista1[i]=R.nextInt();
		}
		
		System.out.println("Insira as salas que precisam de desinfetação da Lista 2:");
		for(int i=0; i<lista2.length; i++) {
			lista2[i]=R.nextInt();
		}
		
		System.out.println("Insira as salas que precisam de desinfetação da Lista 3:");
		for(int i=0; i<lista3.length; i++) {
			lista3[i]=R.nextInt();
		}
		
		
		//modifica valores iguais para não serem considerados
		for(int i=0; i<lista2.length; i++) {
			for(int j=0;j<lista2.length;j++) {
				if(i<lista1.length && j<lista2.length) {
					if(lista1[i] == lista2[j]) {
						lista2[j]=100;
					}
				}
				if(i<lista1.length && j<lista3.length) {
					if(lista1[i] == lista3[j]) {
						lista3[j]=100;
					}
				}
				if(i<lista1.length && j<lista1.length) {
					if(lista1[i] == lista1[j] && i!=j) {
						lista1[j]=100;
					}
				}
				if(i<lista2.length && j<lista1.length) {
					if(lista2[i] == lista1[j]) {
						lista1[j]=100;
					}
				}
				if(i<lista2.length && j<lista3.length) {
					if(lista2[i] == lista3[j]) {
						lista3[j]=100;
					}
				}
				if(i<lista2.length && j<lista2.length) {
					if(lista2[i] == lista2[j] && i!=j) {
						lista2[j]=100;
					}
				}
				if(i<lista3.length && j<lista1.length) {
					if(lista3[i] == lista1[j]) {
						lista1[j]=100;
					}
				}
				if(i<lista3.length && j<lista2.length) {
					if(lista3[i] == lista2[j]) {
						lista2[j]=100;
					}
				}
				if(i<lista3.length && j<lista3.length) {
					if(lista3[i] == lista3[j] && i!=j) {
						lista3[j]=100;
					}
				}
				
			}

		}
		int min;
		int horas;
		int tempo_total = 0;
		//tempo aleatorio
		for(int i=0; i<minutos.length; i++) {
			minutos[i] = random.nextInt(10) + 5;
			
			// so para por no gabarito
			//System.out.println("Sala " + (i+1) + ": " + minutos[i]);
			
			tempo_total = tempo_total + minutos[i];
		}
		min = tempo_total % 60;
		horas = (tempo_total - min) / 60;
		System.out.println("O tempo total de limpeza para todas as 99 salas é de: ");
		System.out.println(horas + " horas : " + min + " minutos");
		
		
		
		
		//soma os minutos das sala necessarias
		int total_minutos = 0;
		for(int i=0; i<minutos.length; i++) {
			for(int j=0; j<minutos.length; j++) {
				if(i<lista1.length) {
					if(lista1[i]==j+1 && lista1[i] != 100) {
						total_minutos = total_minutos + minutos[j];
					}
				}if(i<lista2.length ) {
					if(lista2[i]==j+1 && lista2[i] != 100) {
						total_minutos = total_minutos + minutos[j];
					}
				}if(i<lista3.length ) {
					if(lista3[i]==j+1 && lista3[i] != 100) {
						total_minutos = total_minutos + minutos[j];
					}
				}
			}
		}
		
		
		
		//print da lista única
		System.out.println("Lista única de salas que precisam ser desinfetadas: ");
		for(int i=0; i<lista2.length;i++) {
			if(i<lista1.length) {
				if(lista1[i] != 100) {
					System.out.println(lista1[i]);
					}
			}if(i<lista2.length) {
				if(lista2[i] != 100) {
					System.out.println(lista2[i]);
					}
			}if(i<lista3.length) {
				if(lista3[i] != 100) {
					System.out.println(lista3[i]);
					}
			}
		}
		
		//conversão para horas e minutos
		 min = 0;
		 horas = 0;
		if(total_minutos >= 60) {
			min = total_minutos % 60;
			horas = (total_minutos - min) / 60;
			System.out.println("O tempo total de limpeza necessário é de: ");
			System.out.println(horas + " horas : " + min + " minutos");
		}else {
			min = total_minutos;
			System.out.println("O tempo total de limpeza necessário é de: ");
			System.out.println( min + " minutos");
		}
		
	
		
		
		
		

	}

}
