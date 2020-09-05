public class RearrangeList {

    public static Node reverse(Node head){
        Node prev = null;
        Node cur = head;
        Node next = head;
        while(cur.next!=null){
            next = cur.next;
            if(cur.next!=null)
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
    }
    
    public static Node rearrange(Node node){
        Node cur = node;
        if(cur.next==null){
            return cur;
        }
        else{
            while(cur.next!=null){
                cur.next = reverse(cur.next);
                cur = cur.next;
            }  
            return node;
        }
    }    
  

    public static void print(Node head){
        Node cur = head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node rearranged = rearrange(node);
        print(rearranged);
    }

}