package ispyt1;

public class TreePriorityQueue <E extends Comparable<E>> {
    
    private BinaryTree tree = new BinaryTree();
    
    public void add(E data, int priority) {
        PriorityQueueNode node = new PriorityQueueNode(data, priority);
        tree.insert(node);
    }
    
    public PriorityQueueNode getMin() {
        return (PriorityQueueNode) (tree.getMin().getData());
    }
    
    public void deleteMin() {
        PriorityQueueNode node = getMin();
        tree.delete(node);
    }
    
}
