package algorithms.Recursion;

import java.util.ArrayList;

public class NumWaysMakeChange {
	static int[] coinDenoms;
	public static void waysMakeChange(int centsToChange){
		System.out.println(waysMakeChangeRecurse(centsToChange, 0));
	}
	private static int waysMakeChangeRecurse(int centsToChange, int currSum){
		//Given an argument of number of cents to make change, return the count of possible ways to do so
		if (currSum>centsToChange){
			return 0;
		}
		if (currSum==centsToChange){
			return 1;
		}
		int numFromQuarter = waysMakeChangeRecurse(centsToChange, currSum+25);
		int numFromDime = waysMakeChangeRecurse(centsToChange, currSum+10);
		int numFromNickel = waysMakeChangeRecurse(centsToChange, currSum+5);
		int numFromPenny = waysMakeChangeRecurse(centsToChange, currSum+1);
		return numFromPenny+numFromNickel+numFromDime+numFromQuarter;
	}
	public static void waysMakeChangeDifferent(int centsToChange){
		//Prepare data
		coinDenoms = new int[]{25,10,5,1};
		int startSum = 0;
		int startDenom = 0;
		int[] startCoins = new int[coinDenoms.length];
		ArrayList<int[]> cc = waysMakeChangeDifferentRecurse(centsToChange, startSum, startDenom, startCoins);
		
		//Print result
		System.out.println("There are "+
		cc.size()+
		" different solutions." );
		
		for (int[] c: cc){
			for (int coin:c){
				System.out.print(coin+" ");
			}
			System.out.println();
		}
	}
	private static ArrayList<int[]> waysMakeChangeDifferentRecurse(int centsToChange, int currentSum, int denomIndex, int[] currentCoins){
		ArrayList<int[]> ret = new ArrayList<int[]>();
		for (int i = denomIndex; i<coinDenoms.length;i++){
			//Iterate through coins of current size or smaller
			int newSum = currentSum+coinDenoms[i];
			if (newSum>centsToChange){
				//If we pass the amount
				continue;
			}
			if (newSum==centsToChange){
				//If we hit the right amount
				currentCoins[i]++;
				ret.add(currentCoins);
				return ret;
			}
			//If we're still approaching the right amount
			int[] tempCoins = currentCoins.clone();
			tempCoins[i]++;
			//Keep going deeper
			ArrayList<int[]> differentWays = waysMakeChangeDifferentRecurse(centsToChange, newSum, i, tempCoins);
			ret.addAll(differentWays);
		}
		return ret;
	}
}
