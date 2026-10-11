/**
 * Practica: Metodo de Gauss-Jordan
 * Alumna: Yajahira Aguilar
 */
public class GaussJordan {

    public static double[] resolver(double[][] matriz) {
        int n = matriz.length;

        for (int i = 0; i < n; i++) {
            int pivote = i;

            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matriz[k][i]) >
                    Math.abs(matriz[pivote][i])) {
                    pivote = k;
                }
            }

            if (Math.abs(matriz[pivote][i]) < 1e-10) {
                System.out.println("El sistema no tiene solucion unica.");
                return null;
            }

            double[] temporal = matriz[i];
            matriz[i] = matriz[pivote];
            matriz[pivote] = temporal;

            double divisor = matriz[i][i];

            for (int j = 0; j <= n; j++) {
                matriz[i][j] /= divisor;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];

                    for (int j = 0; j <= n; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }

        double[] solucion = new double[n];

        for (int i = 0; i < n; i++) {
            solucion[i] = matriz[i][n];
        }

        return solucion;
    }
}
