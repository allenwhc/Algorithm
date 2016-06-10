//
//  reverse_words.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef reverse_words_h
#define reverse_words_h
#include "classes.h"
#include <sstream>

string trim(string s){
    size_t first = s.find_first_not_of(" ");
    size_t last = s.find_last_not_of(" ");
    return s.substr(first, (last - first +1));
}

void Solution::reverseWords(string &s){
    istringstream ss(s);
    vector<string> words;
    copy(istream_iterator<string>(ss) , istream_iterator<string>(), back_inserter(words));
    s.erase();
    for (int i = words.size() - 1; i >= 0; i--){
        s += words[i];
        if(i>0) s+=' ';
    }
}

#endif /* reverse_words_h */
