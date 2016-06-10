//
//  search_rotated_array.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef search_rotated_array_h
#define search_rotated_array_h

int Solution::search(vector<int> &nums, int target){
    if (nums.empty()) return -1;
    if (nums.size() == 1 && nums.back() == target) return 0;
    int l = 0, r = nums.size() - 1;
    while (l <= r){
        int mid = (l + r) / 2;
        if (nums[mid] == target) return mid;
        else if(nums[mid] > nums[l]){
            if (target < nums[mid] && target >= nums[l]) r = mid - 1;
            else l = mid + 1;
        }
        else{
            if (target > nums[mid] && target <= nums[r]) l = mid + 1;
            else r = mid - 1;
        }
    }
    return -1;
 }


#endif /* search_rotated_array_h */
