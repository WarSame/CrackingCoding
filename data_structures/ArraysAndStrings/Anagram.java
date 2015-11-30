package data_structures.ArraysAndStrings;

public class Anagram {
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
}
