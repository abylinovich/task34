package by.epam.task34.tree;


import junit.framework.TestCase;
import org.junit.Test;

public class TreeImplHorizontalTest extends TestCase {


    private Tree<Integer> tree;

    @Override
    protected void setUp() throws Exception {
        tree = new TreeImpl<>(1111);
        tree.add(10, ByPassStrategy.HORIZONTAL);
        tree.add(3, ByPassStrategy.HORIZONTAL);
        tree.add(2, ByPassStrategy.HORIZONTAL);
        tree.add(7, ByPassStrategy.HORIZONTAL);
        tree.add(-500, ByPassStrategy.HORIZONTAL);
    }

    @Test
    public void testContainsHorizontal() {
        assertTrue(tree.contains(7, ByPassStrategy.HORIZONTAL));
    }

    @Test
    public void testDeleteHorizontal() {
        tree.delete(7, ByPassStrategy.HORIZONTAL);
        assertFalse(tree.contains(7, ByPassStrategy.HORIZONTAL));
    }



}

