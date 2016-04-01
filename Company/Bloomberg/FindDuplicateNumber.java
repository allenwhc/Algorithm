

public class FindDuplicateNumber{
	public static int findDuplicate(int[] nums){
		int n=nums.length;
		if(n<2) return 0;

		for(int i=0; i<n; i++){
			if(nums[Math.abs(nums[i])]>0) nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
			else return Math.abs(nums[i]);
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums={1,2,2};
		System.out.println("Duplicate number: "+findDuplicate(nums));
	}
}