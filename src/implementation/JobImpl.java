package implementation;

import interfaces.Job;

public class JobImpl implements Job {

	private String Title;
	private int Salary;
	private String Company;
	
	public JobImpl(String t, int s, String c) {
		setTitle(t);
		setSalary(s);
		setCompany(c);
	}

	@Override
	public double getSalary() {
		return Salary;
	}

	@Override
	public String getTitle() {
		return Title;
	}

	@Override
	public void setSalary(double s) {
		if(s <= 0)
			return;
		Salary = (int) s;
	}

	@Override
	public void setTitle(String t) {
		if(t.equals(""))
			return;
		Title = t;
	}

	@Override
	public String getCompany() {
		return Company;
	}

	@Override
	public void setCompany(String c) {
		if(c.equals(""))
			return;
		Company = c;
	}

	@Override
	public boolean equals(Job p) {
		return p.getCompany() == getCompany() && p.getTitle() == getTitle();
	}

}
