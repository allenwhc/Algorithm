import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class H_Index{
	public static int hIndex(int[] citations){
		int n=citations.length;
		int hIdx=0;

		int[] arr=new int[n+1];
		for(int i=0; i<n; i++){
			if(citations[i]>=n) arr[n]++;
			else arr[citations[i]]++;
		}

		int sum=0;
		for(int i=n; i>=0; i--){
			sum+=arr[i];
			if(sum>=i) return i;
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] citations={3,0,6,1,5};
		System.out.println("H-Index is: "+hIndex(citations));
	}
}