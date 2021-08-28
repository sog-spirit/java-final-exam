package cau_2;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SearchCourse extends Frame implements ActionListener, WindowListener {
	
	Label code, name, credit;
	TextField textCode, textName, textCredit;
	Button search;
	Panel containerPanel, enterCodePanel, outputPanel;
	
	public SearchCourse(String string) {
		super(string);
		GUI();
	}
	public void GUI() {
		code = new Label("Code");
		name = new Label("Course name");
		credit = new Label("Credit");
		
		textCode = new TextField();
		textName = new TextField();
		textName.setEditable(false);
		textCredit = new TextField();
		textCredit.setEditable(false);
		
		search = new Button("Search");
		search.addActionListener(this);
		
		containerPanel = new Panel(new GridLayout(2, 1));
		enterCodePanel = new Panel(new GridLayout(1, 3));
		outputPanel = new Panel(new GridLayout(2, 2));
		
		enterCodePanel.add(code);
		enterCodePanel.add(textCode);
		enterCodePanel.add(search);
		
		outputPanel.add(name);
		outputPanel.add(textName);
		outputPanel.add(credit);
		outputPanel.add(textCredit);
		
		containerPanel.add(enterCodePanel);
		containerPanel.add(outputPanel);
		
		addWindowListener(this);
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
		if(e.getSource() == search) {
			String searchText = textCode.getText();
			
			try {
				Connection connection = getConnection();
				PreparedStatement search = connection.prepareStatement(""
						+ "select Name, Credit from Course "
						+ "where Code = ?");
				search.setString(1, searchText);
				ResultSet result = search.executeQuery();
				
				while(result.next()) {
					textName.setText(result.getString("Name"));
					textCredit.setText(result.getString("Credit"));
				}
				
			}
			catch (Exception SQLException) {
				System.out.println(SQLException);
			}
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
