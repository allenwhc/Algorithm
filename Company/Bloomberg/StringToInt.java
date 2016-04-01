public class StringToInt{
	public static int myAtoi(String str){
		int n=0;
		boolean negative=false;

		str=str.trim();
		char[] c=str.toCharArray();
		for(int i=0; i<c.length; i++){
			if(c[i]=='+' || c[i]=='-'){
				if(i==0) negative=(c[i]=='+')?false:true;
				else return negative?-n:n;
			}
			else if(!Character.isDigit(c[i])) return negative?-n:n;
			else{
				int k=c[i]-'0';
				int temp=n*10+k;
				if((n>=Integer.MAX_VALUE/10 && k>=8) ||  (temp-k)/10!=n)
					return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
				n=temp;
			}
		}

		return (negative)?-n:n;
	}

	public static void main(String[] args) {
		String[] str={" -134aefae"," afec","2147483648","-2147483648"};
		for(String s:str)
			System.out.println(s+" -> "+myAtoi(s));
	}
}