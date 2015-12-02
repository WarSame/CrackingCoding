package data_structures.LinkedLists;

public class SinglyLinkedNode<T> {
	private SinglyLinkedNode<T> next = null;
	private T data;
	public SinglyLinkedNode(T data){
		this.data=data;
	}
	public T getData(){
		return this.data;
	}
	public void setNext(SinglyLinkedNode<T> next){
		this.next = next;
	}
	public SinglyLinkedNode<T> getNext(){
		return this.next;
	}
}
