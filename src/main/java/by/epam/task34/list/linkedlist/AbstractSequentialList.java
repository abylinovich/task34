package by.epam.task34.list.linkedlist;

import by.epam.task34.list.AbstractList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractSequentialList<E> extends AbstractList<E> {

    @Override
    public E get(int index) {
        try {
            return listIterator(index).next();
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }

    @Override
    public void set(int index, E element) {
        try {
            ListIterator<E> e = listIterator(index);
            e.set(element);
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }

    @Override
    public void add(int index, E element) {
        try {
            listIterator(index).add(element);
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }

    @Override
    public E remove(int index) {
        try {
            Iterator<E> e = listIterator(index);
            E outCast = e.next();
            e.remove();
            return outCast;
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: "+index);
        }
    }

    @Override
    public int size() {
        return 0;
    }

    public Iterator<E> iterator() {
        return listIterator();
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public abstract ListIterator<E> listIterator(int index);

}

