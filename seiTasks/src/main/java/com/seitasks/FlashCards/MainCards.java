/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seitasks.FlashCards;

import javax.swing.JFrame;

/**
 *
 * @author Nicolas Marin
 */
public class MainCards {
    public static void main(){
        JFrame ventana = new JFrame("SeiTasks");

        ventana.setContentPane(new FalshCardWindow());
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack(); 
        ventana.setLocationRelativeTo(null); 
        ventana.setVisible(true); 
}
}