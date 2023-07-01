package queueorStack;

import java.util.List;

public class twoStack {
	
	
	public static int twoStacks(int x, List<Integer> a, List<Integer> b) {
        int maxScore = 0;
        int runningSumA = 0;

        for (int k = 0; k <= a.size(); k++) {
            if (k > 0) {
                runningSumA += a.get(k - 1);
            }

            if (runningSumA > x) {
                break;
            }

            int runningSumB = 0;
            int y = 0;
            while (y < b.size() && runningSumA + runningSumB + b.get(y) <= x) {
                runningSumB += b.get(y);
                y++;
            }

            maxScore = Math.max(maxScore, k + y);
        }

        return maxScore;
        }


}
