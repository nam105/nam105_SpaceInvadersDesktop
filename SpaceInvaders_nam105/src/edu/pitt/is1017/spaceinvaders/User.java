package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class User {
	
	public int userID;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public boolean loggedIn = false;
	
//Constructor for UserID	
public User(int userID){
	this.userID = userID;
	DbUtilities db = new DbUtilities();
	
	String sql = "SELECT * FROM users WHERE userID = '" +userID+ "';";
	
	try{
	ResultSet rs = db.getResultSet(sql);
		while (rs.next()){
			System.out.print(rs.getInt("userID") + "\t");
			System.out.print(rs.getString("lastName") + "\t");
			System.out.print(rs.getString("firstName") + "\t");
			System.out.println(rs.getString("email"));
		}
	}
	catch(Exception ex){
		System.out.println("An error has occured");
	} finally{
		
		db.closeConnection();
		}
}

//Constructor used for Login
public User(String email, String password){
	this.email = email;
	this.password = password;
	DbUtilities db = new DbUtilities();
	
	String sql = "SELECT * FROM users WHERE email = '" +email+ "' AND password = MD5('" + password + "');";
	
	try{
		ResultSet rs = db.getResultSet(sql);
		if(rs.next()){
			loggedIn = true;
			JOptionPane.showMessageDialog(null, "Login Successful");
		}
		else{
			loggedIn = false;
			JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
		}
	} 
	catch(Exception ex){
		System.out.println("An error has occured");
	// Close Connection here
	} finally{
		
		db.closeConnection();
		}
	
}

//Constructor used for Registration
public User(String lastName, String firstName, String email, String password){		
	this.lastName = lastName;
	this.firstName = firstName;
	this.email = email;
	this.password = password;
	DbUtilities db = new DbUtilities();
	
	String sql = "INSERT INTO users (lastName,firstName,email,password)";
	sql = sql + "VALUES('" +lastName+ "', '" +firstName+ "', '" +email+ "', MD5('" +password+ "'));";
	
	db.executeQuery(sql);
}
	
			
}
	
	


