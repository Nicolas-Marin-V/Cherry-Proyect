/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seitasks.Pomodoro;

import com.seitasks.Menu.Menu;
import javax.swing.JFrame;

/**
 *
 * @author Nicolas Marin
 */
public class MainPomodoro {
        public static void main() {
        JFrame ventana = new JFrame("SeiTasks");

        ventana.setContentPane(new Pomodoro());
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack(); 
        ventana.setLocationRelativeTo(null); 
        ventana.setVisible(true); 
    }
}
