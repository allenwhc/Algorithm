import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class BullsAndCows{
	public static String getHint(String secret, String guess){
		int numBulls=0,numCows=0;
		int n=secret.length();
		int[] digits=new int[10];
		for(int i=0; i<n; i++){
			if(secret.charAt(i)==guess.charAt(i))
				numBulls++;
			else{
				if(digits[secret.charAt(i)-'0']<0) numCows++;
				if(digits[guess.charAt(i)-'0']>0) numCows++;
				digits[secret.charAt(i)-'0']++;
				digits[guess.charAt(i)-'0']--;
			}
		}
		return numBulls+"A"+numCows+"B";
	}

	public static void main(String[] args) {
		String secret="1122";
		String guess="1222";
		System.out.println("Bulls & cows for '"+guess+"' guessing '"+secret+"' is: '"+getHint(secret,guess)+"'.");
	}
}