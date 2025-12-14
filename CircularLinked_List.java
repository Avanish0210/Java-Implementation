public class CircularLinked_List {
    Node head = null;
    Node tail = null;

    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            tail.next = head;
        }else{
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            tail.next = head;
        }else{
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFirst(){
        if(head==null) return;
        Node temp = head;
        head = this.head.next;
        tail.next = head;
        temp.next = null;
        
    }



    public void print(){
        if(head==null) return;
        Node currNode = head.next;
        System.out.print(head.data +" -> ");

        while(currNode!=head){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println(head.data);
    }

    public static void main(String[] args) {
        CircularLinked_List list = new CircularLinked_List();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.removeFirst();

        list.print();
        
    }
}
