import java.util.Arrays;

public class ThreeSumClosest{
	public static int threeSumClosest(int[] nums, int target){
		int n=nums.length;
		if(n<3) return 0;

		Arrays.sort(nums);
		int minDiff=Integer.MAX_VALUE;

		int m1=-1,m2=-1,m3=-1;
		int j,k;
		for(int i=0; i<n-2; i++){
			if(i>0 && nums[i]==nums[i-1]) continue;
			j=i+1;
			k=n-1;
			while(j<k){
				int sum=nums[i]+nums[j]+nums[k];
				if(sum==target) return target;
				else{
					if(Math.abs(sum-target)<minDiff){
						m1=i;m2=j;m3=k;
						minDiff=Math.abs(sum-target);
					}
					if(sum<target) {
						j++;
						while(j<k && nums[j]==nums[j-1]) j++;
					}
					else{ 
						k--;
						while(j<k && nums[k]==nums[k+1]) k--;
					}
				}
			}
		}

		return nums[m1]+nums[m2]+nums[m3];
	}

	public static void main(String[] args) {
		int[] nums={-1,2,1,-4};
		int target=1;
		System.out.println("Closest sum: "+threeSumClosest(nums,target));
	}
}