// import strukdat.Graph;
import java.util.List;

import strukdat.Heap;
import strukdat.WeightedGraph;

class MyVertex{
	String nodeName;
	MyVertex(String name)
	{
		this.nodeName = name;
	}

    @Override
    public String toString() {
        return (nodeName);
    }
}


public class MainProgram {
    public static void main(String[] args) {
        //create vertex
        MyVertex A = new MyVertex("A");
        MyVertex B = new MyVertex("B");
        MyVertex C = new MyVertex("C");
        MyVertex D = new MyVertex("D");
        MyVertex E = new MyVertex("E");
        MyVertex F = new MyVertex("F");
        MyVertex G = new MyVertex("G");
        MyVertex H = new MyVertex("H");
        MyVertex I = new MyVertex("I");
        MyVertex J = new MyVertex("J");
        MyVertex K = new MyVertex("K");
        MyVertex L = new MyVertex("L");
        MyVertex M = new MyVertex("M");
        MyVertex N = new MyVertex("N");
        MyVertex O = new MyVertex("O");
        MyVertex P = new MyVertex("P");
        MyVertex Q = new MyVertex("Q");
        MyVertex R = new MyVertex("R");
        MyVertex S = new MyVertex("S");
        MyVertex T = new MyVertex("T");
        MyVertex U = new MyVertex("U");
        MyVertex V = new MyVertex("V");
        MyVertex W = new MyVertex("W");
        MyVertex X = new MyVertex("X");
        MyVertex Y = new MyVertex("Y");
        MyVertex Z = new MyVertex("Z");


        WeightedGraph<MyVertex> WG = new WeightedGraph<MyVertex>(true); 
        WG.addEdge(A, B, 1);
        WG.addEdge(A, C, 1);
        WG.addEdge(A, D, 1);
        WG.addEdge(A, E, 1);
        WG.addEdge(B, L, 1);
        WG.addEdge(B, F, 1);
        WG.addEdge(B, A, 1);
        WG.addEdge(C, G, 1);
        WG.addEdge(E, D, 1);
        WG.addEdge(E, H, 1);
        WG.addEdge(F, G, 1);
        WG.addEdge(F, O, 1);
        WG.addEdge(G, D, 1);
        WG.addEdge(G, I, 1);
        // WG.addEdge(H, I, 1);
        // WG.addEdge(I, U, 1);
        // WG.addEdge(I, V, 1);
        // WG.addEdge(K, J, 1);
        // WG.addEdge(K, M, 1);
        // WG.addEdge(L, J, 1);
        // WG.addEdge(L, K, 1);
        // WG.addEdge(M, N, 1);
        // WG.addEdge(M, P, 1);
        // WG.addEdge(N, O, 1);
        // WG.addEdge(P, Q, 1);
        // WG.addEdge(P, R, 1);
        // WG.addEdge(Q, T, 1);
        // WG.addEdge(R, S, 1);
        // WG.addEdge(R, X, 1);
        // WG.addEdge(R, Y, 1);
        // WG.addEdge(S, D, 1);
        // WG.addEdge(T, R, 1);
        // WG.addEdge(V, W, 1);
        // WG.addEdge(W, Z, 1);
        // WG.addEdge(Z, U, 1);
        // WG.addEdge(Z, V, 1);

        System.out.println("Undirected Graph:"); WG.printGraph();
        // System.out.println("\n from A");
        // WG.dijkstra(A);
        // System.out.println("\n from B");
        // WG.dijkstra(B);
        // System.out.println("\n from C");
        // WG.dijkstra(C);
        System.out.println("\n from D");
        WG.dijkstra(D);
        System.out.println("\n from E");
        WG.dijkstra(E);
        System.out.println("\n from F");
        WG.dijkstra(F);
        System.out.println("\n from G");
        WG.dijkstra(G);
        // System.out.println("\n from H");
        // WG.dijkstra(H);
        // System.out.println("\n from I");
        // WG.dijkstra(I);
        // System.out.println("\n from J");
        // WG.dijkstra(J);
        // System.out.println("\n from K");
        // WG.dijkstra(K);
        // System.out.println("\n from L");
        // WG.dijkstra(L);
        // System.out.println("\n from M");
        // WG.dijkstra(M);
        // System.out.println("\n from N");
        // WG.dijkstra(N);
        // System.out.println("\n from O");
        // WG.dijkstra(O);
        // System.out.println("\n from P");
        // WG.dijkstra(P);
        // System.out.println("\n from Q");
        // WG.dijkstra(Q);
        // System.out.println("\n from R");
        // WG.dijkstra(R);
        // System.out.println("\n from S");
        // WG.dijkstra(S);
        // System.out.println("\n from T");
        // WG.dijkstra(T);
        // System.out.println("\n from U");
        // WG.dijkstra(U);
        // System.out.println("\n from V");
        // WG.dijkstra(V);
        // System.out.println("\n from W");
        // WG.dijkstra(W);
        // System.out.println("\n from X");
        // WG.dijkstra(X);
        // System.out.println("\n from Y");
        // WG.dijkstra(Y);
        // System.out.println("\n from Z");
        // WG.dijkstra(Z);
        // System.out.println("Kruskal Method MST:"); WG.MSTKruskal();
        // System.out.println("");
        // System.out.println("Prim Method MST:"); WG.MSTPrim(A);
    }
}
