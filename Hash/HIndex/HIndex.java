import java.util.Arrays;
import java.util.Collections;

public class HIndex{
	public static int hIndex(int[] citations){
		int n=citations.length;
		if(n==0) return 0;
		int h=0;
		Arrays.sort(citations);
		int[] arr=new int[n];
		for(int i=0; i<n; i++)
			arr[i]=citations[n-1-i];
		for(int i=0; i<n; i++)
			h=Math.max(h,Math.min(arr[i],i+1));
		return h;
	}

	public static void main(String[] args) {
		int[] citations={10,8,5,4,3};
		System.out.println("H-index for "+Arrays.toString(citations)+" is: "+hIndex(citations));
	}
}