package edu.century.pa2.collections;

import java.util.ArrayList;

import edu.century.pa2.Student;

public class StudentCollection 
{
	private ArrayList<Student> list = new ArrayList<Student>();
	
	//No Argument constructor
	public StudentCollection()
	{
		
	}
	
	//Add method that adds a Student to the ArrayList
	public void add(Student person)
	{
		list.add(person);
	}
	
	//Remove method that removes a Student from the ArrayList
	public void remove(int i)
	{
		list.remove(i);
	}
	
	//Contains method that searches the ArrayList for a
	//particular Student name and returns the Student
	public Student contains(String name)
	{
		for(Student student: list)
		{
			if(student.getName().equals(name))
			{
				return student;
			}
		}
		return null;
	}
	
	//Contains method that searches the ArrayList for a 
	//particular Student UID and returns the Student
	public Student contains(int uid)
	{
		for(Student student: list)
		{
			if(student.getUid() == (uid))
			{
				return student;
			}
		}
		return null;
	}
	
	//Size method that returns the size of the ArrayList
	public int size()
	{
		return list.size();
	}
	
	//Get method finds the index for an associated Linked List
	//and then returns the name associated with that Student
	public String get(int i)
	{
		Student s1 = list.get(i);
		return s1.getName();	
	}
	
	//To-String method for Student Collection
	@Override
	public String toString() 
	{
		String send = "";
		for(Student student: list)
		{
			send += student.toString() + "\n";
		}
		return send;
	}	
}