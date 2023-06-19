package dailyProblems_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class anagram_pairs {

	//Time Complexity ==> O(n)
	//Space Complexity ==> 0(n)
	public static void main(String[] args) {
		String s = "abba";
		
		int count = 0;

        for (int left = 0; left < s.length(); left++) {
            for (int right = left + 1; right <= s.length(); right++) {
                String substring = s.substring(left, right);
                char[] ch = substring.toCharArray();
                Arrays.sort(ch);
               
                for (int i = left + 1; i < s.length(); i++) {
                    for (int j = i + 1; j <= s.length(); j++) {
                        String temp = s.substring(i, j);
                        char[] ch1 = temp.toCharArray();
                        Arrays.sort(ch1);
                      
                        if (Arrays.equals(ch, ch1)) {
                            count++;
                        }
                    }
                }
            }
        }

		
		System.out.println(count);
		System.out.println("New Method : " +countAnagramPairs(s));
	}
	
	
	public static int countAnagramPairs(String str) {
        int count = 0;
        Map<Map<Character, Integer>, Integer> frequency = new HashMap<>();

        // Iterate through all possible substrings
        for (int i = 0; i < str.length(); i++) {
            Map<Character, Integer> charCount = new HashMap<>();

            // Iterate through the characters after the current index
            for (int j = i; j < str.length(); j++) {
                // Update the count of the current character
                char currentChar = str.charAt(j);
                charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

                // Increment the count of anagram pairs
                count += frequency.getOrDefault(charCount, 0);

                // Update the frequency map
                frequency.put(new HashMap<>(charCount), frequency.getOrDefault(charCount, 0) + 1);
            }
        }

        return count;
    }

//		    public static void main(String[] args) {
//		        String str = "abba";
//		        int pairsCount = countAnagramPairs(str);
//		        System.out.println("Number of anagram pairs: " + pairsCount);
//		    }
		}	
	
