
public class PO3{
	public static boolean isPowerOfThree(int n){
		if(n<=0) return false;
		while(n%3==0) n/=3;
		return n==1;
	}

	public static void main(String[] args) {
		int[] nums={3,14,27,101,357,789};
		for(int n:nums){
			if(isPowerOfThree(n))
				System.out.println(n+" is a power of three.");
			else
				System.out.println(n+" is not a power of three.");
		}
	}
}