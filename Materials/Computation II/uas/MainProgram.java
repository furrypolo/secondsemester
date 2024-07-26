import classes.WeightedRelation;

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
        //Membuat individu individu dalam jejaring sosial
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

        //Menginisialisasi hubungan sosial yang berarah
        WeightedRelation<MyVertex> SCM = new WeightedRelation<MyVertex>(true); //directed
        //Memasukkan hubungan antar individu
        SCM.addEdge(A, B, 1);
        SCM.addEdge(A, D, 1);
        SCM.addEdge(A, H, 1);
        SCM.addEdge(B, A, 1);
        SCM.addEdge(B, C, 1);
        SCM.addEdge(C, D, 1);
        SCM.addEdge(C, F, 1);
        SCM.addEdge(D, E, 1);
        SCM.addEdge(E, J, 1);
        SCM.addEdge(E, A, 1);
        SCM.addEdge(F, G, 1);
        SCM.addEdge(F, B, 1);
        SCM.addEdge(G, C, 1);
        SCM.addEdge(H, A, 1);
        SCM.addEdge(H, I, 1);
        SCM.addEdge(I, E, 1);
        SCM.addEdge(J, D, 1);

        //Menghitung Closeness Centrality dan Normalized Closeness Centrality
        SCM.ClosenessCentrality();

        //Menghitung Density
        SCM.Density();

        
    }
}
