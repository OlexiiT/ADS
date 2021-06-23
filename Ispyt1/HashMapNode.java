package ispyt1;

public class HashMapNode<K, V> {
    
    private HashMapNode<K, V> next = null;
    private K key;
    private V value;
   
    public HashMapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public HashMapNode<K, V> getNext() {
        return next;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setNext(HashMapNode<K, V> next) {
        this.next = next;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public void setValue(V value) {
        this.value = value;
    }
}