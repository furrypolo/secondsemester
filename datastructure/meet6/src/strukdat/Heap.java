package strukdat;
import strukdat.TheArrayList;
import strukdat.GNode;

public class Heap<K extends Comparable<? super K>,V> {
    TheArrayList<GNode<K,V>>arrList;
    boolean priority;
    public Heap(int capacity, boolean priority){
        arrList=new TheArrayList<GNode<K,V>>(capacity);
        this.priority = priority;
    }
    public int size(){
        return arrList.size();
    }

    public V getData(int index){
        return arrList.get(index).data;
    }

    public V getData(GNode<K,V>node){
        return node.data;
    }

    public K getKey(int index){
        return arrList.get(index).key;
    }

    public K getKey(GNode<K,V> node){
        return node.key;
    }

    public void add(K key, V data){
        arrList.add(new GNode<K,V>(key,data));
    }

     public void insert(K key, V data) {
        arrList.add(new GNode<K,V>(key, data));
        int size = arrList.size();
        for (int i = size / 2 - 1; i >= 0; i = (i+1)/2 - 1) {
            if(priority) heapifyMin(size, i);
            else heapifyMax(size, i);
        }
    }

    public void buildHeap(){
        int size = arrList.size();
        for(int i = size/2-1; i>=0; i--){
            if(priority) heapifyMin(size,i);
            else heapifyMax(size,i);
        }
    }

    void heapifyMax(int size, int i){
        int parent = i;
        int left = 2*i+1;
        int right = 2*1+2;
        if(left<size) if(arrList.get(left)!=null && arrList.get(parent)!=null) if(arrList.get(left).key.compareTo(arrList.get(parent).key)>0) parent = left;
        if(right<size) if(arrList.get(right)!=null && arrList.get(parent)!=null) if(arrList.get(right).key.compareTo(arrList.get(parent).key)>0) parent = right;
        if(parent!=i){
            GNode<K,V>temp=arrList.get(i);
            arrList.set(i, arrList.get(parent));
            arrList.set(parent,temp);
            heapifyMax(size, parent);
        }
    }

    public void heapifyMin(int size, int i){
        int parent = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if (left < size && arrList.get(left).key.compareTo(arrList.get(parent).key) <= 0)
            parent = left;

        // if right child is smaller than root
        if (right < size && arrList.get(right).key.compareTo(arrList.get(parent).key) <= 0)
            parent = right;
        if(parent!=i){
            GNode<K,V>temp=arrList.get(i);
            arrList.set(i, arrList.get(parent));
            arrList.set(parent,temp);
            heapifyMin(size, parent);
        }
    }

    public void sort(){
        int size = arrList.size();
        buildHeap();
        for(int i = size -1; i>=0; i--){
            GNode<K,V> temp = arrList.get(0);
            arrList.set(0, arrList.get(i));
            arrList.set(i, temp);
            if(priority) heapifyMin(i, 0);
            else heapifyMax(i, 0);
        }

    }

    public void display(){
        arrList.cetakList();
    }

    public GNode<K,V> first(){
        return arrList.get(0);
    }

    public GNode<K,V> removeFirst() {
        
        int n = arrList.size() - 1;

        GNode<K,V> temp = arrList.get(0);
        arrList.set(0, arrList.get(n));
        arrList.set (n, temp);

        if(priority) heapifyMin(n, 0);
        else heapifyMax(n, 0);

        arrList.remove(n);

        return temp;
    }

}