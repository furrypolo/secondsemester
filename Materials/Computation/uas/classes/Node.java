package classes;

import java.util.*;

public class Node<T> {
    public T data;
    public Node<T> next;
    boolean visited;

    //constructor
    public Node(T value) {
        data = value;
        next = null;
        visited = false;
    }
}