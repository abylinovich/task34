package by.epam.task34.list;

public interface Iterator<E> {

    boolean hasNext();

    E next();

    void remove();

}
