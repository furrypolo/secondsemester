package strukdat;

public class Node<K> {
    // Konstanta untuk order dari pohon 2-3
   private static final int ORDER = 4;
   protected int numItems;
   private Node<K> parent;
   private Node<K> childArray[] = new Node[ORDER];
   protected DataItem itemArray[] = new DataItem[ORDER - 1];

   // Method untuk menghubungkan child dengan parent
   public void connectChild(int childNum, Node child) {
      childArray[childNum] = child;
      if (child != null)
         child.parent = this;
   }

   // Method untuk memutus hubungan child dari parent
   public Node<K> disconnectChild(int childNum) {
      Node<K> tempNode = childArray[childNum];
      childArray[childNum] = null;
      return tempNode;
   }

   // Method untuk mendapatkan child dari indeks tertentu
   public Node<K> getChild(int childNum) {
      return childArray[childNum];
   }

   // Method untuk mendapatkan parent dari node
   public Node<K> getParent() {
      return parent;
   }

   // Method untuk mengecek apakah node merupakan leaf atau bukan
   public boolean isLeaf() {
      return (childArray[0] == null) ? true : false;
   }

   // Method untuk mendapatkan jumlah item pada node
   public int getNumItems() {
      return numItems;
   }

   // Method untuk mendapatkan item pada indeks tertentu
   public DataItem getItem(int index) {
      return itemArray[index];
   }

   // Method untuk mengecek apakah node penuh atau tidak
   public boolean isFull() {
      return (numItems == ORDER - 1) ? true : false;
   }

   // Method untuk mencari item berdasarkan kunci
   public int findItem(long key) {
      for (int j = 0; j < ORDER - 1; j++) {
         if (itemArray[j] == null)
            break;
         else if (itemArray[j].dData == key)
            return j;
      }
      return -1;
   }

   // Method untuk memasukkan item baru ke dalam node
   public int insertItem(DataItem newItem) {
      numItems++;
      long newKey = newItem.dData;

      for (int j = ORDER - 2; j >= 0; j--) {
         if (itemArray[j] == null)
            continue;
         else {
            long itsKey = itemArray[j].dData;
            if (newKey < itsKey)
               itemArray[j + 1] = itemArray[j];
            else {
               itemArray[j + 1] = newItem;
               return j + 1;
            }
         }
      }
      itemArray[0] = newItem;
      return 0;
   }

   // Method untuk menghapus item dari node
   public DataItem removeItem() {
      DataItem temp = itemArray[numItems - 1];
      itemArray[numItems - 1] = null;
      numItems--;
      return temp;
   }

   // Method untuk menampilkan isi dari node
   public void displayNode() {
      for (int j = 0; j < numItems; j++)
         itemArray[j].displayItem();
      System.out.println("/");
   }

}
