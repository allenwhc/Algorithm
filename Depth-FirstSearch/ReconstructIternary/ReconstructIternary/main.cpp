//
//  main.cpp
//  ReconstructIternary
//
//  Created by Haochen Wang on 2/8/16.
//  Copyright (c) 2016 Haochen Wang. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
#include <utility>
#include <unordered_map>
#include <set>
using namespace std;

class Reconstruct{
public:
    vector<string> findItinerary(vector<pair<string, string>> tickets){
        vector<string> itinerary;
        
        if(tickets.size()==0) return itinerary;
        
        unordered_map<string, multiset<string>> adjacent_list;
        for(pair<string,string> fromTo:tickets)
            adjacent_list[fromTo.first].insert(fromTo.second);
        
        dfs(adjacent_list, itinerary, "JFK");
        
        reverse(itinerary.begin(), itinerary.end());
        return itinerary;
    }
private:
    void dfs(unordered_map<string, multiset<string>>& adjacent_list, vector<string>& itinerary, string u){
        while(!adjacent_list[u].empty()){
            string v=*adjacent_list[u].begin();
            adjacent_list[u].erase(adjacent_list[u].begin());
            dfs(adjacent_list, itinerary, v);
        }
        itinerary.push_back(u);
    }
};


int main(int argc, const char * argv[]) {
    // insert code here...
    vector<pair<string, string>> tickets={{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
    Reconstruct r;
    vector<string> itinerary=r.findItinerary(tickets);
    for(vector<string>::iterator it=itinerary.begin(); it!=itinerary.end(); it++)
        cout<<*it<<" ";
    cout<<endl;
    return 0;
}
