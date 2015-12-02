package data_structures.LinkedLists;

import java.util.NoSuchElementException;

import data_structures.LinkedLists.SinglyLinkedNode;

public class SinglyLinkedList<T>{
	private SinglyLinkedNode<T> head = null;
	private int length = 0;
	public SinglyLinkedList(T data){
		this.head = new SinglyLinkedNode<T>(data);
		this.length = 1;
	}
	public SinglyLinkedList(){
	}
 	public int getLength(){
 		return this.length;
 	}
	public SinglyLinkedNode<T> getHead(){
		if (this.head == null){
			throw new NoSuchElementException();
		}
		return this.head;
	}
	public SinglyLinkedNode<T> getTail(){
		SinglyLinkedNode<T> tailNode = this.head;
		if (tailNode==null){
			throw new NoSuchElementException();
		}
		while(tailNode.getNext()!=null){
			tailNode = tailNode.getNext();
		}
		return tailNode;
	}
	public void clear(){
		this.head = null;
		this.length = 0;
	}
	public boolean appendFront(T data){//Add data node to the front of the list
		SinglyLinkedNode<T> frontData = new SinglyLinkedNode<T>(data);
		frontData.setNext(this.head);
		this.head = frontData;
		this.length++;
		return true;
	}
	public boolean append(T data){//Add data node to the end of the list
		SinglyLinkedNode<T> end = new SinglyLinkedNode<T>(data);
		SinglyLinkedNode<T> n = this.head;
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
		SinglyLinkedNode<T> n = this.head;
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
	public Integer[] toArray(){
		//Usable only for integer arrays
		Integer[] arr = new Integer[this.length];
		SinglyLinkedNode<T> n =this.head;
		if (n==null){
			throw new NoSuchElementException();
		}
		arr[0] = (Integer) n.getData();
		int index = 1;
		while (n.getNext()!=null){
			n = n.getNext();
			arr[index] = (Integer) n.getData();
			index++;
		}
		return arr;
	}
	public boolean delete(T data){
		SinglyLinkedNode<T> nodeBeforeDelete = this.head;
		if (nodeBeforeDelete==null){
			throw new NoSuchElementException();
		} else if (nodeBeforeDelete.getData()==data){//If the head is the data we want
			this.head = this.head.getNext();
			this.length--;
			return true;
		}
		SinglyLinkedNode<T> next;
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
	public boolean contains(T data){//data is in linked list
		SinglyLinkedNode<T> n = this.head;
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
	public int getCount(T data){
		SinglyLinkedNode<T> currNode = this.head;
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
	public void removeDuplicates(){//Remove any data that has duplicates
		SinglyLinkedNode<T> prevNode = this.head;//Node before the node we are looking at
		if (prevNode==null){
			throw new NoSuchElementException();
		}
		SinglyLinkedNode<T> currNode = prevNode.getNext();//The node we are looking at
		while (currNode!=null){
			SinglyLinkedNode<T> runnerNode = this.head;//Runs from the head to our current node
			while (runnerNode!=currNode){
				if (currNode.getData() == runnerNode.getData()){//If we have a duplicate node
					prevNode.setNext(currNode.getNext());
					currNode = prevNode.getNext();
					this.length--;
					break;//Match one at a time
				}
				runnerNode = runnerNode.getNext();
			}
			if (runnerNode==currNode){//If there was no duplicate, move to the next node
				prevNode = currNode;
				currNode = currNode.getNext();
			}
		}
	}
	public T fromLast(int distance){
		if (distance==0){
			return this.getTail().getData();
		}
		if (distance==this.length-1){
			return this.getHead().getData();
		}
		if (distance >= this.length){
			throw new NoSuchElementException();
		}
		SinglyLinkedNode<T> firstNode = this.head;
		SinglyLinkedNode<T> secondNode = firstNode;
		while (secondNode!=null && distance>=0){//Either separate the nodes by distance or run out of room
			secondNode = secondNode.getNext();
			distance--;
		}
		while (secondNode!=null){//Move the nodes to the end of the list
			secondNode = secondNode.getNext();
			firstNode = firstNode.getNext();
		}
		return firstNode.getData();
	}
	public boolean deleteNode(SinglyLinkedNode<T> targetNode){//delete target node from linked list
		if (targetNode == null||targetNode.getNext()==null){
			targetNode = null;
			return false;
		}
		targetNode = targetNode.getNext();
		this.length--;
		return true;
	}
	public static SinglyLinkedList<Integer> addLists(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2){//Lists go from lowest power to highest
		//All values are single digit int - no need for generics
		if (l1==null && l2==null){
			return null;
		}
		SinglyLinkedNode<Integer> n1 = l1.head;
		SinglyLinkedNode<Integer> n2 = l2.head;
		SinglyLinkedList<Integer> retList = new SinglyLinkedList<Integer>();
		int carry = 0;
		while (n1!=null || n2!=null){//While one or the other ll still has numbers left
			int result = carry;
			if (n1!=null){
				result+=n1.getData();
				n1 = n1.getNext();
			}
			if (n2!=null){
				result+=n2.getData();
				n2 = n2.getNext();
			}
			carry = result/10;
			result %= 10;
			retList.append(result);
		}
		return retList;
	}
	public SinglyLinkedNode<T> findLoopNode(){//Given a loop in a linked list, return the node at the start of the loop
		SinglyLinkedNode<T> currNode = this.head;
		if (currNode ==null){
			return null;
		}
		this.getTail().setNext(this.head.getNext());//Start cycle
		SinglyLinkedNode<T> runnerFast = currNode;
		SinglyLinkedNode<T> runnerSlow = currNode;
		while (runnerFast!=null){
			runnerFast = runnerFast.getNext().getNext();//2 at a time
			runnerSlow = runnerSlow.getNext();//1 at a time
			if (runnerFast==runnerSlow){//If fast catches up to slow
				break;
			}
		}
		if (runnerFast == null){//If they never met
			return null;
		}
		runnerSlow = this.head;
		while (runnerSlow!=runnerFast){
			runnerSlow = runnerSlow.getNext();
			runnerFast = runnerFast.getNext();
		}
		return runnerFast;
	}
}
