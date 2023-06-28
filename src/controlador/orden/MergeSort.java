package controlador.orden;

import controlador.listas.ListaEnlazada;

/**
 *
 * @author Juan_fer
 */
public class MergeSort {

    // Método principal que inicia el algoritmo de Merge Sort
    public static ListaEnlazada<Integer> mergeSort(ListaEnlazada<Integer> lista, int tipo) throws Exception {
        // Verificar si la lista tiene tamaño menor o igual a 1, en cuyo caso ya está ordenada
        if (lista.size() <= 1) {
            return lista;
        }

        // Calcular el índice medio de la lista
        int medio = lista.size() / 2;

        // Crear dos nuevas listas enlazadas para almacenar las mitades izquierda y derecha
        ListaEnlazada<Integer> mitadIzquierda = new ListaEnlazada<>();
        ListaEnlazada<Integer> mitadDerecha = new ListaEnlazada<>();

        // Llenar la mitad izquierda con los elementos correspondientes
        for (int i = 0; i < medio; i++) {
            mitadIzquierda.insertarNodo(lista.get(i));
        }

        // Llenar la mitad derecha con los elementos correspondientes
        for (int i = medio; i < lista.size(); i++) {
            mitadDerecha.insertarNodo(lista.get(i));
        }

        // Llamada recursiva para ordenar las mitades izquierda y derecha
        mitadIzquierda = mergeSort(mitadIzquierda, tipo);
        mitadDerecha = mergeSort(mitadDerecha, tipo);

        // Combinar y ordenar las mitades ordenadas
        return merge(mitadIzquierda, mitadDerecha, tipo);
    }

    // Método privado para combinar y ordenar dos listas ordenadas
    private static ListaEnlazada<Integer> merge(ListaEnlazada<Integer> listaIzquierda, ListaEnlazada<Integer> listaDerecha, int tipo) throws Exception {
        // Crear una nueva lista enlazada para almacenar los elementos ordenados
        ListaEnlazada<Integer> listaOrdenada = new ListaEnlazada<>();

        // Comparar los elementos de las dos listas y agregarlos a listaOrdenada en el orden correcto
        while (!listaIzquierda.isEmpty() && !listaDerecha.isEmpty()) {
            if (tipo == 0) { // Ascendente
                if (listaIzquierda.get(0) <= listaDerecha.get(0)) {
                    listaOrdenada.insertarNodo(listaIzquierda.get(0));
                    listaIzquierda.delete(0);
                } else {
                    listaOrdenada.insertarNodo(listaDerecha.get(0));
                    listaDerecha.delete(0);
                }
            } else { // Descendente
                if (listaIzquierda.get(0) >= listaDerecha.get(0)) {
                    listaOrdenada.insertarNodo(listaIzquierda.get(0));
                    listaIzquierda.delete(0);
                } else {
                    listaOrdenada.insertarNodo(listaDerecha.get(0));
                    listaDerecha.delete(0);
                }
            }
        }

        // Agregar los elementos restantes de la mitad izquierda a listaOrdenada
        while (!listaIzquierda.isEmpty()) {
            listaOrdenada.insertarNodo(listaIzquierda.get(0));
            listaIzquierda.delete(0);
        }

        // Agregar los elementos restantes de la mitad derecha a listaOrdenada
        while (!listaDerecha.isEmpty()) {
            listaOrdenada.insertarNodo(listaDerecha.get(0));
            listaDerecha.delete(0);
        }

        // Devolver la lista enlazada ordenada
        return listaOrdenada;
    }
}
