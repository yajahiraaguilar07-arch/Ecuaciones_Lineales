import java.util.Scanner;

/**
 * Clase principal del programa.
 * Practica: Metodo de Gauss-Jordan
 * Alumna: Yajahira Aguilar
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   METODO DE GAUSS-JORDAN - JAVA");
        System.out.println("       Yajahira Aguilar");
        System.out.println("========================================");

        try {
            int n = EntradaDatos.leerTamano(scanner);
            double[][] matriz = EntradaDatos.leerMatriz(scanner, n);

            System.out.println("\nMatriz aumentada ingresada:");
            Gauss.imprimirMatriz(matriz);

            double[] solucion = GaussJordan.resolver(matriz);

            if (solucion != null) {
                System.out.println("\nSolucion del sistema:");
                Gauss.imprimirSolucion(solucion);
            } else {
                System.out.println(
                    "\nEl sistema no tiene solucion unica."
                );
            }

        } catch (IllegalArgumentException e) {
            System.out.println(
                "\nNo se pudo resolver el sistema: "
                + e.getMessage()
            );
        } finally {
            scanner.close();
        }
    }
]
}
