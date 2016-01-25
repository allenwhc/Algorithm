import java.util.Arrays;

public class Wiggle{
	public static void wiggleSort(int[] nums){
		int n=nums.length;
		Arrays.sort(nums);
		if(n<=1) return;

		int mid=(n%2==0)?n/2-1:n/2;	//Find mid index
		int[] temp=Arrays.copyOf(nums,n);
		int index=0;
		for(int i=0; i<=mid; i++){
			nums[index]=temp[mid-i];
			if(index+1<n) nums[index+1]=temp[n-i-1];
			index+=2;
			//System.out.println(Arrays.toString(nums));
		}

		return;
	}

	public static void main(String[] args) {
		int[] nums={1, 5, 1, 1, 6, 4};
		System.out.println("Before wiggle sort: "+Arrays.toString(nums));
		wiggleSort(nums);
		System.out.println("After wiggle sort: "+Arrays.toString(nums));
	}
}