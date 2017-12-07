package by.epam.task34.list;

import java.util.Iterator;

public abstract class AbstractCollection<E> implements Collection<E> {

    protected AbstractCollection() {
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean remove(Object o) {
        Iterator<E> it = iterator();
        if (o == null) {
            while (it.hasNext()) {
                if (it.next()==null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

}
