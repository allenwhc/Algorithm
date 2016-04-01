public class Sqrt{
	public static int mySqrt(int x){
		if(x<=0) return 0;
		double x0=x, x1=0;
		while(x0!=x1){
			x1=x0;
			x0=(x0+x/x0)/2;
		}
		return Math.abs((int)x0);
	}

	public static void main(String[] args) {
		int x=Integer.MAX_VALUE;
		System.out.println("Square root of "+x+"="+mySqrt(x));
	}
}