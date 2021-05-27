package lab1;

public class Node {
    
    private Object data;
    private Node next = null;
    
    public Node(Object data) {
        this.data = data;
    }
    
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }
    
    public void setNext (Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
    
}
