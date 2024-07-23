package com.craftelix.strategy;

import java.util.*;

public class TreeList<E> {

    private final Node<E> root;

    public TreeList(final E root) {
        this.root = new Node<>(root);
    }

    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        if (parentNode.isPresent() && childNode.isEmpty()) {
            Node<E> newChildNode = new Node<>(child);
            parentNode.get().children.add(newChildNode);
            newChildNode.parent = parentNode.get();
            rsl = true;
        }
        return rsl;
    }

    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public List<E> getLastNodeValues() {
        List<E> rsl = new ArrayList<>();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.isEmpty()) {
                rsl.add(el.value);
            } else {
                data.addAll(el.children);
            }
        }
        return rsl;
    }

    public List<E> getPathTo(E value) {
        List<E> path = new ArrayList<>();
        Optional<Node<E>> node = findBy(value);
        if (node.isPresent()) {
            Node<E> el = node.get();
            while (el != null) {
                path.add(0, el.value);
                el = el.parent;
            }
        }
        return path;
    }

    private class Node<E> {
        final E value;
        Node<E> parent = null;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }
    }
}
