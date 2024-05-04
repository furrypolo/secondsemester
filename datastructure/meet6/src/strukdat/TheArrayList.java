package strukdat;

public class TheArrayList<E> {
    Object[] thelist;
    private int n;
    private int max_size;

    public TheArrayList(int max_size){
        thelist = new Object[max_size];
        n=0;
        this.max_size = max_size;
    }

    public int maxSize(){
        return max_size;
    }

    public int size(){
        return n;
    }

    public void setSize(int size){
        n=size;
    }

    private boolean isFull(){
        if(n == max_size) return true;
        else return false;
    }

    public boolean isEmpty(){
        if(n==0) return true;
        else return false;
    }

    public void add(E value){
        if(!isFull()){
            thelist[n] = value;
            n=n+1;
        }
        else System.out.println("List sudah penuh!");
    }

    public void add(int index, E value){
        if(index>=0 && !isFull()){
            n=n+1;
            int i=n;
            do{
                thelist[i] = thelist[i-1];
                i = i-1;
            }while(i>index);
            thelist[index]=value;
        }
        else System.out.println("List sudah penuh!");
    }

    public void remove(int index){
        if(index>=0 && !isEmpty()){
            for(int i=index; i<n-1; i++)
                thelist[i]=thelist[i+1];
            thelist[n-1] = null;
            n=n-1;
        }
    }

    public E get(int i){
        @SuppressWarnings("unchecked")
        final E e = (E) thelist[i];
        return e;
    }

    public void set(int index, E value){
        thelist[index] = value;   
    }

    public void clear(){
        if(!isEmpty()){
            for(int i=0;i<n;i++)
                thelist[i] = null;
            n=0;
        }
    }

    public void cetakList(){
        if(isEmpty()) System.out.println("List Kosong!");
        else{
            System.out.print("[");
            for(int i=0; i<n; i++)
            if(this.thelist[i]!=null){
                System.out.print(thelist[i].toString()+" ");
            }
            System.out.println("]");
        }
    }
}
