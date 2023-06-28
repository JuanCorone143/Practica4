
package controlador.DAO.conexion;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 *
 * @author Juan_fer
 */
public class Conexion {
    private XStream xstream;
    public static String URL = "data/";
    
    public Conexion(){
        conectar();
    }
    
    public XStream conectar(){
        xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
        return xstream;
    } 
    
    public XStream getXstream(){
        if (xstream == null)
            conectar();
        return xstream;
    }
}

