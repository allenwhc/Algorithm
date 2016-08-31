#include <iostream>
#include <vector>
#include <limits.h>
#include <iostream>
using namespace std;

/*
*	Dynamic programming solution
*	Time complexity: O(2*n^2)
*	Extra space: O(n^2+n)
*/

int minCut(string s){
	if(s.empty()) return 0;
	int n = s.size();
	vector<vector<bool>> T(n, vector<bool>(n, false));
	//All single characters are already palindrome
	for(int i=0; i<n; i++){T[i][i] = true;}	
	//Check palindrome for substring with l=2
	for(int i=0; i<n-1; i++){
		if(s[i] == s[i+1]) T[i][i+1] = true;
	}
	//Check palindrome when l>=3
	for(int len=3; len<=n; len++){
		for(int i=0; i<=n-len; i++){
			int j = i+len-1;
			if(s[i] == s[j] && T[i+1][j-1]) T[i][j] = true;
		}
	}

	vector<int> cut(n, 0);
	for(int i=0; i<n; i++){
		if(T[0][i]) cut[i] = 0;
		else{
			int temp = INT_MAX;
			for(int j=0; j<i; j++){
				if(T[j+1][i] && cut[j] + 1 < temp)
					temp = cut[j] + 1;
			}
			cut[i] = temp;
		}
	}
	// for(vector<bool>& v: T){
	// 	for(bool b:v) cout << b << " ";
	// 	cout << endl;
	// }
	//for(int c:cut) cout << c << " ";	
	return cut[n-1];
}

int main(int argc, char const *argv[])
{
	string s = "aasasfb";
	cout << minCut(s) << endl;
	return 0;
}