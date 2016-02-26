import java.util.Arrays;

public class RotateArray{
	public static void rotate(int[] nums, int k){
		int n=nums.length;
		k%=n;
		reverse(nums,0,n-k);
		reverse(nums,n-k,n);
		reverse(nums,0,n);
	}

	private static void reverse(int[] nums, int s, int e){
		if(s<0 || e>nums.length) return;
		while(s<e){
			int temp=nums[s];
			nums[s++]=nums[--e];
			nums[e]=temp;
		}
	}

	public static void main(String[] args) {
		int[] nums={1,2,3,4,5,6,7};
		int k=7;
		System.out.println("k="+k);
		System.out.println(Arrays.toString(nums));
		rotate(nums,k);
		System.out.println(Arrays.toString(nums));
	}
}