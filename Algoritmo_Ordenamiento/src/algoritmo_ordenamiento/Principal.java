package algoritmo_ordenamiento;

import java.util.Arrays;

public class Principal {

    // Prueba rapida en consola
    public static void main(String[] args) {
        int[] datos = {64, 34, 25, 12, 22, 11, 90, 5};

        System.out.println("Arreglo original: " + Arrays.toString(datos));
        MergeSort.ordenar(datos);
        System.out.println("Arreglo ordenado: " + Arrays.toString(datos));
    }
}
