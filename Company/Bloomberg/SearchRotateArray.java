import java.util.Arrays;

public class SearchRotateArray{
	public static int search(int[] nums, int target){
		int n=nums.length;
		int s=0, e=n-1;
		while(s<=e){
			int mid=(e-s)/2+s;
			if(nums[mid]==target) return mid;
			if(nums[s]<=nums[mid]){
				if(target>=nums[s] && target<nums[mid]) e=mid-1;
				else s=mid+1;
			}else{
				if(target>nums[mid] && target<=nums[e]) s=mid+1;
				else e=mid-1;
			}
		}
		return -1;
	}	


	public static void main(String[] args) {
		int[] nums={6,7,0,1,2,4,5};
		int target=3;
		System.out.println("Index of "+target+" in "+Arrays.toString(nums)+" is: "+search(nums,target));
	}
}