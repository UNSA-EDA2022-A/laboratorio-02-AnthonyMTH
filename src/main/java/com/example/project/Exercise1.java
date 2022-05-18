package com.example.project;

import java.util.Scanner;

public class Exercise1 {

	public static void main(final String[] args) {

		Exercise1 obj = new Exercise1();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			System.out.println(obj.esCuadradoPerfecto(n));			
		}
	}

	public boolean esCuadradoPerfecto(int numero) {
		if(numero == 1) {
		    return true;
		}
		if(numero == 0) {
			return false;
		}
		return esCuadradoPerfecto(numero-(numero-(int)(Math.pow(Math.sqrt(numero)-1,2))));
	}
}
