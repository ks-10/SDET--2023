package dailyProblems_String;

import java.util.Stack;

import org.junit.Test;

public class goodString {
	@Test
	public void data() {
		String s = "leEeetcode";
		//System.out.println(goodstring(s));
		goodstring2(s);
	}
	
	public String goodstring(String s) {
		
		StringBuilder  op = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		char [] ch =  s.toCharArray();
		stack.push(ch[0]);
		for (int i = 1; i < ch.length; i++) {
			if(stack.isEmpty()) {
				stack.push(ch[i]);
			}
			else if(stack.peek()-ch[i]==32) {
				stack.pop();
			}
			
			else stack.push(ch[i]);
		}
		
		while(!stack.isEmpty()) {
			op.append(String.valueOf(stack.pop()));
		}
		
		return op.reverse().toString();
	}
	
	public void goodstring2(String s){
		
		StringBuilder op = new StringBuilder();
		char [] ch =  s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			
		}
		
		System.out.println(op);
	}
}
