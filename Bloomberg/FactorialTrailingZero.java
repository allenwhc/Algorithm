public class FactorialTrailingZero{
	public static int tralingZeroes(int n){
		if(n<5) return 0;
		int num=0;
		int fac=5;
		while(n/fac>0){
			num+=n/fac;
			n/=fac;
		}
		return num;
	}

	public static void main(String[] args) {
		int n=18;
		System.out.println(tralingZeroes(n)+" trailing 0s in "+n+"!. ");
	}
}