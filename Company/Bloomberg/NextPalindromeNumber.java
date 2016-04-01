import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPalindromeNumber{
	public static int nextPalindrome(int x){
		if(x<0) return 0;
		List<Integer> digits=new ArrayList<Integer>();
		int y=x;
		while(x!=0){
			digits.add(x%10);
			x/=10;
		}
		Collections.reverse(digits);
		System.out.println(Arrays.deepToString(digits.toArray()));
		return 0;
	}

	private static boolean isAllNine()

	public static void main(String[] args) {
		int x=13344376;
		System.out.println("Next palindrome of "+x+" is: "+nextPalindrome(x));
	}
}