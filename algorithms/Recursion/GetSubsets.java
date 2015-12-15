package algorithms.Recursion;

import java.util.HashSet;
import java.util.LinkedList;

public class GetSubsets {
	public static LinkedList<HashSet<Integer>> getSubsets(HashSet<Integer> inSet){
		//Given a set, return all subsets of it in a linked list
		LinkedList<HashSet<Integer>> ll = new LinkedList<HashSet<Integer>>();
		for (Integer i :inSet){//If we still have elements, add their subsets to the list
			@SuppressWarnings("unchecked")
			HashSet<Integer> inSetSub = (HashSet<Integer>) inSet.clone();
			inSetSub.remove(i);
			if (inSetSub.isEmpty()){//Base case
				break;
			}
			ll.add(inSetSub);
			LinkedList<HashSet<Integer>> subSetLl = getSubsets(inSetSub);
			ll.addAll(subSetLl);
		}
		return ll;
	}
}
