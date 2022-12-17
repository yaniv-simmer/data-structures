package il.ac.telhai.ds.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBinarySearchTreeInteger {

	private BinarySearchTree<Integer> searchTree;
	BinarySearchTree<Integer> small;
	BinarySearchTree<Integer> big;

	@Before
	public void setUp() throws Exception {
		searchTree = new BinarySearchTree<Integer>();
		searchTree.add(15);
		searchTree.add(10);
		searchTree.add(20);
	}

	
	@Test
	public void testTree() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.add(5);
		tree.add(4);
		tree.add(2);
		tree.add(3);
		tree.add(6);
		tree.add(1);

		assertEquals(6, tree.size());
		assertTrue(tree.contains(3));
		tree.remove(3);
		assertFalse(tree.contains(3));
		
		
		assertEquals(tree.findGe(3), Integer.valueOf(4));
		
		tree.remove(4);
		tree.remove(5);
		tree.add(3);
 		assertEquals(tree.findGe(4), Integer.valueOf(6));
		
		tree.add(4);
		assertEquals(tree.findGe(4), Integer.valueOf(4));
		assertEquals(tree.findGe(5), Integer.valueOf(6));
		
		assertEquals(tree.findGe(0), Integer.valueOf(1));
		
		assertNull(tree.findGe(7));
	}
}
