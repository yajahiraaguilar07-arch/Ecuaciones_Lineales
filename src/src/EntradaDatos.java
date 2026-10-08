import java.util.Scanner;

/**
 * Clase encargada de leer los datos introducidos por el usuario.
 *
 * Alumna: Yajahira Aguilar
 */
public class EntradaDatos {

    public static int leerTamano(Scanner scanner) {
        int n;

        do {
            System.out.print("Ingresa el número de ecuaciones (n > 0): ");
            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("El tamaño debe ser mayor que cero.");
            }
        } while (n <= 0);

        return n;
    }

    /**
     * Lee una matriz aumentada de tamaño n x (n+1).
     */
    public static double[][] leerMatriz(Scanner scanner, int n) {
        double[][] matriz = new double[n][n + 1];

        System.out.println("\nIngresa los coeficientes de la matriz aumentada.");
        System.out.println("En cada fila escribe primero los coeficientes");
        System.out.println("y al final el término independiente.");

        for (int i = 0; i < n; i++) {
            System.out.println("\nEcuación " + (i + 1) + ":");

            for (int j = 0; j <= n; j++) {
                if (j == n) {
                    System.out.print("b = ");
                } else {
                    System.out.print("a" + (i + 1) + (j + 1) + " = ");
                }

                matriz[i][j] = scanner.nextDouble();
            }
        }

        return matriz;
    }
}
