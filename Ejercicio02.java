package repaso;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		
		double incremento=0.5;
		
		double notas[]=new double[30];
		
		for(int i=0;i<notas.length;i++) {
			double aleatorio= Math.random()*10;
			notas[i]=Math.round(aleatorio*100)/100.0;
			
		}
		
		System.out.println("Notas de la clase");
		System.out.println(Arrays.toString(notas));
		
		double media=calcularMedia(notas);
		System.out.println("--------");
		System.out.println("Nota media: "+media);
		
		double maxima=notaMaxima(notas);
		System.out.println("--------");
		System.out.println("Nota máxima: "+maxima);
		
		int aprobados=contarAprobados(notas);
		System.out.println("--------");
		System.out.println("Número de aprobados: "+ aprobados);
		
		subirNotas(notas,incremento);
		
		
	

	}

	/*
	 * Calcula la media de las notas
	 * @param notas, el array que contiene las notas
	 * @return notaMedia, la nota media de la clase
	 * */
	static double calcularMedia(double[] notas) {
		
		double notaMedia=0.0;
		double suma = 0;
		
		for(int i=0;i<notas.length;i++) {
			suma+=notas[i];
		}
		notaMedia= suma/notas.length;
		
		return  notaMedia;
	}

	static double notaMaxima(double[] notas) {
		
		double notaMayor=0.00;
		
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] > notaMayor) {
				notaMayor = notas[i];
			}
		}
		
		return notaMayor;
		
	}
	static int contarAprobados(double[] notas) {
		
		int aprobados=0;
		
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= 5) {
				aprobados++;
			}
		}
		return aprobados;
	}

	static void subirNotas(double[] notas, double incremento) {
		
		double notasIncrementadas[]=new double[notas.length];
		
		for(int i=0;i<notas.length;i++) {
			notasIncrementadas[i]=notas[i];
			notasIncrementadas[i]+=incremento;
			
			if(notasIncrementadas[i]>10) {
				notasIncrementadas[i]=10;
			}
		}
		System.out.println("---------");
		System.out.println("Notas incrementadas: "+ Arrays.toString(notasIncrementadas));
	}

}

