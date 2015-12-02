package data_structures.StacksAndQueues;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SetOfStacks<T> {
	ArrayList<Stack<T>> stacks = new ArrayList<>();
	final int CAPACITY = 3;
	public int getNumStacks(){
		return this.stacks.size();
	}
	public SetOfStacks(T data){
		push(data);
	}
	public SetOfStacks(){
	}
	public T popAt(int index){
		if (index>=stacks.size()){
			throw new ArrayIndexOutOfBoundsException();
		}
		Stack<T> atStack = stacks.get(index);
		if (atStack==null){//If the stack is empty, remove and report
			stacks.remove(index);
			throw new NoSuchElementException();
		}
		if (atStack.getSize()==1){
			stacks.remove(index);
		}
		return atStack.pop().getData();
	}
	public T pop(){
		Stack<T> lastStack = getLastStack();
		if (lastStack==null || lastStack.getSize()==0){//Delete this stack and go to the previous stack
			stacks.remove(stacks.size()-1);
		}
		lastStack = getLastStack();
		if (lastStack==null){
			throw new NoSuchElementException();
		}
		return lastStack.pop().getData();
	}
	public void push(T data){
		Stack<T> lastStack = getLastStack();
		if (lastStack==null||lastStack.getSize()>=CAPACITY){//If we need to create a new stack
			lastStack = new Stack<T>();
			addStack(lastStack);
		}
		lastStack.push(data);
	}
	public Stack<T> getLastStack(){
		int size = this.stacks.size();
		if (size==0){
			return null;
		}
		return this.stacks.get(size-1);
	}
	public void addStack(Stack<T> s){
		stacks.add(s);
	}
}
