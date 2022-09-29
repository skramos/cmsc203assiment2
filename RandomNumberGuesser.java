import java.util.Scanner;

/*
 * Class: CMSC203 
 * Description: runs a random number guessing game. Uses rng class to create number and validate input
 * Due: 09/28/2022
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Name: Sophia K. Ramos
*/


public class RandomNumberGuesser {

	public static void main(String[] args) {
		
		//variables
		Scanner scan = new Scanner(System.in);
		int userGuess;
		int lowGuess = 1;
		int highGuess = 100;
		int rand = RNG.rand();
		String playAgain = "";
		
		System.out.println("this application generates a random integer between 1 and 100");
		System.out.println("and asks the user to guess repeatedly until they guess correctly\n");
		
		do {
			
			do {
				
				System.out.println("Enter a guess between "+lowGuess+" and "+highGuess);
				userGuess = scan.nextInt();
				scan.nextLine();
				
				if(RNG.inputValidation(userGuess, lowGuess, highGuess)) {
					if(userGuess == rand) {
						System.out.println("congrats you guessed correctly");
					}
					else if(userGuess>rand) {
						highGuess = userGuess;
						System.out.println("your guess is too high");
					}
					else {
						lowGuess = userGuess;
						System.out.println("your guess is too low");
					}
				}//if valid input
				
				if(userGuess!=rand) {
					System.out.println("Number of guesses: "+RNG.getCount());
				}
				
			}while(userGuess!=rand&&RNG.getCount()<7);
			
			if(RNG.getCount()==7) {
				System.out.println("you ran out of guesses");
			}
			
			System.out.println("try again? (yes or no)");
			playAgain = scan.nextLine();
			
			if(playAgain.equalsIgnoreCase("yes")) {
				RNG.resetCount();
				rand = RNG.rand();
				lowGuess = 1;
				highGuess = 100;
			}
			
		}while(playAgain.equalsIgnoreCase("yes")||!playAgain.equalsIgnoreCase("no"));
		

		System.out.println("\n\nEND PROGRAM");
		
	}

}
