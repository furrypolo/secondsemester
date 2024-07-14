package classes;
/* 
 * Struktur data Graph dengan bobot pada setiap edge
 * sources: 
 * 1. https://www.lavivienpost.net/weighted-graph-as-adjacency-list/
 * 2. https://www.lavivienpost.net/find-shortest-path-using-dijkstras-algorithm/
 * 
*/

import java.util.*;

import classes.SingleList;

public class WeightedRelation<T> { 
	private Map<T, SingleList<Edge<T>>> adj;
	boolean directed;
	
	//Constructor dari class WeightedRelation
	public WeightedRelation (boolean type) { 
        adj = new HashMap<>();
		directed = type; // false: undirected, true: directed
	}

	//Fungsi untuk menambahkan hubungan antara 2 individu
	public void addEdge(T a, T b, int w) {
		adj.putIfAbsent(a, new SingleList<>()); //add node
		adj.putIfAbsent(b, new SingleList<>()); //add node
		Edge<T> edge1 = new Edge<>(a, b, w);
		adj.get(a).pushQ(edge1);//menambah hubungan kedalam Map adj
		if (!directed) { //jika undirected menambahkan hubungan sebaliknya
			Edge<T> edge2 = new Edge<>(b, a, w);
			adj.get(b).pushQ(edge2);
		}			
	}

	//Menampilkan hubungan antara masing masing individu
	public void printRelation() {
		for (T key: adj.keySet()) {
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

	// Perhitungan Closeness Centrality dan Normalized Closeness Centrality
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void ClosenessCentrality(){
		//Menggunakan Algoritma Dijkstra

		// Penyimpan jarak shortest path terpendek sepanjang iterasi
		Map<T, Integer> res = new HashMap<>(); 

		// Penyimpan priority queue sepanjang iterasi dijkstra
        PriorityQueue<Map.Entry<T, Integer>> pq =new PriorityQueue<>((a,b) -> (int)(a.getValue() - b.getValue()));   
		
		// Menyimpan path dari shortest path individu ke individu
        Map<T,T> prev = new HashMap<>();

		// Jumlah individu dalam jejaring sosial
		double vertexes = adj.size();

		//ArrayList untuk menyimpan path dari shortest path dalam perhitungan jumlah geodesic distance suatu individu
		ArrayList<T> path = new ArrayList<>();

		// Mengiterasi antara masing masing individu dalam jejaring sosial
		for(T start: adj.keySet()){
			double total=0;
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
						// Ketika jarak ke salah satu individu itu kurang dari jarak yang ada dalam map, maka akan digantikan
						if (res.get(v) > res.get(u) + weight) { 
							res.put(v, res.get(u) + weight); 
							pq.offer(new AbstractMap.SimpleEntry(v, res.get(v))); 
							prev.put(v, u);
						}
						curr = curr.next; 
					}
				}

				System.out.println("Distance shortest path from " + start + " to: ");
				// Menghitung berapa individu yang harus dilewati dari satu individu kepada yang lain
				for (T key: adj.keySet()) {
					if(key!=start){
						T node = key;
						path.add(node);
						while(node!=start){
							node = prev.get(node);
							path.add(node);
							// Menghitung total jumlah semua shortest path dari satu individu ke semua individu lainnya (gedoesic distance)
							total = total + 1;
						}
						System.out.println(key + " = " + (path.size()-1));
						path.clear();
					}
				}
				//Perhitungan Closeness Centrality
				System.out.println("");
				// Menampilkan total geodesic distance individu
				System.out.println("Total geodesic distance = " + total);
				// Memasukkan total geodesic distance kedalam rumus closeness centrality
				double ClosenessCentrality = 1/total;
				// Memasukkan total geodesic distance kedalam rumus normalized closeness centrality
				double NormalizedClosenessCentrality = (vertexes-1)/total;

				// Menampilkan hasil perhitungan
				System.out.println("Closeness Centrality of " + start + " = " + ClosenessCentrality);
				System.out.println("Normalized Closeness Centrality of " + start + " = " + NormalizedClosenessCentrality);
				System.out.println("");
		}
	}

	public void Density(){
		// Untuk menyimpan jumlah hubungan yang ada dalam jejaring sosial
		double total = 0;

		// Jumlah individu yang ada dalam jejaring sosial
		double vertexes = adj.size();

		//Iterasi terhadap individu yang ada
		for (T key: adj.keySet()) {
			SingleList<Edge<T>> thelist = adj.get(key);
			//Mengambil tetangga (individu yang terhubung langsung) dengan individu yang diiterasi
			Node<Edge<T>> curr = thelist.head;
			while(curr != null) {
				// Menambah jumlah hubungan ketika ditemukan
				total = total + 1;
				curr = curr.next;
			}
		}

		//Memasukkan jumlah hubungan dan jumlah individu ke dalam rumus density
		double density = total / (vertexes * (vertexes-1));

		//Menampilkan hasil perhitungan
		System.out.println("Density of the sociomatrix = " + density);
	}
}

