package data_structures.StacksAndQueues;

public class MinStack extends Stack{
	public int getMin(){
		return this.peek().getMin();
	}
}
