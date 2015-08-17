package hangman;

import java.util.Scanner;

public class Hangman {
	
	public static void main(String arg[]){
		Game game = new Game("heather");
			Prompter prompter = new Prompter(game);
		
			prompter.play();
		
	}
}
