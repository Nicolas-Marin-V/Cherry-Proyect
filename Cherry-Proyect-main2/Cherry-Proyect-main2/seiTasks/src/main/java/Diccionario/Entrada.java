/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Diccionario;

/**
 *
 * @author Nicolas Marin
 */
public class Entrada {
    int Hash;
    String Titulo;
    String Definición;

    public Entrada(int Hash, String Titulo, String Definición) {
        this.Hash = Hash;
        this.Titulo = Titulo;
        this.Definición = Definición;
    }

    public int getHash() {
        return Hash;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getDefinición() {
        return Definición;
    }
    
}
