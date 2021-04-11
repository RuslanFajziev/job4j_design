package ru.job4j.collection.hashmap;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayHash<K, V> implements Iterable<K> {
    private NodeHashMap[] container;
    private int capacity = 10;
    private int count = 0;
    private int modCount = 0;
    final double fullness = 0.75;

    public ArrayHash() {
        this.container = new NodeHashMap[capacity];
    }

    static int hash(int hk) {
        return Objects.hash(hk);
    }

    static int indexFor(int h, int length) {
        return h % length;
    }

    public int size() {
        return count;
    }

    private void grow() {
        int capacityGrow = capacity;
        int index;
        if (((double) count / capacity) >= fullness) {
            capacityGrow += 10;
            NodeHashMap[] newContainer = new NodeHashMap[capacityGrow];
            for (var elmNode : container) {
                if (elmNode == null) {
                    index = 0;
                } else {
                    index = indexFor(elmNode.getHash(), capacityGrow);
                }
                newContainer[index] = elmNode;
            }
            container = newContainer;
            capacity = capacityGrow;
        }
    }

    public boolean insert(K key, V value) {
        int h = hash(key.hashCode());
        int index = indexFor(h, capacity);
        NodeHashMap newNode = new NodeHashMap(h, key, value);
        NodeHashMap node = container[index];
        if (node == null) {
            container[index] = newNode;
            count++;
            modCount++;
            grow();
            return true;
        }
        return false;
    }

    public boolean delete(K key) {
        int h = hash(key.hashCode());
        int index = indexFor(h, capacity);
        ArrayHash.NodeHashMap node = container[index];
        if (node != null && node.getHash() == h && node.getKey().equals(key)) {
            container[index] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int h = hash(key.hashCode());
        int index = indexFor(h, capacity);
        ArrayHash.NodeHashMap node = container[index];
        if (node != null && node.getHash() == h && node.getKey().equals(key)) {
            return (V) node.getValue();
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int head = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (head < capacity && container[head] == null) {
                    head++;
                }
                return head < capacity && container[head] != null;
            }

            @Override
            public K next() {
                if (head >= capacity && !hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) container[head++];
            }
        };
    }

    protected static class NodeHashMap<K, V> {
        private int hash;
        private K key;
        private V value;

        public NodeHashMap(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NodeHashMap<?, ?> that = (NodeHashMap<?, ?>) o;
            return hash == that.hash && key.equals(that.key) && value.equals(that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hash, key, value);
        }
    }
}
