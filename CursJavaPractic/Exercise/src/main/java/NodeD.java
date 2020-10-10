public class NodeD {

    NodeD prev;
    Object value;
    NodeD next;

    public NodeD(NodeD prev,Object value,NodeD next){
        this.prev = prev;
        this.value = value;
        this.next = next;
    }
}
