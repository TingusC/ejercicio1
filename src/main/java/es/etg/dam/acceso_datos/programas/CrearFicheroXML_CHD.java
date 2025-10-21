package es.etg.dam.acceso_datos.programas;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class CrearFicheroXML_CHD {
    public static final String MSG_FINAL_ARCHIVO = "Alcanzado el final del archivo";

    public static final String NOMBRE_RAIZ = "Jugadores";
    public static final String NOMBRE_ETIQUETA = "Jugador";
    public static final String[] NOMBRES_ATRIBUTOS = {"codigo", "nombre", "equipo", "PXP", "activo"};

    public static final String ARCHIVO = "src/main/resources/ficheros/jugadores.dat";
    public static final String ARCHIVO_XML = "src/main/resources/ficheros/Jugadores.xml";
    public static final String PERMISOS_ARCHIVO = "r";
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
        try(RandomAccessFile archivo = new RandomAccessFile(ARCHIVO, PERMISOS_ARCHIVO))
        {
            
            Document documento = crear();
            crearElementos(archivo, documento);
            transformar(documento, ARCHIVO_XML);

        }
        catch(EOFException e)
        {
            System.out.println(MSG_FINAL_ARCHIVO);
        }
        
    }    
    

    public static Document crear() throws ParserConfigurationException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementacion = builder.getDOMImplementation();
        Document ret = implementacion.createDocument(null, NOMBRE_RAIZ, null);

        return ret;
    }

    public static void crearAtributo(String nombre, String valor, Element raiz, Document documento)
    {
        Element elemento = documento.createElement(nombre);
        raiz.appendChild(elemento);
        elemento.appendChild(documento.createTextNode(valor));
    }

    public static void crearJugador(Document documento, Element raiz, int codigo, String nombre, String equipo, float puntosXPartido, boolean activo)
    {
        crearAtributo(NOMBRES_ATRIBUTOS[0], Integer.toString(codigo), raiz, documento);
        crearAtributo(NOMBRES_ATRIBUTOS[1], nombre, raiz, documento);
        crearAtributo(NOMBRES_ATRIBUTOS[2], equipo, raiz, documento);
        crearAtributo(NOMBRES_ATRIBUTOS[3], Float.toString(puntosXPartido), raiz, documento);
        crearAtributo(NOMBRES_ATRIBUTOS[4], Boolean.toString(activo), raiz, documento);
    }

    public static void crearElementos(RandomAccessFile archivo, Document documento) throws IOException
    {
        long posicionInicio = 0;
        while(posicionInicio < archivo.length())
        {
            archivo.seek(posicionInicio);

            int codigo = archivo.readInt();
            String nombre = archivo.readUTF();
            String equipo = archivo.readUTF();
            float puntosXPartido = archivo.readFloat();
            boolean activo = archivo.readBoolean();

            Element ret = documento.createElement(NOMBRE_ETIQUETA);

            documento.getDocumentElement().appendChild(ret);

            crearJugador(documento, ret, codigo, nombre, equipo, puntosXPartido, activo);

            posicionInicio = archivo.getFilePointer();
        }
    }

    public static void transformar(Document documento, String ruta) throws TransformerFactoryConfigurationError, TransformerException
    {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        Source source = new DOMSource(documento);
        Result resultado = new StreamResult(new File(ruta));
        transformer.transform(source, resultado);
    }
}
