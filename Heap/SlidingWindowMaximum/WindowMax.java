import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class WindowMax{
	public static int[] maxSlidingWindow(int[] nums, int k){
		int n=nums.length;
		if(n<k || n==0 || k==0) return new int[0];
		Deque<Integer> heap=new LinkedList<Integer>();
		List<Integer> window=new ArrayList<Integer>();
		for(int i=0; i<k; i++){
			while(heap.size()>0 && nums[i]>nums[heap.getLast()])
				heap.pollLast();
			heap.addLast(i);
		}
		for(int i=k; i<n; i++){
			window.add(nums[heap.getFirst()]);
			while(heap.size()>0 && nums[i]>nums[heap.getLast()])
				heap.pollLast();
			while(heap.size()>0 && i-heap.getFirst()>=k)
				heap.pollFirst();
			heap.addLast(i);
		}

		window.add(nums[heap.getFirst()]);

		int[] windowMax=new int[window.size()];
		for(int i=0; i<window.size(); i++)
			windowMax[i]=window.get(i);
		return windowMax;
	}

	public static void main(String[] args) {
		int[] nums={1,3,-1,-3,5,3,6,7};
		int k=3;
		System.out.println("Sliding window maximum is: "+Arrays.toString(maxSlidingWindow(nums,k)));
	}
}