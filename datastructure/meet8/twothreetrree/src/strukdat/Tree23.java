package strukdat;
import strukdat.DataItem;
import strukdat.Node;

// import org.w3c.dom.Node;

public class Tree23 {
    private Node<Integer> root = new Node();

   // Method untuk mencari kunci dalam pohon
   public int find(long key) {
      Node<Integer> curNode = root;
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
      Node<Integer> curNode = root;
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
      Node<Integer> parent, child2, child3;
      int itemIndex;

      itemC = thisNode.removeItem();
      itemB = thisNode.removeItem();
      child2 = thisNode.disconnectChild(2);
      child3 = thisNode.disconnectChild(3);
      
      Node newRight = new Node();

      if (thisNode == root) {
         root = new Node<Integer>();
         parent = root;
         root.connectChild(0, thisNode);
      } else
         parent = thisNode.getParent();

      itemIndex = parent.insertItem(itemB);
      int n = parent.getNumItems();

      for (int j = n - 1; j > itemIndex; j--) {
         Node<Integer> temp = parent.disconnectChild(j);
         parent.connectChild(j + 1, temp);
      }
      parent.connectChild(itemIndex + 1, newRight);
      newRight.insertItem(itemC);
      newRight.connectChild(0, child2);
      newRight.connectChild(1, child3);
   }

   // Method untuk mendapatkan child berikutnya dari sebuah node
   public Node<Integer> getNextChild(Node<Integer> theNode, long theValue) {
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
         Node<Integer> nextNode = thisNode.getChild(j);
         if (nextNode != null)
            recDisplayTree(nextNode, level + 1, j);
            else
               return;
         }
      }

      public void delete(long key) {
         Node<Integer> curNode = root;
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
      private void removeItem(int index, Node<Integer> node) {
         // Shift items to the left
         for (int i = index; i < node.getNumItems() - 1; i++) {
               node.itemArray[i] = node.itemArray[i + 1];
         }
         node.numItems--;
         }
   

  
}
