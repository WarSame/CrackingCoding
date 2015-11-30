package data_structures.ArraysAndStrings;

public class ReverseString {//For C-style string
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
}
