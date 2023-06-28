package controlador.orden;

import controlador.listas.ListaEnlazada;

/**
 *
 * @author Juan_fer
 */
public class QuickSort {

    public static ListaEnlazada<Integer> quickSort(ListaEnlazada<Integer> lista, int tipo) throws Exception {
        if (lista.size() <= 1) {
            return lista; // Si la lista tiene tamaño 0 o 1, no se necesita ordenar, por lo que se devuelve tal cual.
        }

        int pivotIndex = lista.size() / 2; // Se selecciona un índice pivote en el medio de la lista.
        int pivotValue = lista.get(pivotIndex); // Se obtiene el valor del pivote.
        ListaEnlazada<Integer> lesser = new ListaEnlazada<>(); // Lista para almacenar los valores menores al pivote.
        ListaEnlazada<Integer> greater = new ListaEnlazada<>(); // Lista para almacenar los valores mayores al pivote.

        for (int i = 0; i < lista.size(); i++) {
            if (i == pivotIndex) {
                continue; // Se salta el índice del pivote durante el proceso de partición.
            }
            int value = lista.get(i);
            if (tipo == 0 && value <= pivotValue) {
                lesser.insertarNodo(value); // Si el tipo es 0 y el valor es menor o igual al pivote, se agrega a la lista de menores.
            } else if (tipo == 1 && value >= pivotValue) {
                lesser.insertarNodo(value); // Si el tipo es 1 y el valor es mayor o igual al pivote, se agrega a la lista de menores.
            } else {
                greater.insertarNodo(value); // Si no cumple ninguna de las condiciones anteriores, se agrega a la lista de mayores.
            }
        }

        lesser = quickSort(lesser, tipo); // Se aplica el algoritmo de QuickSort de forma recursiva en la lista de menores.
        greater = quickSort(greater, tipo); // Se aplica el algoritmo de QuickSort de forma recursiva en la lista de mayores.

        ListaEnlazada<Integer> sortedList = new ListaEnlazada<>(); // Lista para almacenar la lista ordenada.
        for (int i = 0; i < lesser.size(); i++) {
            sortedList.insertarNodo(lesser.get(i)); // Se agregan los elementos de la lista de menores a la lista ordenada.
        }
        sortedList.insertarNodo(pivotValue); // Se agrega el pivote a la lista ordenada.
        for (int i = 0; i < greater.size(); i++) {
            sortedList.insertarNodo(greater.get(i)); // Se agregan los elementos de la lista de mayores a la lista ordenada.
        }

        return sortedList; // Se devuelve la lista ordenada.
    }
}
