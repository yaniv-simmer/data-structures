package il.ac.telhai.ds.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DLinkedListStackTest {
	Stack<Integer> stack;

	@Before
	public void setUp() throws Exception {
		stack = new DLinkedListStack<Integer>();
	}

	@Test
	public void testPush() {
		assertTrue(stack.isEmpty());
		stack.push(5);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testPop() {
		assertNull(stack.pop());
		stack.push(5);
		assertEquals(Integer.valueOf(5), stack.pop());
		assertNull(stack.pop());
		stack.push(7);
		stack.push(8);
		stack.push(9);
		assertEquals(Integer.valueOf(9), stack.pop());
		assertEquals(Integer.valueOf(8), stack.pop());
		assertEquals(Integer.valueOf(7), stack.pop());
		assertNull(stack.pop());
		assertTrue(stack.isEmpty());		
	}

	@Test
	public void testTop() {
		assertNull(stack.top());
		stack.push(5);
		assertEquals(Integer.valueOf(5), stack.top());
		assertEquals(Integer.valueOf(5), stack.top());
		stack.push(7);
		assertEquals(Integer.valueOf(7), stack.top());
		stack.pop();
		assertFalse(stack.isEmpty());		
		assertEquals(Integer.valueOf(5), stack.top());
		stack.pop();
		assertTrue(stack.isEmpty());		
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());
		stack.push(7);
		assertFalse(stack.isEmpty());
	}

	@Test
	public void testToString() {
		assertEquals("[]", stack.toString());
		stack.push(5);
		assertEquals("[5]", stack.toString());
		stack.push(7);
		assertEquals("[7, 5]", stack.toString());
		stack.push(8);
		assertEquals("[8, 7, 5]", stack.toString());
	}

}
