package edu.pitt.is1017.spaceinvaders;

public class TEST {

	public static void main(String[] args) {
		User u = new User(95);
		System.out.println(u.getFirstName());
		System.out.println(u.getLastName());
		System.out.println(u.getEmail());
		
		
		ScoreTracker track = new ScoreTracker(u);
		
		track.recordScore(u, 18);
		//track.recordScore(u, 1);
		//track.recordScore(u,4);
		track.recordFinalScore(u);
		
		
	}

}
