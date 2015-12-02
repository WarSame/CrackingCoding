package data_structures.StacksAndQueues;

import java.util.NoSuchElementException;

public class Stack<T> {//Work from the top
	private StackNode<T> top;
	public Stack(T data){
		StackNode<T> node = new StackNode<T>(data);
		this.top = node;
	}
	public Stack(){
		this.top = null;
	}
	public StackNode<T> peek(){
		StackNode<T> node = this.top;
		return node;
	}
	public StackNode<T> pop(){
		StackNode<T> node = this.top;
		this.top = this.top.getNext();
		return node;
	}
	public void push(T data){
		StackNode<T> node = new StackNode<T>(data);
		node.setNext(this.top);
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
