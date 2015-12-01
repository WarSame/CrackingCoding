package data_structures.LinkedLists;

public class LinkedListsMain {

	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList(7);
		ll.append(6);
		ll.append(5);
		ll.append(2);
		ll.append(4);
		ll.append(3);
		ll.print();
		SinglyLinkedNode meet = ll.findLoopNode();
		if (meet!=null){
			System.out.println(meet.getData());
		}
	}

}
