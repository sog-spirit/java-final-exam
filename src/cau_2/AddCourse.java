package cau_2;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCourse extends Frame implements ActionListener {
	Label code, name, credit;
	TextField textCode, textName, textCredit;
	Button add, clear;
	Panel containerPanel;
	
	public AddCourse(String string) {
		super(string);
		GUI();
	}
	public void GUI() {
		code = new Label("Code");
		name = new Label("Name");
		credit = new Label("Credit");
		
		textCode = new TextField();
		textName = new TextField();
		textCredit = new TextField();
		
		add = new Button("Add");
		add.addActionListener(this);
		clear = new Button("Clear");
		clear.addActionListener(this);
		
		containerPanel = new Panel(new GridLayout(4, 2));
		containerPanel.add(code);
		containerPanel.add(textCode);
		containerPanel.add(name);
		containerPanel.add(textName);
		containerPanel.add(credit);
		containerPanel.add(textCredit);
		containerPanel.add(add);
		containerPanel.add(clear);
		
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			String codeInput, nameInput, creditInput;
			codeInput = textCode.getText();
			nameInput = textName.getText();
			creditInput = textCredit.getText();
			
			try {
				Connection connection = getConnection();
				PreparedStatement insert = connection.prepareStatement(""
						+ "insert into Course "
						+ "(Code, Name, Credit) "
						+ "values (?,?,?)");
				insert.setString(1, codeInput);
				insert.setString(2, nameInput);
				insert.setString(3, creditInput);
				insert.execute();
			}
			catch (Exception sqlException) {
				System.out.println(e);
			}
			dispose();
		}
		if(e.getSource() == clear) {
			textCode.setText("");
			textName.setText("");
			textCredit.setText("");
		}
	}
}
