import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.Collections;

public class ShiftedString{
	public static List<List<String>> groupStrings(String[] strings){
		List<List<String>> groups=new ArrayList<List<String>>();
		int n=strings.length;
		if(n==0) return groups;
		HashMap<String,List<String>> map=new HashMap<String,List<String>>();
		for(String s:strings){
			String str=hashString(s);
			if(!map.containsKey(str))
				map.put(str,new ArrayList<String>(Arrays.asList(s)));
			else
				map.get(str).add(s);
		}

		for(String key:map.keySet()){
			Collections.sort(map.get(key));
			groups.add(new ArrayList<String>(map.get(key)));
		}
		return groups;
	}

	private static String hashString(String s){
		StringBuilder str=new StringBuilder();
		int[] ascii=new int[s.length()];
		for(int i=0; i<s.length(); i++){
			ascii[i]=(s.charAt(i)-s.charAt(0))>=0?(s.charAt(i)-s.charAt(0)):(s.charAt(i)-s.charAt(0)+26);
			str.append((char)(ascii[i]+'a'));
		}
		return str.toString();
	}

	public static void main(String[] args) {
		String[] strings={"abc", "bcd", "acef", "xyz", "az", "dae", "yx", "yvz"};
		for(List<String> list:groupStrings(strings))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}