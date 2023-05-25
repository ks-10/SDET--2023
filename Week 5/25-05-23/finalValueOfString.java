package dailyProblems_String;

import org.junit.Test;

public class finalValueOfString {

	@Test
	public void data() {
		String str[] = {"--X","X++","X++"};
		System.out.println(finalValueAfterOperations(str));
	}
	@Test
	public void data1() {
		String str[] = {""};
		System.out.println(finalValueAfterOperations(str));
	}
	
	@Test
	public void data2() {
		String str[] = null;
		System.out.println(finalValueAfterOperations(str));
	}
	//Time complexity --> O(n)
	//Space complexity --> O(1)
	 public int finalValueAfterOperations(String[] operations) {
		 if(operations==null) {
			 return 0;
		 }
	        int x=0;
	        for (String ob : operations) {
	        	if(ob.isBlank() || ob.isEmpty()) {
	        		return 0;
	        	}
	            if(ob.charAt(1)=='-'){
	                x--;
	            }
	            else {
	                x++;
	            }
	        }
	        return x;
	    }
	
	
}
