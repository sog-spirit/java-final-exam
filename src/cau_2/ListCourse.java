package cau_2;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ListCourse extends Frame implements ActionListener, WindowListener {
	
	Label header;
	TextArea resultTextArea;
	Panel containerPanel;
	
	public ListCourse(String string) {
		super(string);
		GUI();
		
		try {
			Connection connection = getConnection();
			PreparedStatement getAll = connection.prepareStatement(""
					+ "select * from Course order by Credit ASC");
			ResultSet result = getAll.executeQuery();
			
			String outputString = "";
			
			while(result.next()) {
				outputString += result.getString(1) + " | " + result.getString(2) + " | " + result.getString(3) + "\n";
			}
			resultTextArea.setText(outputString);
		}
		catch (Exception SQLException) {
			System.out.println(SQLException);
		}
	}
	public void GUI() {
		header = new Label("List of all courses (order by Credit)");
		resultTextArea = new TextArea();
		resultTextArea.setEditable(false);
		
		containerPanel = new Panel(new GridLayout(1, 1));
		containerPanel.add(header);
		containerPanel.add(resultTextArea);
		
		add(containerPanel);
		setSize(400,400);
		setVisible(true);
	}
	public static Connection getConnection() {
		String connectionString = "jdbc:sqlserver://localhost; database=TestJava; integratedSecurity=true";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(connectionString);
			return connection;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@Override
	public void windowOpened(WindowEvent e) {
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
	}
	@Override
	public void windowClosed(WindowEvent e) {
		dispose();
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
