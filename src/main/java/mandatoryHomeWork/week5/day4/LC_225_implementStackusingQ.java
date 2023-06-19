package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public  class implementStackusingQ {
	static class MyStack {

	    Queue<Integer> st = new ArrayDeque<>();
		    public MyStack() {
		    	
		    }
		    public void push(int x) {
		    	st.add(x);
					for(int i = 1;i<st.size();i++) {
		    		st.add(st.remove());
		    	}
		    }
		    
		    public int pop() {   	
				return st.remove();   
		    }
		  
		    public int top() {
				return st.peek();
		        
		    }
		    public boolean empty() {
		    	if(st.isEmpty()) {
		    		return true;
		    	}
				return false;
		        
		    }
	
}
	public static void main(String[] args) {
		MyStack obj = new MyStack();
		 
		 obj.push(1);
		 obj.push(2);
		 int param_2 = obj.pop();
		 int param_3 = obj.top();
		 boolean param_4 = obj.empty();
	}
	
	
}
