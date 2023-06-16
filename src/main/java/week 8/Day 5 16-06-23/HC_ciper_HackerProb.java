package dailyProblems_String;

public class ciper_HackerProb {

	public static void main(String[] args) {
		String input = "middle-Outz";
		int k =2;
		String orginalArray =  "abcdefghijklmnopqrstuvwxyz";
		if(k>26) {
			k = k%26;
		}
		String temp = orginalArray.substring(0, k);
		orginalArray =  orginalArray.concat(temp);
		String reversed = (String) orginalArray.subSequence(k,orginalArray.length());
		System.out.println(reversed);
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if(Character.isLetter(input.charAt(i))&& !Character.isUpperCase(input.charAt(i))){
				int temp1 = orginalArray.indexOf(input.charAt(i));
				out.append(reversed.charAt(temp1));
				
			}
			else if(Character.isLetter(input.charAt(i)) && Character.isUpperCase(input.charAt(i))){
				char lowerCase = Character.toLowerCase(input.charAt(i));
				int temp1 = orginalArray.indexOf(lowerCase);
				String temp2 = String.valueOf(reversed.charAt(temp1));
				out.append(temp2.toUpperCase());
				
			}
		
			else {
				out.append(input.charAt(i));
			}
		}
		System.out.println(out);
		sol2();
	}
	
	static void sol2(){
		String input = "middle-Outz";
		int k =87;
		String orginalArray =  "abcdefghijklmnopqrstuvwxyz";
		StringBuilder out = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char shiftedChar = (char) ((ch - 'A' + k) % 26 + 'A');
                    out.append(shiftedChar);
                } else {
                    char shiftedChar = (char) ((ch - 'a' + k) % 26 + 'a');
                    out.append(shiftedChar);
                }
            } else {
                out.append(ch);
            }
        }

        System.out.println(out.toString());
	}

}
