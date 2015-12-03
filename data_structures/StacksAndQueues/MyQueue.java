package data_structures.StacksAndQueues;

public class MyQueue<E> {
	//Implementation of a queue using two stacks
	private Stack<E> main;
	private Stack<E> secondary;
	public MyQueue(){
		main = new Stack<E>();
		secondary = new Stack<E>();
	}
	public void enq(E data){
		move(main, secondary);
		main.push(data);
	}
	public StackNode<E> deq(){
		move(secondary, main);
		return secondary.pop();
	}
	private void move(Stack<E> destination, Stack<E> source){
		//Move all elements from source to destination
		while (source.peek()!=null){
			destination.push(source.pop().getData());
		}
	}
}
