package data_structures.ArraysAndStrings;

import java.util.Arrays;

public class Arrays_And_Strings_Main {

	public static void main(String[] args) {
		//char[] linkify = " pan  ap ".toCharArray();
		String s1 = "apple";
		String s2 = "pplea";
		System.out.println(isRotation(s1,s2));
	}

	public static boolean hasUniqueChars(String s){
		int[] charArr = new int[26];
		int charVal;
		for (int i=0;i<s.length();i++){
			charVal = s.charAt(i)-'a';
			System.out.println(charArr[charVal]);
			if (charArr[charVal]!=0){
				return false;
			}
			charArr[charVal]=1;
		}
		return true;
	}
	
	public static boolean uniqueCharsNoStructure(String s){
		char[] chars = s.toCharArray();
		if (chars.length<2){
			return true;
		}
		Arrays.sort(chars);
		for (int j=1;j<chars.length;j++){
			if (chars[j-1]==chars[j]){
				return false;
			}
		}
		return true;
	}
	
	public static String reverseString(String s){
		char[] chars = s.toCharArray();
		if (chars.length <2){
			return s;
		}
		char tmp;
		for (int j=0;j<(chars.length-1)/2;j++){
			int i = chars.length -1 - j;
			tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
		}
		s=String.valueOf(chars);
		return s;
	}
	
	public static char[] removeDuplicates(char[] s){
		//Doesn't work
		if (s==null){
			return null;
		}
		int len = s.length;
		if (len < 2){
			return s;
		}
		int tail=1;
		for (int i=1;i<len;++i){
			int j;
			for (j=0;j<=tail;++j){
				if (s[j]==s[i]){
					break;
				}
				if (j==tail){
					s[tail] = s[i];
					tail++;
				}
				System.out.println("j is "+j+" tail is "+tail);
			}
			//System.out.println("outside for"+tail);
		}
		s[tail] = 0;
		return s;
	}
	
	public static boolean anagram(String s){
		if (s==null){
			return false;
		}
		int len = s.length();
		if (len<2){
			return true;
		}
		
		for (int j = 0; j<(len/2);j++){
			int i = len -1- j;
			if (s.charAt(i)!=s.charAt(j)){
				return false;
			}
		}
		
		return true;
	}

	public static char[] linkifySpaces(char[] s){
		int len = s.length, numspaces=0;
		for (int i=0;i<len;i++){
			if (s[i]==' '){
				numspaces++;
			}
		}
		char[] linkified = new char[len+2*numspaces];
		int j=linkified.length-1;
		for (int i=len-1;i>=0;i--,j--){
			if (s[i]==' '){
				linkified[j]='0';
				linkified[j-1]='2';
				linkified[j-2]='%';
				j-=2;
			}
			else {
				linkified[j] = s[i];
			}
		}
		return linkified;
	}

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

	public static boolean isRotation(String s1, String s2){
		if (s1.length()==s2.length() && s1.length()>0){
			s1+=s1;
			return s1.contains(s2);
		}
		return false;
	}

}
