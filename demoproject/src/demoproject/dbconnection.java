package demoproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
	
	final static String url = "jdbc:mysql://localhost/javaservletdb";
	final static String user = "root";
	final static String pwd = "root";
	
	
	static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pwd);
		return con;
	}

}
