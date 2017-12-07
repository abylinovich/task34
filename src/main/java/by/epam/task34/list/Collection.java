package by.epam.task34.list;

import java.lang.Iterable;

public interface Collection<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    boolean equals(Object o);

    int hashCode();

    boolean add(E element);

    boolean remove(Object o);

}
