#include <iostream>
#include <vector>
#include <string>
using namespace std;

/*
*	Time complexity: O(m*n)
*	Extra space: O(m*n)
*/
bool isMatch(string s, string p){
	int m = s.size(), n = p.size();
	vector<vector<bool>> dp(m+1, vector<bool>(n+1, false));
	dp[0][0] = true;
	if(n!=0 && p[0] == '*'){
		for(int j=1; j<=n; j++){
			if(p[j-1] == '*') dp[0][j] = true;
			else break;
		}
	}
	for(int i=1; i<=m; i++){
		for(int j=1;j<=n;j++){
			if(s[i-1] == p[j-1] || p[j-1] == '?') dp[i][j] = dp[i-1][j-1];
			else if(p[j-1] == '*') dp[i][j] = dp[i-1][j] | dp[i][j-1];
			else dp[i][j] = false;
		}
	}
	for(vector<bool> x:dp){
		for(bool v:x) cout << v << " ";
		cout << endl;
	}
	return dp[m][n];
}

int main(int argc, char const *argv[])
{
	string s = "b";
	string p = "*?*?";
	if(isMatch(s,p)) cout << "Match" << endl;
	else cout << "Not matched" << endl;
	return 0;
}