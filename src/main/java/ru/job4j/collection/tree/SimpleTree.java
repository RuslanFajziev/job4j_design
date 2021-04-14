package ru.job4j.collection.tree;

import java.util.*;
import java.util.function.Predicate;

class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean isBinary() {
        Predicate<Node<E>> predicate = x -> x.children.size() > 2;
        Optional<Node<E>> rsl = findByPredicate(predicate);
        return !rsl.isPresent();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public boolean add(E parent, E child) {
        Node<E> node = new Node<>(child);
        Optional<Node<E>> rslParent = findBy(parent);
        if (rslParent.isPresent()) {
            List<Node<E>> childLst = rslParent.get().children;
            if (findBy(child).isEmpty()) {
                childLst.add(node);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> predicate = x -> x.value.equals(value);
        return findByPredicate(predicate);
    }
}