package com.seitasks.Menu;
/**
 *
 * @author Gabriel
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TareaManager {
    private static final String Archivo = "tareas.json";
    private static final Gson gson = new Gson();

    public static List<Tarea> cargarTareas() {
        try (FileReader reader = new FileReader(Archivo)) {
            Type listType = new TypeToken<List<Tarea>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void guardarTareas(List<Tarea> tareas) throws IOException {
        try (FileWriter writer = new FileWriter(Archivo)) {
            gson.toJson(tareas, writer);
        } 
    }

    public static void agregarTarea(Tarea nuevaTarea) throws IOException {
        List<Tarea> tareas = cargarTareas();
        tareas.add(nuevaTarea);
        guardarTareas(tareas);
    }
    
    public static boolean eliminarTareaPorNombre(String nombre) throws IOException {
    List<Tarea> tareas = cargarTareas();
    boolean eliminada = tareas.removeIf(t -> t.getNombre().equalsIgnoreCase(nombre));

    if (eliminada) {
        guardarTareas(tareas);
    }return eliminada;}
    
    public static boolean marcarComoCompletadaPorIndice(int index) throws IOException {
    List<Tarea> tareas = cargarTareas();

    if (index >= 0 && index < tareas.size()) {
        Tarea tarea = tareas.get(index);
        tarea.setCompletada(true);
        guardarTareas(tareas);
        return true;
    }
    return false;
}

    
}
