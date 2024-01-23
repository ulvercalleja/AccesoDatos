package practica6;

import java.util.Scanner;

public class Leer {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número entero válido.");
            scanner.next();
        }
        int resultado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer después de leer el entero
        return resultado;
    }
}
