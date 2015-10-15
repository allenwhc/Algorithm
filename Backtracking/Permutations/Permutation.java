import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation{
	//Integer permuation
	public static List<List<Integer>> intPermute(int[] nums){
		List<Integer> permuation=new ArrayList<Integer>();	
		List<List<Integer>> allPermutations=new ArrayList<List<Integer>>();
		if(nums.length==0) return allPermutations;
		getIntPermutation(allPermutations,permuation,nums,0,new boolean[nums.length]);
		return allPermutations;
	}

	private static void getIntPermutation(List<List<Integer>> allPermutations, List<Integer> permuation, int[] nums, int step, boolean[] visited){
		if(step==nums.length){
			allPermutations.add(new ArrayList<Integer>(permuation));
			return;
		}
		for(int i=0; i<nums.length; i++){
			if(!visited[i]){
				if(i>0 && nums[i]==nums[i-1] && visited[i-1]) continue;
				visited[i]=true;
				permuation.add(nums[i]);
				getIntPermutation(allPermutations,permuation,nums,step+1,visited);
				permuation.remove(permuation.size()-1);
				visited[i]=false;
			}
		}
	}

	//String permutation
	public static List<String> stringPermute(String s){
		List<String> allPermutations=new ArrayList<String>();
		if(s.length()==0) return allPermutations;
		getStrPermutations(allPermutations,s,0);
		return allPermutations;
	} 

	private static void getStrPermutations(List<String> allPermutations, String s, int step){
		if(step==s.length()){
			if((allPermutations.size()==0) || (allPermutations.size()>0 && !allPermutations.contains(s)))
				allPermutations.add(s);
			return;
		}
		for(int i=step; i<s.length(); i++){
			s=swap(s,step,i);
			getStrPermutations(allPermutations,s,step+1);
			s=swap(s,step,i);
		}
	}

	private static String swap(String s, int i, int j){
		if(i==j) return s;
		char[] c=s.toCharArray();
		char temp=c[i];
		c[i]=c[j];
		c[j]=temp;
		s=new String(c);
		return s;
	}

	public static void main(String[] args) {
		System.out.println("Integer Permutation: ");
		int[] nums={1,2,2,3};
		System.out.println("All permuations of "+Arrays.toString(nums)+" are: ");
		for(List<Integer> list:intPermute(nums))
			System.out.println(Arrays.deepToString(list.toArray()));
		System.out.println();
		System.out.println("String Permutation");
		String s="abbd";
		System.out.println("All permuations of '"+s+"' are: ");
		for(String str:stringPermute(s))
			System.out.println(str);

	}
}