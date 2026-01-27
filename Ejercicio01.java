package repaso;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		final int longitudMinima = 5;

		String frase;

		System.out.println("Escribe una frase completa");
		frase = reader.nextLine();

		String[] palabras = obtenerPalabras(frase);
		System.out.println(Arrays.toString(palabras));

		int numPalabraLarga = contarPalabrasLargas(palabras, longitudMinima);
		System.out.println("Hay " + numPalabraLarga + " palabras largas");

		String palabraMasLarga = palabraMasLarga(palabras);
		System.out.println("La palabra más larga es: " + palabraMasLarga);

		reader.close();
	}

	static String[] obtenerPalabras(String frase) {

		String fraseFinal;

		fraseFinal = frase.trim();

		fraseFinal = frase.toLowerCase();

		String palabras[] = fraseFinal.split(" ");

		return palabras;
	}

	static int contarPalabrasLargas(String[] palabras, int longitudMinima) {

		int contador = 0;
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].length() >= longitudMinima) {
				contador++;
			}
		}
		return contador;
	}

	static String palabraMasLarga(String[] palabras) {

		String palabraMasLarga = "";

		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].length() > palabraMasLarga.length()) {
				palabraMasLarga = palabras[i];
			}
		}

		return palabraMasLarga;
	}

}