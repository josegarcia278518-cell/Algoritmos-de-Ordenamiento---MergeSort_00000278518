package algoritmo_ordenamiento;

public class MergeSort {

    // Metodo inicial: Se valida el arreglo y se inicia con todo el rango (del indice 0 al ultimo indice valido)
    public static void ordenar(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return;
        }
        mergeSort(arreglo, 0, arreglo.length - 1);
    }

    // Parte recursiva: Se parte a la mitad el rango actual hasta tener piezas de 1 solo numero
    private static void mergeSort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            // Se ordena la mitad izquierda - {64, 34, 25, 12} queda como [12, 25, 34, 64]
            mergeSort(arreglo, izquierda, medio);

            // Se ordena la mitad derecha - {22, 11, 90, 5} queda como [5, 11, 22, 90]
            mergeSort(arreglo, medio + 1, derecha);

            // Se unen ambas mitades para que quede el arreglo final [5, 11, 12, 22, 25, 34, 64, 90]
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    // Metodo de mezcla: compara ambas partes y las sobreescribe en orden
    private static void merge(int[] arreglo, int izquierda, int medio, int derecha) {
        int tamanoIzq = medio - izquierda + 1;
        int tamanoDer = derecha - medio;

        // 1. Se respaldan las dos mitades en temporales - subIzq [12, 25, 34, 64] y subDer [5, 11, 22, 90]
        int[] subIzq = new int[tamanoIzq];
        int[] subDer = new int[tamanoDer];

        for (int i = 0; i < tamanoIzq; i++) {
            subIzq[i] = arreglo[izquierda + i];
        }
        for (int j = 0; j < tamanoDer; j++) {
            subDer[j] = arreglo[medio + 1 + j];
        }

        // 2. Se compara y se inserta el menor de cada lado - 5 < 12 mete el 5, luego 11 < 12 mete el 11...
        int i = 0, j = 0, k = izquierda;
        while (i < tamanoIzq && j < tamanoDer) {
            if (subIzq[i] <= subDer[j]) {
                arreglo[k] = subIzq[i];
                i++;
            } else {
                arreglo[k] = subDer[j];
                j++;
            }
            k++;
        }

        // 3. Se vacian los numeros restantes de subIzq si sobraron - pasa directo el 64
        while (i < tamanoIzq) {
            arreglo[k] = subIzq[i];
            i++;
            k++;
        }

        // Se vacian los restantes de subDer si sobraron - pasa directo el 90
        while (j < tamanoDer) {
            arreglo[k] = subDer[j];
            j++;
            k++;
        }
    }
}
