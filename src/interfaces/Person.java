package interfaces;

public interface Person {

	String getName();
	int getAge();
	Job getJob();
	void setJob(Job j);
	void setAge(int a);
	void setName(String n);
	boolean equals(Person p);
	boolean olderThan(Person p);
	boolean youngerThan(Person p);
	boolean isAdult();
	boolean isColleague(Person p);
}
