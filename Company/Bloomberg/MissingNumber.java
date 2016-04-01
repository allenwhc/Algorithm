import java.util.Arrays;

public class MissingNumber{
	public static int missingNumber(int[] nums){
		int n=nums.length;
		int missing=0;
		for(int i=0; i<=n; i++) missing^=i;
		for(int i:nums) missing^=i;
		return missing;
	}

	public static void main(String[] args) {
		int[] nums={0,1,3,4,5};
		System.out.println("Missing "+missingNumber(nums));
	}
}