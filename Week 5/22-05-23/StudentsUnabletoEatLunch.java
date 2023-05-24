package dailyProblems_Math;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import Queue.Deque;
import Queue.dequeue;

public class StudentsUnabletoEatLunch {

	@Test
	public void postiveScenario() {
		int a []= {1,1,0,0} ;
		int b[] = {0,1,0,1};
		
		System.out.println(solution(a,b));

	}

	//@Test
	public void negativeScenario() {
		int a []= {1,1,1,0,0} ;
		int b[] = {0,1,0,1,0};
		
		System.out.println(solution(a,b));
	}

	//@Test
	public void EdgecaseScenario() {
		int a []= {1} ;
		int b[] = {0};
		
		System.out.println(solution(a,b));
	}

	// --- Time complexcity ==> O(n) ---
	// --- Space complexcity ==> O(n) ---
	
	private int solution(int []a, int [] b) {
	
		//Add the students to the queue
		Queue<Integer> student = new ArrayDeque<Integer>();
		for (Integer stu : a) {
			student.add(stu);
		}
	
		//loop till the queue size and check if the sandwich and student are equal if yes remove it assign the pointer to the first position
		int index=0;
		 for(int i=0;i<student.size();i++){
			 if(b[index]==student.peek()) {
				 student.remove();
				 i=-1;
				 index++;
			 }
			 //else assign the student at the last
			 else {
				 int removed = student.remove();
					student.add(removed); 
			 }
		 }
		System.out.println(student);
		
		
		return student.size();

	}

}
