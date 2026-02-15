package com.seitasks.FlashCards;

import java.io.Serializable;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Node<T> root;

    // Insertar un nuevo dato al árbol
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> current, T data) {
        if (current == null) return new Node<>(data);

        if (data.compareTo(current.Dato) < 0) {
            current.left = insertRec(current.left, data);
        } else {
            current.right = insertRec(current.right, data);
        }
        return current;
    }

    // Verificar si un dato está en el árbol
    public boolean contains(T data) {
        return containsRec(root, data);
    }

    private boolean containsRec(Node<T> current, T data) {
        if (current == null) return false;

        int cmp = data.compareTo(current.Dato);
        if (cmp == 0) return true;
        else if (cmp < 0) return containsRec(current.left, data);
        else return containsRec(current.right, data);
    }

    // Recorrido in-order: izquierda, raíz, derecha
    public void fillInOrder(List<T> result) {
        inOrderRec(root, result);
    }

    private void inOrderRec(Node<T> current, List<T> result) {
        if (current != null) {
            inOrderRec(current.left, result);
            result.add(current.Dato);
            inOrderRec(current.right, result);
        }
    }

    // Recorrido pre-order: raíz, izquierda, derecha
    public void fillPreOrder(List<T> result) {
        preOrderRec(root, result);
    }

    private void preOrderRec(Node<T> current, List<T> result) {
        if (current != null) {
            result.add(current.Dato);
            preOrderRec(current.left, result);
            preOrderRec(current.right, result);
        }
    }

    // Recorrido post-order: izquierda, derecha, raíz
    public void fillPostOrder(List<T> result) {
        postOrderRec(root, result);
    }

    private void postOrderRec(Node<T> current, List<T> result) {
        if (current != null) {
            postOrderRec(current.left, result);
            postOrderRec(current.right, result);
            result.add(current.Dato);
        }
    }
}

