package data_structures.ArraysAndStrings;

import java.util.Arrays;

public class HasUniqueChars {
	public static boolean hasUniqueChars(String s){
		int[] charArr = new int[26];
		int charVal;
		for (int i=0;i<s.length();i++){
			charVal = s.charAt(i)-'a';
			if (charArr[charVal]!=0){
				return false;
			}
			charArr[charVal]=1;
		}
		return true;
	}
	public static boolean hasUniqueCharsNoStructure(String s){
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
}
