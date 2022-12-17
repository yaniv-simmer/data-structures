package il.ac.telhai.ds.misc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	private Person p;

	@Before
	public void setUp() {
		p = new Person("123456789", "Michal", "Horovitz");
	}

	@Test
	public void testPerson() {
		assertEquals("123456789", p.getId());
		assertEquals("Michal", p.getFirstName());
		assertEquals("Horovitz", p.getLastName());
		assertEquals(p,new Person("123456789", "Michal", "Horovitz"));
		assertEquals(p,new Person("123456789", "a", "a"));
		assertNotEquals(p,new Person("987654321", "Michal", "Horovitz"));
	}

	@Test
	public void testSetFirstName() {
		p.setFirstName("Moshe");
		assertEquals("123456789", p.getId());
		assertEquals("Moshe", p.getFirstName());
		assertEquals("Horovitz", p.getLastName());
	}

	@Test
	public void testSetLastName() {
		p.setLastName("Efrat");
		assertEquals("123456789", p.getId());
		assertEquals("Michal", p.getFirstName());
		assertEquals("Efrat", p.getLastName());
	}


	@Test
	public void testCompareTo() {
		Person k1 = new Person("123456789", "Horovitz", "Michal");
		Person k2 = new Person("312396120", "Horovitz", "Moshe");
		Person k3 = new Person("12313122", "Efrat", "Michal");
		Person k4 = new Person("123456789", "Horovitz", "Michal");
		assertTrue(k1.compareTo(k1)==0);
		assertTrue(k1.compareTo(k2)<0);
		assertTrue(k1.compareTo(k3)>0);
		assertTrue(k1.compareTo(k4)==0);
		assertTrue(k2.compareTo(k1)>0);
		assertTrue(k2.compareTo(k2)==0);
		assertTrue(k2.compareTo(k3)>0);
		assertTrue(k2.compareTo(k4)>0);
		assertTrue(k3.compareTo(k1)<0);
		assertTrue(k3.compareTo(k2)<0);
		assertTrue(k3.compareTo(k3)==0);
		assertTrue(k3.compareTo(k4)<0);
		assertTrue(k4.compareTo(k1)==0);
		assertTrue(k4.compareTo(k2)<0);
		assertTrue(k4.compareTo(k3)>0);
		assertTrue(k4.compareTo(k4)==0);
	}

}
