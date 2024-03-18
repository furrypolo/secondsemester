package a;

public class LinkedList {
	Node head;
	Node tail;
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    void merge(LinkedList list2) {
        Node first = this.head;
        Node second = list2.head;
        if (first == null) {
            this.head = second;
            return;
        }
        if (second == null) {
            return;
        }
        while (first.next != null) {
            first = first.next;
        }
        first.next = second;
    }
    
    public void pushQ(int data) {
    	Node newNode = new Node(data);
    	if(head == null) {
    		head = newNode;
    		tail = newNode;
    	}
    	else {
    		tail.next = newNode;
    		tail = newNode;
    	}
    }
	public static void main(String[] args) {
		LinkedList first= new LinkedList();
        LinkedList second = new LinkedList();

        first.pushQ(1);
        first.pushQ(2);
        first.pushQ(3);

        second.pushQ(4);
        second.pushQ(5);
        second.pushQ(6);

        first.printList();
        second.printList();
        
        LinkedList third = new LinkedList();
        third=first.merge(second);
        first.printList();
	}

}
