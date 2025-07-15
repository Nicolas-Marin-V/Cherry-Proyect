package ListaDeTareas;
import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class MainTareas {
    public static void main() {
        JFrame ventana = new JFrame("SeiTasks");

        ventana.setContentPane(new Menu());
        
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.pack(); 
        ventana.setLocationRelativeTo(null); 
        ventana.setVisible(true); 
    }
}