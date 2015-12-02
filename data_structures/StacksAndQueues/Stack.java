package data_structures.StacksAndQueues;

import java.util.NoSuchElementException;

public class Stack<StackNode<T>> {//Work from the top
	private StackNode<T> top;
	private int size;
	public Stack(StackNode<T> data){
		StackNode<T> node = new StackNode<T>(data);
		this.top = node;
	}
	public Stack(){
		this.top = null;
	}
	public StackNode<T> peek(){
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
	public StackNode<T> pop(){
		StackNode<T> node = this.top;
		this.top = this.top.getNext();
		decreaseSize();
		return node;
	}
	public void push(T data){
		StackNode<T> node = new StackNode<T>(data);
		node.setNext(this.top);
		increaseSize();
		this.top = node;
	}
	public void print(){
		StackNode<T> node = this.top;
		if (node==null){
			throw new NoSuchElementException();
		}
		StringBuilder s = new StringBuilder();
		while (node!=null){
			s.append(node.getData()+" ");
			node=node.getNext();
		}
		System.out.println(s);
	}
}
