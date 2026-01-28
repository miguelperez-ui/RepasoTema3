package repaso;

/**
 * Clase Ejercicio03
 * Propósito: Buscar una lista de palabras clave dentro de un texto,
 * ignorando mayúsculas/minúsculas y mostrando las coincidencias.
 */
public class Ejercicio03 {

	public static void main(String[] args) {

		// Texto donde vamos a buscar
		String texto = "Hola soy Miguel y estoy haciendo un ejercicio de repaso";

		// Array con las palabras clave que queremos encontrar
		String claves[] = { "caballo", "tortiLLa", "Miguel", "caramelo", "esToy" };
		
		// Llamamos a la función principal que devuelve un array solo con las que aparecen
		String[] encontradas = palabrasEncontradas(texto, claves);
		
		// Mostramos el resultado por pantalla
		mostrarResultado(encontradas);
	}

	/**
	 * Verifica si una palabra está dentro del texto, ignorando mayúsculas y minúsculas.
	 * @param texto El texto completo.
	 * @param palabra La palabra clave a buscar.
	 * @return true si la encuentra, false si no.
	 */
	static boolean contienePalabra(String texto, String palabra) {

		// Convertimos ambos a minúsculas al vuelo y comprobamos si contiene la palabra
		return texto.toLowerCase().contains(palabra.toLowerCase());
	}

	/**
	 * Genera un nuevo array que contiene solo las palabras del array 'claves'
	 * que aparecen en el 'texto'.
	 * @param texto Texto donde buscar.
	 * @param claves Array de palabras a buscar.
	 * @return Array de Strings con las coincidencias encontradas.
	 */
	static String[] palabrasEncontradas(String texto, String[] claves) {
		
		// PASO 1: Contar. 
		// Como los arrays en Java son fijos, primero necesitamos saber de qué tamaño 
		// crear el array de resultados.
		int contador = 0;
		for (int i = 0; i < claves.length; i++) {
			// Usamos nuestra función auxiliar para comprobar
			if (contienePalabra(texto, claves[i])) {
				contador++;
			}
		}
		
		// PASO 2: Crear el array con el tamaño exacto.
		String resultado[] = new String[contador];

		// PASO 3: Rellenar.
		// Volvemos a recorrer para guardar las palabras. Necesitamos una variable 'pos'
		int pos = 0;
		for (int i = 0; i < claves.length; i++) {
			if (contienePalabra(texto, claves[i])) {
				resultado[pos] = claves[i]; // Guardamos la palabra encontrada
				pos++; // Avanzamos solo en el array de resultados
			}
		}
		
		return resultado;
	}

	/**
	 * Imprime el array de palabras encontradas con formato bonito.
	 * @param encontradas Array de palabras.
	 */
	static void mostrarResultado(String[] encontradas) {
		// Verificamos si el array está vacío (length 0)
		if (encontradas.length == 0) {
			System.out.println("No se han encontrado palabras clave en el texto");
		} else {
			System.out.println("Palabras encontradas: ");
			
			// Recorremos el array para imprimir elemento a elemento
			// Esto sustituye a todo el bucle for
			System.out.println(String.join(", ", encontradas));
			// Salto de línea final para que quede limpio en consola
			System.out.println(); 
		}
	}
}
