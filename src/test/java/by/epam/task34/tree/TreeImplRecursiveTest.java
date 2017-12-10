package by.epam.task34.tree;


import junit.framework.TestCase;
import org.junit.Test;

public class TreeImplRecursiveTest extends TestCase {


    private Tree<Integer> tree;

    @Override
    protected void setUp() throws Exception {
        tree = new TreeImpl<>(1111);
        tree.add(10, ByPassStrategy.RECURSIVE);
        tree.add(3, ByPassStrategy.RECURSIVE);
        tree.add(2, ByPassStrategy.RECURSIVE);
        tree.add(7, ByPassStrategy.RECURSIVE);
        tree.add(-500, ByPassStrategy.RECURSIVE);
    }

    @Test
    public void testContainsRecursive() {
        assertTrue(tree.contains(7, ByPassStrategy.RECURSIVE));
    }

    @Test
    public void testDeleteRecurcive() {
        tree.delete(7, ByPassStrategy.RECURSIVE);
        assertFalse(tree.contains(7, ByPassStrategy.RECURSIVE));
    }




}

