package dailyProblems_String;

import org.junit.Test;

public class RingsandRods {

	@Test
	public void data() {
		String str = "B9R9G0R4G6R8R2R9G9";
		System.out.println(countPoints(str));
	}
	//@Test
	public void data1() {
		String str = "B0R0G0R9R0B0G0";
		System.out.println(countPoints(str));
	}
	//@Test
	public void data2() {
		String str = "G4";
		System.out.println(countPoints(str));

	}
	 
	 public int countPoints(String rings) {
		 //Creating a int array of length 10
		 int[] rodColors = new int[10];
		 //Loop till the end of the string by incrementing 2
	        for (int i = 0; i < rings.length(); i += 2) {
	        	//Getting the color
	            char color = rings.charAt(i);
	            //getting the rod details
	            int rod = rings.charAt(i + 1) - '0';
	            //If color is R add 1 to the array in the corresponding rod
	            // **** new learning '|=' --> which will not increment the value again and again 
	            // **** why choose 1+2+4  -- > 0001 0011 0111 => 0111 || if its 1+ 2 + 3 --> 0001 0011 0011 =>0011
	            	if(color=='R') {
	            		rodColors[rod] |= 1;
	            		
	            	}
	            //If color is G add 2 to the array in the corresponding rod	
	            	else if(color=='G') {
	            		rodColors[rod] |= 2;
	            		
	            	}
	           //If color is B add 4 to the array in the corresponding rod		
	            	else if(color=='B') {
	            		rodColors[rod] |= 4;
	            		
	            	}
	        }
	        //Check if the color is equal to 7 if yes increment the count
	        int count = 0;
	        for (int color : rodColors) {
	            if (color==7) { 
	                count++;
	            }
	        }

	        return count;
	        
	    }
}
