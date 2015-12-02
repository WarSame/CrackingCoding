package data_structures.StacksAndQueues;

public class MinStackNode<T extends Comparable<T>> extends StackNode<T> {
	//T must be comparable
	private T min;
	public MinStackNode(T data) {
		super(data);
		this.min = minimum(super.getNext().getData(), this.getData());
	}
	private T minimum(T t, T t2){
		if (t.compareTo(t2) > 0){
			return t;
		}
		return t2;
	}
	public T getMin(){
		return this.min;
	}
}
