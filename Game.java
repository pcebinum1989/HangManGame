package hangman;

import java.io.Console;
import java.util.Scanner;


public class Prompter {
	Scanner scan = new Scanner(System.in);
	private Game mGame;
	
	public Prompter(Game game){
		mGame = game;
	}
	
	public void play(){
		while(mGame.getRemainingTries() > 0 && !mGame.isSolved()){
			displayProgress();
			promptForGuess();
		}
		
		if(mGame.isSolved() ){
			System.out.printf("Congrats you won with %d tries ramining", mGame.getRemainingTries() );
		}
		else{
			System.out.printf("Bummer the word was %s. :(\n", mGame.getAnswer());
		}
	}

	public boolean promptForGuess(){
		boolean isHit = false;
		boolean isValidGuess = false;
		
		while(! isValidGuess){
			System.out.println("Please Enter A letter: ");
			String guessAsString = scan.nextLine();
			try{
				isHit = mGame.applyGuess(guessAsString);
				isValidGuess = true;
			}catch(IllegalArgumentException iae){
				System.out.printf(" %s. Please try again.\n ", iae.getMessage());
			}
		}
		return isHit;
	}
	
	public void displayProgress(){
		System.out.printf("You have  %d tries left to solve: %s\n",mGame.getRemainingTries(),mGame.getCurrentProgress());
	}

}
