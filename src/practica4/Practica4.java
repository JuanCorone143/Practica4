
package practica4;
import controlador.exception.PositionException;
import controlador.listas.ListaEnlazada;
import controlador.orden.MergeSort;
import controlador.orden.QuickSort;
import java.util.Random;


/**
 *
 * @author juan_fer
 */
public class Practica4 {

    public static void main(String[] args) throws PositionException {
        // Crear una lista enlazada con valores aleatorios del 1 al 100
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        Random random = new Random();

        System.out.println("Lista desordenada:");
        for (int i = 0; i < 100; i++) {
            int valor = random.nextInt(100) + 1; // Generar un valor aleatorio entre 1 y 100
            lista.insertarNodo(valor);
            System.out.print(valor + " ");
        }
        System.out.println();
        
        ////MergeSort////

        try {
            // Llamar al método mergeSort para ordenar la lista en forma ascendente
            ListaEnlazada<Integer> listaOrdenada = MergeSort.mergeSort(lista, 0);

            // Imprimir la lista ordenada en forma ascendente
            System.out.println("Lista ordenada en forma ascendente MergeSort:");
            for (int i = 0; i < listaOrdenada.size(); i++) {
                System.out.print(listaOrdenada.get(i) + " ");
            }
            System.out.println();

            // Llamar al método mergeSort para ordenar la lista en forma descendente
            listaOrdenada = MergeSort.mergeSort(lista, 1);

            // Imprimir la lista ordenada en forma descendente
            System.out.println("Lista ordenada en forma descendente MergeSort:");
            for (int i = 0; i < listaOrdenada.size(); i++) {
                System.out.print(listaOrdenada.get(i) + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        /// QuickSort   /////
        try {
            // Ordenar la lista utilizando quickSort en orden ascendente
            ListaEnlazada<Integer> listaAscendente = QuickSort.quickSort(lista, 0); // Orden ascendente, tipo = 0

            System.out.println("Lista ordenada ascendente QuickSort:");
            listaAscendente.imprimir();

            // Ordenar la lista utilizando quickSort en orden descendente
            ListaEnlazada<Integer> listaDescendente = QuickSort.quickSort(lista, 1); // Orden descendente, tipo = 1

            System.out.println("Lista ordenada descendente QuickSort:");
            listaDescendente.imprimir();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        
        }

    }
        
    
}
