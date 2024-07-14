package strukdat;

public class GNode<K,V> {
    K key;
    V data;

    GNode<K,V> llink;
    GNode<K,V> rlink;

    public GNode(K k, V data){
        this.key = k;
        this.data = data;
        llink = null;
        rlink = null;
    }

    @Override
    public String toString(){
        return(key.toString()+":"+data.toString()+"");
    }
}  
