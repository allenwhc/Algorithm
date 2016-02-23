import java.lang.StringBuilder;

public class LongestPalindromeString{
	public static String longestPalindrome(String s){
		int n=s.length();
		if(n<2) return s;
		int l=0, r=0, max=0;
		char[] c=s.toCharArray();
		for(int i=0; i<c.length; i++){
			if(isPalindrome(c,i-max-1,i)){
				l=i-max-1;
				r=i;
				max+=2;
			}else if (isPalindrome(c,i-max,i)) {
				l=i-max;
				r=i;
				max+=1;
			}
		}
		return s.substring(l,r+1);
	}

	private static boolean isPalindrome(char[] c, int s, int e){
		if(s<0) return false;
		while(s<e){
			if(c[s++]!=c[e--]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s="acbdedbea";
		System.out.println(longestPalindrome(s));
	}
}