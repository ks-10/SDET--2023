package dailyProblems_Math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sparseArrays {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new ArrayList<>();
		matchingStrings(l1, l2);
	}
	public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        
        Map<String,Integer> mp = new HashMap<>();
        List<Integer> out = new ArrayList<>();
        for (String qele : stringList) {
            mp.put(qele, mp.getOrDefault(qele,0)+1);
        }
        
        for (String string : queries) {
            if(mp.containsKey(string)){
                out.add(mp.get(string));
            }
            else out.add(0);
        }
        
        return out;
    }

	
}
