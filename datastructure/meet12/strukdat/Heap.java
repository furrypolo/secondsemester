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

    public void swap(int index1, int index2) {
        GNode<K, V> temp = arrList.get(index1);
        arrList.set(index1, arrList.get(index2));
        arrList.set(index2, temp);
    }

    public void heapifyMax(int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
    
        if (left < size && arrList.get(left).key.compareTo(arrList.get(largest).key) > 0)
            largest = left;
    
        if (right < size && arrList.get(right).key.compareTo(arrList.get(largest).key) > 0)
            largest = right;
    
        if (largest != i) {
            GNode<K, V> temp = arrList.get(i);
            arrList.set(i, arrList.get(largest));
            arrList.set(largest, temp);
            heapifyMax(size, largest);
        }
    }
    
    public void heapifyMin(int size, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
    
        if (priority) {
            if (left < arrList.size() && getKey(left).compareTo(getKey(smallest)) < 0) {
                smallest = left;
            }
    
            if (right < arrList.size() && getKey(right).compareTo(getKey(smallest)) < 0) {
                smallest = right;
            }
        } else {
            if (left < arrList.size() && getKey(left).compareTo(getKey(smallest)) > 0) {
                smallest = left;
            }
    
            if (right < arrList.size() && getKey(left).compareTo(getKey(smallest)) > 0) {
                smallest = right;
            }
        }
    
        if (smallest != i) {
            swap(i, smallest);
            heapifyMin(size, smallest);
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

    public GNode<K,V> removeSort() {
        if (arrList.size() == 0) {
            return null; // Handle empty list case
        }
    
        GNode<K,V> temp = arrList.get(0); // Get the first element
        arrList.remove(0); // Remove the first element
    
        return temp;
    }

}