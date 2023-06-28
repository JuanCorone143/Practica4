/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.exception;

/**
 *
 * @author Juan_fer
 */
public class SpaceException extends Exception{

    public SpaceException() {
        super("Espacio Lleno o posicion no valida");
    }

    public SpaceException(String message) {
        super(message);
    }
    
}
