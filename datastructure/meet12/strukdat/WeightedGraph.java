package strukdat;
/* 
 * Struktur data Graph dengan bobot pada setiap edge
 * sources: 
 * 1. https://www.lavivienpost.net/weighted-graph-as-adjacency-list/
 * 2. https://www.lavivienpost.net/find-shortest-path-using-dijkstras-algorithm/
 * 
*/

import java.lang.reflect.Array;
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
		Edge<T> edge1 = new Edge<>(a, b, w);
		adj.get(a).pushQ(edge1);//add(edge1); //add edge
		if (!directed) { //undirected
			Edge<T> edge2 = new Edge<>(b, a, w);
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
					T v = edge.getNeighbor();  //.connectedVetex;
					int weight = edge.getWeight(); 
					if (res.get(v) > res.get(u) + weight) { 
						res.put(v, res.get(u) + weight); 
						pq.offer(new AbstractMap.SimpleEntry(v, res.get(v))); 
						prev.put(v, u);
					}
					curr = curr.next; 
				} 
				System.out.println(res);
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

	//MST menggunakan Algoritm Prim
	public void MSTPrim(T src) { 
		int totalMST = 0;
		if (!adj.containsKey(src))
			return;
			
		SingleList<Edge<T>> outputList = new SingleList<Edge<T>>();
		Map<T, Boolean> visited = new HashMap<>(); 
		visited.put(src, true); 

		Node<Edge<T>> min = null;
		int minimum = Integer.MAX_VALUE;

		while(visited.size()!=adj.size()){
			min = null;
			minimum = Integer.MAX_VALUE;

			for (Map.Entry<T, Boolean> entry : visited.entrySet()) {
				T vertex = entry.getKey();
				SingleList<Edge<T>> thelist = adj.get(vertex);
				Node<Edge<T>> curr = thelist.head;
				while(curr != null) {
					if (visited.get(curr.data.getNeighbor()) == null){
						if(curr.data.getWeight()<minimum){
							min = curr;
							minimum = curr.data.getWeight();
						}
					}
					curr = curr.next;
				}      
			}
			
			Edge<T> edge = min.data;
			outputList.pushQ(edge);
			totalMST += min.data.getWeight();
			visited.put(min.data.getNeighbor(), true);
		}
		outputList.cetakList();
	    System.out.println("MST Length = " + totalMST); 
	}

	//MST menggunakan Algoritm Kruskal
	public void MSTKruskal() {
		SingleList<Edge<T>> outputList = new SingleList<Edge<T>>();
		int totalMST = 0;
		
		Heap<Integer, Edge<T>> edgeList = new Heap<Integer, Edge<T>>(adj.size() * adj.size(), true);
		Set<Edge<T>> edgesDone = new HashSet<>();
		for (T key : adj.keySet()) {
			SingleList<Edge<T>> thelist = adj.get(key);
			Node<Edge<T>> curr = thelist.head;
			while (curr != null) {
				Edge<T> edge = curr.data;
				if (!edgesDone.contains(edge)) {
					int weight = edge.getWeight();
					edgeList.insert(weight, edge);
					edgesDone.add(edge);
				}
				curr = curr.next;
			}
		}
	
		Sorter(edgeList);

		Map<T, T> parent = new HashMap<>();
		Map<T, Integer> ranking = new HashMap<>();

		for (T vertex : adj.keySet()) {
			parent.put(vertex, vertex);
			ranking.put(vertex, 0);
		}

		while (edgeList.size() != 0) {
			GNode<Integer, Edge<T>> item = edgeList.removeSort();
			Edge<T> edge = item.data;

			boolean right = false;
			Node<Edge<T>> current = outputList.head;
			while (current != null) {
				Edge<T> currentEdge = current.data;
				if ((edge.getVertex() == currentEdge.getVertex() && edge.getNeighbor() == currentEdge.getNeighbor()) || 
					(edge.getVertex() == currentEdge.getNeighbor() && edge.getNeighbor() == currentEdge.getVertex())) {
					right = true;
					break;
				}
				current = current.next;
			}

			if (!right) {
				if (!connected(edge.getVertex(), edge.getNeighbor(), parent)) {
					outputList.pushQ(edge);
					totalMST += edge.getWeight();
					union(edge.getVertex(), edge.getNeighbor(), parent, ranking);
				}
			}
		}

		outputList.cetakList();
		System.out.println("MST Length = " + totalMST);
	}

	 public void Sorter(Heap<Integer, Edge<T>> edgeList ){
		for (int i = 0; i < edgeList.size() - 1; i++) {
			boolean swap = false;
			for (int j = 0; j < edgeList.size() - i - 1; j++) {
				int weightone = edgeList.getKey(j);
				int weighttwo = edgeList.getKey(j + 1);
				if (weightone > weighttwo) {
					edgeList.swap(j, j + 1);
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}

	private T find(T vertex, Map<T, T> parent) {
		if (!parent.get(vertex).equals(vertex)) {
			parent.put(vertex, find(parent.get(vertex), parent));
		}
		return parent.get(vertex);
	}

	private void union(T vertex, T neighbor, Map<T, T> parent, Map<T, Integer> rank) {
		T from1 = find(vertex, parent);
		T from2 = find(neighbor, parent);
	
		if (!from1.equals(from2)) {
			int ranking1 = rank.get(from1);
			int ranking2 = rank.get(from2);
	
			if (ranking1 < ranking2) {
				parent.put(from1, from2);
			} 
			else if (ranking1 > ranking2) {
				parent.put(from2, from1);
			} 
			else {
				parent.put(from2, from1);
				rank.put(from1, ranking1 + 1);
			}
		}
	}

	private boolean connected(T vertex, T neighbor, Map<T, T> parent) {
		boolean fin = find(vertex, parent).equals(find(neighbor, parent));
		return fin;
	}
	
	
	
}
