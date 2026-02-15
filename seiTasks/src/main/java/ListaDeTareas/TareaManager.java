package ListaDeTareas;

/**
 *
 * @author Gabriel
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
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
        File archivo = new File(Archivo);

        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(archivo)) {
            if (archivo.length() == 0) {
                return new ArrayList<>();
            }

            Type listType = new TypeToken<List<Tarea>>() {}.getType();
            List<Tarea> tareas = gson.fromJson(reader, listType);

            if (tareas == null) {
                return new ArrayList<>();
            }

            return ordenarPrioridad(tareas);

        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
    private static List<Tarea> ordenarPrioridad(List<Tarea> tareas) {
        minHeap(tareas);
        int n = tareas.size();
        List<Tarea> resultado = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Tarea min = tareas.get(0);
            resultado.add(min);

            tareas.set(0, tareas.get(tareas.size() - 1));
            tareas.remove(tareas.size() - 1);

            heapify(tareas, tareas.size(), 0);
        }
        return resultado;
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
    
    public static boolean eliminarTareaIndice(int index) throws IOException {
        List<Tarea> tareas = cargarTareas();

        if (index >= 0 && index < tareas.size()) {
            tareas.remove(index);
            guardarTareas(tareas);
            return true;
        }return false;
    }

    public static boolean marcarCompletadaIndice(int index) throws IOException {
        List<Tarea> tareas = cargarTareas();

        if (index >= 0 && index < tareas.size()) {
            Tarea tarea = tareas.get(index);
            tarea.setCompletada(true);
            guardarTareas(tareas);
            return true;
        }
        return false;
    }

    private static void heapify(List<Tarea> tareas, int n, int i) {
        int menor = i;
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        if (izquierda < n && tareas.get(izquierda).getPrioridad() < tareas.get(menor).getPrioridad()) {
            menor = izquierda;
        }

        if (derecha < n && tareas.get(derecha).getPrioridad() < tareas.get(menor).getPrioridad()) {
            menor = derecha;
        }

        if (menor != i) {
            Tarea temp = tareas.get(i);
            tareas.set(i, tareas.get(menor));
            tareas.set(menor, temp);
            heapify(tareas, n, menor);
        }
    }

    private static void minHeap(List<Tarea> tareas) {
        int n = tareas.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(tareas, n, i);
        }
    }

}
