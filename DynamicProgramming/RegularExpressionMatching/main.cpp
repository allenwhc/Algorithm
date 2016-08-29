#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
*	Time complexity: O(m*n)
*	Extra space: O(m*n)
*/
bool isMatch(string s, string p){
	int m = s.size(), n = p.size();
	vector<vector<bool>> dp(m+1, vector<bool>(n+1, false));
	dp[0][0] = true;
	for(int i=1; i<=n; i++){
		if(p[i-1] == '*') dp[0][i] = dp[0][i-2];
	}
	for(int i=1; i<=m; i++){
		for(int j=1;j<=n;j++){
			if(p[j-1] == '.' || s[i-1] == p[j-1]) dp[i][j] = dp[i-1][j-1];
			else if(p[j-1] == '*'){
				dp[i][j] = dp[i][j-2];
				if(p[j-2] == '.' || p[j-2] == s[i-1]) dp[i][j] = dp[i][j] | dp[i-1][j];
			}
			else dp[i][j] = false;
		}
	}
	// for(vector<bool> x:dp){
	// 	for(bool v:x) cout << v << " ";
	// 	cout << endl;
	// }
	return dp[m][n];
}

int main(int argc, char const *argv[])
{
	string s = "abcd";
	string p = "d*";
	if(isMatch(s,p)) cout << "Mathched" << endl;
	else cout << "Not matched" << endl;
	return 0;
}