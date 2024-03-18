class Node {
    int info;
    Node next;

    public Node(int data) {
        this.info = data;
        this.next = null;
    }
}  
public class SingularList {
    Node head = null; 
    Node tail = null; 

    public void pushQ(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void printList() {
        Node curr = head;
        if(curr == null) System.out.println("List kosong!");
        else {
            System.out.print("[ ");
            while(curr != null) {
                System.out.print(curr.info + " ");
                curr = curr.next;
            }
        }
        System.out.println("]");
    }

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

    public void mergeNew(SingularList FIRST, SingularList SECOND){
        Node curr=null;
        if (FIRST.head == null) {
            this.head = SECOND.head;
            this.tail = SECOND.head;
            curr = SECOND.head.next;
        }
        else{
            this.head = FIRST.head;
            this.tail = FIRST.head;  
            curr = FIRST.head.next;
        }

        while (curr != null) {
            tail.next = curr;
            tail = curr;
            curr = curr.next;
        }
        if(FIRST.head!=null && SECOND.head!=null){
            curr = SECOND.head;
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
    }
}

