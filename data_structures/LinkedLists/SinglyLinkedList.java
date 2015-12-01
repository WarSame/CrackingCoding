package data_structures.LinkedLists;

import java.util.NoSuchElementException;

import data_structures.LinkedLists.SinglyLinkedNode;

public class SinglyLinkedList{
	private SinglyLinkedNode head = null;
	private int length = 0;
	public SinglyLinkedList(int data){
		this.head = new SinglyLinkedNode(data);
		this.length = 1;
	}
	public int getHead(){
		if (this.head == null){
			throw new NoSuchElementException();
		}
		return this.head.getData();
	}
	public int getTail(){
		SinglyLinkedNode tailNode = this.head;
		if (tailNode==null){
			throw new NoSuchElementException();
		}
		while(tailNode.getNext()!=null){
			tailNode = tailNode.getNext();
		}
		return tailNode.getData();
	}
	public void clear(){
		this.head = null;
		this.length = 0;
	}
	public boolean appendFront(int data){//Add data node to the front of the list
		SinglyLinkedNode frontData = new SinglyLinkedNode(data);
		frontData.setNext(this.head);
		this.head = frontData;
		this.length++;
		return true;
	}
	public boolean append(int data){//Add data node to the end of the list
		SinglyLinkedNode end = new SinglyLinkedNode(data);
		SinglyLinkedNode n = this.head;
		if (n==null){//If list is empty
			this.head = end;
			this.length = 1;
			return true;
		}
		while (n.getNext()!=null){//Get last node
			n=n.getNext();
		}
		n.setNext(end);
		this.length++;
		return true;
	}
	public void print(){
		SinglyLinkedNode n = this.head;
		if (n==null){
			System.out.println("Linked list is empty");
			throw new NoSuchElementException();
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
			throw new NoSuchElementException();
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
	public boolean delete(int data){
		SinglyLinkedNode nodeBeforeDelete = this.head;
		if (nodeBeforeDelete==null){
			throw new NoSuchElementException();
		} else if (nodeBeforeDelete.getData()==data){//If the head is the data we want
			this.head = this.head.getNext();
			this.length--;
			return true;
		}
		SinglyLinkedNode next;
		while (true){//Loop through list until end or data
			next = nodeBeforeDelete.getNext();
			if (next==null){
				return false;
			}
			else if (next.getData()==data){
				break;
			}
			nodeBeforeDelete=next;
		}
		nodeBeforeDelete.setNext(next.getNext());//Skip the deleted node
		next.setNext(null);//For garbage collection
		this.length--;
		return true;
	}
	public boolean contains(int data){//data is in linked list
		SinglyLinkedNode n = this.head;
		if (n==null){
			throw new NoSuchElementException();
		}
		while (n.getData()!=data &&n.getNext()!=null){//Get either the desired node or the last node
			n = n.getNext();
		}
		if (n.getData()==data){
			return true;
		}
		return false;
	}
	public int getCount(int data){
		SinglyLinkedNode currNode = this.head;
		if (currNode==null){
			throw new NoSuchElementException();
		}
		int count = 0;
		while (currNode!=null){
			if (currNode.getData()==data){
				count++;
			}
			currNode = currNode.getNext();
		}
		return count;
	}
}
