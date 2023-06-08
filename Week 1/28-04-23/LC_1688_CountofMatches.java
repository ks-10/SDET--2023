package dailyProblems;

import org.junit.Test;

public class CountofMatches {

	/*
	 * You are given an integer n, the number of teams in a tournament that has
	 * strange rules:
	 * 1.If the current number of teams is even, each team gets
	 * paired with another team. A total of n / 2 matches are played, and n / 2
	 * teams advance to the next round. 
	 * 2.If the current number of teams is odd, one
	 * team randomly advances in the tournament, and the rest gets paired. A total
	 * of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the
	 * next round. Return the number of matches played in the tournament until a
	 * winner is decided.
	 */

	@Test
	public void postiveScenario() {
		int b = 49;
		System.out.println(solution(b));

	}

	@Test
	public void negativeScenario() {
		int b = 699996;
		System.out.println(solution(b));
	}

	@Test
	public void EdgecaseScenario() {
		int b = 1;
		System.out.println(solution(b));
	}

	// --- Time complexcity ==> O(log N) ---
	// --- Space complexcity ==> O(1) ---
	
	private int solution(int teams) {
		int match = 0;
		int currentTeam = 0;
		while (teams != 1) {
			if (teams % 2 == 0) {
				match += teams / 2;
				currentTeam = teams / 2;
				teams = currentTeam;
			} else {
				match += (teams - 1) / 2;
				currentTeam = ((teams - 1) / 2) + 1;
				teams = currentTeam;
			}
		}

		return match;

	}

}
