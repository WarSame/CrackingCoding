package data_structures.StacksAndQueues;

public class StackNode<E> {
	private E data;
	private StackNode<E> next;
	public StackNode(E data){
		this.data = data;
		this.next = null;
	}
	public StackNode<E> getNext(){
		return this.next;
	}
	public void setNext(StackNode<E> next){
		this.next = next;
	}
	public E getData(){
		return this.data;
	}
}
