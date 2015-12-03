package data_structures.StacksAndQueues;

public class DescendingSortedStack<E extends Comparable<E>> extends SortableStack<E> {
	public boolean compare(E pushData, E stackData) {
		return pushData.compareTo(stackData)>=0;
	}
}