import java.util.Arrays;

public class NumArrayMutable{
	private static int n;
	private static int[] reserve_nums, segment_tree;

	public NumArrayMutable(int[] nums){
		n=nums.length;
		if(n==0) return;
		reserve_nums=nums;
		int treeHeight=(int)Math.ceil(Math.log(n)/Math.log(2))+1;	//Height of seg tree is h=log2n1
		int maxSize=(int)Math.pow(2,treeHeight)-1;	//# of nodes in a complete tree is 2^h-1
		segment_tree=new int[maxSize];	//Instantiate segment tree as 1d array
		constructSegTree(nums,0,n-1,0);
	}

	void update(int i, int val){
		if(i<0 || i>=reserve_nums.length) return;
		int diff=val-reserve_nums[i];
		reserve_nums[i]=val;
		updateHelper(0,n-1,0,i,diff);
	}

	public static int sumRange(int i, int j){
		return sumRangeHelper(0,n-1,i,j,0);
	}

	private static int constructSegTree(int[] nums, int start, int end, int idx){
		if(start>=end){
			segment_tree[idx]=nums[start];
			return segment_tree[idx];
		}

		int middle=(end-start)/2+start;	//Get mid point of current segment
		segment_tree[idx]=constructSegTree(nums,start,middle,2*idx+1)+constructSegTree(nums,middle+1,end,2*idx+2);
		return segment_tree[idx];
	}

	private static void updateHelper(int start, int end, int idx, int i, int diff){
		if(i<start || i>end) return;
		segment_tree[idx]+=diff;
		if(start!=end){
			int middle=(end-start)/2+start;
			updateHelper(start,middle,2*idx+1,i,diff);
			updateHelper(middle+1,end,2*idx+2,i,diff);
		}
	}

	private static int sumRangeHelper(int start, int end, int i, int j, int idx){
		if(i<=start && j>=end) return segment_tree[idx];
		if(end<i || start>j) return 0;
		int middle=(end-start)/2+start;
		return sumRangeHelper(start,middle,i,j,2*idx+1)+sumRangeHelper(middle+1,end,i,j,2*idx+2);
	}

	void print(){
		System.out.println(Arrays.toString(segment_tree));
	}

	public static void main(String[] args) {
		int[] nums={1,3,5,7,9,11,13};
		NumArrayMutable numArray=new NumArrayMutable(nums);
		numArray.print();
		int i=1; 
		int j=4;
		System.out.println(numArray.sumRange(0,3));
		numArray.update(2,10);
		numArray.print();
		System.out.println(numArray.sumRange(0,3));
	}
}