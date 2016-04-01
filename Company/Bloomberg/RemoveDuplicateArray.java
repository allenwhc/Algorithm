import java.util.Arrays;

public class RemoveDuplicateArray{
	public static int removeDuplicates(int[] nums){
		int n=nums.length;
		if(n<2) return n;
		int len=n;
		int i=1, j=0;
		while(i<n){
			if(nums[i]==nums[j]){
				i++;
				len--;
			}else{
				j++;
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i++;
			}
		}
		return len;
	}

	public static void main(String[] args) {
		int[] nums={1,2,2,3,3,4};
		System.out.println("New length: "+removeDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
}
