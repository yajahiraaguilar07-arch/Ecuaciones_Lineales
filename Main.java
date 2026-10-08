import java.util.Scanner;

/**
 * Clase principal del programa.
 * Práctica: Método de Gauss
 * Alumna: Yajahira Aguilar
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("       MÉTODO DE GAUSS - JAVA");
        System.out.println("       Yajahira Aguilar");
        System.out.println("========================================");

        int n = EntradaDatos.leerTamano(scanner);
        double[][] matriz = EntradaDatos.leerMatriz(scanner, n);

        System.out.println("\nMatriz aumentada ingresada:");
        Gauss.imprimirMatriz(matriz);

        try {
            Gauss.eliminacion(matriz);

            System.out.println("\nMatriz después de la eliminación:");
            Gauss.imprimirMatriz(matriz);

            double[] solucion = Gauss.sustitucionRegresiva(matriz);

            System.out.println("\nSolución del sistema:");
            Gauss.imprimirSolucion(solucion);

        } catch (IllegalArgumentException e) {
            System.out.println("\nNo se pudo resolver el sistema: " + e.getMessage());
        }

        scanner.close();
    }
}
