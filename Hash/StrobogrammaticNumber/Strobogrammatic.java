
public class Strobogrammatic{
	public static boolean isStrobogrammatic(String num){
		int n=num.length();
		if(n==0) return true;
		char[] cc=num.toCharArray();
		for(int i=0; i<n; i++){
			if(cc[i]!='0' && cc[i]!='1' && cc[i]!='6' && cc[i]!='8' && cc[i]!='9') return false;
			else{
				if(cc[i]=='1' && cc[n-i-1]!='1') return false;
				if(cc[i]=='0' && cc[n-i-1]!='0') return false;
				if(cc[i]=='8' && cc[n-i-1]!='8') return false;
				if(cc[i]=='6' && cc[n-i-1]!='9') return false;
				if(cc[i]=='9' && cc[n-i-1]!='6') return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] nums={"69","818","78","9696","1011","1961"};
		for(String s:nums)
			System.out.println(isStrobogrammatic(s));
	}
}