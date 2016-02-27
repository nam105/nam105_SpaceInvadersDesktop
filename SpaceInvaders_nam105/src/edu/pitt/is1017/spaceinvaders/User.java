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
	
	String sql = "SELECT * FROM users WHERE userID = " +userID+ ";";
	
	try{
	ResultSet rs = db.getResultSet(sql);
		while (rs.next()){
			lastName = rs.getString("lastName");
			firstName = rs.getString("firstName");
			email = rs.getString("email");
			/*
			System.out.println(userID + "\t");
			System.out.println(lastName + "\t");
			System.out.println(firstName + "\t");
			System.out.println(email + "\t");
			*/
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
			//JOptionPane.showMessageDialog(null, "Login Successful");
			
			String sql2 = "SELECT * FROM users WHERE email = '" +email+ "';";
			
			ResultSet gt = db.getResultSet(sql2);
		
			while (gt.next()){
			userID = gt.getInt("userID");
			lastName = gt.getString("lastName");
			firstName = gt.getString("firstName");
			}
		}
		else{
			loggedIn = false;
			JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
		}
	} 
	catch(Exception ex){
		System.out.println("An error has occured");
	
	} 
	//Close connection here
	finally{
		
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

public int getUserID() {
	return userID;
}


public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public boolean getLoggedIn(){
	return loggedIn;
}

public User getUser(User u){
	return u;
}

public void saveUserInfo(){
	System.out.println("Saved userID: " + userID);
	System.out.println("Saved Last Name: " + lastName);
	System.out.println("Saved First Name: " + firstName);
	System.out.println("Saved Email: " + email);
	
	DbUtilities db = new DbUtilities();
	
	String sql = "UPDATE users SET lastName = '" +lastName+ "', firstName = '" +firstName+ "', email = '" +email+ "' WHERE userID = " +userID+ ";";
	
	db.executeQuery(sql);
	
	
}





}
			

	
	


