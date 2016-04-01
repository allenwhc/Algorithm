import java.util.Arrays;

public class MergeSortedArray{
	public static void merge(int[] nums1, int m, int[] nums2, int n){
		if(m==0) {for(int i=0; i<n; i++) nums1[i]=nums2[i];return;}

		int j=nums1.length-1;
		for(int i=m-1; i>=0; i--){
			nums1[j--]=nums1[i];
		} 
		j++;

		int k=0, i=0;
		while(j<nums1.length && k<n){
			if(nums1[j]<=nums2[k]){
				nums1[i]=nums1[j];
				j++;
			}else{
				nums1[i]=nums2[k];
				k++;
			}
			i++;
		}

		while(j<nums1.length) nums1[i++]=nums1[j++];
		while(k<n) nums1[i++]=nums2[k++];
	}

	public static void main(String[] args) {
		// int[] nums1={-5,-3,2,6,10,0,0,0};
		// int m=5;
		// int[] nums2={-2,7,14};
		// int n=3;
		int[] nums1={0};int m=0;
		int[] nums2={1};int n=1;
		merge(nums1,m,nums2,n);
		System.out.println(Arrays.toString(nums1));
	}
}