package assignments.assignmentTwo;

import java.util.Random;

/**
 * Allows the original method to have the letters shifted (turn into different letters)
 * @author Ava Downey
 * @version 2/25/20
 */

public class ShiftN_Cipher implements Cipher {

	private int shifts;		// indicates the number of positions to shift the message
	
	/**
	 * caller inputs number of shifts
	 * @param shifts number of shifts
	 */
	public ShiftN_Cipher(int shifts) {
		this.shifts = shifts;
		
	}
	
	/**
	 * default constructor
	 * sets the shift to a random number between 0 and 9
	 */
	public ShiftN_Cipher() {
		Random random = new Random();
		shifts = random.nextInt(10) + 1;
	}
	
	/**
	 * shifts the numbers and letters in the users message
	 * @param plainText is the message the user inputs
	 */
	@Override
	public String encode(String plainText) {
		String result = "";
		for(int i=0; i<plainText.length(); i++) {
            char c = plainText.charAt(i);
			result = result + shift(c);
		}
		return result;
	}
	
	/**
	 * decodes the encoded message the user originally inputted... must use encode first
	 * @param plainText is the users message
	 */
	@Override
	public String decode(String plainText) {
		String result = "";
		shifts = shifts * -1;	// sets to reverse of shift
		result = encode(plainText);
		shifts = shifts * -1;	// sets back to original shift
		return result;
	}
	
	/**
	 * Shifts a character at i in the message inputted by the user
	 * @param c is the character in that location of the message
	 * @return result returns the shifted number or letter for i in the string
	 */
	private char shift(char c) {
		
		char result;
		
		if (isLetter(c)) {	// checks for letters
			result = shiftLetter(c);
		} else if (isNumber(c)) {	// checks for numbers
			result = shiftNumber(c);
		} else {	// checks for spaces and punctuation... leaves it alone
			result = c;
		}
		
		return result;
	}
	
	/**
	 * shifts a letter shifts amount of times
	 * @param c is the letter that is to be shifted
	 * @return the newly shifted letter
	 */
	private char shiftLetter(char c) {
		int result = c + shifts;
		if (Character.isUpperCase(c)) {		// A is 65... Z is 90
			if (result >= 91) {
				result = result - 90 + 64;	// subtract Z and add A to get back in bound
			} else if (result < 65) {
				result = result + 90 - 64;	// add Z and subtract A to get back in bound
			}
		} else {	// a is 97... z is 122
			if (result >= 123) {
				result = result - 122 + 96;	// subtract z and add a to get back in bound
			} else if (result < 97) {
				result = result + 122 - 96;	// add z and subtract a to get back in bound
			}
		}
		return (char)result;
	}
	
	/**
	 * shifts a number shifts amount of times
	 * @param c is the number that is to be shifted
	 * @return the newly shifted number
	 */
	private char shiftNumber(char c) {
		int result = c + shifts;
		if (result > 58) {		// 0 is 48... 9 is 57
			result = result - 57 + 48;	// subtract 9 and add 0 to get back in bound
		} else if (result < 48) {
			result = result + 57 - 48;	// add 9 and subtract 0 to get back in bound
		}
		return (char)result;
	}
	
	/**
	 * checks to see if the character is a letter
	 * @param c the character being tested
	 * @return true if the character is a letter
	 */
	private boolean isLetter(char c) {
		return Character.isLetter(c);
	}
	
	/**
	 * checks to see if the character is a number
	 * @param c the character being tested
	 * @return true if the character is a number
	 */
	private boolean isNumber(char c) {
		return Character.isDigit(c);
	}
	
}
