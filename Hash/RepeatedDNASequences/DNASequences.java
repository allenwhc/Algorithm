import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class DNASequences{
	public static List<String> findRepeatedDnaSequences(String s){
		int n=s.length();
		Set<String> appeared=new HashSet<String>();
		Set<String> repeatDna=new HashSet<String>();
		for(int i=0; i<=n-10; i++){
			String dnaSequence=s.substring(i,i+10);
			if(!appeared.add(dnaSequence))
				repeatDna.add(dnaSequence);
		}
		return new ArrayList<String>(repeatDna);
	}

	public static void main(String[] args) {
		String s="GGGTTTAAAAACCCCCAAAAACCCCCCAAAAAGGGTTTAAAAA";
		System.out.println("Repeated sequences in '"+s+"' are: "+Arrays.deepToString(findRepeatedDnaSequences(s).toArray()));
	}
}