import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public class BullsAndCows{
	public static String getHint(String secret, String guess){
		//if(secret.length()==0) return "";
		// HashMap<Integer,Integer> map_secret=new HashMap<Integer,Integer>();
		// for(int i=0; i<secret.length(); i++){
		// 	int digit=secret.charAt(i)-'0';
		// 	map_secret.put(i,digit);
		// }

		// HashMap<Integer,Integer> map_guess=new HashMap<Integer,Integer>();
		// for(int i=0; i<guess.length(); i++){
		// 	int digit=guess.charAt(i)-'0';
		// 	map_guess.put(i,digit);
		// }
		//  for(Integer key:map_secret.keySet())
		//  	System.out.println(key+":"+map_secret.get(key));
		//  for(Integer key:map_guess.keySet())
		//  	System.out.println(key+":"+map_guess.get(key));
		// int numBulls=0,numCows=0;
		// for(Integer key:map_secret.keySet()){
		// }
		// StringBuilder str=new StringBuilder();
		// str.append(numBulls).append("A").append(numCows).append("B");
		// return str.toString();
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