package com.example.project;

import java.util.Scanner;

public class Exercise2 {

	public static void main(final String[] args) {

		Exercise2 obj = new Exercise2();
		Scanner sc = new Scanner(System.in);
		while (true) {

			int n = sc.nextInt(), suma;
			int a[] = new int[n];

			for (int i = 0; i < n; i++) {
				n = sc.nextInt();
				a[i] = n;
			}

			suma = sc.nextInt();

			System.out.println(obj.esSubconjuntoSumaExt(a, suma));
		}
	}

	public boolean esSubconjuntoSumaExt(int a[], int suma) {
		//resta almacena el valor que se le restará a la suma
		int resta = 0;
		if(suma == 0) {
			return true;
		}

		//Recorre el arreglo en busca de los múltiplos de 7, rellena con 0 esos espacios, y los considera si verifica que no haya un 1 delante
		for(int i = 0 ; i < a.length-1; i++) {
			if(a[i] % 7 == 0) {
				if(a[i+1] != 1){
					suma = suma - a[i];
				}
				a[i] = 0;
			}
		}

		//Para almacenar el valor que se restará en el return
		for(int i = 0; i < a.length; i++) {
			if(a[i] != 0) {
				resta = a[i];
				break;
			}
			//Si todos los espacios están en cero, se supone que no consiguió la suma, retorna false
		}
		if(resta == 0){
			return false;
		}

		//Si después de haber almacenado los múltiplos de siete la suma resulta negativa, retorna false
		if(suma < 0) {
			return false;
		}
		System.out.println(suma);
		//Recursividad
		return esSubconjuntoSumaExt (cogerElemento(a), suma - resta) || (esSubconjuntoSumaExt (cogerElemento(a), suma));
	}
	
	//Simula coger el primer elemento diferente de 0
	private int[] cogerElemento(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] != 0) {
				a[i] = 0;
				break;
			}
		}
		return a;
	}
}
