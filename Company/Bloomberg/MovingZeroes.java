import java.util.Arrays;

public class MovingZeroes{
	public static void movingZeroes(int[] nums){
		int n=nums.length;
		if(n==0) return;
		int i=0, j=0;
		while(i<n){
			if(nums[i]!=0){
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i++;j++;
			}else i++;
		}
	}

	public static void main(String[] args) {
		int[] nums={-1,0,1,0,3,12};
		System.out.println(Arrays.toString(nums));
		movingZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}