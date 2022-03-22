package lab1;
import java.util.Scanner;
/*
 * 		Name: Sujun Kim
 * 		Class: CECS378 Sec 03 11471
 * 		ID : 028945720
 * 
 * 		This program encodes message based on key given 
 */
public class encoder { 
	public static String takeInput() { // asks user for input and return that to bestored or encoded
		String message = "";
		Scanner in = new Scanner(System.in);
		message = in.nextLine();
		in.close();
		return message;
	}
	public static String encode(String key, String message) { //encrypt the mssage based on key given
		
		String encrypted = "";
		int x = key.charAt(0)- 97; // find the ascii value of given key and subtract ascii of a
		// ascii of a~z = 97~122
		for (int i = 0; i< message.length() ;i++) {
			char ascii = (char) ((message.charAt(i) - 97 +  x)%26 + 97 );// add the diff to each char
			if(message.charAt(i) != 32)
				encrypted = encrypted + ascii;		
			else 
				encrypted = encrypted + " ";
			} 
		return encrypted;
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter message to be encrypted");
		String message = in.nextLine();
		message.toLowerCase();
		System.out.println("Provide key to encrypt the message");
		String key = in.nextLine();
		System.out.println("Encrypted message: " + encode(key,message));
		
	}
	
}
