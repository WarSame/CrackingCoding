package data_structures.StacksAndQueues;

public class Tower{
	private Stack<Integer> disks;
	private int index;
	public Tower(int i){
		disks = new Stack<Integer>();
		index = i;
	}
	public int getIndex(){
		return index;
	}
	public void addDisk(int disk){
		StackNode<Integer> topDisk = disks.peek();
		if (disks!=null&&topDisk!=null&&topDisk.getData()<=disk){//If disk is too large to sit on topDisk
			System.out.println("Error - disk "+disk+" too large for tower "+index+".");
			this.print();
			return;
		}
		disks.push(disk);
	}
	public void print(){
		System.out.println("Tower " +index+" is composed of: "+disks.print());
	}
	public void moveTopTo(Tower destination){
		StackNode<Integer> n = this.disks.pop();
		if (n==null){
			return;
		}
		destination.addDisk(n.getData());
		System.out.println("Moved disk "+n.getData()+" from tower "+this.index+" to tower "+ destination.index);
	}
	public void moveDisks(int n, Tower destination, Tower buffer){
		if (n>0){
			moveDisks(n-1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
}