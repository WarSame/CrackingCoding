package data_structures.LinkedLists;

public class LinkedListsMain {

	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList(7);
		ll.append(5);
		ll.append(3);
		ll.append(29);
		ll.append(29);
		ll.delete(2);
		//ll.print();
		//System.out.println("thsi"+ll.getCount(5));
		ll.delete(3);
		ll.delete(5);
		ll.delete(7);
		//ll.print();
		ll.delete(29);
		ll.delete(29);
		//ll.print();
		//System.out.println("post39");
		//System.out.println(ll.getLength());
		ll.print();
		System.out.println(ll.getLength());
		int[] arr = ll.toArray();
		System.out.println(arr==null?"Null":"Not null");
	}

}
