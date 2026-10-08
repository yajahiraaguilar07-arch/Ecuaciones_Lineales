/**
 * Contiene las operaciones del Método de Gauss para resolver
 * sistemas de ecuaciones lineales.
 *
 * Alumna: Yajahira Aguilar
 */
public class Gauss {

    private static final double EPSILON = 1e-10;

    /**
     * Realiza la eliminación de Gauss con pivoteo parcial.
     */
    public static void eliminacion(double[][] matriz) {
        int n = matriz.length;

        for (int columna = 0; columna < n; columna++) {

            int filaPivote = columna;

            for (int fila = columna + 1; fila < n; fila++) {
                if (Math.abs(matriz[fila][columna])
                        > Math.abs(matriz[filaPivote][columna])) {
                    filaPivote = fila;
                }
            }

            if (Math.abs(matriz[filaPivote][columna]) < EPSILON) {
                throw new IllegalArgumentException(
                        "El sistema no tiene una solución única.");
            }

            intercambiarFilas(matriz, columna, filaPivote);

            for (int fila = columna + 1; fila < n; fila++) {
                double factor =
                        matriz[fila][columna] / matriz[columna][columna];

                for (int j = columna; j <= n; j++) {
                    matriz[fila][j] -= factor * matriz[columna][j];
                }
            }
        }
    }

    /**
     * Obtiene las incógnitas mediante sustitución regresiva.
     */
    public static double[] sustitucionRegresiva(double[][] matriz) {
        int n = matriz.length;
        double[] x = new double[n];

        for (int i = n - 1; i >= 0; i--) {
            double suma = matriz[i][n];

            for (int j = i + 1; j < n; j++) {
                suma -= matriz[i][j] * x[j];
            }

            if (Math.abs(matriz[i][i]) < EPSILON) {
                throw new IllegalArgumentException(
                        "El sistema no tiene una solución única.");
            }

            x[i] = suma / matriz[i][i];
        }

        return x;
    }

    private static void intercambiarFilas(
            double[][] matriz, int fila1, int fila2) {

        if (fila1 == fila2) {
            return;
        }

        double[] temporal = matriz[fila1];
        matriz[fila1
