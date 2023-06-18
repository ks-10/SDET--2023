package dailyProblems;

import java.util.Arrays;
import org.junit.Test;

public class sortingSentence {
	@Test
	public void data() {
		String s = "is2 sentence4 This1 a3";
		System.out.println(solution1(s));
	}

	@Test
	public void data1() {
		String s = "sentence1";
		System.out.println(solution1(s));
	}

	//Time complexity = O(n)
	//Space complexity = O(n)
	public String solution1(String a) {
		//Creating a output string 
		StringBuilder op = new StringBuilder();
		//spliting the string with spaces 
		String[] split = a.split(" ");
		//creating a temp string array with split length
		String[] temp = new String[split.length];
		//looping the splited strings
		for (int j = 0; j < split.length; j++) {
			//getting the last integer value
			int index = Integer.parseInt(split[j].substring(split[j].length() - 1));
			//adding the string without numbers in temp variable in the ordered way
			temp[index - 1] = split[j].substring(0, split[j].length() - 1);
		}
		//looping the temp variable and appending it to the output string
		for (int i = 0; i < temp.length; i++) {
			op.append(temp[i]);
			op.append(" ");
		}
		//removing the last spaces in the string
		return op.toString().trim();
	}

	// Brute force
	
	//Time complexity = O(n^2 log n)
	//Space complexity = O(n)
	public String solution(String a) {
		StringBuilder op = new StringBuilder();
		String[] split = a.split(" ");
		int c[] = new int[split.length];
		int count = 0;

		for (int i = 0; i < split.length; i++) {
			char[] ch = split[i].toCharArray();
			for (int j = 0; j <= ch.length - 1; j++) {
				if (Character.isDigit(ch[j])) {
					c[count++] = ch[j] - '0';
				}
			}

		}
		Arrays.sort(c);//(n log n)
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < split.length; j++) {
				if (split[j].contains(String.valueOf(c[i]))) {
					op.append(split[j]);
				}
			}
		}
		return op.toString().replaceAll("\\d", " ").trim();
	}
}
