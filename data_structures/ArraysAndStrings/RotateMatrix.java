package data_structures.ArraysAndStrings;

public class RotateMatrix {
	public static int[][] rotateMatrix(int[][] image){
		//image[y][x] = image[row][column]
		int n = image.length;
		for (int layer=0;layer<n/2;layer++){
			int first = layer;
			int last = n-layer-1;
			for (int i=first;i<last;i++){//Do this layer of rotation, 1 element at a time
				int offset = i-first;
				int top = image[first][i];//Get top for later
				image[first][i] = image[last-offset][first];//Move left to top
				image[last-offset][first] = image[last][last-offset];//Move bot to left
				image[last][last-offset] = image[i][last];//Move right to bot
				image[i][last]=top;//Move top to right
			}
			
		}
		return image;
	}
	
	public static void printMatrix(int[][] A){
		for (int i=0;i<A.length;i++){
			int[] row = A[i];
			String rowString = "";
			for (int j=0;j<row.length;j++){
				rowString+=A[i][j]+" ";
			}
		System.out.println(rowString);
		}
	}
}
