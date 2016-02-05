#include <iostream>
#include <utility>
#include <vector>
using namespace std;

class Skyline{
	struct Strap
	{
		int left;
		int height;
	public:
		Strap(int l, int h){
			left=l;
			height=h;
		}
	};
public:
	vector<pair<int,int> > getSkyline(vector<vector<int> >& buildings){
		vector<pair<int,int> > skyline;
		return skyline;
	}
private:
	vector<pair<int,int> > divide(vector<vector<int> >& buildings, int start, int end){

	}

	vector<pair<int,int> > merge(vector<pair<int,int> >& skyline1, vector<pair<int,int> >& skyline2){

	}
};

int main(int argc, char* argv[]){
		//int[][] array={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		vector<vector<int> > buildings={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		//buildings={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		Skyline sky;
		vector<pair<int,int> > skyline=sky.getSkyline(buildings);
		cout<<"The skyline is: "<<endl;
		for(int i=0; i<skyline.size(); i++)
			cout<<"["<<skyline[i].first<<","<<skyline[i].second<<"], ";
		cout<<endl;
		return 0;
	}