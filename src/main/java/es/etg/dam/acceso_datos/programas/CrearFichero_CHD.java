package es.etg.dam.acceso_datos.programas;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CrearFichero_CHD {
    public static final String ARCHIVO = "src/main/resources/ficheros/jugadores.dat";

    public static final int[] CODIGOS = {1, 2, 3, 4, 5};
    public static final String[] NOMBRES = {"LeBron James", "Michael Jordan", "Nikola Jokic", "Kobe Bryant", "Derrick Rose"};
    public static final String[] EQUIPOS = {"Cavaliers", "Bulls", "Nuggets", "Lakers", "Bulls"};
    public static final float[] PUNTOS_X_PARTIDO = {27.0f, 30.1f, 21.8f, 25.0f, 17,4f};
    public static final boolean[] ACTIVOS = {true, false, true, false, false};

    public static final String MSG_CREADO = "Fichero creado";
    
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(ARCHIVO));
        for(int i = 0; i < CODIGOS.length; i++)
        {
            escribir(out, CODIGOS[i],NOMBRES[i], EQUIPOS[i], PUNTOS_X_PARTIDO[i],ACTIVOS[i]);
        }
        System.out.println(MSG_CREADO);
    }

    private static void escribir(DataOutputStream out, int codigo, String nombre, String equipo, float puntosXPartido, boolean activo) throws IOException
    {
        out.writeInt(codigo);
        out.writeUTF(nombre);
        out.writeUTF(equipo);
        out.writeFloat(puntosXPartido);
        out.writeBoolean(activo);
    }
}