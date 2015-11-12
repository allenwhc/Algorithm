import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Alien{
	public static String alienOrder(String[] words){
		int n=words.length;
		if(n==0) return "";

		List<Character> distinct_alphabet=new ArrayList<Character>();
		for(String s:words){
			for(int i=0; i<s.length(); i++)
				if(!distinct_alphabet.contains(s.charAt(i)))
					distinct_alphabet.add(s.charAt(i));
		}

		List<List<String>> graph=new ArrayList<List<String>>();
		for(int i=0; i<26; i++)
			graph.add(new ArrayList<String>());

		
	}

	public static void main(String[] args) {
		String[] words={"wrt","wrf","er","ett","rftt"};
		System.out.println("Order of "+Arrays.toString(words)+" is: "+alienOrder(words));
	}
}