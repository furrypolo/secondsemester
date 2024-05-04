package strukdat;

public class BinarySearchTree<K extends Comparable<? super K>,V> extends BinaryTree<K,V> implements Tree<K,V>{
    private GNode<K,V>root;
    public BinarySearchTree(){
        root=null;
    }
    public void insert(K key, V data){
        root = insertNode(root, key, data);
    }
    public void delete(K key){
        root = deleteNode(root, key);
    }
    public V search(K key){
        V info = null;
        info = getData(find(root,key));
        return info;
    }
    public K max(){
        K kunci = null;
        kunci = getKey(findMax(root));
        return kunci;
    }
    public K min(){
        K kunci = null;
        kunci = getKey(findMin(root));
        return kunci;
    }

    private GNode<K,V> insertNode(GNode<K,V> node, K k, V data){
        if(node == null){
            GNode<K,V>newNode = new GNode<K,V>(k,data);
            return newNode;
        }
        else if(k.compareTo(node.key)<0){
            node.llink=insertNode(node.llink, k, data);
            return node;
        }
        else{
            node.rlink=insertNode(node.rlink, k, data);
            return node;
        }
    }

    private GNode<K,V> find(GNode<K,V>node, K k){
        if(node==null||node.key==k) return node;
        else if(node.key.compareTo(k)<0) return find(node.rlink,k);
        else return find(node.llink, k);
    }

    public void inOrder(){
        printInOrder(root);
    }

    public void levelOrder(){
        printLevelOrder(root);
    }

    public K getKey(GNode<K,V>node){
        return node.key;
    }

    public V getData(GNode<K,V>node){
        return node.data;
    }

    private GNode<K,V> findMax(GNode<K,V>node){
        if(node.rlink!=null){
            GNode<K,V>max = findMax(node.rlink);
            return max;
        }
        else{
            GNode<K,V>max = node;
            return max;
        }
    }

    private GNode<K,V> findMin(GNode<K,V>node){
        if(node.llink!=null){
            GNode<K,V>min = findMin(node.llink);
            return min;
        }
        else{
            GNode<K,V>min = node;
            return min;
        }
    }

    private GNode<K,V> deleteNode(GNode<K,V>node, K k){
        if(root==null){
            return root;
        }
        if(node.key==k){
            if(node.rlink==null && node.llink!=null){      
                K temp = getKey(node.llink);
                V val = getData(node.llink);
                node.key=temp;
                node.data=val;
                root = deleteNode(node.llink, temp);
                return root;
            }
            else if(node.rlink!=null){
                K temp = getKey(node.rlink);
                V val = getData(node.rlink);
                node.key=temp;
                node.data=val;
                root = deleteNode(node.rlink, temp);
                return root;
            }
            else{
                node.key = null;
                node.data = null;
                return root;
            }
        }
        else{
            if(k.compareTo(node.key)>0){
                root = deleteNode(node.rlink, k);
                return root;
            }
            else{
                root = deleteNode(node.llink, k);
                return root;
            }
        }
    }

}