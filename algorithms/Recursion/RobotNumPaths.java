package algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

import pair.Pair;

public class RobotNumPaths {
	static List<Pair<Integer,Integer>> blockedCoords;
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
}
