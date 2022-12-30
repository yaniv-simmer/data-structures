package il.ac.telhai.ds.trees;
	
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAVLTree {

	AVLTree<Integer> avlTree;

	@Test
	public void buildAVLTree() {
		AVLTree<Integer> avlTree = new AVLTree<Integer>(11);
		for (int i = 0; i < 10; i++) {
			int k = 2 * i;
			avlTree = avlTree.add(k);
		}

		String s = inOrder(avlTree);
		assertEquals(s, " 0  2  4  6  8  10  11  12  14  16  18 ");
		checkTreeStructure(avlTree);
	}

	private void checkTreeStructure(AVLTree<Integer> avlTree) {
		assertEquals(avlTree.getValue(), Integer.valueOf(6));

		assertEquals(avlTree.getLeft().getValue(), Integer.valueOf(2));
		assertEquals(avlTree.getRight().getValue(), Integer.valueOf(12));

		assertEquals(avlTree.getLeft().getLeft().getValue(), Integer.valueOf(0));
		assertEquals(avlTree.getLeft().getRight().getValue(), Integer.valueOf(4));
		assertEquals(avlTree.getRight().getLeft().getValue(), Integer.valueOf(10));
		assertEquals(avlTree.getRight().getRight().getValue(), Integer.valueOf(16));

		assertEquals(avlTree.getRight().getLeft().getLeft().getValue(),  Integer.valueOf(8));
		assertEquals(avlTree.getRight().getLeft().getRight().getValue(), Integer.valueOf(11));
		assertEquals(avlTree.getRight().getRight().getLeft().getValue(), Integer.valueOf(14));
		assertEquals(avlTree.getRight().getRight().getRight().getValue(), Integer.valueOf(18));
	}

	private String inOrder(AVLTree<Integer> tree) {
		StringBuilder sb = new StringBuilder();

		if (tree.getLeft() != null) {
			sb.append(inOrder(tree.getLeft()));
		}
		sb.append(" ");
		sb.append(tree.getValue());
		sb.append(" ");
		if (tree.getRight() != null) {
			sb.append(inOrder(tree.getRight()));
		}
		return sb.toString();
	}

	@Test
	public void testSingleRotateLeft() {
		AVLTree<Integer> tree = new AVLTree<Integer>(0);
		tree = tree.add(10);
		tree = tree.add(20);
		testTree(tree);
	}

	@Test
	public void testSingleRotateRight() {
		AVLTree<Integer> tree = new AVLTree<Integer>(20);
		tree = tree.add(10);
		tree = tree.add(0);
		testTree(tree);
	}

	@Test
	public void testDoubleRotateLeftRight() {
		AVLTree<Integer> tree = new AVLTree<Integer>(20);
		tree = tree.add(0);
		tree = tree.add(10);
		testTree(tree);
	}

	@Test
	public void testDoubleRotateRightLeft() {
		AVLTree<Integer> tree = new AVLTree<Integer>(10);
		tree = tree.add(20);
		tree = tree.add(0);
		testTree(tree);
	}

	private void testTree(AVLTree<Integer> tree) {
		assertEquals(tree.getValue(), Integer.valueOf(10));
		assertEquals(tree.getLeft().getValue(), Integer.valueOf(0));
		assertEquals(tree.getRight().getValue(), Integer.valueOf(20));
	}
}