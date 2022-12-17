package il.ac.telhai.ds.trees;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import il.ac.telhai.ds.misc.Person;

public class TestBinarySearchTreePerson {

	private Person p1;
	private Person p3;
	private Person p5;
	private Person p7;
	private Person p10;
	private Person p15;
	private BinarySearchTree<Person> treePerson;

	@Before
	public void setUp() throws Exception {
		p10 = new Person("10", "10firstName", "10lastName");
		p5 = new Person("05", "05firstName", "05lastName");
		p1 = new Person("01", "01firstName", "01lastName");
		p3 = new Person("03", "03firstName", "03lastName");
		p7 = new Person("07", "07firstName", "07lastName");
		p15 = new Person("15", "15firstName", "15lastName");
		treePerson = new BinarySearchTree<Person>();
		treePerson.add(p10);
		treePerson.add(p5);
		treePerson.add(p1);
		treePerson.add(p3);
		treePerson.add(p7);
		treePerson.add(p15);
	}


	@Test
	public void testAdd() {
		assertEquals(6, treePerson.size());
		assertFalse(treePerson.add(p10));

		assertEquals(6, treePerson.size());
		assertFalse(treePerson.add(p10));

		assertEquals(6, treePerson.size());
		Person p = new Person("02", "02firstName", "02lastName");
		treePerson.add(p);
		assertEquals(7, treePerson.size());
	}

	@Test
	public void testRemoveExistingLeaf() {
		assertTrue(treePerson.remove(new Person("03", "03firstName", "03lastName")));
		assertEquals(5, treePerson.size());
		assertFalse(treePerson.remove(p3));
		assertFalse(treePerson.contains(p3));
	}

	@Test
	public void testRemoveExistingMiddleItemWithEmptyLeftChild() {

		Person p8 = new Person("08", "08firstName", "08lastName");
		treePerson.add(p8);
		assertEquals(treePerson.getValInPath(
				BinarySearchTree.Direction.LEFT,
				BinarySearchTree.Direction.RIGHT,
				BinarySearchTree.Direction.RIGHT), p8);
		assertTrue(treePerson.remove(p7));
		assertEquals(treePerson.getValInPath(
				BinarySearchTree.Direction.LEFT,
				BinarySearchTree.Direction.RIGHT), p8);
	}

	@Test
	public void testRemoveExistingMiddleItemWithEmptyRightChild() {
		Person p6 = new Person("06", "06firstName", "06lastName");
		treePerson.add(p6);
		assertEquals(treePerson.getValInPath(
				BinarySearchTree.Direction.LEFT,
				BinarySearchTree.Direction.RIGHT,
				BinarySearchTree.Direction.LEFT), p6);
		assertTrue(treePerson.remove(p7));
		assertEquals(treePerson.getValInPath(
				BinarySearchTree.Direction.LEFT,
				BinarySearchTree.Direction.RIGHT), p6);
	}

	@Test
	public void testRemoveExistingMiddleItemWithTwoChildren1() {
		Person p8 = new Person("08", "08firstName", "08lastName");
		Person p6 = new Person("06", "06firstName", "06lastName");
		Person p2 = new Person("02", "02firstName", "02lastName");

		treePerson.add(p8);
		treePerson.add(p6);
		treePerson.add(p2);

		assertEquals(treePerson.size(),9);

		assertEquals(treePerson.getValInPath(
				BinarySearchTree.Direction.LEFT,
				BinarySearchTree.Direction.RIGHT,
				BinarySearchTree.Direction.RIGHT), p8);
		assertEquals(treePerson.getValInPath(
				BinarySearchTree.Direction.LEFT,
				BinarySearchTree.Direction.RIGHT,
				BinarySearchTree.Direction.LEFT), p6);

		assertTrue(treePerson.remove(p7));
		assertEquals(treePerson.size(),8);


		treePerson.add(p7);
		assertEquals(treePerson.size(),9);
		treePerson.remove(p5);
		assertEquals(treePerson.size(),8);
	}

}