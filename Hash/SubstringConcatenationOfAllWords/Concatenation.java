import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Concatenation{
	public static List<Integer> findSubstring(String s, String[] words){
		int n=words.length;
		int len=s.length();
		List<Integer> idx=new ArrayList<Integer>();
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		if(n==0 || len==0) return idx;
		int m=words[0].length();
		for(int i=0; i<n; i++){
			if(!map.containsKey(words[i]))
				map.put(words[i],1);
			else map.put(words[i],map.get(words[i])+1);
		}
		for(int i=0; i<=len-m*n; i++){
			HashMap<String,Integer> map2=new HashMap<String,Integer>();
			//System.out.println(i+":"+str);
			int j=0;
			while(j<n){
				String str=s.substring(i+j*m,i+(j+1)*m);
				if(map.containsKey(str)){
					if(!map2.containsKey(str))
						map2.put(str,1);
					else map2.put(str,map2.get(str)+1);
					if(map2.get(str)>map.get(str)) break;
				}
				else break;
				j++;
			}
			if(j==n)
				idx.add(i);
		} 
		return idx;
	}

	public static void main(String[] args) {
		String s="wordgoodgoodgoodbestword";
		String[] words={"word","good","best","good"};
		System.out.println("Starting indices are: "+Arrays.deepToString(findSubstring(s,words).toArray()));
	}
}