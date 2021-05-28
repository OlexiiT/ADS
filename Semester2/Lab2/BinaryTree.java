package lab2;

public class BinaryTree {

    private Node root;

    public void insert(int number) {
        root = insert(root, number);
    }

    private Node insert(Node node, int number) {
        if (node == null) {
            return new Node(number);
        } else {
            if (node.getData() > number) {
                node.setLeft(insert(node.getLeft(), number));
            } else {
                node.setRight(insert(node.getRight(), number));
            }
        }
        return node;
    }

    public void delete(int number) {
        if (root.getData() == number) {
            if (root.getLeft() == null) {
                root = root.getRight();
            } else {
                if (root.getRight() == null) {
                    root = root.getLeft();
                } else {
                    Node right = root.getRight();
                    Node left = root.getLeft();
                    Node min = getMin(right);
                    min.setLeft(left);
                    root = right;
                }
            }
        } else if (root != null) {
            delete(root, number);
        }
    }

    private Node delete(Node node, int number) {
        if (node == null) {
            return node;
        } else if (node.getData() > number) {
            node.setLeft(delete(node.getLeft(), number));
        } else if (node.getData() < number) {
            node.setRight(delete(node.getRight(), number));
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

    private Node getMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public int getSum() {
        return getSum(root);
    }

    private int getSum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getData() + getSum(node.getLeft()) + getSum(node.getRight());
    }

    public Node find(int number) {
        return find(root, number);
    }

    private Node find(Node node, int number) {
        if (node == null) {
            return null;
        } else if (node.getData() == number) {
            return node;
        } else if (node.getData() > number) {
            return find(node.getLeft(), number);
        } else {
            return find(node.getRight(), number);
        }
    }

}
