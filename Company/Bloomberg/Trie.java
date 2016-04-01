import java.util.Arrays;

public class Trie{
	public static class TrieNode{
		int val;
		TrieNode[] children;
		public TrieNode(){
			val=0;
			children=new TrieNode[26];
			Arrays.fill(children, null);
		}
	}

	private static TrieNode root;
	private static int count;

	public Trie(){
		root=new TrieNode();
		count=0;
	}

	// Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p=root;
        char[] cw=word.toCharArray();
        for(int i=0; i<cw.length; i++){
        	int charVal=cw[i]-'a';
        	if(p.children[charVal]==null) p.children[charVal]=new TrieNode();
        	p=p.children[charVal];
        }
        count++;
        p.val=count;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p=root;
        char[] cw=word.toCharArray();
        for(int i=0; i<cw.length; i++){
        	int idx=cw[i]-'a';
        	if(p.children[idx]==null) return false;
        	else p=p.children[idx];
        }
        if(p.val==0) return false;
        return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p=root;
        char[] cw=prefix.toCharArray();
        for(int i=0; i<cw.length; i++){
        	int idx=cw[i]-'a';
        	if(p.children[idx]==null) return false;
        	else p=p.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
    	
    }

}