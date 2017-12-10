package by.epam.task34.list.linkedlist;

import by.epam.task34.list.List;
import by.epam.task34.list.linkedlist.LinkedList;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkedListTest extends TestCase {


    private List<String> emptyList;
    private List<String> filledList;

    @Override
    protected void setUp() throws Exception {
        emptyList = new LinkedList<>();
        filledList = new LinkedList<>();
        filledList.add("one");
        filledList.add("two");
        filledList.add("three");
    }


    @Test
    public void testEquals() {
        emptyList.add("one");
        emptyList.add("two");
        emptyList.add("three");
        assertThat(emptyList, is(filledList));
    }

    @Test
    public void testAdd() {
        emptyList.add("first");
        emptyList.add("second");
        assertThat(emptyList.size(), is(2));
    }

    @Test
    public void testRemoveByIndex() {
        filledList.remove(2);
        assertThat(filledList.size(), is(2));
    }

    @Test
    public void testRemoveObject() {
        filledList.remove("one");
        filledList.remove("two");
        filledList.remove("three");
        assertThat(filledList.size(), is(0));
    }

    @Test
    public void testIsEmpty() {
        filledList.remove("one");
        filledList.remove("two");
        filledList.remove("three");
        assertEquals(filledList.isEmpty(), true);
    }

    @Test
    public void testGetByIndex() {
        String result = filledList.get(1);
        assertEquals(result, "two");
    }

    @Test
    public void testSetByIndex() {
        filledList.set(1, "testContainsRecursive");
        assertEquals(filledList.get(1), "testContainsRecursive");
    }

    @Test
    public void testAddByIndex() {
        filledList.add(1, "testContainsRecursive");
        assertEquals(filledList.get(1), "testContainsRecursive");
    }

    @Test
    public void testIterator() {
        Iterator<String> it = filledList.iterator();
        while (it.hasNext()) {
            emptyList.add(it.next());
        }
        assertEquals(emptyList, filledList);
    }

}
