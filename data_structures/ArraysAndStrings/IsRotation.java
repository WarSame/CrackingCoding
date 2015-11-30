package data_structures.ArraysAndStrings;

public class IsRotation {
	public static boolean isRotation(String s1, String s2){
		if (s1.length()==s2.length() && s1.length()>0){
			s1+=s1;
			return s1.contains(s2);
		}
		return false;
	}
}
