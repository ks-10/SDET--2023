package dailyProblems_String;

import org.junit.Test;

public class reverseOnlyString {
	@Test
	public void data() {
		String str  = "ab%*1cd";
		reverseString(str);
	}
	@Test
	public void data1() {
		String s ="asd@#$@12efrdf312s*(^&*dsd";
		reverseString(s);
	}

	private void reverseString(String str) {
		
		StringBuilder sb =  new StringBuilder();
		char[] ch = str.toCharArray();
		int left =0 ;
		int right = ch.length-1;
		while(left<right) {
			if(!((ch[left] >= 'A' && ch[left] <= 'Z') || (ch[left] >= 'a' && ch[left] <= 'z'))) {
			//if(!Character.isAlphabetic(ch[left])) {
				left++;
			}
			else if(!((ch[left] >= 'A' && ch[left] <= 'Z') || (ch[left] >= 'a' && ch[left] <= 'z'))) {
		//	else if(!Character.isAlphabetic(ch[right])){
				right--;
			}
			else {
				char temp = ch[left];
				ch[left++] = ch[right];
				ch[right--] = temp;
			}
		}
		sb.append(ch);
		System.out.println(sb);
		
		
	}
}
