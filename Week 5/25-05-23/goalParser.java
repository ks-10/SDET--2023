package dailyProblems_String;

import org.junit.Test;

public class goalParser {

	@Test
	public void data() {
		String str = "G()()()()(al)";
		System.out.println(goal(str));
	}

	@Test
	public void data1() {
		String str = "G(al)";
		System.out.println(goal(str));
	}

	@Test
	public void data2() {
		String str = "a";
		System.out.println(goal(str));
	}

	//Time complexity --> O(n)
	//Space complexity --> O(1)
	private String goal(String str) {
		String op = "";
		char[] ch = str.toCharArray();
		//Loop till the end
		for (int i = 0; i < ch.length; i++) {
			//if G--> append string G
			if (ch[i] == 'G') {
				op += "G";
				//if ()--> append string O
			} else if (ch[i] == '(') {
				if (ch[i + 1] == ')') {
					op += "O";
					//if (al)--> append string AL
				} else {
					op += "AL";
				}
			}
		}
		return op;
	}

	private String goal1(String str) {
		String op = "";
		char[] ch = str.toCharArray();
		int index = 0;
		while (index < ch.length) {
			if (ch[index] == 'G') {
				op += "G";
				index++;
			} else if (ch[index] == '(') {
				if (ch[index + 1] == ')') {
					op += "O";
					index += 2;

				} else {
					op += "AL";
					index += 4;
				}
			}
		}
		return op;
	}

}
