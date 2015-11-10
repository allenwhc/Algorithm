
public class Wildcard{
	public static boolean isMatch(String s, String p){
		int i=0, j=0;
		int starPos=-1, posCharInS=-1;
		while(i<s.length()){

			//If corresponding character in p is '?', increment both pointers
			if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
				i++;
				j++;
			}

			else if(j<p.length() && p.charAt(j)=='*'){
				starPos=j; 	//Store position of '*'
				posCharInS=i;
				j++;
			}

			else if(starPos!=-1){
				j=starPos+1;
				i=++posCharInS;
			}

			else return false;
		}

		while(j<p.length() && p.charAt(j)=='*') j++;
		return j==p.length();
	}

	public static void main(String[] args) {
		String[] s={"aa","aa","aaa","aa","asdfsdca","acnnbbccbsnbaabc","aab"};
		String[] p={"a","aa","aa","*","a*a","?*","c*a*b"};

		for(int i=0; i<s.length; i++)
			System.out.println(isMatch(s[i],p[i]));
	}
}