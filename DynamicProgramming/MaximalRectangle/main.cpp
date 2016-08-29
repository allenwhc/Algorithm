#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int largestRectangleArea(vector<int> &heights){
	if(heights.empty()) return 0;
	stack<int> stk;
	int maxArea = -1, area = 0, i = 0;
	for(; i<heights.size();){
		if(stk.empty() || heights[i] > heights[stk.top()]) stk.push(i++);
		else{
			int h = stk.top();
			stk.pop();
			if(stk.empty()) area = i * heights[h];
			else area = heights[h] * (i - stk.top() - 1);
			if(area > maxArea) maxArea = area;
		}
	}
	while(!stk.empty()){
		int h = stk.top();
		stk.pop();
		if(stk.empty()) area = i * heights[h];
		else area = heights[h] * (i - stk.top() - 1);
		if(area > maxArea) maxArea = area;
	}
	return maxArea;
}

int maximalRectangle(vector<vector<char>>& matrix){
	if(matrix.empty()) return 0;
	if(matrix[0].empty()) return 0;
	int m = matrix.size(), n = matrix[0].size();
	int maxArea = -1;
	vector<int> cols(n,0);
	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			if(matrix[i][j] == '1') cols[j] += 1;
			else cols[j] = 0;
		}
		maxArea = max(maxArea, largestRectangleArea(cols));
	}
	return maxArea;
}

int main(int argc, char const *argv[])
{
	vector<int> heights = {2,1,5,6,2,3};
	cout << "max histogram: " << largestRectangleArea(heights) << endl;
	vector<vector<char>> matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},{'1', '0', '0', '1', '0'}};
	cout << "max rectangle: " << maximalRectangle(matrix) << endl;
	return 0;
}