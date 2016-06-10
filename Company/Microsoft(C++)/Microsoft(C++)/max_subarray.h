//
//  max_subarray.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef max_subarray_h
#define max_subarray_h

vector<int> Solution::maxSubarray(vector<int> &nums){
    if (nums.empty()) return {};
    vector<int> result;
    int max_sum = INT_MIN, sum = 0, start = 0, end = 0;
    for (int i = 0; i < nums.size(); i++){
        if (sum ==0) start = i;
        sum += nums[i];
        if (sum > max_sum){
            end = i;
            max_sum = sum;
        }
        sum = max(sum, 0);
    }
    for (int i = start; i <= end; i++)
        result.push_back(nums[i]);
    return result;
}

#endif /* max_subarray_h */
