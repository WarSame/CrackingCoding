package data_structures.StacksAndQueues;

public abstract class SortableStack<E extends Comparable<E>> extends Stack<E> {
	Stack<E> secondary;
	public SortableStack(){
		super();
		secondary = new Stack<E>();
	}
	public SortableStack(E data){
		super(data);
		secondary = new Stack<E>();
	}
	public void push(E data){
		StackNode<E> n = this.peek();
		while (n!=null&&compare(data,n.getData())){//While data needs to go down further
			secondary.push(this.pop());
			n=this.peek();
		}
		super.push(data);
		n = secondary.peek();//Put the data back into the main stack
		while (n!=null){
			this.push(secondary.pop());
			n=secondary.peek();
		}
	}
	public abstract boolean compare(E pushData, E stackData);
}
