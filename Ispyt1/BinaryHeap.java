package ispyt1;

public class BinaryHeap<E extends Comparable<E>> {

    private Object[] heap;
    private int size = 0;
    private final int capacity;
    
    public BinaryHeap() {
        capacity = 100;
        heap = new Object[100];
    }

    public BinaryHeap(int capacity) {
        this.capacity = capacity++;
        heap = new Object[capacity];
    }
    
    public E getMin() {
        return (E) (heap[1]);
    }

    public void add(E x) {
        if(size == capacity) {
            throw new RuntimeException("Sorry, this heap is full!");
        } 
        heap[++size] = x;
        int i = size;
        while(i > 1) {
            int parent = i / 2;
            if(((E) (heap[i])).compareTo((E) (heap[parent])) >= 0) break;
            swap(i, parent);
            i = parent;
        }
    }
    
    public E delete(E i) {
        if (size == 0) throw new RuntimeException("Sorry, this heap is empty!");
        E min = (E) heap[1];
        heap[1] = heap[size--];
        int index = 1;
        while(true) {
            int next = index * 2;
            if (next > size) break;
            if (next + 1 <= size) {
                next = min(next, next + 1);
            }
            if (((E) (heap[index])).compareTo((E) (heap[next])) <= 0) break;
            swap(index, next);
            index = next;
        }
        return min;
    }
    
    public int find(E i) {
        for (int j = 0; j < heap.length; j++) {
            if (((E) (heap[j])).compareTo(i) == 0) return 1;
        }
        return -1;
    }

    private void swap(int i, int j) {
        Object b = heap[i];
        heap[i] = heap[j];
        heap[j] = b;
    }

    private int min(int left, int right) {
        if (((E) (heap[left])).compareTo((E) (heap[right])) < 0) {
            return left;
        }
        return right;
    }
    
}
