package interfaces;
import java.util.List;

public interface Employer {

	void hire(Person p, String title, double salary);
	List<Person> getEmployees();
	int getEmployeeCount();
	boolean fire(Person p);
	String getName();
	boolean isEmployed(Person p);
	Person getHighestPaid();
	Person getLowestPaid();
	double getStaffCost();
	int getCountOf(String title);
	List<Person> getAll(String title);
}
