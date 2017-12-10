package by.epam.task34.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeImpl<T> implements Tree<T>, Serializable {

    private static final long serialVersionUID = 42L;

    private static final String UNKNOWN_STRATEGY_EXCEPTION_MESSAGE = "Unknown strategy.";

    private Node<T> root;

    private static class Node<T> {
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
            if(left == null && right == null) {
                return "" + item + "\r\n";
            } else {
                if(left != null && right != null) {
                    return "" + item + left.toString() + right.toString() + "\r\n";
                } else {
                    if(left == null) {
                        return "" + item + right.toString() + "\r\n";
                    } else {
                        return "" + item + left.toString() + "\r\n";
                    }
                }
            }
        }
    }

    public TreeImpl(T element) {
        this.root = new Node<T>(element);
    }


    public void setRoot(T element) {
        this.root = new Node<>(element);
    }

    @Override
    public boolean contains(T element, ByPassStrategy strategy) {
        Node<T> result;
        switch (strategy) {
            case RECURSIVE:
                result = containsRecursive(root, element);
                return result != null;
            case HORIZONTAL:
                result = containsHorizontal(root, element);
                return result != null;
            case VERTICAL:
                result = containsVertical(root, element);
                return result != null;
            default:
                throw new IllegalArgumentException(UNKNOWN_STRATEGY_EXCEPTION_MESSAGE);
        }

    }

    @Override
    public void delete(T element, ByPassStrategy strategy) {
        switch (strategy) {
            case RECURSIVE:
                deleteRecursive(root, element);
            case HORIZONTAL:
                deleteHorizontal(root, element);
                break;
            case VERTICAL:
                deleteVertical(root, element);
                break;
            default:
                throw new IllegalArgumentException(UNKNOWN_STRATEGY_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public void add(T element, ByPassStrategy strategy) {
        switch (strategy) {
            case RECURSIVE:
                addRecursive(root, element);
            case HORIZONTAL:
                addHorizontal(root, element);
                break;
            case VERTICAL:
                addVertical(root, element);
                break;
            default:
                throw new IllegalArgumentException(UNKNOWN_STRATEGY_EXCEPTION_MESSAGE);
        }

    }

    private Node<T> containsRecursive(Node<T> root, T element) {
        if(root == null) {
            return null;
        }
        T item = root.item;
        if(item != null && item.equals(element)) {
            return root;
        } else {
            Node<T> result = containsRecursive(root.left, element);
            if(result != null) {
                return result;
            }
            result = containsRecursive(root.right, element);
            return result;
        }
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

    private boolean deleteRecursive(Node<T> root, T element) {
        if(root == null) {
            return false;
        }
        if(root.item.equals(element)) {
            setRoot(null);
            return true;
        }
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

    private Node<T> containsHorizontal(Node<T> root, T element) {
        if(root.item == null) {
            return null;
        }
        if(root.item.equals(element)) {
            return root;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            if(current.left != null) {
                T item = current.left.item;
                if(item != null) {
                    if(current.left.item.equals(element)) {
                        return current.left;
                    } else {
                        queue.add(current.left);
                    }
                }
            }
            if(current.right != null) {
                T item = current.right.item;
                if(item != null) {
                    if(current.right.item.equals(element)) {
                        return current.right;
                    } else {
                        queue.add(current.right);
                    }
                }
            }
        }
        return null;
    }

    private boolean deleteHorizontal(Node<T> root, T element) {
        if(root == null) {
            return false;
        }
        if(root.item.equals(element)) {
            setRoot(null);
            return true;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            if(current.left != null) {
                T item = current.left.item;
                if(item != null) {
                    if(item.equals(element)) {
                        current.left = null;
                        return true;
                    } else {
                        queue.add(current.left);
                    }
                }
            }
            if(current.right != null) {
                T item = current.right.item;
                if(item != null) {
                    if(item.equals(element)) {
                        current.right = null;
                        return true;
                    } else {
                        queue.add(current.right);
                    }
                }
            }
        }
        return false;
    }

    private void addHorizontal(Node<T> root, T element) {
        if(root == null) {
            setRoot(element);
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            if(current.left == null) {
                current.left = new Node<>(element);
                return;
            } else {
                queue.add(current.left);
            }
            if(current.right == null) {
                current.right = new Node<>(element);
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    private void addVertical(Node<T> root, T element) {
        if(root == null) {
            setRoot(element);
            return;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            Node<T> current = stack.pop();
            if(current.left == null) {
                current.left = new Node<>(element);
            } else {
                stack.push(current.left);
            }
        }
    }

    private Node<T> containsVertical(Node<T> root, T element) {
        if(root.item == null) {
            return null;
        }
        if(root.item.equals(element)) {
            return root;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        Node<T> current = null;
        while (current != null || !stack.empty()) {
            if (!stack.empty()){
                current = stack.pop();
            }
            while (current != null) {
                if(current.item.equals(element)) {
                    return current;
                }
                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.left;
            }
        }
        return null;
    }

    private boolean deleteVertical(Node<T> root, T element) {
        if(root == null) {
            return false;
        }
        if(root.item.equals(element)) {
            setRoot(null);
            return true;
        }
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        Node<T> current = null;
        while (current != null || !stack.empty()){
            if (!stack.empty()){
                current = stack.pop();
            }
            while (current != null){
                if(current.left != null) {
                    if(current.left.item.equals(element)) {
                        current.left = null;
                        return true;
                    }
                }
                if(current.right != null) {
                    if(current.right.item.equals(element)) {
                        current.right = null;
                        return true;
                    }
                    stack.push(current.right);
                }
                current = current.left;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}