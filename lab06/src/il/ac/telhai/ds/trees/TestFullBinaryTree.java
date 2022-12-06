package il.ac.telhai.ds.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestFullBinaryTree {

	private FullBinaryTree<Integer> c1;
	private FullBinaryTree<Integer> c2;
	private FullBinaryTree<Integer> v5;
	private BinaryTreeI<Integer> n1;

	@Before
	public void setUp() {
		c1 = new FullBinaryTree<Integer>(1);
		c2 = new FullBinaryTree<Integer>(2);
		n1 = new BinaryTree<Integer>(5);
	}

	@Test
	public void testConstructor() {
		try {
			v5 = new FullBinaryTree<Integer>(5, null, c2);
			fail("Shold not work");
		} catch (Exception e) {
		}
		try {
			v5 = new FullBinaryTree<Integer>(5, c2, null);
			fail("Shold not work");
		} catch (Exception e) {
		}

		v5 = new FullBinaryTree<Integer>(5, null, null);
		v5 = new FullBinaryTree<Integer>(5, c1, c2);

	}

	@Test
	public void testSet() {
		v5 = new FullBinaryTree<Integer>(5, c1, c2);
		try {
			v5.setLeft(n1);
			fail("Shold not work");
		} catch (Exception e) {
		}

		try {
			v5.setRight(n1);
			fail("Shold not work");
		} catch (Exception e) {
		}

		try {
			v5.setLeft(null);
			fail("Shold not work");
		} catch (Exception e) {
		}

		try {
			v5.setRight(null);
			fail("Shold not work");
		} catch (Exception e) {
		}

		try {
			c1.setLeft(new FullBinaryTree<Integer>(7));
			fail("Shold not work");
		} catch (Exception e) {
		}

		try {
			c1.setRight(new FullBinaryTree<Integer>(7));
			fail("Shold not work");
		} catch (Exception e) {
		}

		FullBinaryTree<Integer> c3 = new FullBinaryTree<Integer>(7);
		FullBinaryTree<Integer> c4 = new FullBinaryTree<Integer>(7);
		v5.setLeft(c3);
		v5.setRight(c4);
		assertEquals(c3, v5.getLeft());
		assertEquals(c4, v5.getRight());

		c1.setLeft(null);
		c1.setRight(null);

	}
}