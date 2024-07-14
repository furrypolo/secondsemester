package strukdat;
/* 
 * Struktur data Graph dengan bobot pada setiap edge
 * sources: https://www.lavivienpost.net/weighted-graph-as-adjacency-list/  
 * 
 */

import java.util.*;

public class WeightedGraph<T> { 
    //Map<T, LinkedList<Edge<T>>> adj;
	private Map<T, SingleList<Edge<T>>> adj;
	boolean directed;
	
	//Constructor, Time O(1) Space O(1)
	public WeightedGraph (boolean type) { 
        adj = new HashMap<>();
		directed = type; // false: undirected, true: directed
	}

    //Add edges including adding nodes, Time O(1) Space O(1)
	public void addEdge(T a, T b, int w) {
		adj.putIfAbsent(a, new SingleList<>()); //add node
		adj.putIfAbsent(b, new SingleList<>()); //add node
		Edge<T> edge1 = new Edge<>(b, w);
		adj.get(a).pushQ(edge1);//add(edge1); //add edge
		if (!directed) { //undirected
			Edge<T> edge2 = new Edge<>(a, w);
			adj.get(b).pushQ(edge2);
		}			
	}

    //Print graph as hashmap, Time O(V+E), Space O(1)
	public void printGraph() {
		for (T key: adj.keySet()) {
			//System.out.println(key.toString() + " : " + adj.get(key).toString());
            System.out.print(key.toString() + " : ");
			SingleList<Edge<T>> thelist = adj.get(key);
			Node<Edge<T>> curr = thelist.head;
			while(curr != null) {
				System.out.print(curr.data);
				curr = curr.next;
			}
			System.out.println();
		}
	}

	public SingleList<Edge<T>> getNeighbors(T vertex){
		return adj.get(vertex);
	}

	public void BFS(T vertex){
		System.out.println("Breadth First Search: ");
		Queue<T> queue = new LinkedList<>();
		Set<T> visited = new HashSet<>();
		
		queue.add(vertex);
		visited.add(vertex);

		while(!queue.isEmpty()){
			T currentV = queue.poll();
			System.out.print(currentV + " ");
			SingleList<Edge<T>> neighbors = getNeighbors(currentV);
			Node<Edge<T>> current = neighbors.head;
			while(current != null){
				T neighbor = current.data.neighbor;
				if(!visited.contains(neighbor)){
					queue.add(neighbor);
					visited.add(neighbor);
				}
				current = current.next;
			}		
		}
		System.out.println(" ");
}

public void DFS(T src) {
	System.out.println("Depth First Search:");
	if (!adj.containsKey(src))
		return;
	Set<T> visited = new HashSet<>();
	helper(src, visited);
	System.out.println();
}

private void helper(T v, Set<T> visited) {
	visited.add(v);
	System.out.print(v.toString() + " ");
	SingleList<Edge<T>> thelist = adj.get(v);
	Node<Edge<T>> curr = thelist.head;
	while(curr != null) {
		T u = curr.data.neighbor;
		if (!visited.contains(u))
			helper(u, visited);
		curr = curr.next;
	}
}

	public void removeEdge(T a, T b) {
		SingleList<Edge<T>> neighbors = getNeighbors(a);
		Node<Edge<T>> current = neighbors.head;
		while(current != null){
			T neighbor = current.data.neighbor;
			if(neighbor == b){
				adj.get(a).remove(current.data);
				break;
			}
			current = current.next;
		}
		neighbors = getNeighbors(b);
		current = neighbors.head;
		while(current != null){
			T neighbor = current.data.neighbor;
			if(neighbor == a){
				adj.get(b).remove(current.data);
				break;
			}
			current = current.next;
		}		
	}

}
