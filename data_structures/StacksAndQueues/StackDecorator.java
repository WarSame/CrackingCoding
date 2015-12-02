package data_structures.StacksAndQueues;

public class StackDecorator<E> implements StackInterface<E>{
	protected final Stack<E> decoratedStack;
	public StackDecorator(Stack<E> s){
		this.decoratedStack = s;
	}
	@Override
	public StackNode<E> peek() {
		return decoratedStack.peek();
	}
	@Override
	public int getSize() {
		return decoratedStack.getSize();
	}
	@Override
	public void increaseSize() {
		decoratedStack.increaseSize();
	}
	@Override
	public void decreaseSize() {
		decoratedStack.decreaseSize();
	}
	@Override
	public StackNode<E> pop() {
		return decoratedStack.pop();
	}
	@Override
	public void push(E data) {
		decoratedStack.push(data);
	}
	@Override
	public void print() {
		decoratedStack.print();
	}
}
