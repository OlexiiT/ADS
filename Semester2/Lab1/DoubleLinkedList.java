package lab1;

public class DoubleLinkedList implements List {

    private int size = 0;
    private DoubleNode head;
    private DoubleNode tail;

    @Override
    public void addFirst(Object o) {
        DoubleNode dn = new DoubleNode(o, head, null);
        if (size == 0) {
            tail = dn;
        } else if (size == 1) {
            tail.setPrev(dn);
        } else {
            head.setPrev(dn);
        }
        head = dn;
        size++;
    }

    @Override
    public void addLast(Object o) {
        DoubleNode dn = new DoubleNode(o, null, tail);
        if (size == 0) {
            head = dn;
        } else if (size == 1) {
            head.setNext(dn);
        } else {
            tail.setNext(dn);
        }
        tail = dn;
        size++;
    }

    @Override
    public void add(Object o, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(o);
        } else if (index == size) {
            addLast(o);
        } else {
            DoubleNode next = getNode(index);
            DoubleNode prev = next.getPrev();
            DoubleNode newNode = new DoubleNode(o, next, prev);
            next.setPrev(newNode);
            prev.setNext(newNode);
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        head = head.getNext();
        head.setPrev(null);
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException();
        }
        tail = tail.getPrev();
        tail.setNext(null);
        size--;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            DoubleNode next = getNode(index + 1);
            DoubleNode prev = next.getPrev().getPrev();
            prev.setNext(next);
            next.setPrev(prev);
            size--;
        }
    }

    @Override
    public void changeFirst(Object o) {
        head = new DoubleNode(o, head.getNext(), null);
    }

    @Override
    public void changeLast(Object o) {
        tail = new DoubleNode(o, null, tail.getPrev());
    }

    @Override
    public void change(Object o, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            changeFirst(o);
        } else if (index == size - 1) {
            changeLast(o);
        } else {
            DoubleNode node = getNode(index);
            DoubleNode newNode = new DoubleNode(o,
                    node.getNext(), node.getPrev());
            node.getNext().setPrev(newNode);
            node.getPrev().setNext(newNode);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int index(Object value) {
        DoubleNode n = head;
        int index = 0;
        if (value == null) {
            while (n != null) {
                if (n.getData() == null) {
                    return index;
                }
                index++;
                n = n.getNext();
            }
        } else {
            while (n != null) {
                if (value.equals(n.getData())) {
                    return index;
                }
                index++;
                n = n.getNext();
            }
        }
        return -1;
    }

    @Override
    public Object get(int i) {
        return getNode(i).getData();
    }

    private DoubleNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode n;
        if (index < size / 2) {
            n = head;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
        } else {
            n = tail;
            for (int i = size - 1; i > index; i--) {
                n = n.getPrev();
            }
        }
        return n;
    }

    @Override
    public String toString() {
        String result = "[";
        DoubleNode n = head;
        if (n != null) {
            while (true) {
                if (n.getNext() != null) {
                    result += n.getData() + ", ";
                    n = n.getNext();
                } else {
                    result += n.getData();
                    break;
                }
            }
        }
        result += "]";
        return result;
    }

    @Override
    public int sum() {
        int result = 0;
        DoubleNode n = head;
        while (n != null) {
            result += (int) n.getData();
            n = n.getNext();
        }
        return result;
    }
    
    @Override
    public void clean() {
        head = null;
        size = 0;
    }

}
