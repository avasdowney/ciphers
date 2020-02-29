package assignments.assignmentTwo;

/**
 * Interface with encode and decode methods
 * @author Ava Downey
 * @version 2/27/20
 */

public interface Cipher {
	
	/**
	 * takes in a string and returns a new encoded string
	 * @param plainText is the original method to be encoded
	 * @return the encoded plain text message
	 */
	public abstract String encode(String plainText);
	
	/**
	 * takes in an encoded message and returns the original message
	 * @param plainText is the original method to be encoded
	 * @return the original plain text message
	 */
	public abstract String decode(String plainText);
	
}
