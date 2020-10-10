public class DoubleLinkedList<T> {

    NodeD head;

    public DoubleLinkedList() {
        head = null;
    }


    public void addNode(Object value) {
        NodeD newNode = new NodeD(null, value, null);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void deleteNode() {
        head = head.next;
        head.prev = null;
    }

    public void display() {
        NodeD n = head;
        while (n != null) {
            System.out.println((T) n.value);
            n = n.next;
        }
    }
}
