 package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implementation.EmployerImpl;
import implementation.PersonImpl;
import interfaces.Employer;
import interfaces.Person;

class TestEmployerImpl {

	private Employer e;
	private Person highest;
	private Person lowest;
	
	@BeforeEach
	void setUp() throws Exception {
		e = new EmployerImpl("NCCO");
		lowest = new PersonImpl("John", 18);
		e.hire(lowest, "Lab Assistant", 20000);
		highest = new PersonImpl("Anu", 50);
		e.hire(highest, "Best Teacher", 80000);
		e.hire(new PersonImpl("Damien", 18), "Teacher", 41000);
		e.hire(new PersonImpl("Malachy", 45), "Teacher", 50000);
		
	}

	@Test
	void testGetEmployees() {
		List<Person> l = e.getEmployees();
		assertNotNull(l);
		assertEquals(4, l.size());
	}

	@Test
	void testGetEmployeeCount() {
		assertEquals(4, e.getEmployeeCount());
		Person p = new PersonImpl("Paul H", 50);
		e.hire(p, "teacher", 1000);
		assertEquals(5, e.getEmployeeCount());
		e.fire(p);
		assertEquals(4, e.getEmployeeCount());
	}

	@Test
	void testFire() {
		Person p = new PersonImpl("Damien", 18);
		boolean f= e.fire(p);
		assertTrue(f);
		assertEquals(3, e.getEmployeeCount());
		
		p = new PersonImpl("Danika", 23);
		f = e.fire(p);
		assertFalse(f);
	}

	@Test
	void testGetName() {
		assertEquals("NCCO", e.getName());
	}

	@Test
	void testIsEmployed() {
		Person p = new PersonImpl("Damien", 18);
		assertTrue(e.isEmployed(p));
		
		p = new PersonImpl("Danika", 23);
		assertFalse(e.isEmployed(p));
	}
	
	@Test
	public void testGetHighestPaid() {
		assertEquals(highest, e.getHighestPaid());
	}

	@Test
	void getLowestPaid() {
		assertEquals(lowest, e.getLowestPaid());
	}

	@Test
	void getStaffCost() {
		assertEquals(191000, e.getStaffCost());
	}
	
	@Test
	void testGetCountOf() {
		assertEquals(2, e.getCountOf("Teacher"));
		assertEquals(0, e.getCountOf("Awesome Teacher"));
	}
	
	@Test 
	void testGetAll(){
		assertEquals(2, e.getAll("Teacher").size());
		assertNotNull(e.getAll("Dean"));
		assertTrue(e.getAll("Dean").isEmpty());
	}

}
