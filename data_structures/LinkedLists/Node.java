package data_structures.LinkedLists;

public class Node {
	private Node next = null;
	int data;
	public Node(int data){
		this.data=data;
	}
	public int getData(){
		return this.data;
	}
	public void setNext(Node next){
		this.next = next;
	}
	public Node getNext(){
		return this.next;
	}
}
