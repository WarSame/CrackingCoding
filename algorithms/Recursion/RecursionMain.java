package algorithms.Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import pair.Pair;

public class RecursionMain {
	static List<Pair<Integer,Integer>> blockedCoords;
	public static void main(String[] args){
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(4);
		hs.add(5);
		hs.add(7);
		System.out.println(getSubsets(hs));
	}
	public static int fibonacciNum(int n){
		if (n==0||n==1){
			return 1;
		}
		return fibonacciNum(n-1) + fibonacciNum(n-2);
	}
	public static int robotNumPaths(int N){
		//In NxN grid, how many paths to reach bottom right by only travelling down and right?
		blockedCoords = new ArrayList<>();
		Pair<Integer,Integer> block1 = new Pair<>(1,1);
		blockedCoords.add(block1);
		return robotNumPathsRecurse(N,0,0);
	}
	public static int robotNumPathsRecurse(int N, int x, int y){
		if (isBlocked(x,y)){
			return 0;
		}
		if ( ( (x==N-2) && (y==N-1) ) || ( (x==N-1) && (y==N-2) ) ){
			return 1;
		}
		if (y==N-1){
			return robotNumPathsRecurse(N,x+1,y);
		}
		if (x==N-1){
			return robotNumPathsRecurse(N,x,y+1);
		}
		return robotNumPathsRecurse(N,x+1,y) + robotNumPathsRecurse(N,x,y+1);
	}
	public static boolean isBlocked(int x, int y){
		for (Pair<Integer,Integer> p:blockedCoords){
			if (p.getL()==x&&p.getR()==y){
				return true;
			}
		}
		return false;
	}
	public static LinkedList<HashSet<Integer>> getSubsets(HashSet<Integer> inSet){
		//Given a set, return all subsets of it in a linked list
		LinkedList<HashSet<Integer>> ll = new LinkedList<HashSet<Integer>>();
		for (Integer i :inSet){//If we still have elements, add their subsets to the list
			@SuppressWarnings("unchecked")
			HashSet<Integer> inSetSub = (HashSet<Integer>) inSet.clone();
			inSetSub.remove(i);
			if (inSetSub.isEmpty()){//Base case
				continue;
			}
			ll.add(inSetSub);
			LinkedList<HashSet<Integer>> subSetLl = getSubsets(inSetSub);

			for (HashSet<Integer> set : subSetLl){
				ll.add(set);
			}
		}
		return ll;
	}
}
