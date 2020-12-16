package implementation;

import java.awt.Container;

import interfaces.Job;
import interfaces.Person;

public class PersonImpl implements Person {

	private String name;
	private int age;
	private Job job;
	
	public PersonImpl(String n, int a) {
		name = n;
		age = a;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public Job getJob() {
		return job;
	}

	@Override
	public void setJob(Job j) {
		this.job = j;
	}

	@Override
	public void setAge(int a) {
		if(a <= 0)
			return;
		age = (int) a;
	}

	@Override
	public void setName(String n) {
		if(n == null || n == "") { 
			return;
		}
		this.name = n;
	}

	@Override
	public boolean equals(Person p) {
		return p.getName() == getName() && p.getAge() == getAge();
	}

	@Override
	public boolean olderThan(Person p) {
		return this.age > p.getAge();
	}

	@Override
	public boolean youngerThan(Person p) {
		return this.age < p.getAge();
	}

	@Override
	public boolean isAdult() {
		return this.age >= 18;
	}

	@Override
	public boolean isColleague(Person p) {
		return this.getJob().getCompany().equals(p.getJob().getCompany());
	}

}
