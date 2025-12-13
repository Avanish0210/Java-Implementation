public class DoublyLined_List {
    Node head;
    Node tail;

    public class Node {
        int data;
        Node next;
        Node prev; 

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }

    public void LastaddFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head =newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.prev = head;
            tail.next = newNode;
            tail = newNode;


        }

    }

    public void removeFirst(){
        if(head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }
        head = this.head.next;
        head.prev = null;
    }

    public void removeLast(){
        if(tail == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }
        Node curr = head;
        Node lastNode = head.next;
        while(lastNode.next!=null){
            curr = curr.next;
            lastNode = lastNode.next;
        }
        curr.next = null;
        lastNode.prev = null;
    }
    public void print(){
        Node currNode = head;

        while(currNode != null){
            System.out.print(currNode.data + " <=> ");
            currNode = currNode.next;
        }
        System.out.print(" null");
    }

    public static void main(String[] args) {
        DoublyLined_List list = new DoublyLined_List();
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);

        list.removeLast();

        list.print();
        
    }
}
