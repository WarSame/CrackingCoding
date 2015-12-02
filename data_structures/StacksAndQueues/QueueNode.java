package data_structures.StacksAndQueues;

public class QueueNode<T> {
	private T data;
	private QueueNode<T> next = null;
	public QueueNode(T data){
		this.data = data;
	}
	public T getData(){
		return this.data;
	}
	public QueueNode<T> getNext(){
		return this.next;
	}
	public void setNext(QueueNode<T> next){
		this.next = next;
	}
}
