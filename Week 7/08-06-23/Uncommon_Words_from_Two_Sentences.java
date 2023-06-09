
package learnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
public class Uncommon_Words_from_Two_Sentences {


		/*
		 * Positive data s1 = ["this apple is sweet"] s2 = ["this apple is sour"]
		 * edge case s1 = ["this is apple"] s2 = [""] 
		 * negative case s1 = ["this is apple"] s2 = [""]
		 * 
		 * 
		 * Pseudocode 
		 * 1.
		 */

		@Test
		public void data1() {
			
			String s1 = "this apple is sweet";
			String s2 = "this apple is sour";
			
			System.out.println(Arrays.toString(uncommon(s1,s2)));
			
		}
		
		@Test
		public void data2() {

			String s1 = "apple apple";
			String s2 = "banana";
			
			System.out.println(Arrays.toString(uncommon(s1,s2)));

		}
		
		
		public void data3() {

			String s1 = "abcd def abcd xyz";
			String s2 = "ijk def ijk";
			
			System.out.println(Arrays.toString(uncommon(s1,s2)));
			

		}

		public String[] uncommon(String s1, String s2) {
			Set<String> out = new HashSet<String>();
			ArrayList<String> str = new ArrayList<String>(Arrays.asList(s1.split(" ")));
			ArrayList<String> str1 = new ArrayList<String>(Arrays.asList(s2.split(" ")));
			
			
			
			for (String un : str1) {
				for (String un1 : str) {
					
				if(!str.contains(un) ) {
					out.add(un);
				}
				else if(!str1.contains(un1)) {
					out.add(un1);
					}
				}
			}
			return out.toArray(new String[out.size()]);
		}

	}
