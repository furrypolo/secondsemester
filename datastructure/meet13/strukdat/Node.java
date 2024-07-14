package strukdat;

import java.util.*;

public class Node<T> {
    /*
     * class untuk mendefinisikan satu node di linkedlist secara generic
     * [data | next]   
     * data = bagian node yang berisi informasi (teks, bilangan, object of a class)
     * next = bagian node yang berisi alamat (pointer) ke node lainnya
     */

    public T data;
    public Node<T> next;
    boolean visited;
    private List<Node<T>> neighbors = new LinkedList<>();

    //constructor
    public Node(T value) {
        data = value;
        next = null;
        visited = false;
    }

    public void setVisited(boolean b) {
        this.visited = b;
    }

    public Collection<? extends Node<T>> getNeighbors() {
        return neighbors;
    }

    public boolean isVisited(){
        return visited;
    }
}