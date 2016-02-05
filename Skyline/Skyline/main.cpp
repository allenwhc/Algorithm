//
//  main.cpp
//  Skyline
//
//  Created by Haochen Wang on 2/4/16.
//  Copyright (c) 2016 Haochen Wang. All rights reserved.
//

#include <iostream>
#include <vector>
#include <utility>
using namespace std;

class Skyline{
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings){
        vector<pair<int, int>> skyline;
        skyline=divide(buildings, 0, buildings.size()-1);
        for(int i=0; i<skyline.size(); i++){
            while(i>0 && skyline[i].second==skyline[i-1].second){
                skyline.erase(skyline.begin()+i);
                i--;
            }
        }
        return skyline;
    }
private:
    vector<pair<int, int>> divide(vector<vector<int>>& buildings, int start, int end){
        if(start==end){
            vector<pair<int, int>> skyline;
            skyline.push_back(make_pair(buildings[start][0], buildings[start][2]));
            skyline.push_back(make_pair(buildings[start][1], 0));
            return skyline;
        }
        int mid=(end-start)/2+start;
        vector<pair<int, int>> skyline1=divide(buildings, start, mid);
        vector<pair<int, int>> skyline2=divide(buildings, mid+1, end);
        return merge(skyline1, skyline2);
    }
    
    vector<pair<int, int>> merge(vector<pair<int, int>>& skyline1, vector<pair<int, int>>& skyline2){
        int m=skyline1.size();
        int n=skyline2.size();
        int i=0,j=0;
        int h1=0, h2=0;
        
        vector<pair<int, int>> skyline;
        while(i<m && j<n){
            if(skyline1[i].first<skyline2[j].first){
                h1=skyline1[i].second;
                skyline.push_back(make_pair(skyline1[i].first, max(h1, h2)));
                i++;
            }else if(skyline1[i].first>skyline2[j].first){
                h2=skyline2[j].second;
                skyline.push_back(make_pair(skyline2[j].first, max(h1,h2)));
                j++;
            }else{
                h1=skyline1[i].second;
                h2=skyline2[j].second;
                skyline.push_back(make_pair(skyline1[i].first, max(h1,h2)));
                i++;j++;
            }
        }
        
        while (i<m) {
            skyline.push_back(make_pair(skyline1[i].first, skyline1[i].second));
            i++;
        }
        while (j<n) {
            skyline.push_back(make_pair(skyline2[j].first, skyline2[j].second));
            j++;
        }
        return skyline;
    }
};


int main(int argc, const char * argv[]) {
    // insert code here...
    vector<vector<int> > buildings={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
    Skyline sky;
    vector<pair<int,int> > skyline=sky.getSkyline(buildings);
    cout<<"The skyline is: "<<endl;
    for(int i=0; i<skyline.size(); i++)
        cout<<"["<<skyline[i].first<<","<<skyline[i].second<<"], ";
    cout<<endl;
    return 0;
}
