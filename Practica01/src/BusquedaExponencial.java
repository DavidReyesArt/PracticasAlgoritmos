/**
 * Implementación de Búsqueda Exponencial en Java
 * 
 * Precondiciones:
 * - El arreglo debe estar ordenado en orden ascendente
 * - El arreglo no debe ser null
 */
public class ExponentialSearch {

    /**
     * Realiza una búsqueda binaria en el subarreglo especificado
     * 
     * @param arr arreglo ordenado
     * @param left límite inferior del subarreglo
     * @param right límite superior del subarreglo
     * @param target elemento a buscar
     * @return índice del elemento si se encuentra, -1 si no
     */
    private static int binarySearch(int[] arr, int left, int right, int target) {
        System.out.printf("Realizando búsqueda binaria en rango [%d, %d]%n", left, right);
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.printf("Iteración - Índice medio: %d, Valor: %d%n", mid, arr[mid]);
            
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Realiza una búsqueda exponencial en el arreglo
     * 
     * @param arr arreglo ordenado donde buscar
     * @param target elemento a buscar
     * @return índice del elemento si se encuentra, -1 si no
     */
    public static int exponentialSearch(int[] arr, int target) {
        System.out.println("\nIniciando búsqueda exponencial...");
        
        // Si el elemento está en la primera posición
        if (arr[0] == target) {
            System.out.println("Elemento encontrado en la primera posición (índice 0)");
            return 0;
        }
        
        // Encontrar el rango para la búsqueda binaria
        int i = 1;
        System.out.printf("Fase exponencial - Comparando en índice: %d%n", i);
        while (i < arr.length && arr[i] <= target) {
            System.out.printf("Fase exponencial - Índice actual: %d, Valor: %d%n", i, arr[i]);
            i *= 2;
            if (i < arr.length) {
                System.out.printf("Fase exponencial - Siguiente índice a comparar: %d%n", i);
            } else {
                System.out.println("Fase exponencial - Índice excede el tamaño del arreglo");
            }
        }
        
        // Realizar búsqueda binaria en el rango encontrado
        int left = i / 2;
        int right = Math.min(i, arr.length - 1);
        System.out.printf("Rango determinado para búsqueda binaria: [%d, %d]%n", left, right);
        
        return binarySearch(arr, left, right, target);
    }

    public static void main(String[] args) {
        // Prueba del algoritmo
        int[] sortedArray = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        int target = 18;
        
        System.out.println("Arreglo ordenado: " + java.util.Arrays.toString(sortedArray));
        System.out.println("Buscando elemento: " + target);
        
        long startTime = System.nanoTime();
        int result = exponentialSearch(sortedArray, target);
        long endTime = System.nanoTime();
        
        if (result == -1) {
            System.out.println("Elemento no encontrado en el arreglo");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
        
        System.out.printf("Tiempo de ejecución: %d nanosegundos%n", (endTime - startTime));
        
        // Prueba con elemento no presente
        target = 25;
        System.out.println("\nBuscando elemento: " + target);
        
        startTime = System.nanoTime();
        result = exponentialSearch(sortedArray, target);
        endTime = System.nanoTime();
        
        if (result == -1) {
            System.out.println("Elemento no encontrado en el arreglo");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
        
        System.out.printf("Tiempo de ejecución: %d nanosegundos%n", (endTime - startTime));
    }
}
