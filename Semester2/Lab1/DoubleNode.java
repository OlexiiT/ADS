package lab1;

public class DoubleNode{
    
    private Object data;
    private DoubleNode next = null;
    private DoubleNode prev = null;
    
    public DoubleNode(Object data, DoubleNode next, DoubleNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public DoubleNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
    
    public void setNext (DoubleNode next) {
        this.next = next;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getPrev() {
        return prev;
    }
    
}
