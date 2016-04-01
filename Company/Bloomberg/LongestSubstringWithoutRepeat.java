import java.util.HashMap;

public class LongestSubstringWithoutRepeat{
	//1. Naive approach
	// public static int lengthOfLongestSubstring(String s){
	// 	if(s.length()==0) return 0;

	// 	int i,j;
	// 	int len=0;
	// 	for(i=0; i<s.length(); i++){
	// 		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
	// 		map.put(s.charAt(i),1);
	// 		j=i+1;
	// 		while(j<s.length() && !map.containsKey(s.charAt(j))){
	// 			map.put(s.charAt(j),1);
	// 			j++;
	// 		}
	// 		len=Math.max(len,j-i);
	// 	}
	// 	return len;
	// }

	//2
	public static int lengthOfLongestSubstring(String s){
		if(s.length()==0) return 0;
		int n=s.length();

		int len=0;
		int l,r;
		for(l=0, r=1; r<n; r++){
			int idx=s.lastIndexOf(s.charAt(r),r-1);
			if(idx>=0){
				len=Math.max(len,r-l);
				l=Math.max(l,idx+1);
			}
		}
		return Math.max(r-l,len);
	}

	public static void main(String[] args) {
		String s="abcdbcaeb";
		System.out.println("Length: "+lengthOfLongestSubstring(s));
	}
}