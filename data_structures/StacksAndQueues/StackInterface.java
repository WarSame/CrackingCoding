package data_structures.StacksAndQueues;

public interface StackInterface<E> {
	public StackNode<E> peek();
	public int getSize();
	public void increaseSize();
	public void decreaseSize();
	public StackNode<E> pop();
	public void push(E data);
	public StringBuilder print();
}
