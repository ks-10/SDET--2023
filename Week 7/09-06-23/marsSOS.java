package dailyProblems_String;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class marsSOS {

	public static void main(String[] args) {
		String s = "SOSOSOSOSDSDSKWOSDOSDOASDOASDFAFJDFDOSOSOWNSOSOSNDSKDDOSOSOSJDSDSOOSOSDSDOSASSOASDSAOSOSODSDSOASDWS";
		System.out.println(marsExploration(s));

	}
	
	public static int marsExploration(String s) {
        int out=0;
        String s1 = "SOS";
        System.out.println(s.length());
        for (int i = 0; i < s.length(); i++) {
        	 if (s.charAt(i) != s1.charAt(i % 3)) {
                 out++;
             }
            
        }
        return out;

    }
	
	public static int marsExploration1(String s) {
        int out=0;
        int count=0;
        Map<Character,Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
 
        }
        System.out.println(mp);
        
        
        
        return out;

    }

}
