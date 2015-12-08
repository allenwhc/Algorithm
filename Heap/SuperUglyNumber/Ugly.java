import java.util.Arrays;

public class Ugly{
	public static int nthSuperUglyNumber(int n, int[] primes){
		int m=primes.length;
		Arrays.sort(primes);
		int[] superUgly=new int[n];
		int[] pos=new int[m];
		superUgly[0]=1;
		for(int i=1; i<n; i++){
			int prevSuperUgly=superUgly[i-1];
			for(int j=0; j<m; j++){
				while(superUgly[pos[j]]*primes[j]<=prevSuperUgly)
					 pos[j]++;
			}
			int[] superUglyCandidates=new int[m];
			int x=Integer.MAX_VALUE;
			for(int k=0; k<m; k++){
				superUglyCandidates[k]=superUgly[pos[k]]*primes[k];
				x=Math.min(x,superUglyCandidates[k]);
			}
			superUgly[i]=x;
		}
		return superUgly[n-1];
	}

	public static void main(String[] args) {
		int n=12; 
		int[] primes={2,7,13,19};
		System.out.println(n+"th super ugly number in primes list "+Arrays.toString(primes)+" is: "+nthSuperUglyNumber(n,primes));
	}
}