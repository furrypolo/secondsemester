import strukdat.Heap;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] val = {60, 30, 23, 5, 12};
        String[] data = {"Andree", "Leana", "Faviola", "Loyce", "Quincy"};
        Heap<Integer,String>heap=new Heap<Integer,String>(80000,false);
        for(int i=0;i<val.length;i++)
            heap.add(val[i], data[i]);
        heap.buildHeap();
        heap.sort();
        heap.display();
        heap.removeFirst();
        heap.display();
    }
}
