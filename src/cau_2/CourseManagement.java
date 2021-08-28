package cau_2;
import java.awt.*;
import java.awt.event.*;

public class CourseManagement extends Frame implements ActionListener {
	Label coursesManagement;
	Button add, display, search, exit;
	Panel containerPanel;
	
	public CourseManagement(String string) {
		super(string);
		GUI();
	}
	public static void main(String[] args) {
		new CourseManagement("CourseManagement");
	}
	public void GUI() {
		coursesManagement = new Label("Courses Management");
		
		add = new Button("Add a new Course");
		add.addActionListener(this);
		display = new Button("Display all Courses");
		display.addActionListener(this);
		search = new Button("Search Course by Course Code");
		search.addActionListener(this);
		exit = new Button("Exit Application");
		exit.addActionListener(this);
		
		containerPanel = new Panel(new GridLayout(5, 1));
		containerPanel.add(coursesManagement);
		containerPanel.add(add);
		containerPanel.add(display);
		containerPanel.add(search);
		containerPanel.add(exit);
		
		add(containerPanel);
		setVisible(true);
		setSize(400,400);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			new AddCourse("Add Course");
		}
		if(e.getSource() == display) {
			new ListCourse("List Course");
		}
		if(e.getSource() == search) {
			new SearchCourse("Search Course");
		}
		if(e.getSource() == exit) {
			System.exit(0);
		}
	}
}
