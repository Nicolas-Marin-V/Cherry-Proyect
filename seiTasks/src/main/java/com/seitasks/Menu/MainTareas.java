package com.seitasks.Menu;
import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class MainTareas {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mi Aplicación");

        ventana.setContentPane(new Menu());
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack(); 
        ventana.setLocationRelativeTo(null); 
        ventana.setVisible(true); 
        
        // Crear una tarea
        Tarea tarea = new Tarea("Estudiar para examen", 1, false);

        // Guardarla en JSON
        GuardarTarea.guardarEnJson(tarea, "tarea.json");

        // Leerla desde JSON
        Tarea tareaLeida = LeerTarea.leerDesdeJson("tarea.json");

        // Mostrar los datos
        if (tareaLeida != null) {
            System.out.println("Nombre: " + tareaLeida.getNombre());
            System.out.println("Prioridad: " + tareaLeida.getPrioridad());
            System.out.println("Completada: " + tareaLeida.isCompletada());
        }
    }
}