package algorithms.Recursion;

public class FibonacciNum {
	public static int fibonacciNum(int n){
		if (n==0||n==1){
			return 1;
		}
		return fibonacciNum(n-1) + fibonacciNum(n-2);
	}
}
