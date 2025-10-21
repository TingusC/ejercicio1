package es.etg.dam.acceso_datos.otras_clases;

import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {
    public GestionContenido() {
        super();
    }
    
    @Override
    public void startDocument(){ 
        System.out.println("Comienzo del documento XML");
    }

    @Override
    public void endDocument(){ 
        System.out.println("Fin del documento XML");
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud){ 
        String car=new String(ch, inicio, longitud);
        car=car.replaceAll("[\t\n]", ""); 
        System.out.println("\t\t"+ car);
    }
}
