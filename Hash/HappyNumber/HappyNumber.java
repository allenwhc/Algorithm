import java.util.HashSet;

public class HappyNumber{
	public static boolean isHappy(int n){
		if(n<=0) return false;
		HashSet<Integer> set=new HashSet<Integer>();
		while(set.add(n)){
			int value=0;
			while(n>0){
				value+=Math.pow(n%10,2);
				n/=10;
			}
			n=value;
		}
		return n==1;
	}

	public static void main(String[] args) {
		int[] nums={82,15,376,618,970};
		for(int n:nums)
			System.out.println(isHappy(n));
	}
}