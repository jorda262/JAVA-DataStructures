package edu.century.pa2.collections;

import edu.century.pa2.Course;
import edu.century.pa2.CourseNode;
import edu.century.pa2.GuiDriver;
import edu.century.pa2.Student;

public class CourseCollection 
{
	private CourseNode head;
	
	//No argument constructor
	public CourseCollection()
	{
		
	}
	
	//Adds a node to the beginning of the Linked List
	public void addFirst(Course course)
	{
		head = new CourseNode(course, head);
	}
	
	//Removes a designated target node from the Linked List
	@SuppressWarnings("null")
	public void remove(Course target)
	{
		CourseNode cursor;
		CourseNode before;
		
		if(head != null)
		{
			for(cursor=head, before=null; cursor!=null; before=cursor, cursor=cursor.getLink())
			{
				if(head.getData().equals(target))
				{
					head = head.getLink();
					GuiDriver.courseFound();
					break;
				}
				else if(cursor.getData().equals(target))
				{
					before.removeNodeAfter();
					GuiDriver.courseFound();
					break;
				}
				else
				{
					GuiDriver.courseNotFound();
					break;
				}
			}
		}
	}
	
	//Searches the Linked List for the desired Course
	public Course search(String courseName)
	{
		CourseNode cursor;
		for (cursor = head; cursor != null; cursor = cursor.getLink())
		{
			if (cursor.getData().getCourseName().equals(courseName)) 
				return cursor.getData();
		}
		return null;
	}
	
	//Clone method for Course Collection
	public CourseCollection clone()
	{
		CourseCollection copy = null;
		try{
			copy = (CourseCollection) super.clone();
		}
		catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		copy.head = CourseNode.listCopy(head);
		return copy;
	}
	
	//To-String method for Course Collection
	@Override
	public String toString() {
		CourseNode cursor;
		String send = "";
		for(cursor=head; cursor!=null; cursor=cursor.getLink())
		{
			Course course = cursor.getData();
			send += course.toString() + "\n";
		}
		return send;
	}
	
}