package il.ac.telhai.ds.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBinaryTree {
	private BinaryTreeI<Integer> c1;
	private BinaryTreeI<Integer> c2;
	private BinaryTreeI<Integer> c3;
	private BinaryTreeI<Integer> c4;
	private BinaryTreeI<Integer> v5_12;
	private BinaryTreeI<Integer> v6_3;
	private BinaryTreeI<Integer> v7_4;
	private BinaryTreeI<Integer> v8_5;
	private BinaryTreeI<Integer> v9_5;

	@Before
	public void setUp() {
		c1 = new BinaryTree<Integer>(1);
		c2 = new BinaryTree<Integer>(2);
		c3 = new BinaryTree<Integer>(3);
		c4 = new BinaryTree<Integer>(4);

		v5_12 = new BinaryTree<Integer>(5, c1, c2);
		v6_3 = new BinaryTree<Integer>(6, c3, null);
		v7_4 = new BinaryTree<Integer>(7, null, c4);
		v8_5 = new BinaryTree<Integer>(8, v5_12, v6_3);
		v9_5 = new BinaryTree<Integer>(9, v8_5, v7_4);
	}

	@Test
	public void testSizeHeightAndIsLeaf() {
		assertEquals(1, c1.size());
		assertEquals(0, c1.height());

		assertEquals(3, v5_12.size());
		assertEquals(1, v5_12.height());
		assertEquals(2, v6_3.size());
		assertEquals(1, v6_3.height());
		assertEquals(2, v7_4.size());
		assertEquals(1, v7_4.height());
		assertEquals(9, v9_5.size());
		assertEquals(3, v9_5.height());
	}

	@Test
	public void testIsLeaf() {
		assertTrue(c1.isLeaf());
		assertFalse(v5_12.isLeaf());
		assertFalse(v6_3.isLeaf());
		assertFalse(v7_4.isLeaf());
		assertFalse(v9_5.isLeaf());
	}
	
	@Test
	public void testGetterAndSetters() {
		assertNull(c1.getLeft());
		assertNull(c1.getRight());
		assertEquals(v5_12.getLeft(),c1);
		assertEquals(v5_12.getRight(),c2);
		assertEquals(v6_3.getLeft(),c3);
		assertNull(v6_3.getRight());
		assertNull(v7_4.getLeft());
		assertEquals(v7_4.getRight(),c4);
	
		v6_3.setLeft(null);
		assertNull(v6_3.getLeft());
		v7_4.setRight(null);
		assertNull(v7_4.getRight());
		v9_5.setValue(10);
		assertEquals(v9_5.getValue(),Integer.valueOf(10));
		v9_5.setLeft(c1);
		assertEquals(v9_5.getLeft(),c1);
		v9_5.setRight(c2);
		assertEquals(v9_5.getRight(),c2);
;	}

	@Test
	public void order() {
		String inOrder = v9_5.inOrder();
		String inOrderSeparation = v9_5.inOrder(",", "#");
		String preOrder = v9_5.preOrder();
		String preOrderSeparation = v9_5.preOrder(",", "#");
		String postOrder = v9_5.postOrder();
		String postOrderSeparation = v9_5.postOrder(",", "#");

		assertEquals(" 1  5  2  8  3  6  9  7  4 ", inOrder);
		assertEquals(",1#,5#,2#,8#,3#,6#,9#,7#,4#", inOrderSeparation);

		assertEquals(" 9  8  5  1  2  6  3  7  4 ", preOrder);
		assertEquals(",9#,8#,5#,1#,2#,6#,3#,7#,4#", preOrderSeparation);

		assertEquals(" 1  2  5  3  6  8  4  7  9 ", postOrder);
		assertEquals(",1#,2#,5#,3#,6#,8#,4#,7#,9#", postOrderSeparation);

	}
	
	@Test
	public void testClear() {
		v9_5.clear();
		assertEquals(1, v9_5.size());
		assertEquals(0, v9_5.height());
	}

}