import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class GrayCode{
	public static List<Integer> grayCode(int n){
		List<Integer> gCode=new ArrayList<Integer>();
		gCode.add(0);
		for(int i=0; i<n; i++){
			int mostSignificantBit=1<<i;	//Shift i to right with 1 bit
			for(int j=gCode.size()-1; j>=0; j--)
				gCode.add(mostSignificantBit+gCode.get(j));
		}
		return gCode;
	}

	public static void main(String[] args) {
		int n=3;
		System.out.println("The Gray Code of a "+n+"-bit system is: "+Arrays.deepToString(grayCode(n).toArray()));
	}
}