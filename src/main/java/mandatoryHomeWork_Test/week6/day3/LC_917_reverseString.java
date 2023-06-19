package dailyProblems_String;

import org.junit.Test;

public class reverseString {
	@Test
	public void data() {
		String name = "ab-cd";
		

		System.out.println(reverseOnlyLetters1(name));
	}
	
	@Test
	public void data1() {
		String name = "a-bC-dEf-ghIj";
		
		System.out.println(reverseOnlyLetters1(name));
	}
	
	@Test
	public void data2() {
		String name = "Test1ng-Leet=code-Q!";
		
		System.out.println(reverseOnlyLetters1(name));
	}
	//Time complexity is O(n)
	//Space complexity is O(1)
	 public String reverseOnlyLetters(String s) {
	        char[] ch = s.toCharArray();
	        int left=0;
	        int right=ch.length-1;

	        while(left<right){
	        	if ((ch[left] < 'A' || ch[left] > 'Z') && (ch[left] < 'a' || ch[left] > 'z')) {
	                left++;
	            }
	            else if((ch[right] < 'A' || ch[right] > 'Z') && (ch[right] < 'a' || ch[right] > 'z')){
	                right--;
	            }
	            else{
	                char temp = ch[left];
	                ch[left++]=ch[right];
	                ch[right--] = temp;

	            }
	        }
	        return new String(ch);
	    }
	 
	//Time complexity is O(n)
		//Space complexity is O(1)
	 public String reverseOnlyLetters1(String s) {
	        char[] ch = s.toCharArray();
	        int left=0;
	        int right=ch.length-1;

	        while(left<right){
	        	if (!Character.isAlphabetic(ch[left])) {
	                left++;
	            }
	            else if(!Character.isAlphabetic(ch[right])){
	                right--;
	            }
	            else{
	                char temp = ch[left];
	                ch[left++]=ch[right];
	                ch[right--] = temp;

	            }
	        }
	        return new String(ch);
	    }
}
