public class ReverseLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void append(int new_data) {
        Node new_node = new Node(new_data);

        if (head == null) {
            head = new_node;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next;
        }
        head = prev;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        
        System.out.println("Original linked list:");
        list.printList();
        
        list.reverse();
        
        System.out.println("Reversed linked list:");
        list.printList();
    }
}
