package dailyProblems_String;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.junit.Test;

public class LongPressedString {

	@Test
	public void data() {
		String name = "xnhtq";
		String typed = "xhhttqq";

		System.out.println(isLongPressedName1(name, typed));
	}
	
	@Test
	public void data1() {
		String name = "a";
		String typed = "b";

		System.out.println(isLongPressedName1(name, typed));
	}
	
	@Test
	public void data2() {
		String name = "alex";
		String typed = "aaleexa";

		System.out.println(isLongPressedName1(name, typed));
	}

	//Time complexity --> O(M+N)
	//Space complexity --> O(1)
	private boolean isLongPressedName1(String name, String typed) {
		//Init the pointers for both the strings
		int left = 0;
		int right = 0;
		int temp = 0;
		int leftT = 0;
		int rightT = 0;
		int tempT = 0;

		//Looping the first string and checking the repeated characters and storing it in temp var
		while (right < name.length() || rightT < typed.length()) {
			if (left < name.length() && leftT < typed.length() && typed.charAt(leftT) == name.charAt(left)) {
				if (right < name.length() && name.charAt(left) == name.charAt(right)) {
					temp++;
					right++;
				} else {
					//incrementing my left to the right pointer
					left = right;
					//looping the second string and checking the repeated characters and storing it in temp var
					while (rightT <= typed.length()) {
						if (rightT < typed.length() && typed.charAt(leftT) == typed.charAt(rightT)) {
							tempT++;
							rightT++;
						} else {
							leftT = rightT;
							//checking if the temp>tempT if yes return false, else reset the temp variables and break the loop
							if (temp > tempT) {
								return false;
							} else {
								temp = 0;
								tempT = 0;
								break;
							}
						}
					}

				}
			} else
				return false;
		}
		return leftT == typed.length();

	}
}
