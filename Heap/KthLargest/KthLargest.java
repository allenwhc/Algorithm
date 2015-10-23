import java.util.Arrays;
import java.util.Stack;

public class KthLargest{
	public static int findKthLargest(int[] nums, int k){
		int n=nums.length;
		Stack<Integer> minHeap=new Stack<Integer>();
		Stack<Integer> helperHeap=new Stack<Integer>();
		minHeap.push(nums[0]);
		for(int i=1; i<k; i++)
			heapify(nums[i],k,minHeap,helperHeap);
		for(int i=k; i<n; i++){
			if(nums[i]>minHeap.peek())
				heapify(nums[i],k,minHeap,helperHeap);
		}
		return minHeap.peek();
	}

	private static void heapify(int x, int k, Stack<Integer> minHeap, Stack<Integer> helperHeap){
		while(!minHeap.empty() && x>minHeap.peek())
					helperHeap.push(minHeap.pop());
			minHeap.push(x);
		while(minHeap.size()<k && !helperHeap.empty()) minHeap.push(helperHeap.pop());
	}

	public static void main(String[] args) {
		int[] nums={-1,2,0};
		int k=1;
		System.out.println(k+"th largest element in "+Arrays.toString(nums)+" is: "+findKthLargest(nums,k));
	}
}