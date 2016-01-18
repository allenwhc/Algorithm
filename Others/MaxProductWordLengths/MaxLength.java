import java.util.Arrays;

public class MaxLength{
	public static int maxProduct(String[] words){
		int n=words.length;
		if(n==0) return 0;
		int product=0;
		int[] mark=new int[n];

		for(int i=0; i<n; i++){
			String str=words[i];
			for(int j=0; j<str.length(); j++){
				int ascii=str.charAt(j)-'a';
				mark[i]|=(1<<ascii);
			}
			
		}
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				int bitwise=mark[i]&mark[j];
				if(bitwise==0)
					product=Math.max(product,words[i].length()*words[j].length());
			}
		}
		return product;
	}

	public static void main(String[] args) {
		String[] words1={"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		String[] words2={"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		String[] words3={"a", "aa", "aaa", "aaaa"};

		System.out.println(Arrays.toString(words1));
		System.out.println("Max product word lengths: "+maxProduct(words1));
		System.out.println(Arrays.toString(words2));
		System.out.println("Max product word lengths: "+maxProduct(words2));
		System.out.println(Arrays.toString(words3));
		System.out.println("Max product word lengths: "+maxProduct(words3));
	}
}