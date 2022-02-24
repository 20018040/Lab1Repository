package lab1;
/*
 * 		Name: Sujun Kim
 * 		Class: CECS378 Sec 03 11544
 * 		ID : 028945720
 * 
 * 		This program decodes simple encrypted message based on key given 
 */
import java.util.Scanner;

public class decoder {
	public static String decode(String key, String message) { //decode the mssage based on key given
			
			String encrypted = "";
			int x = key.charAt(0)- 97; // find the ascii value of given key and subtract ascii of a
			// ascii of a~z = 97~122
			for (int i = 0; i< message.length() ;i++) {
				char ascii = (char) (122 -  (122- message.charAt(i)+x)%26);// subtract the key to each char and if it goes under 97 use reaminder to fight right answer
				if(message.charAt(i) != 32)
					encrypted = encrypted + ascii;		
				else 
					encrypted = encrypted + " ";
				} 
			return encrypted;
		}
	public static void main(String args[]) {
		 Scanner in = new Scanner(System.in);
		System.out.println("Enter message to be decrypted");
		String message = in.nextLine();
		message.toLowerCase();
		System.out.println("Provide key used to encrypt the message");
		String key = in.nextLine();
		System.out.println(decode(key,message));
	}
}
