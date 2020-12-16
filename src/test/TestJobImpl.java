package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implementation.JobImpl;
import interfaces.Job;

class TestJobImpl {

	private Job j;
	
	@BeforeEach
	void setUp() throws Exception {
		j = new JobImpl("Teacher", 40000, "St Martins School");
	}

	@Test
	void testGetSalary() {
		assertEquals(40000, j.getSalary());
	}

	@Test
	void testGetTitle() {
		assertEquals("Teacher", j.getTitle());
	}

	@Test
	void testSetSalary() {
		j.setSalary(1000000);
		assertEquals(1000000, j.getSalary());
	}
	
	@Test
	void testSetSalaryFail() {
		j.setSalary(-100);
		assertNotEquals(-100, j.getSalary());
		j.setSalary(0);
		assertNotEquals(0, j.getSalary());
	}

	@Test
	void testSetTitle() {
		j.setTitle("Best teacher");
		assertEquals("Best teacher", j.getTitle());
	}
	
	@Test
	void testSetTitleFail() {
		j.setTitle("");
		assertNotEquals("", j.getTitle());
	}

	@Test
	void testGetCompany() {
		assertEquals("St Martins School", j.getCompany());
	}

	@Test
	void testSetCompany() {
		j.setCompany("NCCO");
		assertEquals("NCCO", j.getCompany());
	}
	
	@Test
	void testSetCompanyFail() {
		j.setCompany("");
		assertNotEquals("", j.getCompany());
	}


}
