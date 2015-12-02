import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Multiplication{
	public static int[][] mutiply(int[][] A, int[][] B){
		if(A.length==0 || B.length==0) return new int[0][0];
		if(A[0].length!=B.length) return new int[0][0];
		int m=0, n=0;
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[0].length; j++){
				if(A[i][j]!=0) m++;
			}
		}
		for(int i=0; i<B.length; i++){
			for(int j=0; j<B[0].length; j++){
				if(B[i][j]!=0) n++;
			}
		}
		return new int[m][n];
	}

	public static void main(String[] args) {
		int[][] A={{1,0,0},{-1,0,3}};
		int[][] B={{7,0,0},{0,0,0},{0,0,1}};
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