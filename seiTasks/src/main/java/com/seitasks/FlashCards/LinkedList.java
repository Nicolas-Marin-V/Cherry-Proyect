package com.seitasks.FlashCards;
/**
 *
 * @author esteb
 */

import java.util.ArrayList;

public class LinkedList<T> {
    public Node<T> Head, Tail;

    public LinkedList(){
        this.Head = null;
        this.Tail = null;
    }

    public void add(T x){
        Node<T> newNode = new Node<>(x);
        if (Head == null) {
            Head = newNode;
        } else if (Head.nextNode == null) {
            Head.nextNode = newNode;
        } else {
            Tail.nextNode = newNode;
        }
        Tail = newNode;
    }

    public void delete(T z){
        if (Head == null) return;

        if (Head.Dato.equals(z)) {
            Head = Head.nextNode;
        } else {
            Node<T> actual = Head;
            while (actual.nextNode != null && !z.equals(actual.nextNode.Dato)) {
                actual = actual.nextNode;
            }
            if (actual.nextNode != null) {
                if (actual.nextNode == Tail) {
                    Tail = actual;
                }
                actual.nextNode = actual.nextNode.nextNode;
            }
        }
    }

    public boolean find(T y) {
        Node<T> actual = Head;
        while (actual != null) {
            if (y.equals(actual.Dato)) {
                return true;
            }
            actual = actual.nextNode;
        }
        return false;
    }

    public ArrayList<String> toList() {
        ArrayList<String> elementos = new ArrayList<>();
        Node<T> actual = Head;
        while (actual != null) {
            elementos.add(actual.Dato.toString());
            actual = actual.nextNode;
        }
        return elementos;
    }
}
