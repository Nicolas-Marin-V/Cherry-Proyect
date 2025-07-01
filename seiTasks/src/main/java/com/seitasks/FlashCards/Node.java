package com.seitasks.FlashCards;

import java.io.Serializable;

public class Node<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    
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

