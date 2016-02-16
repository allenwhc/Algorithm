import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Triplet{
	public static boolean increasingTriplet(int[] nums){
		int n=nums.length;
		if(n<3) return false;
		int min_idx=0,max_idx=n-1;
		
		int i,j;
		for(i=1; i<n-1; i++){
			boolean less=false, greater=false;
			for(j=i-1; j>=0; j--){
				if(nums[j]<nums[i]){
					less=true;
					break;
				}
			}

			for(j=i+1;j<n; j++){
				if(nums[j]>nums[i]){
					greater=true;
					break;
				}
			}
			if(less && greater) return true;
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] nums={{1,2,3,4,5},{5,4,3,2,1},{2,1,5,0,3},{1,5,4,2,3},{1,1,-2,6},{1,2,1,2,1,2,1,2,1,2}};
		for(int[] n:nums){
			System.out.print("Array: "+Arrays.toString(n));
			if(increasingTriplet(n))
				System.out.println(" exists increasing triplet.");
			else
				System.out.println(" doesn't exist increasing triplet.");
		}
		
	}
}