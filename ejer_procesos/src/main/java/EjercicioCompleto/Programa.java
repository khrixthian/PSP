package EjercicioCompleto;

import java.util.Scanner;

public class Programa {

	static String texto=""; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Escribe un texto: ");
		texto=sc.nextLine();
		System.out.println("Texto Introducido: "+texto);

	}

}
