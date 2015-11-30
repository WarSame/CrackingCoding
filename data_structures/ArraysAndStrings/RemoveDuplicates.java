package data_structures.ArraysAndStrings;

public class RemoveDuplicates {
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
}
