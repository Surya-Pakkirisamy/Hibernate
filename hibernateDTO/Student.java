package hibernateDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //@Entity annotation is used to create a table for this class
public class Student {
	@Id  //id annotation is used to mention the primary for the table
	private int id;
	private String name,phno;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phno=" + phno + ", percentage=" + percentage + "]";
	}
	double percentage;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	

}
