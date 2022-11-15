import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DiagonalMatrixTest {
	private Matrix d3;

	@Before
	public void setUp() throws Exception {
		d3 = new DiagonalMatrix(3);
	}

	@Test
	public void testDiagonalMatrixInt() {
		assertEquals(0, d3.get(1, 2), 0);
		assertEquals(0, d3.get(1, 3), 0);
		assertEquals(0, d3.get(3, 2), 0);
		try {
			d3.get(1, 4);
			fail("Should not work");
		} catch (Exception e) {
		}
		try {
			d3.get(0, 1);
			fail("Should not work");
		} catch (Exception e) {
		}
	}

	@Test
	public void testDiagonalMatrix() {
		Matrix d = new DiagonalMatrix();
		assertEquals(0, d.get(1, 2), 0);
		assertEquals(0, d.get(1, 3), 0);
		assertEquals(0, d.get(100, 100), 0);
		try {
			d3.get(1, 101);
			fail("Should not work");
		} catch (Exception e) {
		}
		try {
			d3.get(0, 1);
			fail("Should not work");
		} catch (Exception e) {
		}
	}

	@Test
	public void testGetSet() {
		d3.set(1, 1, 7);
		assertEquals(7, d3.get(1, 1), 0);
		assertEquals(7, d3.get(2, 2), 0);
		assertEquals(0, d3.get(2, 3), 0);
		d3.set(2, 3, 11);
		assertEquals(11, d3.get(2, 3), 0);
		assertEquals(11, d3.get(1, 2), 0);
		assertEquals(7, d3.get(1, 1), 0);
		assertEquals(7, d3.get(2, 2), 0);
	}

	@Test
	public void testTranspose() {
		d3.set(1, 1, 7);
		d3.set(2, 3, 11);
		d3.transpose();
		assertEquals(7, d3.get(1, 1), 0);
		assertEquals(7, d3.get(2, 2), 0);
		assertEquals(11, d3.get(3, 2), 0);
		assertEquals(11, d3.get(2, 1), 0);
		d3.transpose();
		assertEquals(7, d3.get(1, 1), 0);
		assertEquals(7, d3.get(2, 2), 0);
		assertEquals(0, d3.get(3, 2), 0);
		assertEquals(11, d3.get(2, 3), 0);
		assertEquals(11, d3.get(1, 2), 0);
	}

	@Test
	public void testGetTranspose() {
		d3.set(1, 1, 7);
		d3.set(2, 3, 11);
		Matrix m = d3.getTranspose();
		assertEquals(7, d3.get(1, 1), 0);
		assertEquals(7, d3.get(2, 2), 0);
		assertEquals(11, d3.get(2, 3), 0);
		assertEquals(11, d3.get(1, 2), 0);

		assertEquals(7, m.get(1, 1), 0);
		assertEquals(7, m.get(2, 2), 0);
		assertEquals(11, m.get(3, 2), 0);
		assertEquals(11, m.get(2, 1), 0);
		assertEquals(0, m.get(1, 2), 0);

		Matrix m2 = m.getTranspose();
		assertEquals(7, m2.get(1, 1), 0);
		assertEquals(7, m2.get(2, 2), 0);
		assertEquals(11, m2.get(2, 3), 0);
		assertEquals(11, m2.get(1, 2), 0);
	}

	@Test
	public void testToString() {
		d3.set(1, 1, 7);
		d3.set(2, 3, 11);
		d3.set(3, 2, 17);
		String expected = "7.0\t11.0\t0.0\n" + "17.0\t7.0\t11.0\n" + "0.0\t17.0\t7.0\n";
		assertEquals(expected, d3.toString());
		System.out.println(d3);
	}

}