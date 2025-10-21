package es.etg.dam.acceso_datos.programas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ConvertirFicheroXML_CHD {
    public static final String ESTILOS_XSL = "src/main/resources/plantillas/Plantilla.xsl";

    public static final String ARCHIVO_XML = "src/main/resources/ficheros/Jugadores.xml";
    public static final String ARCHIVO_HTML = "src/main/resources/ficheros/Jugadores.html";
    
    public static void main(String[] args) throws TransformerFactoryConfigurationError, TransformerException, IOException {

        File html = new File(ARCHIVO_HTML);
        FileOutputStream out = new FileOutputStream(html);

        Source plantilla = new StreamSource(ESTILOS_XSL);
        Source datos = new StreamSource(ARCHIVO_XML);
        Result resultado = new StreamResult(out);


        Transformer transformer = TransformerFactory.newInstance().newTransformer(plantilla);
        transformer.transform(datos, resultado);

        out.close();
    }
}
