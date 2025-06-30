package com.seitasks.Menu;
/**
 *
 * @author Gabriel
 */
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class LeerTarea {
    public static Tarea leerDesdeJson(String rutaArchivo) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(rutaArchivo)) {
            Tarea tarea = gson.fromJson(reader, Tarea.class);
            System.out.println("Tarea leída correctamente desde " + rutaArchivo);
            return tarea;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON:");
            return null;
        }
    }
}
