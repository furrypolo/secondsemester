import java.util.LinkedList;

class Node {
    int info;
    Node next;

    //constructor
    public Node(int data) {
        this.info = data;
        this.next = null;
    }
}

public class SingularList {
    Node head = null; //pointer ke node pertama
	Node tail = null; //pointer ke node terakhir

    /*
     * Setiap node baru yang dibuat diletakkan di akhir list
     * (queue)
     */
    public void pushQ(int data) {
        //buat node baru
		Node newNode = new Node(data);
        //jika list kosong, head dan tail sama-sama menunjuk ke node pertama
		if (head == null) {
			head = newNode;
			tail = newNode;
		}
        //jika tidak kosong, tail diupdate untuk menunjuk ke node baru
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
    
    //Mencetak bagian informasi dari setiap node di linkedlist
    public void printList() {
        //set pointer curr untuk menunjuk ke node pertama 
        //(node pertama yang ditunjuk oleh head)
		Node curr = head;
        //jika list kosong, tampilkan pesan list kosong
		if(curr == null) System.out.println("List kosong!");
        /*
         * jika list tidak kosong, maka cetak bagian informasi 
           dari setiap node yang dikunjungi. 
        */
		else {
            System.out.print("[ ");
			while(curr != null) {
				System.out.print(curr.info + " ");
                /*
                 * curr diupdate untuk menunjuk ke node selanjutnya
                 * sampai curr null, dimana curr diset ke bagian 'next' 
                 * dari node terakhir yang bernilai null. Artinya, 
                 * pointer curr sudah ada di akhir node.
                 */
				curr = curr.next;
			}
		}
        System.out.println("]");
	}


    //pop, mengambil node pertama dan menghapusnya dari list
    Node pop() {
        Node n;
        if(head == null) return head;
        else {
            n = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }   
        }
        return n;
    }

    public void mergeNew(SingularList n, SingularList x){
        Node curr=null;
        if (n.head == null) {
            this.head = x.head;
            this.tail = x.head;
            curr = x.head.next;
        }
        else{
            this.head = n.head;
            this.tail = n.head;  
            curr = n.head.next;
        }

        while (curr != null) {
            tail.next = curr;
            tail = curr;
            curr = curr.next;
        }
        if(n.head!=null && x.head!=null){
            curr = x.head;
            while(curr != null){
                tail.next = curr;
                tail = curr;
                curr = curr.next;
        }
        }
    }

    public void changeInfo(int n, int data){
        Node newNode = new Node(data);
        SingularList list1 = new SingularList();
        if(n==1){
            list1.head=newNode;
        }
        else{
            list1.head=this.head;
        }
        list1.tail=this.head.next;
        Node curr = this.head.next.next;
        int count=3;
        while(curr != null){
            if(count == n){
                list1.tail.next=newNode;
                list1.tail=newNode;
            }
            else{
                list1.tail.next=curr;
                list1.tail=curr;
            }
            count+=1;
            curr=curr.next;
        }

        curr=this.head;
        while(curr != null){
            this.pop();
            curr=this.head;
        }
        curr=list1.head;
        this.head=curr;
        curr=curr.next;
        this.tail=curr;
        curr=curr.next;
        while(curr!=null){
            this.tail.next=curr;
            this.tail=curr;
            curr=curr.next;
        }
    }
    
    

    public static void main(String[] args) {

        SingularList list1 = new SingularList();
        SingularList list2 = new SingularList();
        SingularList list3 = new SingularList();

        list1.pushQ(1);
        list1.pushQ(2);
        list1.pushQ(3);
        list1.pushQ(4);
        list1.pushQ(5);
        list1.pushQ(6);

        list2.pushQ(7);
        list2.pushQ(8);
        list2.pushQ(9);
        
        list1.printList();
        list2.printList();

        list3.mergeNew(list1, list2);

        list3.printList();

        list1.changeInfo(7,100);

        list1.printList();


	}
}
