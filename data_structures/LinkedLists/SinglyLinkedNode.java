package data_structures.LinkedLists;

public class SinglyLinkedNode {
	private SinglyLinkedNode next = null;
	int data;
	public SinglyLinkedNode(int data){
		this.data=data;
	}
	public int getData(){
		return this.data;
	}
	public void setNext(SinglyLinkedNode next){
		this.next = next;
	}
	public SinglyLinkedNode getNext(){
		return this.next;
	}
}
