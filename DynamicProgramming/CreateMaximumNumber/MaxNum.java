import java.util.Arrays;
import java.util.Stack;

public class MaxNum{
	public static int[] maxNumber(int[] nums1, int[] nums2, int k){
		int m=nums1.length;
		int n=nums2.length;
		int[] res=new int[k];
		for(int i=Math.max(0,k-n); i<=k && i<=m; i++){
			int[] temp=merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
			if(greater(temp,0,res,0)) res=temp;
		}
		return res;
	}

	private static int[] merge(int[] nums1, int[] nums2, int k){
		int[] res=new int[k];
		for(int i=0, j=0, s=0; s<k; s++)
			res[s]=greater(nums1,i,nums2,j)?nums1[i++]:nums2[j++];
		return res;
	}

	private static boolean greater(int[] nums1, int i, int[] nums2, int j){
		while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){i++;j++;}
		return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]); 
	}

	private static int[] maxArray(int[] nums, int k){
		int[] res=new int[k];
		for(int i=0,j=0; i<nums.length; i++){
			while(nums.length-i+j>k && j>0 && res[j-1]<nums[i]) j--;
			if(j<k) res[j++]=nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1={3,4,6,5};
		int[] nums2={9,1,2,5,8,3};
		int k=5;
		System.out.println("Max number: "+Arrays.toString(maxNumber(nums1,nums2,k)));
	}
}