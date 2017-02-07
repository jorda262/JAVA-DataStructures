package edu.century.pa2;

import edu.century.pa2.collections.CourseCollection;

public class Student implements Cloneable
{
	private String name;
	private static int updater;
	private int uid;
	private CourseCollection collection;
	
	//Student one argument Constructor
	public Student(String name)
	{
		this.name = name;
		collection = null;
		Student.updater += 100;
		this.uid = updater;
		collection = new CourseCollection();
	}
	
	//Add course method
	public void addCourse(Course course) {
		collection.addFirst(course);
	}
	
	//Remove course method
	public void removeCourse(Course course)
	{
		collection.remove(course);
	}
	
	//Setter and Getter methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUid() {
		return uid;
	}
	public CourseCollection getCollection() {
		return collection;
	}

	//To-String method for Student class
	@Override
	public String toString() {
		return "Name: " + this.name + "\nUID: " + this.uid + 
			   " \n" + collection.toString() + "\n";
	}
	
	//Equals method for Student class
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student)
		{
			Student student = (Student) obj;
			String otherName = student.name;
			int otherUID = student.uid;
			CourseCollection otherCollection = student.collection;
			
			return(this.name.equals(otherName) && this.uid == otherUID &&
				   this.collection.equals(otherCollection));
		}
		return super.equals(obj);
	}
	
	//Clone method for Student class
	public Student clone()
	{
		Student copy = null;
		try{
			copy = (Student) super.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		copy.collection = collection.clone();
		return copy;
	}
	
	
}