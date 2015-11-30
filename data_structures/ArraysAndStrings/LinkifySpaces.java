package data_structures.ArraysAndStrings;

public class LinkifySpaces {
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
}
