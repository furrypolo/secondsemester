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
        MyVertex v1 = new MyVertex("cs1");
        MyVertex v2 = new MyVertex("cs2");
        MyVertex v3 = new MyVertex("cs3");
        MyVertex v4 = new MyVertex("cs4");
        MyVertex v5 = new MyVertex("cs5");
        MyVertex v6 = new MyVertex("cs6");
        MyVertex v7 = new MyVertex("cs7");
        MyVertex v8 = new MyVertex("cs8");
        MyVertex v9 = new MyVertex("cs9");
        MyVertex v10 = new MyVertex("cs10");

        
        WeightedGraph<MyVertex> DAG = new WeightedGraph<MyVertex>(true); //directed
        DAG.addEdge(v1, v2, 1);
        DAG.addEdge(v2, v3, 1);
        DAG.addEdge(v2, v4, 1);
        DAG.addEdge(v2, v5, 1);
        DAG.addEdge(v4, v6, 1);
        DAG.addEdge(v4, v7, 1);
        DAG.addEdge(v5, v10, 1);
        DAG.addEdge(v6, v8, 1);
        DAG.addEdge(v7, v8, 1);
        DAG.addEdge(v7, v9, 1);
        DAG.addEdge(v9, v10, 1);

        // DAG.addEdge(v3, v1, 1); //aktifkan untuk mengetes cycle di DAG
        System.out.println("Directed Graph:"); DAG.printGraph();
        DAG.TopologicalOrdering();
    }
}
