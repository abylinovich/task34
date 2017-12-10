package by.epam.task34.tree;


import junit.framework.TestCase;
import org.junit.Test;

public class TreeImplVerticalTest extends TestCase {


    private Tree<Integer> tree;

    @Override
    protected void setUp() throws Exception {
        tree = new TreeImpl<>(1111);
        tree.add(10, ByPassStrategy.VERTICAL);
        tree.add(3, ByPassStrategy.VERTICAL);
        tree.add(2, ByPassStrategy.VERTICAL);
        tree.add(7, ByPassStrategy.VERTICAL);
        tree.add(-500, ByPassStrategy.VERTICAL);
    }

    @Test
    public void testContainsVertical() {
        assertTrue(tree.contains(7, ByPassStrategy.VERTICAL));
    }

    @Test
    public void testDeleteVertical() {
        tree.delete(7, ByPassStrategy.VERTICAL);
        assertFalse(tree.contains(7, ByPassStrategy.VERTICAL));
    }



}

