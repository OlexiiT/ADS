package ispyt1;

public class Node <E extends Comparable<E>>{
    
    private E data;
    private Node<E> left = null;
    private Node<E> right = null;

    public int compareTo(Node<E> node) {
        return data.compareTo(node.getData());
    }
    
    public Node(E data) {
        this.data = data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return data + "";
    }
    
}
