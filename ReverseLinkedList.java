class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class Main{

    public static Node reverseLinkedList(Node head){
        if(head.next==null)
            return head;
        Node prev = null, cur = head, next = head.next;
        while(cur.next!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        head = cur;
        return head;
    }

    public static void print(Node head){
        System.out.print("Reversed Linked List: ");
        while(head.next!=null){
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
    }

    public static void main(String[] args){
        Node head = new Node(1);
        

        print(head);
        Node rev_list = reverseLinkedList(head);
        print(rev_list);
    }
}
