/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seitasks.FlashCards;

public class Node<T> {
    public T Dato;
    public Node<T> nextNode;
    public Node<T> left;
    public Node<T> right;

    public Node(T Dato){
        this.Dato = Dato;
        this.nextNode = null;
        this.left = null;
        this.right = null;
    }

    public void setNext(Node<T> object){
        this.nextNode = object;
    }

    @Override
    public String toString() {
        return Dato.toString();
    }
}

