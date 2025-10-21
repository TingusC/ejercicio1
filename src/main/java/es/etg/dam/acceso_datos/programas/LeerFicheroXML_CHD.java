package es.etg.dam.acceso_datos.programas;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import es.etg.dam.acceso_datos.otras_clases.GestionContenido;

public class LeerFicheroXML_CHD {

    public static final String ARCHIVO_XML = "src/main/resources/ficheros/Jugadores.xml";

    public static void main(String[] args) throws IOException {
        try
        {
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser parser = factory.newSAXParser();
                    GestionContenido gestor = new GestionContenido();
                    parser.parse(ARCHIVO_XML, gestor);
        }
        catch(ParserConfigurationException | SAXException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
