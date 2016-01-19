import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Multiplication{
	public static int[][] mutiply(int[][] A, int[][] B){
		if(A.length==0 || B.length==0) return new int[0][0];
		if(A[0].length!=B.length) return new int[0][0];
		int[][] res=new int[A.length][B[0].length];
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[0].length; j++){
				if(A[i][j]!=0){
					for(int k=0; k<B[0].length; k++)
						res[i][k]+=A[i][j]*B[j][k];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] A={{1,-5}};
		int[][] B={{12},{-1}};
		System.out.println("Matrix A: ");
		for(int[] a:A)
			System.out.println(Arrays.toString(a));
		System.out.println("Matrix B: ");
		for(int[] b:B)
			System.out.println(Arrays.toString(b));
		System.out.println("Inner product of A and B is: ");
		int[][] M=mutiply(A,B);
		for(int[] m:M)
			System.out.println(Arrays.toString(m));
	}
}