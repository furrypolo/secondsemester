// Source code is decompiled from a .class file using FernFlower decompiler.
package strukdat;

public class Edge<T> { 
	public T neighbor; //connected vertex
	Integer weight; //weight
	
	//Constructor, Time O(1) Space O(1)
	public Edge(T v, int w) {
		this.neighbor = v; 
		this.weight = w;
	}

	public Edge<T> getEdge(){
		return this;
	}

	public int getWeight() {
        return weight;
    }

	public T getNeighbor(){
		return neighbor;
	}
	
	//Time O(1) Space O(1)
	@Override
	public String toString() {
		return "(" + neighbor + "," + weight + ")";
	}
}
