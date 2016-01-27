import java.util.Arrays;

public class Median{
	public static double findMedianSortedArrays(int[] nums1, int[] nums2){
		int m=nums1.length;
		int n=nums2.length;
		
		//Make sure nums1 always has a smaller length
		if(m>n) return findMedianSortedArrays(nums2,nums1);

		int k=(m+n-1)/2;
		int s=0;
		int e=Math.min(k,m);
		while(s<e){
			int mid1=(e-s)/2+s;
			int mid2=k-mid1;
			if(nums1[mid1]<nums2[mid2])
				s=mid1+1;
			else
				e=mid1; 
		}

		//Compare which is larger between nums1[s-1] and nums2[k-s]
		int a=Math.max(s>0?nums1[s-1]:Integer.MIN_VALUE, (k-s)>=0?nums2[k-s]:Integer.MIN_VALUE);
		if((m+n)%2!=0) return (double) a;

		//Compare which is smaller between nums1[s] and nums2[k-s+1]
		int b=Math.min(s<m?nums1[s]:Integer.MAX_VALUE, k-s+1<n?nums2[k-s+1]:Integer.MAX_VALUE);
		return (a+b)/2.0;
	}

	private static double findMedianByRange(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k){
		int m=e1-s1;
		int n=e2-s2;
		if(m==0) return nums2[k-1];
		if(m>n) return findMedianByRange(nums2,s2,e2,nums1,s1,e1,k);
		if(k==1) return Math.max(nums1[s1],nums2[s2]);
		System.out.println(s1+","+e1+"; "+s2+","+e2+"k="+k);
		int i1=Math.min(k/2,m);
		int i2=k-i1;
		if(nums1[i1-1]<nums2[i2-1]) return findMedianByRange(nums1,i1,e1,nums2,s2,i2,k-i1);
		else return findMedianByRange(nums1,s1,i1,nums2,i2,e2,k-i2);
	}

	private static double median(int[] nums, int s, int e){
		if((e-s)%2!=0) return (double)nums[s+(e-s)/2];
		else return ((double)nums[s+(e-s)/2]+(double)nums[s+(e-s)/2-1])/2.0;
	}

	public static void main(String[] args) {
		int[] nums1={1};
		int[] nums2={1};
		System.out.println("Median is: "+findMedianSortedArrays(nums1,nums2));
	}
}