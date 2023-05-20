package dailyProblems_String;

import java.util.Stack;

import org.junit.Test;

public class CrawlerLogFolder {

	@Test
	public void test1() {
		String [] str = {"d1/","d2/","../","d21/","./"};
	
		logFolder(str);
	}

	private void logFolder(String[] str) {
	Stack<String> st = new Stack<String>();
		
		for (int i = 0; i < str.length; i++) {
			boolean isalp = Character.isAlphabetic(str[i].charAt(0)) ||Character.isDigit(str[i].charAt(0)) ;
			if(str[i].contains("../")&& !st.isEmpty()) {
				st.pop();
			}
			else if(str[i].contains("./")&& !st.isEmpty()) {
				st.peek();
			}
			else if(isalp) {
				st.push(str[i]);
			}
		}
		int count=0;
		while(!st.isEmpty()) {
			st.pop();
			count++;
		}
		
		System.out.println(count);
		
	}
}
