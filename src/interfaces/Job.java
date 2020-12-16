package interfaces;

public interface Job {
	
	double getSalary();
	String getTitle();
	void setSalary(double s);
	void setTitle(String t);
	String getCompany();
	void setCompany(String c);
	boolean equals(Job p);

}
