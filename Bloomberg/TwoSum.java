import java.util.HashMap;
import java.util.Map;

public class TwoSum{
	public static int[] twoSum(int[] nums, int target){
		if(nums.length<2) return new int[0];
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int[] index=new int[2];
		map.put(nums[0],0);
		for(int i=1; i<nums.length; i++){
			if(map.containsKey(target-nums[i])){
				index[0]=Math.min(i,map.get(target-nums[i]));
				index[1]=Math.max(i,map.get(target-nums[i]));
			}else{
				map.put(nums[i],i);
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums={0,4,3,0};
		int target=0;
		int[] index=twoSum(nums,target);
		System.out.println(index[0]+","+index[1]);
	}
}