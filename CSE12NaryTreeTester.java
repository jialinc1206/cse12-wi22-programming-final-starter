/**
 * Name: Jialin Chen
 * ID: A16636887
 * Email: jic053@ucsd.edu
 * File description: This file containes a test class
 * that's been implements to meet the requirements for 
 * CSE12 Winter22 Fianl
 */
 
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Custom tests to ensure the program is correctly working
 */
public class CSE12NaryTreeTester {
    CSE12NaryTree<Integer> ary3;
    CSE12NaryTree<Integer> ary5_6; 
    CSE12NaryTree<Integer> ary5_1;
    
    /**
     * Set up an empty 3-ary Tree
     */
    @Before
    public void setUp(){
        // empty 3-ary tree
        ary3 = new CSE12NaryTree<>(3);

        // Construct a 5-ary tree with 6 total elements
        ary5_6 = new CSE12NaryTree<>(5);
        ary5_6.root = this.ary5_6.new Node(1);
        ary5_6.root.addChild(this.ary5_6.new Node(2));
        ary5_6.root.addChild(this.ary5_6.new Node(3));
        ary5_6.root.addChild(this.ary5_6.new Node(4));
        ary5_6.root.addChild(this.ary5_6.new Node(5));
        ary5_6.root.addChild(this.ary5_6.new Node(6));
        ary5_6.size = 6;

        // Construct a 5-ary tree with only root
        ary5_1 = new CSE12NaryTree<>(5);
        ary5_1.root = this.ary5_1.new Node(0);
        ary5_1.size = 1;
    }

    /**
     * Tests the add method on a 5-ary tree that already contains 
     * only a root node and its 5 children nodes.
     */
    @Test
    public void testAdd(){
        ary5_6.add(7);
        assertEquals(Integer.valueOf(7),
            ary5_6.root.children.get(0).children.get(0).getData());
        assertEquals(7, ary5_6.size);
    }

    /**
     * Tests the contains method on a 5-ary tree 
     * when the element is not present in it.
     */
    @Test
    public void testContains(){
        assertFalse(ary5_6.contains(7));
    }

    /**
     * Tests the sortTree method on a 5-ary tree 
     * that contains only the root node.
     */
    @Test
    public void testSortTree(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
        assertEquals(expected.get(0), ary5_1.sortTree().get(0));
        assertEquals(1, ary5_1.sortTree().size());
    }

    /**
     * test adding an element to a empty 3-ary tree
     * this test is qualitatively different from the tests above
     * because the adding methods would determins whether the tree has
     * a root first before execuating add. Therefore the code for adding
     * element to an empty tree is different from adding element to a
     * non-Empty tree.
     */
    @Test
    public void testCustom(){
        ary3.add(1);
        assertEquals(Integer.valueOf(1), ary3.root.getData());
        assertEquals(new ArrayList<>(), ary3.root.getChildren());
    }
}
