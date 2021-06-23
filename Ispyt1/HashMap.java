package ispyt1;

import java.util.ArrayList;

public class HashMap<K, V> {
    
    private ArrayList<HashMapNode<K, V>> buckets;
    private int bucketsNumber;
    private int size = 0;
    private double loadFactor = 0.75;

    public HashMap() {
        buckets = new ArrayList<>(32);
        bucketsNumber = 31;
        for (int i = 0; i < 32; i++) {
            buckets.add(null);
        }
    }
    
    public HashMap(int capacity) {
        buckets = new ArrayList<>(capacity);
        bucketsNumber = capacity;
        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }
    }
    
    public void put(K key, V value) {
        int index = getBucketNumber(key);
        HashMapNode<K, V> node = buckets.get(index);
        while (node != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
            node = node.getNext();
        }
        size++;
        HashMapNode<K, V> nextNode = new HashMapNode(key, value);
        nextNode.setNext(buckets.get(bucketsNumber));
        buckets.set(index, nextNode);
        if (size / bucketsNumber > loadFactor) {
            buckets = changeCapacity();
        } 
    }
    
    public int getSize() {
        return size;
    }
    
    public V get(K key) {
        HashMapNode<K, V> node = buckets.get(getBucketNumber(key));
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }
    
    public void delete(K key) {
        HashMapNode<K, V> node = buckets.get(getBucketNumber(key));
        if (node == null) {
            return;
        }
        HashMapNode<K, V> prev = null;
        while (node != null){
            if (node.getKey().equals(key)) {
                break;
            }
            prev = node;
            node = node.getNext();
        }
        size--;
        if (prev != null) {
            if (node == null) {
                return;
            }
            prev.setNext(node.getNext());
        } else {
            buckets.set(bucketsNumber, node.getNext());
        }
    }
    
    private ArrayList<HashMapNode<K, V>> changeCapacity() {
        bucketsNumber = bucketsNumber * 2 + 1;
        ArrayList<HashMapNode<K, V>> list = new ArrayList<HashMapNode<K, V>>(bucketsNumber);
        for (HashMapNode<K, V> node: buckets) {
            list.add(node);
        }
        for (int i = bucketsNumber / 2; i < bucketsNumber; i++) {
            list.add(null);
        }
        return list;
    }
    
    public void setLoadFactor(int loadFactor) {
        this.loadFactor = loadFactor;
    }
    
    private int getBucketNumber(K key) {
        return Math.abs(key.hashCode() % bucketsNumber);
    }
    
    public ArrayList toArraylist() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i) != null) {
                list.add(list);
            }
        }
        return list;
    }
    
}

