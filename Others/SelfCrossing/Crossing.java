import java.util.Arrays;

public class Crossing{
	public static boolean isSelfCrossing(int[] x){
		if(x.length<4) return false;
		int base=0;
		int a=x[0],b=x[1],c=x[2],d=0;	//Initially, a->north, b->west, c->south
		boolean grow=false;

		if(a<c) grow=true;
		else grow=false;

		for(int i=3; i<x.length; i++){
			d=x[i];
			//Shrinking spiral matrix
			if(!grow && (b<=d)) return true;

			//First grow, then shrink
			else if(grow && (b>=d)){
				if((base+d)<b || (i<x.length-1 && x[i+1]+a<c)) grow=false;
				else if(i<x.length-1) return true;
			}

			//Switch line
			base=a;
			a=b;
			b=c;
			c=d;
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] xx={{2,1,1,2},{1,2,3,4},{3,5,6,5,2,4}};
		for(int[] x: xx){
			System.out.println(Arrays.toString(x)+": "+isSelfCrossing(x));
		}
	}
}