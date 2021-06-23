package ispyt1;

public class TreeSet<E extends Comparable<E>> {

    BinaryTree tree = new BinaryTree();

    public void add(E data) {
        tree.insert(data);
    }

    public void remove(E data) {
        tree.delete(data);
    }

    public boolean hasObject(E data) {
        if (tree.find(data) != null) {
            return true;
        }
        return false;
    }

}
