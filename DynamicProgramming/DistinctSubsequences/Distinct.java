public class Distinct{
	public static int numDistinct(String s, String t){
		int m=s.length();
		int n=t.length();
		if(m==0) return 0;
		int[][] dp=new int[m+1][n+1];
		for(int i=0; i<=m; i++)
			dp[i][0]=1;

		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				dp[i][j]=dp[i-1][j];
				if(s.charAt(i-1)==t.charAt(j-1))
					dp[i][j]+=dp[i-1][j-1];
			}
		}

		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		String s="bufff";
		String t="buff";

		System.out.println(numDistinct(s,t)+" distinct subsequences of '"+t+"' in '"+s+"'.");
	}
}