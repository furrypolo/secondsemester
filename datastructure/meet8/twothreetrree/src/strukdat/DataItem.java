package strukdat;

public class DataItem {
    public long dData;
    
    // Constructor untuk DataItem
    public DataItem(long dd) {
        dData = dd;
    }
    
    // Method untuk menampilkan isi dari DataItem
    public void displayItem() {
        System.out.print("/" + dData);
    }
}
