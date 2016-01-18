import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Generalized{
	public static List<String> generateAbbreviations(String word){
		List<String> abbr=new ArrayList<String>();
		if(word.length()==0 || word==null) {abbr.add("");return abbr;}
		getAbbr(abbr,word.toCharArray(),new StringBuilder(),0,0);
		return abbr;
	}

	private static void getAbbr(List<String> abbr, char[] word, StringBuilder str, int idx, int num){
		int len=str.length();
		if(idx==word.length){
			if(num!=0) str.append(num);
			abbr.add(str.toString());
		}
		else{
			getAbbr(abbr,word,str,idx+1,num+1);
			if(num!=0) str.append(num);
			getAbbr(abbr,word,str.append(word[idx]),idx+1,0);	
		}
		str.setLength(len);
	}

	public static void main(String[] args) {
		String word="word";
		System.out.println("The generalized abrreviation of '"+word+"' are: "+Arrays.deepToString(generateAbbreviations(word).toArray()));
	}
}