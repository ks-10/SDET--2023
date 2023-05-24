package dailyProblems_String;

import org.junit.Test;

public class dafangingIP {
	 
	@Test
	public void data() {
		String str = "1.1.1.1";
		System.out.println(defangIPaddr(str));
	}
	@Test
	public void data1() {
		String str = "1";
		System.out.println(defangIPaddr(str));
	}
	@Test
	public void data2() {
		String str = "";
		System.out.println(defangIPaddr(str));

	}
	
	public String defangIPaddr(String address) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < address.length(); i++) {
			if(address.charAt(i)=='.') {
				sb.append("[.]");
			}
			else {
				sb.append(address.charAt(i));
			}
		}
		return sb.toString();
	        
	    }
}
