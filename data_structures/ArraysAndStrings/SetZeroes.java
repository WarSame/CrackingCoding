package data_structures.ArraysAndStrings;

public class SetZeroes {
	public static int[][] setZeroes(int[][] A){
		//A[row][column]
		boolean[] columns = new boolean[A[0].length];
		boolean[] rows = new boolean[A.length];
		for (int i=0; i<A.length;i++){
			for (int j=0;j<A[0].length;j++){
				if (A[i][j]==0){
					columns[i]=true;
					rows[j]=true;
				}
			}
		}
		
		for (int i=0;i<A.length;i++){
			for (int j=0;j<A[0].length;j++){
				if (columns[i]||rows[j]){
					A[i][j]=0;
				}
			}
		}
		
		return A;
	}
}
