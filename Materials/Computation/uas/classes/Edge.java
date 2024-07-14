// Source code is decompiled from a .class file using FernFlower decompiler.
package classes;

public class Edge<T> { 
	T vertex;
	public T neighbor;
	Integer weight;

	public Edge(T u, T v, int w) {
		this.vertex = u;
		this.neighbor = v; 
		this.weight = w;
	}

	public Edge<T> getEdge(){
		return this;
	}

	public int getWeight() {
        return weight;
    }
	
	public T getVertex() {
		return vertex;
	}

	public T getNeighbor(){
		return neighbor;
	}

	public int compareWeight(Edge<T> other){
		return this.weight - other.getWeight();
	}

	 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return weight == edge.weight && vertex.equals(edge.vertex) && neighbor.equals(edge.neighbor);
    }

	@Override
	public String toString() {
		return "(" + vertex + "," + neighbor + "," + weight + ")";
	}

}
