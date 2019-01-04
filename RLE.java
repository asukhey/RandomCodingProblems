import java.util.regex.Pattern;

/*
 * This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 * 
 * */
public class RLE {
	
	/*Boolean function to check if an encoded string contains numbers*/
	public boolean containsDigits(String ip,String pat) {
		return Pattern.compile(pat).matcher(ip).find();
	}
	
	
	public String str_encode(String ip)  {
	
		if(containsDigits(ip,"[0-9]")) {
			return "Encoded digits must contain only characters";
		}
		else {
			String res="";
			int ptr=0;
			int counter=0; //Calculates number of characters repeated
			
			while(ptr<ip.length()) {
				String temp_char=String.valueOf(ip.charAt(ptr)); //takes character	
				counter+=1;
				if(ptr==ip.length()-1||!temp_char.equalsIgnoreCase(String.valueOf(ip.charAt(ptr+1)))) {
					
					res+=String.valueOf(counter);
					res+=temp_char;
						
					counter=0;
					
				}
				temp_char+="";
				ptr+=1;
			}

			return res;
		}		
		
	}
	
	
	public void str_decode(String ip) {
		String res="";
		if(ip.isEmpty() || ip.length()%2!=0) {
			System.out.println("Enter a valid string to decode");
		}
		else {
			int i=0;
			while(i<ip.length()) {
				if(Character.isDigit(ip.charAt(i))){
					int counter=Integer.parseInt(String.valueOf(ip.charAt(i)));
					while(counter!=0) {
						res+=String.valueOf(ip.charAt(i+1));
						counter-=1;
					}
					
				}
				else {
					System.out.println("Make sure the encoded string is even Digits are placed in odd positions and characters in even");
					break;
				}
				i+=2;
			}
			
		}
		System.out.println("Decoded String: "+ res);
	}
	
	public static void main(String args[]) {
		RLE r = new RLE();
		String ip="AAAABBBCCDAA";
		String op=r.str_encode(ip);
		System.out.println("Input String: "+ip + "\nEncoded String: "+op);
		r.str_decode(op);
		
	}
	
}
