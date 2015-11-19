
public class Additive{
	public static boolean isAdditiveNumber(String num){
		int len=num.length();
		if(len<1) return false;
		for(int i=1; i<len; i++){
			int addend1=Integer.parseInt(num.substring(0,i));
			for(int j=i+1; j<len; j++){
				int temp=addend1;
				int addend2=Integer.parseInt(num.substring(i,j));
				int idx=j;
				int restDigits=Integer.parseInt(num.substring(j));
				while(temp+addend2<=restDigits){
					
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] nums={"112358","199100199","1234127"};
		for(int i=0; i<nums.length; i++){
			System.out.print(num+" ");
			if(isAdditiveNumber(nums[i]))
				System.out.println("is an additive number.");
			else
				System.out.println("is not an additive number.");
		}
	}
}