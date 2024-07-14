import strukdat.Tree23;
public class App {
    public static void main(String[] args) {
        Tree23 theTree = new Tree23();
  
        theTree.insert(24);
        theTree.insert(41);
        theTree.insert(28);
        theTree.insert(53);
        theTree.insert(13);
        theTree.insert(31);
        theTree.insert(74);
        theTree.insert(27);
        theTree.insert(72);
        theTree.insert(50);
        theTree.insert(48);
        theTree.insert(5);
        theTree.insert(19);
        theTree.insert(97);
        theTree.insert(59);
        theTree.insert(16);
        theTree.insert(90);
        theTree.insert(75);
        theTree.insert(18);
        theTree.displayTree();
        System.out.println("");
        int found = theTree.find(40);
        if (found != -1)
           System.out.println("40 ditemukan di tree");
        else
           System.out.println("40 tidak ditemukan di tree ");
        System.out.println("");
        theTree.delete(24);
        theTree.displayTree();
     }
}
