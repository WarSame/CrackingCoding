package data_structures.StacksAndQueues;

public class MinStack<T> extends Stack<T>{
	public int getMin(){
		return this.peek().getMin();
	}
}
