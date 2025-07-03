package com.seitasks.encuesta;

import javax.swing.JFrame;

/**
 *
 * @author Nicolas Marin
 */
public class MainEncuesta {
    
    public static void main(int i) {
        JFrame ventana = new JFrame("SeiTasks");
        ventana.setContentPane(new Encuesta(i));

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }


}
