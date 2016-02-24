public class Pow{
	public static double pow(double x, int n){
		double y=0;
		if(n==0) return 1;
		y=pow(x,n/2);
		if(n%2==0) return y*y;
		else{
			if(n>0) return x*y*y;
			else return y*y/x;
		}
	}

	public static void main(String[] args) {
		double x=3.55;
		int n=4;
		System.out.println(x+"^"+n+"="+pow(x,n));
	}
}