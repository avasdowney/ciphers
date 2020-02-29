package assignments.assignmentTwo;

import java.util.Scanner;

/**
 * Shifts and shuffles a message
 * @author Ava Downey
 * @version 2/27/20
 */

public class CipherMain {

	/**
	 * Main method to print out encoded and decoded messages
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String run = "e";
		String plainText = "";
		int shifts;
		int shuffles;
		String shiftMsg = "";
		String shuffleMsg = "";
		
		Cipher shift = new ShiftN_Cipher();
		Cipher shuffle = new ShuffleN_Cipher();
		
		// loops the program until the user wants to quit
		while (run != "q") {
			
			// lets the user encode a message they input by shuffling and shifting x number of times
			if (run.equals("e")) {
				
				shift = new ShiftN_Cipher();
				shuffle = new ShuffleN_Cipher();
				
				System.out.println("What message would you like to encode?  ");
				plainText = scan.nextLine();
				System.out.println("How much would you like to shift your message? "
								 + "Type 0 if random. ");
				shifts = scan.nextInt();
				System.out.println("How many times would you like to shuffle your "
								 + "message? Type 0 if random. ");
				shuffles = scan.nextInt();
				
				// if shifts / shuffles is 0, randomly choose number of shifts and shuffles
				if (shifts == 0) {
					shift = new ShiftN_Cipher();
				} else {
					shift = new ShiftN_Cipher(shifts);
				}
				
				if (shuffles == 0) {
					shuffle = new ShuffleN_Cipher();
				} else {
					shuffle = new ShuffleN_Cipher(shuffles);
				}
				
				shiftMsg = shift.encode(plainText);
				shuffleMsg = shuffle.encode(plainText);
				
				System.out.println("\nShifted Text: " + shiftMsg);
				System.out.println("Shuffled Text " + shuffleMsg + "\n");
				
				scan.nextLine();
				
			// decodes the previously encoded message
			} else if (run.equals("d")) {
				System.out.println("Decoded shifted message: " + shift.decode(shiftMsg));
				System.out.println("Decoded shuffle message: " + shuffle.decode(shuffleMsg) + "\n");
				
			// quits the program
			} else if (run.equals("q")) {
				System.out.println("Goodbye.");
				scan.close();
				break;
			}
			
			System.out.println("Do you want to encode a message (e)? decode the message (d)? Or quit (q)");
			run = scan.nextLine();
			
		}
		
	}
	
}
