package data_structures.StacksAndQueues;

public class MinStackNode<T> extends StackNode<T> {
	//Assumes integer type
	private int min;
	public MinStackNode(T data) {
		super(data);
		this.min = minimum(super.getNext().getData(), this.getData());
	}
	private int minimum(T t, T t2){
		if (T.compare(t, t2)){
			return t;
		}
		return t2;
	}
	public int getMin(){
		return this.min;
	}
}
