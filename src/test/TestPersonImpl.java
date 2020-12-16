package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implementation.JobImpl;
import implementation.PersonImpl;
import interfaces.Person;

class TestPersonImpl {

	private Person p;
	
	@BeforeEach
	void setUp() throws Exception {
		p = new PersonImpl("Paul S", 53);
		p.setJob(new JobImpl("Vice Dean", 90000, "CNI"));
	}

	@Test
	void testGetName() {
		assertEquals("Paul S", p.getName());
	}

	@Test
	void testGetAge() {
		assertEquals(53, p.getAge());
	}

	@Test
	void testGetJob() {
		assertTrue(p.getJob().equals(new JobImpl("Vice Dean", 90000, "CNI")));
	}

	@Test
	void testSetAge() {
		p.setAge(10);
		assertEquals(10, p.getAge());
	}
	
	@Test
	void testSetAgeFail() {
		p.setAge(-10);
		assertNotEquals(-10, p.getAge());
	}

	@Test
	void testSetName() {
		p.setName("Ainsley");
		assertEquals("Ainsley", p.getName());
	}
	
	@Test
	void testSetNameFail() {
		p.setName("");
		assertNotEquals("", p.getName());
		p.setName(null);
		assertNotNull(p.getName());
	}

	@Test
	void testEqualsPerson() {
		assertTrue(p.equals(p));
		assertFalse(p.equals(new PersonImpl("John", 122)));
	}

	@Test
	void testOlderThan() {
		Person s = new PersonImpl("Jane", 3);
		assertTrue(p.olderThan(s));
		assertFalse(s.olderThan(p));
		assertFalse(p.olderThan(p));
	}

	@Test
	void testYoungerThan() {
		Person s = new PersonImpl("Jane", 3);
		assertTrue(s.youngerThan(p));
		assertFalse(p.youngerThan(s));
		assertFalse(s.youngerThan(s));
	}

	@Test
	void testIsAdult() {
		Person c = new PersonImpl("Clara", 1);
		assertFalse(c.isAdult());
		assertTrue(p.isAdult());
	}

	@Test
	void testIsColleague() {
		Person simon = new PersonImpl("Simon", 35);
		simon.setJob(new JobImpl("Prof.", 60000, "DIT"));
		assertFalse(simon.isColleague(p));
		assertFalse(p.isColleague(simon));
		Person pp = new PersonImpl("Pramod", 80);
		pp.setJob(new JobImpl("Prof.", 60000, "CNI"));
		assertTrue(p.isColleague(pp));
		assertTrue(pp.isColleague(p));
		assertFalse(simon.isColleague(pp));
	}

}
