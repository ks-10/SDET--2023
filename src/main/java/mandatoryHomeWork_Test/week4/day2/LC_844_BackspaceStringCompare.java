package dailyProblems_String;

import java.util.Stack;

import org.junit.Test;

public class BackspaceStringCompare {
	@Test
	public void data() {
		String s = "y#fo##f";
		String t = "y#f#o##f";
		
		System.out.println(backspaceCompare(s, t));
	}
	
	//time and space complexcity --> O(n +m)
	public boolean backspaceCompare(String s, String t) {
		//Init two stacks 
        Stack<Character> st = new Stack<Character>();
        Stack<Character> st1 = new Stack<Character>();
       
        //Loop through the first string
        for(int i=0; i<=s.length();i++){
        	//if the character is # and stack is not empty pop out from the stack
            if(s.charAt(i)=='#'){
            	 if(!st.isEmpty()) {
            		 st.pop();
                 }
                
            }
            //else push the char to stack
            else{
                st.push(s.charAt(i));
            }
        }
       
      //Loop through the Second  string
        for(int j=0; j<=t.length();j++){
        	//if the character is # and stack is not empty pop out from the stack
            if(t.charAt(j)=='#' ){
            	if(!st1.isEmpty()) {
                st1.pop();
            	}
            }
            //else push the char to stack
            else{
                st1.push(t.charAt(j));
            }
        }
        //check if the both the stacks are equal if yes return true
        if(st.equals(st1)){
            return true;
        }

        return false;
    }
}
