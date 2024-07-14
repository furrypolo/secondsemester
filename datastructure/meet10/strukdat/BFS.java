package strukdat;

import java.util.*;

public class BFS<T> {
    private final Node<T> startNode;

    public BFS(Node<T> start){
        this.startNode = start;
    }

    public void traverse(){
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(startNode);
        while(!queue.isEmpty()){
            Node<T> current = queue.poll();
            if(!current.isVisited()){
                current.setVisited(true);
                System.out.println(current);
                queue.addAll(current.getNeighbors());
            }
        }
    }
}
