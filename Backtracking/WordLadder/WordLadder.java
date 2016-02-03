import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class WordLadder{
	public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList){
		List<List<String>> allPaths=new ArrayList<List<String>>();
		List<String> path=new ArrayList<String>();
		path.add(beginWord);

		Set<String> set1=new HashSet<String>();	//Set from front to end
		set1.add(beginWord);
		Set<String> set2=new HashSet<String>();	//Set from end to front
		set2.add(endWord);
		Map<String, List<String>> map=new HashMap<String,List<String>>();
		helper(wordList,set1,set2,map,false);
		System.out.println(Arrays.deepToString(set2.toArray()));

		for(String key:map.keySet())
			System.out.println(key+":"+Arrays.deepToString(map.get(key).toArray()));
		createPath(allPaths,path,map,beginWord,endWord);
		return allPaths; 
	}

	private static boolean helper(Set<String> wordList, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean backward){
		if(set1.isEmpty()) return false;
		if(set1.size()>set2.size()) 
			return helper(wordList,set2,set1,map,!backward);
		wordList.removeAll(set1);
		wordList.removeAll(set2);
		
		Set<String> set=new HashSet<String>();
		boolean isDone=false;

		for(String word:set1){
			for(int i=0; i<word.length(); i++){
				char[] ch=word.toCharArray();
				for(char c='a'; c<='z'; c++){
					ch[i]=c;

					String newWord=new String(ch);
					String key=backward?newWord:word;
					String val=backward?word:newWord;

					List<String> list=new ArrayList<String>();
					if(map.containsKey(key)) list=map.get(key);

					if(set2.contains(newWord)){
						isDone=true;
						list.add(val);
						map.put(key,list);
					}

					if(!isDone && wordList.contains(newWord)){
						set.add(newWord);
						list.add(val);
						map.put(key,list);
					}
				}
			}
		} 
		return isDone || helper(wordList,set2,set,map,!backward);
	}

	private static void createPath(List<List<String>> allPaths, List<String> path, Map<String,List<String>> map, String beginWord, String endWord){
		if(beginWord.equals(endWord)){
			allPaths.add(new ArrayList<String>(path));
			return;
		}

		if(!map.containsKey(beginWord)) return;

		for(String word: map.get(beginWord)){
			path.add(word);
			createPath(allPaths,path,map,word,endWord);
			path.remove(path.size()-1);
		}

	}

	public static void main(String[] args) {
		String beginWord="hit";
		String endWord="cog";
		Set<String> wordList=new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log"));
		//List<List<String>> path=findLadders(beginWord,endWord,wordList);
		System.out.println("The path tranfroming '"+beginWord+"' to '"+endWord+"' from "+Arrays.deepToString(wordList.toArray())+" is: ");
		for(List<String> list:findLadders(beginWord,endWord,wordList))
			System.out.println(Arrays.deepToString(list.toArray()));
	}
}