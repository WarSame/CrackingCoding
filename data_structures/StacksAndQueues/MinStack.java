package data_structures.StacksAndQueues;

public class MinStack<E> extends StackDecorator<E>{
	public MinStack(Stack<E> s){
		super(s);
	}
	
	public int getMin(){
		return this.peek().getMin();
	}
}
