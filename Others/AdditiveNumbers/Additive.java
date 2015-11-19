
public class Additive{
	public static boolean isAdditiveNumber(String num){
		int len=num.length();
		if(num==null || len<3) return false;
		for(int i=0; i<len-2; i++){
			if(num.charAt(0)=='0' && i>0) break;
			long addend1=Long.parseLong(num.substring(0,i+1));
			for(int j=i+1; j<len-1; j++){
				if(num.charAt(i+1)=='0' && j>i+1) break;
				long addend2=Long.parseLong(num.substring(i+1,j+1));
				if(dfs(num,j+1,addend1,addend2))
					return true;
			}

		}
		return false;
	}

	private static boolean dfs(String num, int idx, long addend1, long addend2){
		if(idx==num.length())
			return true;
		long currSum=addend1+addend2;
		String str=String.valueOf(currSum);
		int m=str.length();

		if(idx+m>num.length() || !num.substring(idx,idx+m).equals(str))
			return false;
		return dfs(num,idx+m,addend2,currSum);
	}

	public static void main(String[] args) {
		String[] nums={"112358","199100199","1234127"};
		for(int i=0; i<nums.length; i++){
			System.out.print(nums[i]+" ");
			if(isAdditiveNumber(nums[i]))
				System.out.println("is an additive number.");
			else
				System.out.println("is not an additive number.");
		}
	}
}