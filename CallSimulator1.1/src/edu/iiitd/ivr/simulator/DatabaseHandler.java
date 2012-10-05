package edu.iiitd.ivr.simulator;

import java.sql.*;
/**
 * 
 * @author siddhartha
 */
public class DatabaseHandler {
    /**
     * 
     */
    public Connection con = null;
String url = "jdbc:mysql://localhost:3306/";
String dbName = "course";
String driver = "com.mysql.jdbc.Driver";
String userName = "root"; 
String password = "12345";

/**
 * 
 * @return
 */
public Connection getConnection(){
	 try {
		  Class.forName(driver).newInstance();
		  con = DriverManager.getConnection(url+dbName,userName,password);
		  //System.out.println("Connected to the database");
		  //con.close();
		  //System.out.println("Disconnected from database");
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
		  return con;
		  //
}
}
