package data_structures.StacksAndQueues;

import java.util.NoSuchElementException;

public class Queue<T> {
	//Elements are queued into the tail, and dequeued from the head
	private QueueNode<T> head;
	private QueueNode<T> tail;
	private int length;
	public Queue(){
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	public Queue(T data){
		QueueNode<T> node = new QueueNode<T>(data);
		this.head = node;
		this.tail = node;
		this.length = 1;
	}
	public int getLength(){
		return this.length;
	}
	public QueueNode<T> peek(){
		return this.head;
	}
	public QueueNode<T> getHead(){
		return this.head;
	}
	public QueueNode<T> getTail(){
		return this.tail;
	}
	public void enq(T data){//Enqueue them at the tail
		QueueNode<T> tailNode = this.tail;
		this.length++;
		QueueNode<T> newNode = new QueueNode<T>(data);
		if (tailNode==null){//If q is empty
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		tailNode.setNext(newNode);
		this.tail = newNode;
	}
	public QueueNode<T> deq(){//Dequeue them from head
		QueueNode<T> headNode = this.head;
		if (headNode==null){
			throw new NoSuchElementException();
		}
		this.length--;
		this.head = headNode.getNext();
		return headNode;
	}
	public void print(){
		QueueNode<T> curr = this.head;
		if (curr==null){
			throw new NoSuchElementException();
		}
		StringBuilder s = new StringBuilder();
		while (curr!=null){
			s.append(curr.getData().toString()+" ");
			curr = curr.getNext();
		}
		System.out.println(s);
	}
}
