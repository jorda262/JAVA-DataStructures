package edu.century.pa2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import edu.century.pa2.collections.StudentCollection;

@SuppressWarnings("serial")
public class GuiDriver extends JFrame implements ActionListener
{
	private JPanel main, north, bottom, top, center, middle, south;
	private JButton addStudent, removeStudent, addCourse, removeCourse, display, displayAll;
	private JLabel studentName, select, courseName, gpa, credits;
	private JTextField studentField, courseField, gpaField, creditsField;
	private JComboBox<String> combo;
	private static JTextArea textArea;
	private Student students;
	private StudentCollection list;
	
	//Constructor for the GUI
	public GuiDriver()
	{
		super("Century College");
		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initializeComponents();
		list = new StudentCollection();
		
		addStudent.addActionListener(this);
		removeStudent.addActionListener(this);
		addCourse.addActionListener(this);
		removeCourse.addActionListener(this);
		display.addActionListener(this);
		displayAll.addActionListener(this);
		combo.addActionListener(this);	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initializeComponents()
	{
		//Initialize JPanels
		main = new JPanel(new BorderLayout());
		north = new JPanel(new FlowLayout());
		bottom = new JPanel(new GridLayout(1,1));
		top = new JPanel(new BorderLayout());
		center = new JPanel(new GridLayout(2,1));
		middle = new JPanel(new GridLayout(4,2));
		south = new JPanel(new FlowLayout());
		//Initialize JButtons
		addStudent = new JButton("Add Student");
		removeStudent = new JButton("Remove Student");
		addCourse = new JButton("Add Course");
		removeCourse = new JButton("Remove Course");
		display = new JButton("Display");
		displayAll = new JButton("Display All");
		//Initialize JLabels
		studentName = new JLabel("Name:");
		select = new JLabel("Select Student:");
		courseName = new JLabel("Name:");
		gpa = new JLabel("GPA:");
		credits = new JLabel("Credits:");
		//Initialize JTextFields
		studentField = new JTextField(15);
		courseField = new JTextField(15);
		gpaField = new JTextField(15);
		creditsField = new JTextField(15);
		//Initialize JComboBox
		combo = new JComboBox();
		combo.addActionListener(this);
		//Initialize JTextArea
		textArea = new JTextArea();
		//Initialize South Panel
		south.add(addCourse);
		south.add(removeCourse);
		south.add(display);
		south.add(displayAll);
		//Initialize Middle Panel
		middle.add(select);
		middle.add(combo);
		middle.add(courseName);
		middle.add(courseField);
		middle.add(gpa);
		middle.add(gpaField);
		middle.add(credits);
		middle.add(creditsField);
		//Initialize North Panel
		north.add(studentName);
		north.add(studentField);
		north.add(addStudent);
		north.add(removeStudent);
		//Initialize Bottom Panel
		bottom.add(textArea);
		//Initialize Top Panel
		top.add(middle, BorderLayout.CENTER);
		top.add(south, BorderLayout.SOUTH);
		//Initialize Center Panel
		center.add(top);
		center.add(bottom);
		//Initialize Main Panel
		main.add(north, BorderLayout.NORTH);
		main.add(center, BorderLayout.CENTER);
		//Initialize JFrame
		add(main);
		JScrollPane scrollPane = new JScrollPane(textArea);
	    bottom.add(scrollPane);
		//Initialize Borders
		Border border1 = BorderFactory.createTitledBorder("Student Section");
		Border border2 = BorderFactory.createTitledBorder("Course Section");
		Border border3 = BorderFactory.createTitledBorder("Log Section");
		north.setBorder(border1);
		top.setBorder(border2);
		bottom.setBorder(border3);
		textArea.setEditable(false);
	}

	//If course was not found this will print a message notifying the user
	public static void courseNotFound()
	{
		textArea.setText("Course was not found!");
	}
	
	//If course is found successfully this method will notify the user
	public static void courseFound()
	{
		textArea.setText("Course removed successfully");
	}

	//Method for adding Students with GUI
	public void addStudent()
	{
		if(studentField.getText().trim().equals(""))
		{
			textArea.setText("You must enter a Student name to add a Student!");
		}
		else
		{
			String studentName = studentField.getText().trim();
			Student student = new Student(studentName);
			list.add(student);
			studentField.setText("");
			combo.addItem(studentName);
			textArea.setText("Student added.");
		}
	}
	
	//Method for removing Students with GUI
	public void removeStudent()
	{
		for(int i =0; i < list.size(); i++)
		{
			int counter = 0;
			if(studentField.getText().trim().equals(list.get(i)))
			{
				list.remove(i);
				counter++;
				combo.removeItem(studentField.getText());
				studentField.setText("");
				textArea.setText("Student has been removed.");
			}
			if (counter == 0)
			{
				textArea.setText("Student was not found!");
			}
		}
	}
	
	//Method for adding Courses with GUI
	public void addCourse()
	{
		students = list.contains(getNameInCombo());
		if(courseField.getText().trim().equals("") || creditsField.getText().trim().equals("")
				|| creditsField.getText().trim().equals(""))
		{
			textArea.setText("You must fill out all of the Course fields!");
		}
		else
		{
			String course = courseField.getText();
			double gpa = Double.parseDouble(gpaField.getText());
			double credits = Double.parseDouble(creditsField.getText());
			Course newCourse = new Course(course,gpa,credits);
			students.addCourse(newCourse);
			courseField.setText("");
			gpaField.setText("");
			creditsField.setText("");
			textArea.setText("Course added successfully.");
		}
	}

	//Method for removing Courses with GUI
	public void removeCourse()
	{
		Student student = list.contains(getNameInCombo());
		String target = courseField.getText();
		Course course = student.getCollection().search(target);
		student.removeCourse(course);
		courseField.setText("");
		gpaField.setText("");
		creditsField.setText("");
	}

	//Method for displaying a selected Students ID and Courses
	public void display()
	{
		students = list.contains(getNameInCombo());
		textArea.setText(students.toString());
	}
	
	//Method for displaying all of the Students ID's and Courses
	public void displayAll()
	{
		textArea.setText(list.toString());
	}
	
	//Method for retrieving the name in the drop down menu of GUI
	public String getNameInCombo()
	{
		combo.getSelectedItem();
		return (String)combo.getSelectedItem();
	}
	
	//Action Performed methods for GUI
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(addStudent)){
			addStudent();
		}
		else if(e.getSource().equals(removeStudent)){
			removeStudent();
		}
		else if(e.getSource().equals(addCourse)){
			addCourse();
		}
		else if(e.getSource().equals(removeCourse)){
			removeCourse();
		}
		else if(e.getSource().equals(display)){
			display();
		}
		else if(e.getSource().equals(displayAll)){
			displayAll();
		}
		else if(e.getSource().equals(combo))
		{
			getNameInCombo();
		}
	}
	
	//Main-method
	public static void main(String[] args)
	{
		GuiDriver driver = new GuiDriver();
		driver.setVisible(true);	
	}
}
