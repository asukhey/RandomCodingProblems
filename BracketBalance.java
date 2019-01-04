import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 *This problem was asked by Facebook.

 *Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

 *For example, given the string "([])[]({})", you should return true.

 * Given the string "([)]" or "((()", you should return false. 
 * */

/*Using stacks to check the chronology of parenthesis*/


public class BracketBalance {
	static final int MAX=1000;
	public String[] parenthesis= new String[MAX]; //Checks the order of brackets
	
	public static HashMap<String, String> brackets = new HashMap<String,String>();	
	
	public void balancedString(String s) {
		int top=-1; //empty stack
		
		brackets.put("(", ")");
		brackets.put("{", "}");
		brackets.put("[", "]");
		brackets.put("<", ">");
		
		
		
		
		/*REGEX to extract parenthesis*/
		String pattern ="[\\(\\)\\[\\]\\{\\}\\<\\>]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(s);
		String ip=""; // new string with only parenthesis
		
		
		while(m.find()) {
			ip+=m.group(0);
		}
		
		/*
		 * Now checking if brackets are balanced well or not
		 * */
		
		
		//If first bracket is closed
		
		try {
			if(brackets.containsValue(String.valueOf(ip.charAt(0)))) {
				System.out.println("Not balanced!");
			}
			else {
				int i=0;
				
				while(i<ip.length()) {
					String temp=String.valueOf(ip.charAt(i));
					if(brackets.containsKey(temp)) {
						top+=1;
						parenthesis[top]=temp; // push 
						
					}
					
					else if(brackets.containsValue(temp)) {
						
						//If closing bracket is not equal to the
						if(brackets.get(parenthesis[top]).equals(temp)) {
							top-=1;
						}
						else {
							System.out.println("String is imbalanced");
							break;
						}
						
					}
					i+=1;
				}
				
				if(top==-1) {
					System.out.println("String is balanced");
				}
			}
		}
	
		catch(Exception e) {
			System.out.println("String is Imbalanced");
		}
		
			
		
		
		
	}
	
	public static void main(String args[]) {
		
		String s ="Sh[(e) SH]ells (she) se{lls} by <the> sea shore";
		BracketBalance b = new BracketBalance();
		b.balancedString(s);
			
	}
	
}
