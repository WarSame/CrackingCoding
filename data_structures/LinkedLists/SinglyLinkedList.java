package data_structures.LinkedLists;

import data_structures.LinkedLists.SinglyLinkedNode;

public class SinglyLinkedList{
	private SinglyLinkedNode head = null;
	private SinglyLinkedNode tail = null;
	private int length = 0;
	public SinglyLinkedList(int data){
		this.head = new SinglyLinkedNode(data);
		this.tail = this.head;
		this.length = 1;
	}
	public int getTail(){
		if (this.head ==null){
			return 0;
		}
		return this.tail.getData();
	}
	public int getHead(){
		if (this.head ==null){
			return 0;
		}
		return this.head.getData();
	}
	public void append(int data){//Add data node to the end of the list
		SinglyLinkedNode end = new SinglyLinkedNode(data);
		SinglyLinkedNode n = this.tail;
		if (n==null){
			this.tail = end;
			this.head = end;
			this.length = 1;
			return;
		}
		n.setNext(end);
		this.tail = end;
		this.length++;
	}
	public void print(){
		SinglyLinkedNode n = this.head;
		if (n==null){
			System.out.println("Linked list is empty");
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(n.getData());
		while (n.getNext()!=null){
			n = n.getNext();
			sb.append(" "+n.getData());
		}
		System.out.println(sb);
	}
	public int[] toArray(){
		int[] arr = new int[this.length];
		SinglyLinkedNode n =this.head;
		if (n==null){
			return null;
		}
		arr[0] = n.getData();
		int index = 1;
		while (n.getNext()!=null){
			n = n.getNext();
			arr[index] = n.getData();
			index++;
		}
		return arr;
	}
 	public int getLength(){
 		return this.length;
 	}
	public void delete(int data){
		SinglyLinkedNode n = this.head;
		if (n==null){
			return;
		}
		if (n.getData()==data){//If the head is the data we want
			if (n.getNext()==null){//If it's the only node, null the head and tail
				this.tail = null;
				this.head = null;
				this.length = 0;
			}
			else {//Or move the head to the next node
				this.head = n.getNext();
				this.length--;
			}
			return;
		}
		while (n.getNext()!=null && n.getNext().getData()!=data){//Get the data node or the last node at n.next
			n=n.getNext();
		}
		if (n.getNext() == null){//If n is the last element in the list
			if (n.getData()!=data){//If data wasn't in array then we're done
				return;
			}
			//If we're deleting the only remaining element
			if (this.length <=1){
				this.tail = null;
				this.head = null;
				this.length=0;
			}
			else {//If we're just moving the tail
				n.setNext(null);
				this.tail = n;
				this.length--;
			}
		}
		else {//If n is not the last element
			if (n.getNext().getNext()==null){//If n.next is the last element
				n.setNext(null);
				this.tail = n;
				this.length--;
			}
			else {//If n.next is not the last element
				n.setNext(n.getNext().getNext());
				this.length--;
			}
		}
	}
	public boolean contains(int data){//data is in linked list
		SinglyLinkedNode n = this.head;
		if (n==null){
			return false;
		}
		while (n.getData()!=data &&n.getNext()!=null){//Get either the desired node or the last node
			n = n.getNext();
		}
		if (n.getData()==data){
			return true;
		}
		return false;
	}
}
