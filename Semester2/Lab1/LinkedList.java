package lab1;

public class LinkedList implements List {

    private Node head;
    private int size = 0;

    @Override
    public void addFirst(Object o) {
        head = new Node(o, head);
        size++;
    }

    @Override
    public void addLast(Object o) {
        if (size == 0) {
            head = new Node(o);
        } else {
            Node n = getNode(size - 1);
            n.setNext(new Node(o));
        }
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
            Node node = getNode(index - 1);
            Node newNode = new Node(o, node.getNext());
            node.setNext(newNode);
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        head = head.getNext();
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = getNode(size - 2);
        prev.setNext(null);
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
            Node prev = getNode(index - 1);
            prev.setNext(prev.getNext().getNext());
            size--;
        }
    }

    @Override
    public void changeFirst(Object o) {
        head = new Node(o, head.getNext());
    }

    @Override
    public void changeLast(Object o) {
        Node prev = getNode(size - 2);
        prev.setNext(new Node(o));
    }

    @Override
    public void change(Object o, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            changeFirst(o);
        } else if (index == size - 1) {
            changeLast(o);
        } else {
            Node prev = getNode(index - 1);
            prev.setNext(new Node(o, prev.getNext().getNext()));
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int index(Object value) {
        Node n = head;
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
    public Object get(int index) {
        return getNode(index).getData();
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        return n;
    }

    @Override
    public String toString() {
        String result = "[";
        Node n = head;
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
        Node n = head;
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
