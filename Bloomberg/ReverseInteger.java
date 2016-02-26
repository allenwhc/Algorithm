
public class ReverseInteger{
	public static int reverse(int x){
		int reverseInt=0;
		while(x!=0){
			int temp=reverseInt*10+x%10;
			if((temp-x%10)/10!=reverseInt) return 0;
			x/=10;
			reverseInt=temp;
		}
		return reverseInt;
	}

	public static void main(String[] args) {
		int[] nums={123,-241,1000000003};
		for(int n:nums)
			System.out.println("Reverse of "+n+" is: "+reverse(n));
	}
}