package data_structures.StacksAndQueues;

public class StacksAndQueuesMain {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		MinStack<Integer> m = new MinStack<Integer>(s);
		m.push(4);
		m.push(5);
		System.out.println(m.pop().getData());
	}

}
