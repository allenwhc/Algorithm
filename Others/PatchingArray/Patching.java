
public class Patching{
	public static int minPathches(int[] nums, int n){
		long missed=1, add=0;
		int i=0;
		while(missed<=n){
			if(i<nums.length && nums[i]<=missed){
				missed+=nums[i++];
			}else{
				missed+=missed;
				add++;
			}
		}
		return (int)add;
	}

	public static void main(String[] args) {
		int[] nums={1,5,10};
		int n=20;
		System.out.println("Min Patch: "+minPathches(nums,n));
	}
}