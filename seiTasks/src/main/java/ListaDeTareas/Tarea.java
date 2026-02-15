package ListaDeTareas;

/**
 *
 * @author Gabriel
 */
public class Tarea {
    private String nombre;
    private int prioridad;
    private boolean completada;

    public Tarea(String nombre, int prioridad, boolean completada) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completada = completada;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
