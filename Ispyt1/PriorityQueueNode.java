package ispyt1;

public class PriorityQueueNode<E extends Comparable<E>> implements Comparable<PriorityQueueNode> {

    private int priority;
    private E e;

    public PriorityQueueNode(E e, int priority) {
        this.priority = priority;
        this.e = e;
    }

    @Override
    public int compareTo(PriorityQueueNode o) {
        int r = priority - o.getPriority();
        if (r != 0) {
            return r;
        } else {
            return e.compareTo((E) o.getE());
        }
    }

    public int getPriority() {
        return priority;
    }

    public E getE() {
        return e;
    }

}
