package assignments.assignmentTwo;

public class CipherDebug {

	public static void main(String[] args) {
		Cipher shift = new ShiftN_Cipher(1);
		
		System.out.println(shift.encode("a z"));
		System.out.println(shift.decode("b a"));

	}

}
