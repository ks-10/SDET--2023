package dailyProblems;

import java.util.Iterator;

import org.junit.Test;

public class ArrayMethods {

	@Test
	public void removeValue() {
		/*
		 * For each element a[i] in array a:
				a. If a[i] is not equal to the specified value, do the following:
					i. Assign the value of a[i] to b[j]
					ii. Increment j by 1
		 * */
		int[] a = { 8, 9, 9, 8, 9, 2 };
		int value = 9;

		int[] b = new int[a.length];
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != value) {
				b[j] = a[i];
				j++;
			}
		}
		printArray(b);

	}

	@Test
	public void AddSpecificIndex() {
		/*
		 * Create a new integer array b with a.length + 1
			For each element b[i] in array b, starting from the first element:
				a. If i is equal to the specified index, do :
					i. Assign the value of value to b[i]
					ii. Exit the loop
				b. Otherwise, assign the value of a[i] to b[i]
			For each element b[j] in array b, starting from the element at index + 1 and going up to the last element of array a:
					a. Assign the value of a[j - 1] to b[j]
					*/
		int a[] = { 1,2,3,4,5,6 };
		int value = 6;
		int index = 5;
		int[] b = new int[a.length + 1];
		for (int i = 0; i < b.length - 1; i++) {
			if (i == index) {
				b[i] = value;
				break;
			} else
				b[i] = a[i];
		}
		for (int j = index + 1; j <= a.length; j++) {
			b[j] = a[j - 1];
		}

		printArray(b);

	}

	@Test
	public void contains() {
		/*
		 	Initialize a boolean variable flag to false
		 	For each character str[i] in string str, starting from the first character:
				a. If str[i] is equal to the specified character toFind, set flag to true.
		  	Print out the value of flag
		 
		 */
		String[] str = { "a", "e", "i", "o", "u" };
		String toFind = "t";
		boolean flag = false;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == toFind) {
				flag = true;
			}
		}
		System.out.println(flag);

	}
	
	@Test
	public void trimString() {
		/*
		    Create a new character array trimmedChars of length length
			For each index i from 0 up to length-1, do the following:
				a. If i is less than the length of the original string str, set the character at index i of trimmedChars to the character at index i of str
				b. Otherwise, set the character at index i of trimmedChars to a space character
			Return the resulting character array trimmedChars
		*/
		String str= "Software";
		int length = 2;
	    char[] trimmedChars = new char[length];
	    for (int i = 0; i < length; i++) {
	        if (i < str.length()) {
	            trimmedChars[i] = str.charAt(i);
	        } else {
	            trimmedChars[i] = ' ';
	        }
	    }
	    System.out.println(trimmedChars);
	}

	
	private void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {
				System.out.print("[" + a[i] + ",");
			} else if (i == a.length - 1) {
				System.out.println(a[i] + "]");
			} else
				System.out.print(a[i] + ",");

		}
	}

	private int findlen(int x) {
		int len = 0;
		while (x != 0) {
			x = x / 10;
			++len;
		}
		// System.out.println("Length : " + len);
		return len;

	}

	private int findlen(int[] x) {
		int len = 0;
		for (int i = 0; i < x.length; i++) {
			len++;
		}
		// System.out.println("Length : " + len);
		return len;

	}

}
