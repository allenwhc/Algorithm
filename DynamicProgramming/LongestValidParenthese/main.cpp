#include <iostream>
#include <string>
#include <stack>
using namespace std;

int longestValidParentheses(string s){
	if(s.empty()) return 0;
	stack<int> stk;
	stk.push(-1);
	int res = 0;
	for(int i=0; i<s.size(); i++){
		if(s[i] == '(') stk.push(i);
		else{
			stk.pop();
			if(!stk.empty()){
				res = max(res, i-stk.top());
			}
			else{stk.push(i);}
		}
	}
	return res;
}

int main(int argc, char const *argv[])
{
	string s = ")()())()()(";
	cout << longestValidParentheses(s) << endl;
	return 0;
}