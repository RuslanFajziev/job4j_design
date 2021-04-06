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
                    index = indexFor(elmNode.getKey(), capacityGrow);
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
        NodeHashMap nodeHashMap = new NodeHashMap(h, value);
        NodeHashMap node = container[index];
        if (node != null && node.getKey() == h) {
            return false;
        } else if (node != null && node.getKey() != h) {
            container[index] = nodeHashMap;
            modCount++;
            return true;
        }
        container[index] = nodeHashMap;
        count++;
        modCount++;
        grow();
        return true;
    }

    public boolean delete(K key) {
        int h = hash(key.hashCode());
        for (int i = 0; i < capacity; i++) {
            NodeHashMap node = container[i];
            if (node != null && node.getKey() == h) {
                container[i] = null;
                count--;
                modCount++;
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        int h = hash(key.hashCode());
        for (int i = 0; i < capacity; i++) {
            NodeHashMap node = container[i];
            if (node != null && node.getKey() == h) {
                return (V) node.getValue();
            }
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
                return head < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (container[head] == null) {
                    head++;
                }
                NodeHashMap nod = container[head];
                if (nod == null) {
                    return null;
                }
                head++;
                return (K) nod.getValue();
            }
        };
    }

    private static class NodeHashMap<V> {
        private int key;
        private V value;

        public NodeHashMap(int key, V value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NodeHashMap<?> that = (NodeHashMap<?>) o;
            return key == that.key && value.equals(that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
