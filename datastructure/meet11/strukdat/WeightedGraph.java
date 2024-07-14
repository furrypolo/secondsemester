package strukdat;
/* 
 * sources: 
 * 1. https://www.lavivienpost.net/weighted-graph-as-adjacency-list/
 * 2. https://www.lavivienpost.net/find-shortest-path-using-dijkstras-algorithm/
 *  
 */

import java.lang.reflect.Array;
import java.util.*;
  
import javax.swing.SingleSelectionModel;

import strukdat.SingleList;
import strukdat.Node;

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

	//DFS 
	public void DFS(T src) {
		if (!adj.containsKey(src)) //invalid input
			return;
		HashMap<T, Boolean> visited = new HashMap<>();
	    helper(src, visited);
	    System.out.println();
	}
	private void helper(T v, HashMap<T, Boolean> visited) {
	    visited.put(v, true);
	    System.out.print(v.toString() + " ");
	    SingleList<Edge<T>> thelist = adj.get(v);
		Node<Edge<T>> curr = thelist.head;
		while(curr != null) {
			T u = curr.data.neighbor;
	        if (visited.get(u) == null)
	            helper(u, visited);
			curr = curr.next;
		}
	}

	//BFS
	public void BFS(T src) { 
		if (!adj.containsKey(src)) //invalid input
			return;
		SingleList<T> q = new SingleList<>(); 
	    HashMap<T, Boolean> visited = new HashMap<>(); 
	    q.pushQ(src); 
	    visited.put(src, true); 
	    while (!q.isEmpty()) { 
	        T v = q.pop().data; 
	        System.out.print(v.toString() + " "); 
			SingleList<Edge<T>> thelist = adj.get(v);
			Node<Edge<T>> curr = thelist.head;
			while(curr != null) {
				T u = curr.data.neighbor;
	            if (visited.get(u) == null) { 
	                q.pushQ(u); 
	                visited.put(u, true); 
	            }
				curr = curr.next;
			}         
	    } 
	    System.out.println(); 
	}

	public List<Integer> getAllWeights() {
		List<Integer> weights = new ArrayList<>();
		for (T key : adj.keySet()) {
			SingleList<Edge<T>> thelist = adj.get(key);
			Node<Edge<T>> curr = thelist.head;
			while (curr != null) {
				Edge<T> edge = curr.data;
				weights.add(edge.getWeight());
				curr = curr.next;
			}
		}
		return weights;
	}
	
	/*
	 * Shortest Paths dari vertex v ke semua vertex lainnya 
	 * menggunakan Algoritma Dijkstra
	 * ==========================================================
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public void dijkstra(T start) { // N = number of nodes
        Map<T, Integer> res = new HashMap<>(); 
        PriorityQueue<Map.Entry<T, Integer>> pq =new PriorityQueue<>((a,b) -> (int)(a.getValue() - b.getValue()));           
        Map<T,T> prev = new HashMap<>();

		for (T key: adj.keySet()) 
        	res.put(key, Integer.MAX_VALUE);
			pq.offer(new AbstractMap.SimpleEntry(start, 0)); 
			res.put(start, 0); 
			while (!pq.isEmpty()) { 
				T u = pq.poll().getKey(); 
				SingleList<Edge<T>> thelist = adj.get(u);
				Node<Edge<T>> curr = thelist.head;
				while(curr != null) {
					Edge<T> edge = curr.data;
					T v = edge.getNeighbor();
					int weight = edge.getWeight(); 
					if (res.get(v) > res.get(u) + weight) { 
						res.put(v, res.get(u) + weight); 
						pq.offer(new AbstractMap.SimpleEntry(v, res.get(v))); 
						prev.put(v, u);
					}
					curr = curr.next; 
				} 
			}
			ArrayList<T> path = new ArrayList<>();
			System.out.println("Shortest path to each vertex: ");
			for (T key: adj.keySet()) {
				if(key!=start){
					T node = key;
					path.add(node);
					while(node!=start){
						node = prev.get(node);
						path.add(node);
					}
					System.out.print('[');
					for (int i = path.size() - 1; i >= 0; i--) {
						if(i != path.size() - 1){
							System.out.print(", ");
						}
						System.out.print(path.get(i));
					}
					path.clear();
					System.out.println("] ");
				}
			}
    }
}
