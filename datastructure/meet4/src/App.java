import strukdat.DoubleHashing;
import strukdat.LinearProbing;
import strukdat.QuadraticProbing;

public class App {
    public static void main(String[] args){

        System.out.println("Linear probing = ");
        LinearProbing<Object,String> T = new LinearProbing<Object,String>(13);
        T.put(261,"B");
        T.put(381,"J");
        T.put(835,"N");
        T.put(195,"S");
        T.put(134,"X");
        T.put(477,"W");
        T.put(568,"A");
        T.put(99,"C");
        T.put(726,"T");
        T.put(139,"P");
        T.displayHashTable();
        System.out.println("Jumlah probe yang dibutuhkan = " + T.getProbe());
        System.out.println();
        System.out.println("Quadratic probing = ");
        QuadraticProbing<Object,String> Q = new QuadraticProbing<Object,String>(13);
        Q.put(261,"B");
        Q.put(381,"J");
        Q.put(835,"N");
        Q.put(195,"S");
        Q.put(134,"X");
        Q.put(477,"W");
        Q.put(568,"A");
        Q.put(99,"C");
        Q.put(726,"T");
        Q.put(139,"P");
        Q.displayHashTable();
        System.out.println("Jumlah probe yang dibutuhkan = " + Q.getProbe());
        System.out.println();
        System.out.println("Double Hashing = ");
        DoubleHashing<Object,String> D = new DoubleHashing<Object,String>(13);
        D.put(261,"B");
        D.put(381,"J");
        D.put(835,"N");
        D.put(195,"S");
        D.put(134,"X");
        D.put(477,"W");
        D.put(568,"A");
        D.put(99,"C");
        D.put(726,"T");
        D.put(139,"P");
        D.displayHashTable();
        System.out.println("Jumlah probe yang dibutuhkan = " + D.getProbe());
    }
}
