package com.seitasks.Menu;
/**
 *
 * @author Gabriel
 */
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class GuardarTarea {
    public static void guardarEnJson(Tarea tarea, String rutaArchivo) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(tarea, writer);
            System.out.println("Tarea guardada correctamente en " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la tarea:");
        }
    }
}