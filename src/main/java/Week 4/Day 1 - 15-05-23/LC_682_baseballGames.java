package dailyProblems_String;

import java.util.Stack;

import org.junit.Test;

//You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
//
//You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
//
//An integer x.
//Record a new score of x.
//'+'.
//Record a new score that is the sum of the previous two scores.
//'D'.
//Record a new score that is the double of the previous score.
//'C'.
//Invalidate the previous score, removing it from the record.
//Return the sum of all the scores on the record after applying all the operations.
//
//The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

public class baseballGames {
	@Test
	public void data() {
		String[] str = { "5", "2", "C", "D", "+" };
		System.out.println(calPoints(str));
	}

	@Test
	public void data1() {
		String[] str = { "5", "-2", "4", "C", "D", "9", "+", "+" };
		System.out.println(calPoints(str));
	}

	@Test
	public void data2() {
		String[] str = { "1", "C" };
		System.out.println(calPoints(str));
	}

	public int calPoints(String[] str) {
		// Creating a stack to do the calc
		Stack<Integer> stack = new Stack<Integer>();
		// looping over the string array
		for (int i = 0; i < str.length; i++) {
			// if string is C we need to pop from the stack
			if (str[i].contains("C")) {
				stack.pop();
			}
			// if string is D we need to multiply by 2 from the top value in stack
			else if (str[i].contains("D")) {
				stack.push(2 * stack.peek());
			}
			// if string is + we need to add the last two values from the stack and push it
			else if (str[i].contains("+")) {
				int last = stack.pop();
				int out = stack.peek() + last;
				stack.push(last);
				stack.push(out);
			} else {
				// if its a integer push it in stack
				stack.push(Integer.parseInt(str[i]));
			}
		}
		// calc the sum of the remaining values in stack
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
