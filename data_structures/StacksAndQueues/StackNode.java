package data_structures.StacksAndQueues;

public class StackNode<T> {
	private T data;
	private StackNode<T> next;
	public StackNode(T data){
		this.data = data;
		this.next = null;
	}
	public StackNode<T> getNext(){
		return this.next;
	}
	public void setNext(StackNode<T> next){
		this.next = next;
	}
	public T getData(){
		return this.data;
	}
}
