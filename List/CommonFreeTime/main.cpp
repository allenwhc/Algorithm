#include <vector>
#include <queue>
#include <iostream>
#include <algorithm>
using namespace std;

struct MyCompare{
	bool operator()(pair<int,int> &p1, pair<int, int> &p2){return p1.second < p2.second;}
};

vector<pair<int, int>> commonFreeTime(vector<pair<int, int>> &schedule, int start, int end){
	vector<pair<int,int>> res;
	priority_queue<pair<int,int>, vector<pair<int, int>>, MyCompare> pq;
	sort(schedule.begin(), schedule.end(), [](const pair<int,int> &p1, const pair<int,int> &p2) -> bool{return p1.first < p2.first;});
	if(schedule[0].first>start) res.push_back(make_pair(start, schedule[0].first));
	pq.push(schedule[0]);
	for(int i=1; i<schedule.size(); i++){
		pair<int,int> prev = pq.top();
		pq.pop();
		pair<int,int> curr = schedule[i];
		if(curr.first < prev.second){
			prev.second = max(curr.second, prev.second);
			pq.push(prev);
		} 
		else{
			pq.push(curr);
			res.push_back(make_pair(prev.second, curr.first));
		}
	}
	if(pq.top().second < end) res.push_back(make_pair(pq.top().second, end));
	return res;
}

int main(int argc, char const *argv[])
{
	int start = 0, end = 20;
	vector<pair<int,int>> schedule = {make_pair(2,5),make_pair(1,4),make_pair(6,8),make_pair(13,15),make_pair(9,12),make_pair(7,10)};
	vector<pair<int,int>> res = commonFreeTime(schedule, start, end);
	for(auto it = res.begin(); it!=res.end(); it++) cout << it->first << ", " << it->second << endl;
	return 0;
}