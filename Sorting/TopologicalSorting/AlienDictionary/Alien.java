import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Alien{
	public static String alienOrder(String[] words){
		if(words==null || words.length==0) return "";
		int[] letters=new int[26];
		for(int i=0; i<words.length; i++){
			for(int j=0; j<words[i].length(); j++){
				if(letters[words[i].charAt(j)-'a']==0)
					letters[words[i].charAt(j)-'a']++;
			}
		}

		//Create adjacent list for a directed graph
		List<List<Integer>> adjacent_list=new ArrayList<List<Integer>>();
		for(int i=0; i<26; i++)
			adjacent_list.add(new ArrayList<Integer>());

		//Compare each word and its next word character by character
		//until found the first mismatching character
		for(int i=0; i<words.length-1; i++){
			String word1=words[i];
			String word2=words[i+1];
			for(int j=0; j<Math.min(word1.length(),word2.length()); j++){
				char c1=word1.charAt(j);
				char c2=word2.charAt(j);
				if(c1!=c2){
					adjacent_list.get(c1-'a').add(c2-'a');
					break;
				}
			}
		}

		//Use topological sorting to retrieve the order, and check validation of graph
		boolean[] visited=new boolean[26];
		boolean[] stack=new boolean[26];
		List<Character> order=new ArrayList<Character>();
		for(int i=0; i<26; i++){
			if(adjacent_list.get(i).size()>0)
				if(topologicalSort(adjacent_list,order,visited,stack,i))
					return "";
		}

		StringBuilder dictionary=new StringBuilder();
		for(Character c:order)
			dictionary.append(c);

		//Special case, all words has the exactly same letters
		for(int i=0; i<26; i++){
			if(letters[i]>0){
				char[] c=new char[]{(char)(i+'a')};
				if(!dictionary.toString().contains(new String(c)))
					dictionary.append(c);
			}
		}
		return dictionary.reverse().toString();
	}

	private static boolean topologicalSort(List<List<Integer>> adjacent_list, List<Character> order, boolean[] visited, boolean[] stack, int v){
		if(!visited[v]){
			visited[v]=true;
			stack[v]=true;
			for(Integer i:adjacent_list.get(v)){
				if(!visited[i] && topologicalSort(adjacent_list,order,visited,stack,i))
					return true;
				else if(stack[i])
					return true;
			}
			order.add((char)(v+'a'));
		}
		stack[v]=false;
		return false;
	}

	public static void main(String[] args) {
		String[] words={"z", "z"};
		//String[] words={"baa", "abcd", "abca", "cab", "cad"};
		//String[] words={"wrt", "wrf", "er", "ett", "rftt"};
		System.out.println("The alphabetic order is: "+alienOrder(words));
	}
}