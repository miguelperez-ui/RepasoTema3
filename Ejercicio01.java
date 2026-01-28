package repaso;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase Ejercicio01
 * Propósito: Procesar una cadena de texto introducida por el usuario para
 * dividirla en palabras, contar cuántas superan una longitud y encontrar la más larga.
 */
public class Ejercicio01 {

	public static void main(String[] args) {

		// Inicializamos el Scanner para leer la entrada del teclado
		Scanner reader = new Scanner(System.in);

		// Definimos una constante para la longitud mínima que consideraremos "palabra larga"
		final int longitudMinima = 5;

		String frase;

		// Solicitamos la entrada al usuario
		System.out.println("Escribe una frase completa");
		frase = reader.nextLine(); // Leemos la línea completa

		// Llamada a la función para procesar la frase y convertirla en un array de palabras
		String[] palabras = obtenerPalabras(frase);
		
		// Imprimimos el array para verificar cómo ha quedado dividido (formato [a, b, c])
		System.out.println(Arrays.toString(palabras));

		// Llamada a la función para contar cuántas palabras tienen 5 o más caracteres
		int numPalabraLarga = contarPalabrasLargas(palabras, longitudMinima);
		System.out.println("Hay " + numPalabraLarga + " palabras largas");

		// Llamada a la función para buscar la palabra con mayor longitud
		String palabraMasLarga = palabraMasLarga(palabras);
		System.out.println("La palabra más larga es: " + palabraMasLarga);

		// Cerramos el scanner para liberar recursos (buena práctica)
		reader.close();
	}

	/**
	 * Recibe una frase, limpia espacios, la convierte a minúsculas y la divide en un array.
	 * * @param frase La cadena de texto original.
	 * @return Un array de Strings con las palabras separadas.
	 */
	static String[] obtenerPalabras(String frase) {

		String fraseFinal;

		// Elimina los espacios en blanco al principio y al final de la cadena
		fraseFinal = frase.trim();

		// Convierte toda la cadena a minúsculas para normalizar el texto
		// Nota: Esto hará que el resultado final se muestre siempre en minúsculas.
		fraseFinal = frase.toLowerCase();

		// Divide la cadena usando el espacio en blanco (" ") como separador.
		// Esto crea una posición en el array por cada palabra.
		String palabras[] = fraseFinal.split(" ");

		return palabras;
	}

	/**
	 * Recorre el array de palabras y cuenta cuántas superan o igualan la longitud mínima.
	 * * @param palabras Array de palabras a analizar.
	 * @param longitudMinima El número de caracteres mínimo para contar la palabra.
	 * @return El número total de palabras largas encontradas.
	 */
	static int contarPalabrasLargas(String[] palabras, int longitudMinima) {

		int contador = 0;
		// Bucle para recorrer cada posición del array
		for (int i = 0; i < palabras.length; i++) {
			// Si la longitud de la palabra actual es mayor o igual a la constante definida
			if (palabras[i].length() >= longitudMinima) {
				contador++; // Aumentamos el contador
			}
		}
		return contador;
	}

	/**
	 * Busca la palabra con mayor número de caracteres dentro del array.
	 * * @param palabras Array de palabras a analizar.
	 * @return La cadena de texto que contiene la palabra más larga.
	 */
	static String palabraMasLarga(String[] palabras) {

		// Inicializamos con una cadena vacía para poder comparar
		String palabraMasLarga = "";

		for (int i = 0; i < palabras.length; i++) {
			// Comparamos la longitud de la palabra actual con la que tenemos guardada como "más larga" hasta el momento
			if (palabras[i].length() > palabraMasLarga.length()) {
				// Si la actual es mayor, actualizamos la variable
				palabraMasLarga = palabras[i];
			}
		}

		return palabraMasLarga;
	}

}
