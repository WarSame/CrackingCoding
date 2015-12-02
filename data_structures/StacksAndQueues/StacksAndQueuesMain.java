package data_structures.StacksAndQueues;

public class StacksAndQueuesMain {

	public static void main(String[] args) {
		SetOfStacks ss = new SetOfStacks();
		ss.push(4);
		ss.push(5);
		ss.push(3);
		ss.push(6);
		ss.push(2);
		ss.push(1);
		ss.push(7);
		System.out.println(ss.getNumStacks());
		System.out.println(ss.popAt(1));
		System.out.println(ss.popAt(1));
		System.out.println(ss.popAt(1));
		System.out.println(ss.popAt(1));
		System.out.println(ss.pop());
		System.out.println(ss.pop());
	}

}
