
package Controlador.DAO;


import controlador.DAO.conexion.Conexion;
import controlador.exception.PositionException;
import controlador.listas.ListaEnlazada;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 *
 * @author Juan_fer
 */
public class AdaptadorDAO<T> {
    private Conexion conexion;
    private Class clazz;
    private String url;
    public static Integer Ascendente = 0;
    public static Integer Descendente = 1;

    public AdaptadorDAO(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    public void guardar(T obj) throws IOException {
        ListaEnlazada<T> lista = listar();
        lista.insertarNodo(obj);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    public void modificar(T obj, Integer pos) {
        ListaEnlazada<T> lista = listar();
        try {
            lista.modificar(obj, pos);
            conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
            conexion.getXstream().toXML(lista, new FileWriter(url));
        } catch (PositionException | IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

    public ListaEnlazada listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            lista = (ListaEnlazada<T>) conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return lista;
    }

    public T obtener(Integer id) {
        T obj = null;
        ListaEnlazada<T> lista = listar();
        
        for (int i = 0; i < lista.size(); i++) {
            try {
                T dato = lista.get(i);
                if (id.intValue() == ((Integer) getValueField(lista.get(i))).intValue()) {
                    obj = dato;
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error en el metodo " + e);
            }
        }
        return obj;

    }   

    private Object getValueField(T dato) throws Exception {
        Method metodo = null;
        for (Method aux : this.clazz.getDeclaredMethods()) {
            if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                metodo = aux;

            }
        }

        
        if (metodo == null) {
            for (Method aux : this.clazz.getSuperclass().getDeclaredMethods()) {
                if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                    metodo = aux;
                }
            }

        }
        return metodo.invoke(dato);
    }

     public Integer generarId() {
        return listar().size() + 1;
    }
    
}

