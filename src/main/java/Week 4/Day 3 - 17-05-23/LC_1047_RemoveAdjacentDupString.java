package dailyProblems_String;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

import org.junit.Test;

public class RemoveAdjacentDupString {
	@Test
	public void data() {
		String s = "abbaca";
		System.out.println(removeDuplicates(s));
	}

	@Test
	public void data1() {
		String s = "";
		System.out.println(removeDuplicates(s));
	}

	//Time complexity = O(n)
	//Space complexity = O(n)
	public String removeDuplicates(String s) {
		Stack<Character> str= new Stack<Character>();
		char[] ch = s.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			if(str.isEmpty() ) {
				str.push(ch[i]);
			}
			else if(str.peek()==ch[i]) {
				str.pop();
			}
			else str.push(ch[i]);
		}
		Collections.reverse(str);
		String out ="";
		while(!str.isEmpty()) {
			 out += str.pop();
			}
		return out;
        
    }
	
	
}
