package test;

public class Student {
 private String name;
 private int roll;
 public int getRoll() {
	return roll;
}
public void setRoll(int roll) {
	this.roll = roll;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Boolean getB() {
	return b;
}
public void setB(Boolean b) {
	this.b = b;
}
public Student(String name, Boolean b) {
	super();
	this.name = name;
	this.b = b;
}
public Student() {
	// TODO Auto-generated constructor stub
}
private Boolean b;
 
}
