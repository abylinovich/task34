package by.epam.task34.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

    protected AbstractList() {
    }

    @Override
    public boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof List))
            return false;

        Iterator<E> it1 = iterator();
        Iterator<?> it2 = ((List<?>) o).iterator();
        while (it1.hasNext() && it2.hasNext()) {
            E o1 = it1.next();
            Object o2 = it2.next();
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }
        return !(it1.hasNext() || it2.hasNext());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for(int i = 0; i < this.size(); i++) {
            E e = this.get(i);
            hashCode = 31*hashCode + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

    /**
     *  ---------------------------- Iterator
     * */

    private class Itr implements Iterator<E> {

        int cursor = 0;
        int lastRet = -1;

        public boolean hasNext() {
            return cursor != size();
        }

        public E next() {
            try {
                int i = cursor;
                E next = get(i);
                lastRet = i;
                cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            AbstractList.this.remove(lastRet);
            if (lastRet < cursor)
                cursor--;
            lastRet = -1;
        }

    }


}
