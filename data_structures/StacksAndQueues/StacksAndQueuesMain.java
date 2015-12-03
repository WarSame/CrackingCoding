package data_structures.StacksAndQueues;

import java.util.NoSuchElementException;

public class StacksAndQueuesMain {

	public static void main(String[] args) {
		towersOfHanoi(2);
	}
	
	public static void towersOfHanoi(int n){
		Tower[] towers = new Tower[3];
		for (int i =0;i<3;i++){
			towers[i] = new Tower(i);
		}
		for (int i = n;i>0;i--){
			towers[0].addDisk(i);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
		for (int i=0;i<3;i++){
			try {
				towers[i].print();
			}
			catch (NoSuchElementException e){
				System.out.println("Tower "+i+" is empty.");
			}
		}
	}
}
