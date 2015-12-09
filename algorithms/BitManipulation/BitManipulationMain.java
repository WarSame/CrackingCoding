package algorithms.BitManipulation;

public class BitManipulationMain {

	public static void main(String[] args) {
		
	}
	public static int fillBits(int numToUse, int numToFill, int rightIndex, int leftIndex){
		int max = ~0;
		int left = max - ((1<<leftIndex)-1);
		int right = (1<<rightIndex)-1;
		int mask = left|right;
		return (numToFill&mask) | (numToUse<<rightIndex);
	}
}
