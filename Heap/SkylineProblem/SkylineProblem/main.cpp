//
//  main.cpp
//  SkylineProblem
//
//  Created by Haochen Wang on 2/4/16.
//  Copyright (c) 2016 Haochen Wang. All rights reserved.
//

#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
#include <queue>
#include <map>
#include <set>
using namespace std;

struct Edge{
    int x;
    int height;
    Edge(int x, int height):x(x),height(height){}
};

bool operator<(Edge const& e1, Edge const& e2){
    if(e1.x!=e2.x) return e1.x<e2.x;
    else return e1.height<e2.height;
}

struct sortHeight{
    bool operator()(const int& h1, const int& h2){
        return h1>h2;
    }
};

class Skyline{
public:
    vector<pair<int, int>> getSkyline(vector<vector<int>>& buildings){
        vector<pair<int, int>> skyline;
        if(buildings.size()==0) return skyline;
        
        //Find all turning points on all edges, left markeds as true, right marked as false
        multimap<Edge, bool> edges;
        for(int i=0; i<buildings.size();i++){
            Edge start(buildings[i][0],buildings[i][2]);
            if(edges.find(start)==edges.end()){
                edges.insert(pair<Edge,bool>(start,true));}
            Edge end(buildings[i][1], buildings[i][2]);
            if(edges.find(end)==edges.end())
                edges.insert(pair<Edge,bool>(end,false));
        }
        for(multimap<Edge, bool>::iterator it=edges.begin(); it!=edges.end(); it++)
            cout<<it->first.x<<","<<it->first.height<<": "<<it->second<<endl;

        multiset<int,sortHeight> heap;
        for(multimap<Edge, bool>::iterator it=edges.begin(); it!=edges.end(); it++){
            multiset<int>::iterator it2=heap.begin();
            if(it->second){
                if(heap.empty() || it->first.height>*it2)
                    skyline.push_back(make_pair(it->first.x, it->first.height));
                heap.insert(it->first.height);
            }else{
                heap.erase(it->first.height);
                it2=heap.begin();
                if(heap.empty())
                    skyline.push_back(make_pair(it->first.x, 0));
                else if(it->first.height>*it2)
                    skyline.push_back(make_pair(it->first.x, *it2));
            }
        }
        
        for(int i=0; i<skyline.size(); i++){
            while((i>0 && skyline[i].second==skyline[i-1].second) || (i>0 && skyline[i].first==skyline[i-1].first)){
                skyline.erase(skyline.begin()+(i-1));
                i--;
            }
            
        }
        return skyline;
    }
};

int main(int argc, const char * argv[]) {
//    vector<vector<int> > buildings={{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//    vector<vector<int> > buildings={{0,2,3},{2,5,3}};
    vector<vector<int> > buildings={{1,2,1},{1,2,2},{1,2,3}};
    Skyline sky;
    vector<pair<int,int> > skyline=sky.getSkyline(buildings);
    cout<<"The skyline is: "<<endl;
    for(int i=0; i<skyline.size(); i++)
        cout<<"["<<skyline[i].first<<","<<skyline[i].second<<"], ";
    cout<<endl;
    return 0;
}
