//
//  main.cpp
//  RemoveDuplicateInString
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
#include <stack>
using namespace std;

string removeDuplicate(string s){
    string res = "";
    stack<char> stk;
    vector<int> occurrence(256, 0);
    vector<bool> visited(256, false);
    
    for (auto &c:s)
        occurrence[(int) c]++;
    
    for (auto &c:s){
        occurrence[(int) c]--;
        if (!visited[(int) c]){
            while (!stk.empty() && occurrence[(int) stk.top()] != 0 && c < stk.top()){
                char topC = stk.top();
                stk.pop();
                visited[(int) topC] = false;
            }
            stk.push(c);
            visited[(int) c] = true;
        }
    }
    while (!stk.empty()){
        char topC = stk.top();
        stk.pop();
        res += topC;
    }
    reverse(res.begin(), res.end());
    return res;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    string s = "cbacdcbc";
    cout << s << " -> " << removeDuplicate(s) << endl;
    return 0;
}
