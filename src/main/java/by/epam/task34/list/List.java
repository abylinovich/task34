package by.epam.task34.list;

public interface List<E> extends Collection<E> {

    E get(int index);

    void set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    boolean equals(Object o);

    int hashCode();


}
