package assignments.assignmentTwo;

import java.util.Random;

/**
 * allows the original message to be shuffled
 * @author Ava Downey
 * @version 2/27/20
 *
 */

public class ShuffleN_Cipher implements Cipher {
	
	private int shuffles;
	
	/**
	 * constructor for ShuffleN_Cipher that takes user input on amount of shuffles
	 * @param shuffles is the amount of times the plain text gets shuffled
	 */
	public ShuffleN_Cipher(int shuffles) {
		this.shuffles = shuffles;
	}
	
	/**
	 * constructor that sets shuffle to a random number between 1 and 10
	 */
	public ShuffleN_Cipher() {
		Random random = new Random();
		shuffles = random.nextInt(10);
	}
	
	/**
	 * To perform one shuffle, split the message in half and then take characters
	 * from each half alternately.
	 * For example, if the message is ABCDEFGHI, the halves are ABCDE and FGHI. The 
	 * shuffled message is AFBGCHDIE.  If shuffles is 2, the second shuffle halves are 
	 * AFBGC and HDIE giving the final shuffled message of AHFDBIGEC. 
	 * @param plainText is the original message to be encoded
	 * @return message returns the shuffled message
	 */
	private String shuffle(String plainText) {
		String firstHalf = plainText.substring(0, (plainText.length()/2));
		String secondHalf = plainText.substring(plainText.length()/2);
		String message = "";
		
		int firstHalfCount = 0;
		int secondHalfCount = 0;
		
		for(int i=0; i<plainText.length(); i++) {
			if(i%2 == 0 && firstHalfCount < plainText.length()/2) {	// checks if even... if yes from first half.. if no from second half
				message = message + firstHalf.charAt(firstHalfCount);
				firstHalfCount++;
				
			} else {
				message = message + secondHalf.charAt(secondHalfCount);	
				secondHalfCount++;
			}
		}
		return message;
	}
	
	/**
	 * Unshuffles the message inputted by the user to the original messages
	 * @param cypherText is the message inputted by the user
	 * @return unshuffled, original messaged
	 */
	private String unshuffle(String cypherText) {
		String firstHalf = "";
		String secondHalf = "";
		
		for(int i=0; i<cypherText.length(); i++) {
			
			if(i%2 == 0 && i < cypherText.length()-1) {	// checks if even... if yes from first half.. if no from second half
				firstHalf = firstHalf + cypherText.charAt(i);
				
			} else {
				secondHalf = secondHalf + cypherText.charAt(i);
			}
		}
		return firstHalf + secondHalf;
	}
	
	
	/**
	 * shuffles the original user message the amount of shuffles specified by 
	 * either the user or the randomly generated value
	 * @param plainText is the original message to be encoded
	 * @return result returns the encoded message
	 */
	@Override
	public String encode(String plainText) {
		String result = plainText;
		for (int i=0; i<shuffles; i++) {
			result = shuffle(result);
		}
		return result;
	}
	
	/**
	 * unshuffles the encoded message to and returns the original message
	 * @param plainText is the original message to be encoded
	 * @return result returns the encoded message
	 */
	 @Override
	public String decode(String plainText) {
		 String result = plainText;
			for (int i=0; i<shuffles; i++) {
				result = unshuffle(result);
			}
			return result;
	}

}
