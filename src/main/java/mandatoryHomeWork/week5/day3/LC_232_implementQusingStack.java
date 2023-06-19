package Queue;

import java.util.Stack;

public  class implementQusingStack {
	static class MyQueue {
		
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> st1 = new Stack<Integer>();
	    public MyQueue() {
	    	
	    }
	    
	    //Checking if the st1 is not empty and pushing the values to st
	    public void push(int x) {
	    	while(!st1.isEmpty()) {
	    		st.push(st1.pop());
	    	}
	    	st.push(x);
	    }
	    
	    //Checking if the st is not empty and removing the values to st and pushing it to st1
	    public int pop() {
	    	while(!st.isEmpty()) {
	    		st1.push(st.pop());
	    	}
	    	
			return st1.pop();
	        
	    }
	  //Checking if the st is not empty and pushing it to st1 retunring the st1 first 
	    public int peek() {
	    	while(!st.isEmpty()) {
    		st1.push(st.pop());
    	}
			return st1.peek();
	        
	    }
	    //Both the stacks are empty return true
	    public boolean empty() {
	    	if(st1.isEmpty() && st.isEmpty()) {
	    		return true;
	    	}
			return false;
	        
	    }
	
}
	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		 
		 obj.push(1);
		 obj.push(2);
		 int param_2 = obj.pop();
		 int param_3 = obj.peek();
		 boolean param_4 = obj.empty();
	}
	
	
}
