package lab1;
/*
 * 		Name: Sujun Kim
 * 		Class: CECS378 Sec 03 11544
 * 		ID : 028945720
 *  
 *		This program encodes and decodes encrypted messages.
 *		It counts how many letter of each alphabets are in a message
 *		order those number in descending orders
 *		By using ETAQIN (frequency of common used letters ) it replaces alphabets
 * 		What I couldn't finish:
 * 
 */
public class labOneDecode {
	static int [][]wordcount = new int [26][1];// list to keep track of alphabet counts
	static char []mostFrequent = new char[26]; //lists alphabets in most frequently used 
	public static void count(String message) { // counts number of each alphabet in message
		message = message.toLowerCase();
		for (int i = 0; i< message.length();i++) {
			char alpha = message.charAt(i);
			if(alpha != ' ') {
				wordcount[alpha-97][0]++;
			}
				
		}
	}
	public static void frequency() {  // after counting finds frequency
		int[][]temp = new int[26][1]; 
		for (int i = 0 ;i <26;i++) {
			temp[i][0] = wordcount[i][0];
		}
		for(int i = 0; i<26;i++) {
			int largestValue = 0;
			int place = -1;
			for(int j = 0;j<26;j++) {
				if (temp[j][0]>largestValue) {
					//System.out.println("temp[j][0] = " +temp[j][0] + "Largest : " +largestValue);
					place = j;
					largestValue = temp[j][0];
				}
//				System.out.println("2:::::temp[j][0] = " +temp[j][0] + "Largest : " +largestValue + " Place: "+ place);
			}
			if (place != -1) {
				temp[place][0] = 0;
				mostFrequent[i] = (char)(place+ 97);
			}
		}
	}
	public static String encode(char key, String message) { //encrypt the mssage based on key given
		
		String encrypted = "";
		int x = key - 97; // find the ascii value of given key and subtract ascii of a
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
	public static void print() {
//		for(int x = 0; x<26;x++) {
//			System.out.println((char)(x+97) + ": " + wordcount[x][0]);
//		}
		System.out.println("---------------------");
		for(int x = 0; x<26;x++) {
			if (mostFrequent[x] >=97)
			System.out.println(mostFrequent[x] + ": " + wordcount[mostFrequent[x]-97][0]);
		}
	}
	public static String decode(String message) { //ETAOINSHRDICUMWFGYPBVKJXQZ TAODW      ESDT
		//above there about that this 
		String temp = message;
		temp = temp.replaceAll(" ","");
		//System.out.println(temp);
		String lists[] = new String[26];
		for(char x = 97; x< 123;x++) {
			lists[x-97] = encode(x,temp);
		}
		int points[] = new int[26];
		int counter = 0;
		for(String list: lists) {
			points[counter] = commonWords(list);
			counter++;
		}
		int largest = 0;
		int place = 0;
		for(int x = 0; x<26;x++) {
			if(points[x]>largest) {
				largest = points[x];
				place = x;
			}
		}
		
		return encode((char)(place+97),message);
	}
	public static int commonWords(String message) { // finds the number of common words in message
		int x = 0;
		String commons[] = {"the","what","and", "there", "about","that","this","you","to","be", "in", "have", "for"};
		for(String common : commons) {
			if(message.contains(common)) {
				x++;
			}
		}
		return x;
	}
	public static void checkString(String message) { //checks if common pattern of most used words are found 
		int place = 0;
		int replaced = 0;
		for(int i = 0; i< message.length();i++) {// loops throguh message
			if(message.charAt(i) == 'T' && message.charAt(i+1) <97 && i < message.length() -2&& message.charAt(i + 2) == 'E') { // if T and E is found with a letter in between
				int count[] = new int[26];
				count[message.charAt(i+1)] += 1; // count the middle letter and add H to the center of most commonly found to add THE
				for(int j = 0 ; j < count.length;j++) {
					int largest = 0;
					if(count[j] > largest) {
						largest = count[j];
						place = j; 
					}
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		String check = "fqjcb rwjwj vnjax bnkhj whxcq nawjv nfxdu mbvnu ujbbf nnc";
		String exam3 = "oczmz vmzor jocdi bnojv dhvod igdaz admno ojbzo rcvot jprvi oviyv aozmo cvooj ziejt dojig toczr dnzno jahvi fdiyv xcdzq zoczn zxjiy";
		String exam1 = "ejitp spawa qleji taiul rtwll rflrl laoat wsqqj atgac kthls iraoa twlpl qjatw jufrh lhuts qataq itats aittk stqfj cae";
		String exam2 = "iyhqz ewqin azqej shayz niqbe aheum hnmnj jaqii yuexq ayqkn jbeuq iihed yzhni ifnun sayiz yudhe sqshu qesqa iluym qkque aqaqm oejjs hqzyu jdzqa diesh niznj jayzy uiqhq vayzq shsnj jejjz nshna hnmyt isnae sqfun dqzew qiead zevqi zhnjq shqze udqai jrmtq uishq ifnun siiqa suoij qqfni syyle iszhn bhmei squih nimnx hsead shqmr udquq uaqeu iisqe jshnj oihyy snaxs hqihe lsilu ymhni ty";
		String test = "abcd";
		System.out.println(("fqjcb rwjwj vnjax bnkhj whxcq nawjv nfxdu mbvnu ujbbf nnc\n    DECODES INTO :" +decode(check)));
		System.out.println(("ejitp spawa qleji taiul rtwll rflrl laoat wsqqj atgac kthls iraoa twlpl qjatw jufrh lhuts qataq itats aittk stqfj cae\n    DEOCDES INTO :" + decode(exam1)));
		System.out.println("iyhqz ewqin azqej shayz niqbe aheum hnmnj jaqii yuexq ayqkn jbeuq iihed yzhni ifnun sayiz yudhe sqshu qesqa iluym qkque aqaqm oejjs hqzyu jdzqa diesh niznj jayzy uiqhq vayzq shsnj jejjz nshna hnmyt isnae sqfun dqzew qiead zevqi zhnjq shqze udqai jrmtq uishq ifnun siiqa suoij qqfni syyle iszhn bhmei squih nimnx hsead shqmr udquq uaqeu iisqe jshnj oihyy snaxs hqihe lsilu ymhni ty\n     DECODES INTO: "+(decode(exam2)));
		System.out.println(("oczmz vmzor jocdi bnojv dhvod igdaz admno ojbzo rcvot jprvi oviyv aozmo cvooj ziejt dojig toczr dnzno jahvi fdiyv xcdzq zoczn zxjiy\n    DECODES INTO :" + decode(exam3)));
		
		
//		sub = sub.replace('t', 'E');
//		sub = sub.replace('l', 'A');
//		sub = sub.replace('q', 'O');
//		System.out.println(sub);
		
		//System.out.println(check.replace('n', 'E').replace('j', 'T').replace('b','A'));
		
		
	}
	//etaoinshrdicu
	//
}