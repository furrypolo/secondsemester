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
        MyVertex v1 = new MyVertex("1");
        MyVertex v2 = new MyVertex("2");
        MyVertex v3 = new MyVertex("3");
        MyVertex v4 = new MyVertex("4");
        MyVertex v5 = new MyVertex("5");
        MyVertex v6 = new MyVertex("6");
        MyVertex v7 = new MyVertex("7");
        MyVertex v8 = new MyVertex("8");
        MyVertex v9 = new MyVertex("9");

        WeightedGraph<MyVertex> WG = new WeightedGraph<MyVertex>(false); //undirected
        WG.addEdge(v1, v3, 1);
        WG.addEdge(v1, v4, 1);
        WG.addEdge(v2, v4, 1);
        WG.addEdge(v2, v5, 1);
        WG.addEdge(v3, v6, 1);
        WG.addEdge(v3, v7, 1);
        WG.addEdge(v4, v7, 1);
        WG.addEdge(v4, v8, 1);
        WG.addEdge(v5, v8, 1);
        WG.addEdge(v5, v9, 1);

        System.out.println("Undirected Graph:"); WG.printGraph();

        WG.BFS(v1);
        WG.DFS(v1);

        System.out.println("Pemutusan edge antara 1 dan 3");
        WG.removeEdge(v1, v3);
        WG.printGraph();
    }
}
