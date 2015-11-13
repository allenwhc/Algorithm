import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WordDistance {
	private static HashMap<String,List<Integer>> map;
    public WordDistance(String[] words) {
        map=new HashMap<String,List<Integer>>();
        for(int i=0; i<words.length; i++){
        	if(!map.containsKey(words[i]))
        		map.put(words[i],new ArrayList<Integer>(Arrays.asList(i)));
        	else
        		map.get(words[i]).add(i);
        }
    }

    public static int shortest(String word1, String word2) {
        List<Integer> list1=map.get(word1);
        List<Integer> list2=map.get(word2);
        int minDis=Integer.MAX_VALUE;
        for(int i=0; i<list1.size(); i++){
        	for(int j=0; j<list2.size(); j++){
        		minDis=Math.min(minDis, Math.abs(list1.get(i)-list2.get(j)));
        	}
        }
        return minDis;
    }

    public static void main(String[] args) {
    	String[] words={"practice", "makes", "perfect", "coding", "makes"};
    	String word1="coding";
    	String word2="makes";
    	WordDistance wordDistance=new WordDistance(words);
    	System.out.println("Distance between '"+word1+"' and '"+word2+"' is: "+wordDistance.shortest(word1,word2));
    }
}