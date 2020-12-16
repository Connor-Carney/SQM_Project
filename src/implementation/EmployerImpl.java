package implementation;

import java.util.ArrayList;
import java.util.List;

import interfaces.Employer;
import interfaces.Person;

public class EmployerImpl implements Employer {

	private String empName;
	private List<Person> Employees;
	
	public EmployerImpl(String n) {
		empName = n;
		Employees = new ArrayList<Person>();
	}

	@Override
	public void hire(Person p, String title, double salary) {
		JobImpl newHire = new JobImpl(title, (int)salary, this.getName());
		
		p.setJob(newHire);
		
		Employees.add(p);

	}

	@Override
	public List<Person> getEmployees() {
		return this.Employees;
	}

	@Override
	public int getEmployeeCount() {
		
		return this.Employees.size();
	}

	@Override
	public boolean fire(Person p) {
		if (!this.isEmployed(p))
		return false;
		
		Employees.removeIf(person -> person.equals(p));
		p.setJob(null);
		return true;
	}

	@Override
	public String getName() {
	
		return empName;
	}

	@Override
	public boolean isEmployed(Person p) {
		for (Person person : Employees) {
			if (person.equals(p))
				return true;
		}
		return false;
	}

	@Override
	public Person getHighestPaid() {
		double highestPay = Employees.get(0).getJob().getSalary();
        Person highestPerson = Employees.get(0); 
        for (Person person : Employees) {
            if(person.getJob().getSalary() > highestPay)
            {
            	highestPay = person.getJob().getSalary();
            	highestPerson = person;
            }
        }
        return highestPerson;
	}

	@Override
	public Person getLowestPaid() {
		 double lowestPay = Employees.get(0).getJob().getSalary();
	        Person lowestPerson = Employees.get(0); 
	        for (Person person : Employees) {
	            if(person.getJob().getSalary() < lowestPay)
	            {
	            	lowestPay = person.getJob().getSalary();
	                lowestPerson = person;
	            }
	        }
	        return lowestPerson;
	}

	@Override
	public double getStaffCost() {
		double overallCost = 0;
		for (Person person : Employees) {
			overallCost += person.getJob().getSalary();
		}
		return overallCost;
	}

	@Override
	public int getCountOf(String title) {
		int empCounter = 0;
		for (Person person : Employees) {
			if(person.getJob().getTitle().equals(title))
				empCounter++;
		}
		return empCounter;
	}

	@Override
	public List<Person> getAll(String title) {
		List<Person> listEmployees = new ArrayList<>();
		for (Person person : Employees) {
				if (person.getJob().getTitle().equals(title))
				{
					listEmployees.add(person);
				}
			}
			return listEmployees;
		}
	}


