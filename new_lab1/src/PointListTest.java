import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

public class PointListTest {
	
	PointList points100;
	PointList points3;

	@Before
	public void setUp() throws Exception {
		points100 = new ArrayPointList();
		points3 = new ArrayPointList(3);
	}

	@Test
	public void testAppend() {
		Point p = new Point(5, 6);
		points3.append(p);
		assertEquals(p, points3.getCursor());
		assertNotSame(p, points3.getCursor());

		p = new Point(7, 8);
		points3.append(p);
		assertEquals(p, points3.getCursor());
		assertNotSame(p, points3.getCursor());

	}

	@Test
	public void testClear() {
		points3.append(new Point(5,5));
		points3.clear();
		assertTrue(points3.isEmpty());
		points3.append(new Point(5,5));
		points3.append(new Point(6,6));
		points3.append(new Point(7,7));
		points3.clear();
		assertTrue(points3.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(points100.isEmpty());
		assertTrue(points3.isEmpty());
		points100.append(new Point(5,5));
		points3.append(new Point(5,5));
		assertFalse(points100.isEmpty());
		assertFalse(points3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(points3.isFull());
		points3.append(new Point(5,5));
		assertFalse(points3.isFull());
		points3.append(new Point(6,6));
		assertFalse(points3.isFull());
		points3.append(new Point(7,7));
		assertTrue(points3.isFull());
	}

	@Test
	public void testGoToBeginning() {
		assertFalse(points3.goToBeginning());

		Point p1 = new Point(5, 5);
		points3.append(p1);
		Point p2 = new Point(6, 6);
		points3.append(p2);
		Point p3 = new Point(7, 7);
		points3.append(p3);
		
		assertTrue(points3.goToBeginning());
		assertEquals(p1, points3.getCursor());
	}

	@Test
	public void testGoToEnd() {
		assertFalse(points3.goToEnd());

		Point p1 = new Point(5, 5);
		points3.append(p1);
		Point p2 = new Point(6, 6);
		points3.append(p2);
		Point p3 = new Point(7, 7);
		points3.append(p3);
		
		assertTrue(points3.goToEnd());
		assertEquals(p3, points3.getCursor());

	}

	@Test
	public void testGoToNext() {
		assertFalse(points3.goToNext());

		Point p1 = new Point(5, 5);
		points3.append(p1);
		assertFalse(points3.goToNext());
		
		Point p2 = new Point(6, 6);
		points3.append(p2);
		assertFalse(points3.goToNext());

		Point p3 = new Point(7, 7);
		points3.append(p3);
		assertFalse(points3.goToNext());

		assertTrue(points3.goToBeginning());
		assertTrue(points3.goToNext());
		assertEquals(p2, points3.getCursor());
	}

	@Test
	public void testGoToPrior() {
		Point p1 = new Point(5, 5);
		points3.append(p1);
		Point p2 = new Point(6, 6);
		points3.append(p2);
		Point p3 = new Point(7, 7);
		points3.append(p3);
		
		assertTrue(points3.goToEnd());
		assertEquals(p3, points3.getCursor());
	}

	@Test
	public void testGetCursor() {
		assertNull(points3.getCursor());
	}

}
