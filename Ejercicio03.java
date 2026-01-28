package repaso;

public class Ejercicio03 {

	public static void main(String[] args) {

		String texto = "Hola soy Miguel y estoy haciendo un ejercicio de repaso";

		String claves[] = { "caballo", "tortiLLa", "Miguel", "caramelo", "esToy" };
		
		String[]encontradas=palabrasEncontradas(texto,claves);
		mostrarResultado(encontradas);

	}

	static boolean contienePalabra(String texto, String palabra) {
		texto.toLowerCase();
		palabra.toLowerCase();
		return texto.contains(palabra);
	}

	static String[] palabrasEncontradas(String texto, String[] claves) {
		int contador = 0;
		for (int i = 0; i < claves.length; i++) {
			if (contienePalabra(texto, claves[i])) {
				contador++;
			}
		}
		String resultado[] = new String[contador];

		int pos = 0;

		for (int i = 0; i < claves.length; i++) {
			if (contienePalabra(texto, claves[i])) {
				resultado[pos] = claves[i];
				pos++;

			}
		}
		return resultado;
	}

	static void mostrarResultado(String[] encontradas) {
		if (encontradas.length == 0) {
			System.out.println("No se han encontrado palabras clave en el texto");
		} else {
			System.out.println("Palabras encontradas: ");
			for (int i = 0; i < encontradas.length; i++) {
				System.out.print(String.join(", ", encontradas));
				if (i < encontradas.length - 1) {
					System.out.print(", ");
				}
			}
		}
	}

}
