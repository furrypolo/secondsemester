package strukdat;

public class BinaryTree<K,V> {

    public void printInOrder(GNode<K,V> node){
        if(node==null) return;
        else{
            printInOrder(node.llink);
            System.out.print(node+" ");
            printInOrder(node.rlink);
        }
    }

    private void printLevelOrderRec(SingleList<GNode<K,V>>q){
        if(q.isEmpty()) return;
        GNode<K,V> node = q.remove();
        if(node.key==null){
            System.out.print("");
        }
        else{   
            System.out.print(node+" ");
        }
        if(node.llink!=null) q.pushQ(node.llink);
        if(node.rlink!=null) q.pushQ(node.rlink);
        printLevelOrderRec(q);
    }

    public void printLevelOrder(GNode<K,V>node){
        SingleList<GNode<K,V>>q=new SingleList<GNode<K,V>>();
        q.pushQ(node);
        printLevelOrderRec(q);
    }
    
}
