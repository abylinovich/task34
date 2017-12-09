package by.epam.task34.tree;


import junit.framework.TestCase;
import org.junit.Test;

public class TreeImplTest extends TestCase {


    private Tree<Integer> tree;

    @Override
    protected void setUp() throws Exception {
        tree = new TreeImpl<>(1000);
        tree.add(10);
        tree.add(3);
        tree.add(1);
        tree.add(7);
        tree.add(-500);
    }

    @Test
    public void testContains() {
        assertTrue(tree.contains(7));
    }

    @Test
    public void testDelete() {
        tree.delete(7);
        assertFalse(tree.contains(7));
    }



}

