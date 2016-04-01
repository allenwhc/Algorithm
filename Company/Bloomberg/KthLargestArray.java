import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

public class KthLargestArray{
	public static int findKthLargest(int[] nums, int k){
		int n=nums.length;
		if(n==0 || n<k) return 0;
		PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
		heap.offer(nums[0]);

		for(int i=1; i<n; i++){
			if(heap.size()>=k){
				if(nums[i]>=heap.peek()){
					heap.poll();
					heap.offer(nums[i]);
				}
			}else heap.offer(nums[i]);
		}
		// while(heap.size()>0){
		// 	System.out.print(heap.poll()+" ");
		// }
		return heap.peek();
	}

	public static void main(String[] args) {
		int[] nums={2,1};
		int k=1;

		System.out.println(k+"th largest in "+Arrays.toString(nums)+" is: "+findKthLargest(nums,k));
	}
}