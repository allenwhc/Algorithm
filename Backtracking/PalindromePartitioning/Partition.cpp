#include <vector>
#include <string>
#include <iostream>
using namespace std;

class PalindromPartition{
public:
	vector<vector<string> > partition(string s){
		vector<vector<string> > allPartitions;
		vector<string> partitions;
		getPartition(allPartitions,partitions,s,0);
		return allPartitions;
	}
private:
	void getPartition(vector<vector<string> >& allPartitions, vector<string>& partitions, string& s, int step){
		if(step==s.length()){
			allPartitions.push_back(partitions);
			return;
		}
		for(int i=step; i<s.length(); i++){
			if(isPalindrome(s,step,i)){
				partitions.push_back(s.substr(step,i-step+1));
				getPartition(allPartitions,partitions,s,i+1);
				partitions.pop_back();
			}

		}
	}

	bool isPalindrome(string& s, int start, int end){
		while(start<=end){
			if(s[start]!=s[end]) return false;
			start++;
			end--;
		}
		return true;
	}
};

int main(int argc, char const *argv[])
{
	/* code */
	string s="aab";
	cout<<"All palindrom partitions of '"<<s<<"' are: "<<endl;
	PalindromPartition p;
	for(int i=0; i<p.partition(s).size(); i++){
		for(int j=0; j<p.partition(s)[i].size(); j++)
			cout<<p.partition(s)[i][j]<<", ";
		cout<<endl;
	}
	return 0;
}