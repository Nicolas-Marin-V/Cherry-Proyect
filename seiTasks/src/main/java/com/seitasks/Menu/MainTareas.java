package com.seitasks.Menu;
import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class MainTareas {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("SeiTasks");

        ventana.setContentPane(new Menu());
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack(); 
        ventana.setLocationRelativeTo(null); 
        ventana.setVisible(true); 
    }
}