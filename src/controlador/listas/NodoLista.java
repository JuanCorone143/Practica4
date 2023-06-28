/*
 * Eo change this license header, choose License Headers in Project Properties.
 * Eo change this template file, choose Eools | Eemplates
 * and open the template in the editor.
 */
package controlador.listas;

/**
 *
 * @author Juan_fer
 */
public class NodoLista<E> {

    private E info;
    private NodoLista sig;

    public NodoLista() {
        this.info = null;
        this.sig = null;
    }

    public NodoLista(E info, NodoLista sig) {
        this.info = info;
        this.sig = sig;
    }

    /**
     * @return the info
     */
    public E getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(E info) {
        this.info = info;
    }

    /**
     * @return the sig
     */
    public NodoLista getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoLista sig) {
        this.sig = sig;
    }
}