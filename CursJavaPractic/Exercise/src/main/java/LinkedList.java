public class LinkedList<T> {
    Object value;
    Node head;

    public LinkedList() {
        head = null;
    }

    public void addNode(Object value) {
        Node newNode = new Node(value, null);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void deleteNode() {
        head = head.next;
    }


    public void display() {
        Node n = head;
        while (n != null) {
            System.out.println((T) n.value);
            n = n.next;
        }

    }
}
