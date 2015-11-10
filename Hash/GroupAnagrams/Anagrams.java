import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

public class Anagrams{
	public static List<List<String>> groupAnagrams(String[] strs){
		int n=strs.length;
		List<List<String>> groups=new ArrayList<List<String>>();
		if(n==0) return groups;
		HashMap<String, List<String>> map=new HashMap<String, List<String>>();
		for(String s:strs){
			char[] c=s.toCharArray();
			Arrays.sort(c);
			String hashWord=String.valueOf(c);
			if(!map.containsKey(hashWord))
				map.put(hashWord,new ArrayList<String>(Arrays.asList(s)));
			else 
				map.get(hashWord).add(s);
		}
		for(String hashWord:map.keySet()){
			List<String> anagrams=new ArrayList<String>(map.get(hashWord));
			Collections.sort(anagrams);
			groups.add(anagrams);
		}
		return groups;
	}

	public static void main(String[] args) {
		String[] strs={"cab","tin","pew","duh","may","ill","zac","acz","max","doc"};
		System.out.println("The input strings are: "+Arrays.toString(strs));
		for(List<String> list:groupAnagrams(strs))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}