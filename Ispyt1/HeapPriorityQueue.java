package ispyt1;

public class HeapPriorityQueue <E extends Comparable<E>> {
    
    private BinaryHeap heap = new BinaryHeap(50000);
    
    public void add(E data, int priority) {
        PriorityQueueNode node = new PriorityQueueNode(data, priority);
        heap.add(node);
    }
    
    public PriorityQueueNode getMin() {
        return (PriorityQueueNode) (heap.getMin());
    }
    
    public void deleteMin() {
        PriorityQueueNode node = getMin();
        heap.delete(node);
    }
    
}
