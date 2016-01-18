import java.util.Arrays;

public class BulbSwitcher{
	public static int bulbSwitch(int n){
		if(n==0) return 0;
		//Only bulbs at position 1^2, 2^2, ..., n^2 are left on
		return (int)Math.sqrt(n);
	}

	public static void main(String[] args) {
		int n=10000000;
		System.out.println(bulbSwitch(n)+" bulbs are still on.");
	}
}