import java.util.Arrays;
import java.util.HashMap;

public class Isomorphic{
	public static boolean isIsomorphic(String s, String t){
		int m=s.length();
		int n=t.length();
		if(m==0 && n==0) return true;
		if(m!=n) return false;
		HashMap<Character,Character> map=new HashMap<Character,Character>();
		for(int i=0; i<m; i++){
			char c_s=s.charAt(i);
			char c_t=t.charAt(i);
			if(!map.containsKey(c_s)){
				if(!map.isEmpty()){
					for(Character c:map.values())
						if(c==c_t) return false;
				}
				map.put(c_s,c_t);
			}
			else{
				if(map.get(c_s)!=c_t) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] s={"egg","foo","paper","ab"};
		String[] t={"add","bar","title","aa"};
		for(int i=0; i<s.length; i++)
			System.out.println(isIsomorphic(s[i],t[i]));
	}
}