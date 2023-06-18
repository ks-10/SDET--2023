package dailyProblems;


import java.util.*;
import java.util.Map.Entry;

import org.junit.Test;


public class SortPeople {

	@Test
	public void postiveScenario() {
		String [] names= {"Mary","John","Emma"};
		int [] heights= {180,165,170};
		System.out.println((solution2(names, heights)));
	}

	@Test
	public void negativeScenario() {
		String [] names= {"John","John","John"};
		int [] heights= {180,165,170};
		System.out.println((solution2(names, heights)));
	}

	// @Test
	public void EdgecaseScenario() {
		String [] names= {"John"};
		int [] heights= {180};
		System.out.println((solution2(names, heights)));
	}
	
	//Time complexcity is O(n log n)
	//space complexity is O(n)
	public String[] solution2(String []names,int[] heights) {
		
		//Intializing the output String with same length as names
		String [] op = new String[names.length];
		//Intializing a TreeMap to get sorted Keys in sorted order
		Map<Integer,String> mp = new TreeMap<Integer, String>();
		//Loop through the heights and add it in map 
		for (int i = 0; i < heights.length; i++) {
			mp.put(heights[i],names[i] );
		}
		//Intializing counter to add it in output array
		int count=names.length-1;
		//using for each loop to print the values in reverse order in names
		for (Entry<Integer, String> ele : mp.entrySet()) {
			names[count--]=ele.getValue();
		} 
		  return names;
	}

}
