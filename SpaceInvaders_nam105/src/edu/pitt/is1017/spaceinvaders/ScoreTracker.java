package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.util.UUID;

import javax.swing.JOptionPane;

public class ScoreTracker {
	
	public int currentScore;
	public int highestScore;
	public UUID gameID;
	

public ScoreTracker(User u){
	
	int userID = u.getUserID();
	currentScore = 0;
	gameID = UUID.randomUUID();
	//System.out.println(gameID);
	//System.out.println(userID);
	
	DbUtilities db = new DbUtilities();
	
	String sql = "SELECT scoreValue FROM finalscores WHERE fk_userID = '" +userID+"';";
	
	try{
		ResultSet rs = db.getResultSet(sql);
		if(rs.next()){
			highestScore = rs.getInt("scoreValue");	
			//System.out.println(userID);
			JOptionPane.showMessageDialog(null, "Your High Score is: " +highestScore);
		}
		
		else{
			JOptionPane.showMessageDialog(null, "Cound not find high score.");
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

public void recordScore(User u, int point){

	int userID = u.getUserID();
	currentScore = currentScore + point;
	DbUtilities db = new DbUtilities();
	
	String sql = "UPDATE runningscores SET scoreValue='" +currentScore+ "' WHERE fk_userID='" +userID+"';";
	
	//System.out.println(sql);
	db.executeQuery(sql);
	
}

public void recordFinalScore(User u){
	
	int userID = u.getUserID();
	
	DbUtilities db = new DbUtilities();
	
	String sql = "UPDATE finalscores SET gameID='" +gameID+ "', scoreValue='" +currentScore+ "' WHERE fk_userID='" +userID+"';";
	
	//String sql = "INSERT INTO finalscores (gameID, scoreValue)";
	//sql = sql + " VALUES('" +gameID+ "', '"+currentScore+ "') WHERE fk_userID='" +userID+"';";
	
	//System.out.println(sql);
	
	db.executeQuery(sql);
}

public int getCurrentScore() {
	return currentScore;
}

public int getHighestScore() {
	return highestScore;
}
	

 
}








