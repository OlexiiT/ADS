package ispyt1;

public class BinaryTree <E extends Comparable<E>>{

    private Node<E> root;

    public void insert(E data) {
        root = insert(root, new Node<E>(data));
    }

    private Node<E> insert(Node<E> parent, Node<E> node) {
        if (parent == null) {
            return node;
        } else {
            if (parent.compareTo(node) > 0) {
                node.setLeft(insert(parent.getLeft(), node));
            } else {
                parent.setRight(insert(parent.getRight(), node));
            }
        }
        return parent;
    }

    public void delete(E data) {
        if (root.getData().compareTo(data) == 0) {
            if (root.getLeft() == null) {
                root = root.getRight();
            } else {
                if (root.getRight() == null) {
                    root = root.getLeft();
                } else {
                    Node<E> right = root.getRight();
                    Node<E> left = root.getLeft();
                    Node<E> min = getMin(right);
                    min.setLeft(left);
                    root = right;
                }
            }
        } else if (root != null) {
            delete(root, data);
        }
    }

    private Node<E> delete(Node<E> node, E data) {
        if (node == null) {
            return node;
        } else if (node.getData().compareTo(data) > 0) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (node.getData().compareTo(data) < 0) {
            node.setRight(delete(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setData(getMin(node.getRight()).getData());
            node.setRight(delete(node.getRight(), node.getData()));
        }
        return node;
    }
    
    public Node<E> getMin() {
        return getMin(root);
    }

    private Node<E> getMin(Node<E> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public Node<E> find(E data) {
        return find(root, data);
    }

    private Node<E> find(Node<E> node, E data) {
        if (node == null) {
            return null;
        } else if (node.getData().compareTo(data) == 0) {
            return node;
        } else if (node.getData().compareTo(data) > 0) {
            return find(node.getLeft(), data);
        } else {
            return find(node.getRight(), data);
        }
    }

}
