package edu.century.pa2;

public class Course implements Cloneable
{
	private String courseName;
	private double gpa;
	private double credits;
	
	//Course three argument constructor
	public Course(String courseName, double gpa, double credits)
	{
		this.courseName = courseName;
		this.gpa = gpa;
		this.credits = credits;
	}

	//Setter and Getter methods
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	//To-String method for Course class
	@Override
	public String toString() {
		return "   Course Name: " + courseName + "\n   GPA: " + gpa + "\n   Credits:" + credits;
	}

	//Equals method for Course class
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Course)
		{
			Course otherCourse = (Course) obj;
			String otherCourseName = otherCourse.courseName;
			double otherGPA = otherCourse.gpa;
			double otherCredits = otherCourse.credits;
			
			return(this.courseName.equals(otherCourseName) && 
				   this.gpa == (otherGPA) && this.credits == (otherCredits));
		}
		return super.equals(obj);
	}
	
	
}