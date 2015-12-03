package data_structures.StacksAndQueues;

public class MinStack<E extends Comparable<E>> extends Stack<E>{
	Stack<E> minStack = new Stack<E>();//Tracks the min of the current stack
	public MinStack(){
		super();
	}
	public MinStack(E data){
		super(data);
		minStack.push(data);
	}
	public void push(E data){
		if (minStack.peek()==null || data.compareTo(minStack.peek().getData())<=0){
			//If the new data is the same as or less than the old min, it's the new min
			minStack.push(data);
		}
		super.push(data);
	}
	public StackNode<E> pop(){
		if (super.peek().getData().compareTo(minStack.peek().getData())==0){
			//If the top value is equal to the top min value
			//Then remove both
			minStack.pop();
		}
		return super.pop();
	}
	public E getMin(){
		return minStack.peek().getData();
	}
}
