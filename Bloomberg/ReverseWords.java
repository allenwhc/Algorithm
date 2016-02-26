import java.util.Arrays;
import java.lang.StringBuilder;

public class ReverseWords{
	public static String reverseWords(String s){
		int n=s.length();
		if(n==0) return "";
		
	// 	String str=s.replaceAll("\\s+"," ");
	// 	int start=0;
	// 	while(start<str.length() && str.charAt(start)==' ') start++;
	// 	str=str.substring(start);
	// 	//System.out.println(str);
	// 	String[] strs=str.split("\\s+");
	// 	int i=0, j=strs.length-1;
	// 	while(i<j){
	// 		String t=strs[i];
	// 		strs[i]=strs[j];
	// 		strs[j]=t;
	// 		i++;j--;
	// 	}
	// //	System.out.println(Arrays.toString(strs));
	// 	StringBuilder result=new StringBuilder();
	// 	for(i=0; i<strs.length; i++){
	// 		result.append(strs[i]);
	// 		if(i!=strs.length-1) result.append(" ");
	// 	}
	// 	return result.toString();

		String[] strs=s.split(" +");
		StringBuilder str=new StringBuilder();
		for(int i=strs.length-1; i>=0; i--){
			str.append(strs[i].trim()).append(" ");
		}
		return str.toString().trim();
	}

	public static void main(String[] args) {
		String s="  the   sky is   blue    ";
		System.out.println(s+"->"+reverseWords(s));
	}
}