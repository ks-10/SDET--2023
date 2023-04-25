package dailyProblems;

import java.util.Iterator;

import org.junit.Test;

public class removeFandLoccurence {
	
//Remove the first and last occurrence of a given number in the input array
//	input = {1,2,3,4,5,1}, number = 1
//			output = {2,3,5}
	
	
	@Test
	public void postiveScenario() {
		int [] input = {2,2,3,2,4,2,2};
		int remove= 2;
		printArray (solution(input,remove));

	}

	@Test
	public void negativeScenario() {
		int [] input = {1,2,3,9,4,5,1};
		int remove= 9;
		printArray (solution(input,remove));
	}

	 @Test
	public void EdgecaseScenario() {
		int [] input = {0};
		int remove= 1;
		printArray (solution(input,remove));
	}
	
	//Space complexity ==>O(n)
	// time complexcity ==> O(n)
	private int[] solution(int[] a,int remove) {
		int temp =0;
		int temp2 =0;
		int [] b = new int [a.length];
		for (int i = 0; i < a.length-1; i++) {
			if(a[i]!=remove) {
				b[i]= a[i];		
			}
			else {
			temp =i+1; 
			break;
			}
		}
		
		for (int i = a.length-1; i >=0; i--) {
			if(a[i]!=remove) {
				b[i]= a[i];
			}
			else {
				temp2 = i; 
				break;
				}
		}
		if(temp!=0||temp2!=0) {
		for (int i = temp; i < temp2; i++) {
			b[i]=a[i];
			}
		}
		return b;
		
	}

	// time complexcity ==> O(n)
	private int findlen(int[] x) {
		int len = 0;
		for (int i = 0; i < x.length; i++) {
			len++;
		}
		// System.out.println("Length : " + len);
		return len;

	}

	private void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if(a.length==1) {
				System.out.print("[" + a[i] + "]");
			}
			else {
			if (i == 0) {
				System.out.print("[" + a[i] + ",");
			} else if (i == a.length - 1) {
				System.out.println(a[i] + "]");
			} else {
				System.out.print(a[i] + ",");
			}
		}
		}
	}

}
