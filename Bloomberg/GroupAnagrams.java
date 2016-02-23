import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Collections;

public class GroupAnagrams{
	public static List<List<String>> groupAnagrams(String[] strs){
		
		List<List<String>> result=new ArrayList<List<String>>();
		if(strs.length==0) return result;
		Map<String,List<String>> map=new HashMap<String,List<String>>();
		String[] s=Arrays.copyOf(strs,strs.length);

		for(int i=0; i<s.length; i++){
			char[] c=s[i].toCharArray();
			Arrays.sort(c);
			if(!map.containsKey(new String(c))){
				map.put(new String(c),new ArrayList<String>(Arrays.asList(strs[i])));
			}else map.get(new String(c)).add(strs[i]);
		}

		for(String key:map.keySet()){
			Collections.sort(map.get(key));
			result.add(map.get(key));
		}
		return result;
	}

	public static void main(String[] args) {
		String[] strs={"eat","tea","tan","ate","nat","bat"};
		System.out.println(Arrays.toString(strs));
		for(List<String> list:groupAnagrams(strs))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}