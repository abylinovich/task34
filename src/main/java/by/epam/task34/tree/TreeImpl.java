package by.epam.task34.tree;

import java.io.Serializable;

public class TreeImpl<T extends Comparable<T>> implements Tree<T>, Serializable {

    private static final long serialVersionUID = 42L;

    private Node<T> root;

    private static class Node<T extends Comparable<T>> {
        T item;
        Node<T> left;
        Node<T> right;

        Node(T element) {
            this(element, null, null);
        }

        Node(T element, Node<T> left, Node<T> right) {
            this.item = element;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "item=" + item +
                    ", left=" + left +
                    ", right=" + right + "\r\n"
                    ;
        }
    }

    public TreeImpl(T element) {
        this(element, null, null);
    }

    public TreeImpl(T element, T left, T right) {
        this.root = new Node<>(element, new Node<>(left), new Node<>(right));
    }

    public void setRoot(T element) {
        this.root = new Node<>(element);
    }

    @Override
    public boolean contains(T element) {
        Node<T> result = findRecursive(root, element);
        return result != null;
    }

    @Override
    public void delete(T element) {
        if(root.item.equals(element)) {
            root = null;
        } else {
            deleteRecursive(root, element);
        }
    }

    @Override
    public void add(T element) {
        addRecursive(root, element);
    }

    private boolean addRecursive(Node<T> current, T element) {
        if(current.item == null) {
            current.item = element;
            return true;
        }
        if(current.left == null || current.right == null) {
            if(current.left == null) {
                current.left = new Node<>(element);
                return true;
            } else {
                current.right = new Node<>(element);
                return true;
            }
        }
        boolean result = addRecursive(current.left, element);
        if(result) {
            return true;
        }
        result = addRecursive(current.right, element);
        return result;

    }

    private Node<T> findRecursive(Node<T> root, T element) {
        if(root == null) {
            return null;
        }
        T item = root.item;
        if(item != null && item.equals(element)) {
            return root;
        } else {
            Node<T> result = findRecursive(root.left, element);
            if(result != null) {
                return result;
            }
            result = findRecursive(root.right, element);
            return result;
        }
    }

    private boolean deleteRecursive(Node<T> root, T element) {
        T left = root.left.item;
        T right = root.right.item;
        if(left != null && left.equals(element)) {
            root.left = null;
            return true;
        } else if(right != null && right.equals(element)) {
            root.right = null;
            return true;
        }
        boolean result = deleteRecursive(root.left, element);
        if(result) {
            return true;
        }
        result = deleteRecursive(root.right, element);
        return result;
    }


    @Override
    public String toString() {
        return root.toString();
    }
}