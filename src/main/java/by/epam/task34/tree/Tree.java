package by.epam.task34.tree;

public interface Tree<T> {

    boolean contains(T element, ByPassStrategy strategy);

    void add(T element, ByPassStrategy strategy);

    void delete(T element, ByPassStrategy strategy);

}
