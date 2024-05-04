/*
 * Modified from: http://www.java2s.com/ref/java/java-data-structures-234-tree.html
 * 
*/

class DataItem {
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

class Node {
   // Konstanta untuk order dari pohon 2-3
   private static final int ORDER = 4;
   protected int numItems;
   private Node parent;
   private Node childArray[] = new Node[ORDER];
   protected DataItem itemArray[] = new DataItem[ORDER - 1];

   // Method untuk menghubungkan child dengan parent
   public void connectChild(int childNum, Node child) {
      childArray[childNum] = child;
      if (child != null)
         child.parent = this;
   }

   // Method untuk memutus hubungan child dari parent
   public Node disconnectChild(int childNum) {
      Node tempNode = childArray[childNum];
      childArray[childNum] = null;
      return tempNode;
   }

   // Method untuk mendapatkan child dari indeks tertentu
   public Node getChild(int childNum) {
      return childArray[childNum];
   }

   // Method untuk mendapatkan parent dari node
   public Node getParent() {
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

class Tree23 {
   private Node root = new Node();

   // Method untuk mencari kunci dalam pohon
   public int find(long key) {
      Node curNode = root;
      int childNumber;
      while (true) {
         if ((childNumber = curNode.findItem(key)) != -1)
            return childNumber; 
         else if (curNode.isLeaf())
            return -1; 
         else
            curNode = getNextChild(curNode, key);
      } 
   }

   // Method untuk memasukkan nilai ke dalam pohon
   public void insert(long dValue) {
      Node curNode = root;
      DataItem tempItem = new DataItem(dValue);
      
      while (true) {
         if (curNode.isLeaf())
            break;
         else
            curNode = getNextChild(curNode, dValue);
      }
      curNode.insertItem(tempItem);
      // dilanggar dahulu max items per node dari 2 menjadi 3 
      if (curNode.isFull()) 
      {
        split(curNode); // split it
        curNode = curNode.getParent();
        // untuk setiap node yang melanggar max items per node
        while(curNode.isFull()){
            split(curNode); // split it
            curNode = curNode.getParent();
        }
      }
   }

   // Method untuk membagi node ketika penuh
   public void split(Node thisNode) {
      DataItem itemB, itemC;
      Node parent, child2, child3;
      int itemIndex;

      itemC = thisNode.removeItem();
      itemB = thisNode.removeItem();
      child2 = thisNode.disconnectChild(2);
      child3 = thisNode.disconnectChild(3);
      
      Node newRight = new Node();

      if (thisNode == root) {
         root = new Node();
         parent = root;
         root.connectChild(0, thisNode);
      } else
         parent = thisNode.getParent();

      itemIndex = parent.insertItem(itemB);
      int n = parent.getNumItems();

      for (int j = n - 1; j > itemIndex; j--) {
         Node temp = parent.disconnectChild(j);
         parent.connectChild(j + 1, temp);
      }
      parent.connectChild(itemIndex + 1, newRight);
      newRight.insertItem(itemC);
      newRight.connectChild(0, child2);
      newRight.connectChild(1, child3);
   }

   // Method untuk mendapatkan child berikutnya dari sebuah node
   public Node getNextChild(Node theNode, long theValue) {
      int j;

      int numItems = theNode.getNumItems();
      for (j = 0; j < numItems; j++) {
         if (theValue < theNode.getItem(j).dData)
            return theNode.getChild(j);
      }
      return theNode.getChild(j);
   }

   // Method untuk menampilkan pohon
   public void displayTree() {
      recDisplayTree(root, 0, 0);
   }

   // Method rekursif untuk menampilkan pohon
   private void recDisplayTree(Node thisNode, int level, int childNumber) {
      System.out.print("level=" + level + " child=" + childNumber + " ");
      thisNode.displayNode(); 

      int numItems = thisNode.getNumItems();
      for (int j = 0; j < numItems + 1; j++) {
         Node nextNode = thisNode.getChild(j);
         if (nextNode != null)
            recDisplayTree(nextNode, level + 1, j);
            else
               return;
         }
      }

      public void delete(long key) {
         Node curNode = root;
         int childIndex;
         while (true) {
             childIndex = curNode.findItem(key);
             if (childIndex != -1) {
                 removeItem(childIndex, curNode);
                 break;
             } else if (curNode.isLeaf()) {
                 System.out.println("Key tidak ditemukan");
                 break;
             } else {
                 curNode = getNextChild(curNode, key);
             }
         }   
      }
   
      // Method to remove an item from the node
      private void removeItem(int index, Node node) {
         // Shift items to the left
         for (int i = index; i < node.getNumItems() - 1; i++) {
               node.itemArray[i] = node.itemArray[i + 1];
         }
         node.numItems--;
         }
   

  
}


public class Tree23Main {
   public static void main(String[] args) {
      Tree23 theTree = new Tree23();

      theTree.insert(50);
      theTree.insert(40);
      theTree.insert(60);
      theTree.insert(30);
      theTree.insert(70);

      theTree.insert(21);
      theTree.insert(19);
      theTree.insert(65);
      theTree.insert(35);
      theTree.insert(18);
      theTree.insert(17);
      theTree.displayTree();
      
      int found = theTree.find(40);
      if (found != -1)
         System.out.println("40 ditemukan di tree");
      else
         System.out.println("40 tidak ditemukan di tree ");

      theTree.delete(70);
      theTree.displayTree();
   }
}

         