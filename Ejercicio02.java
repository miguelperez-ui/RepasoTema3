package repaso;

import java.util.Arrays;

/**
 * Clase Ejercicio02
 * Propósito: Gestionar un array de notas de alumnos (double),
 * generarlas aleatoriamente y realizar cálculos estadísticos (media, máximo, aprobados)
 * y modificaciones (subir nota).
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		
		// Variable para definir cuánto subiremos la nota al final
		double incremento = 0.5;
		
		// Creamos un array de 30 posiciones para almacenar las notas (tipo double)
		double notas[] = new double[30];
		
		// Bucle para rellenar el array con notas aleatorias
		for(int i = 0; i < notas.length; i++) {
			// Math.random() genera de 0.0 a 1.0. Al multiplicar por 10, tenemos de 0.0 a 10.0
			double aleatorio = Math.random() * 10;
			
			
			notas[i] = Math.round(aleatorio * 100) / 100.0;
		}
		
		System.out.println("Notas de la clase");
		// Arrays.toString nos permite imprimir el array de forma legible rápidamente
		System.out.println(Arrays.toString(notas));
		
		// Llamada al método para calcular la media
		double media = calcularMedia(notas);
		System.out.println("--------");
		System.out.println("Nota media: " + media);
		
		// Llamada al método para encontrar la nota más alta
		double maxima = notaMaxima(notas);
		System.out.println("--------");
		System.out.println("Nota máxima: " + maxima);
		
		// Llamada al método para contar cuántos tienen un 5 o más
		int aprobados = contarAprobados(notas);
		System.out.println("--------");
		System.out.println("Número de aprobados: " + aprobados);
		
		// Llamada al método que genera un listado con las notas subidas
		subirNotas(notas, incremento);
	}

	/**
	 * Calcula la media aritmética de las notas.
	 * @param notas El array que contiene las notas (double).
	 * @return notaMedia La suma de todas las notas dividida por el total de alumnos.
	 */
	static double calcularMedia(double[] notas) {
		
		double notaMedia = 0.0;
		double suma = 0;
		
		// Recorremos el array acumulando el valor de cada nota en 'suma'
		for(int i = 0; i < notas.length; i++) {
			suma += notas[i];
		}
		
		// Calculamos la media dividiendo el acumulado entre el número de elementos
		notaMedia = suma / notas.length;
		
		return notaMedia;
	}

	/**
	 * Busca el valor más alto dentro del array de notas.
	 * @param notas El array de notas.
	 * @return notaMayor El valor máximo encontrado.
	 */
	static double notaMaxima(double[] notas) {
		
		// Inicializamos con 0.0 porque sabemos que no hay notas negativas
		double notaMayor = 0.00;
		
		for (int i = 0; i < notas.length; i++) {
			// Si la nota actual es mayor que la que tenemos guardada como mayor...
			if (notas[i] > notaMayor) {
				// ...actualizamos la variable notaMayor
				notaMayor = notas[i];
			}
		}
		
		return notaMayor;
	}

	/**
	 * Cuenta cuántas notas son iguales o superiores a 5.
	 * @param notas El array de notas.
	 * @return aprobados El número total de alumnos aprobados.
	 */
	static int contarAprobados(double[] notas) {
		
		int aprobados = 0;
		
		for (int i = 0; i < notas.length; i++) {
			// Condición de aprobado: 5 o más
			if (notas[i] >= 5) {
				aprobados++;
			}
		}
		return aprobados;
	}

	/**
	 * Crea una copia del array de notas sumándole un incremento.
	 * Controla que ninguna nota supere el 10.
	 * @param notas El array original de notas.
	 * @param incremento El valor a sumar a cada nota.
	 */
	static void subirNotas(double[] notas, double incremento) {
		
		// Creamos un NUEVO array para no modificar el original (notas)
		double notasIncrementadas[] = new double[notas.length];
		
		for(int i = 0; i < notas.length; i++) {
			// Copiamos la nota original al nuevo array
			notasIncrementadas[i] = notas[i];
			
			// Le sumamos el incremento (ej: +0.5)
			notasIncrementadas[i] += incremento;
			
			// IMPORTANTE: Controlamos que la nota no pase de 10
			if(notasIncrementadas[i] > 10) {
				notasIncrementadas[i] = 10;
			}
		}
		
		System.out.println("---------");
		// Imprimimos el nuevo array modificado
		System.out.println("Notas incrementadas: " + Arrays.toString(notasIncrementadas));
	}

}
