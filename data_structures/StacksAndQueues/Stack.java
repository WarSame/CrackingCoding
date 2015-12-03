package data_structures.StacksAndQueues;

import java.util.NoSuchElementException;

public class Stack<E> implements StackInterface<E> {
	private StackNode<E> top;
	private int size;
	public Stack(E data){
		StackNode<E> node = new StackNode<E>(data);
		this.top = node;
	}
	public Stack(){
		this.top = null;
	}
	public StackNode<E> peek(){
		return this.top;
	}
	public int getSize(){
		return this.size;
	}
	public void increaseSize(){
		this.size++;
	}
	public void decreaseSize(){
		this.size--;
	}
	public StackNode<E> pop(){
		StackNode<E> node = this.top;
		if (this.top==null){
			throw new NoSuchElementException();
		}
		this.top = this.top.getNext();
		decreaseSize();
		return node;
	}
	public void push(StackNode<E> dataNode){
		//More efficient but less accessible
		dataNode.setNext(this.top);
		increaseSize();
		this.top = dataNode;
	}
	public void push(E data){
		StackNode<E> node = new StackNode<E>(data);
		node.setNext(this.top);
		increaseSize();
		this.top = node;
	}
	public StringBuilder print(){
		StackNode<E> node = this.top;
		if (node==null){
			throw new NoSuchElementException();
		}
		StringBuilder s = new StringBuilder();
		while (node!=null){
			s.append(node.getData()+" ");
			node=node.getNext();
		}
		return s;
	}
}
