//
//  classes.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef classes_h
#define classes_h
#include <vector>
#include <string>
#include <stack>
#include <map>
#include <algorithm>
using namespace std;

struct ListNode{
    int val;
    ListNode *next;
    ListNode(int x): val(x), next(NULL){}
};

struct TreeNode{
    int val;
    TreeNode *left, *right;
    TreeNode(int x): val(x), left(NULL), right(NULL){}
};

struct RandomListNode{
    int label;
    RandomListNode *next, *random;
    RandomListNode(int x): label(x), next(NULL), random(NULL){}
};

class Solution{
public:
    //1. remove duplicate characters in string
    string removeDuplicate(string s);
    
    //2. reverse words in a sentence
    void reverseWords(string &s);
    
    //3. reverse singly-linked list
    ListNode* reverseList(ListNode *head);
    
    //4. merge two sorted singly-linked list
    ListNode* mergeTwoLists(ListNode *l1, ListNode *l2);
    
    //5. iterative in-order traversal
    vector<int> inorderTraversal(TreeNode *root);
    
    //6. check if two binary trees are identival
    bool isIdentical(TreeNode *t1, TreeNode *t2);
    
    //7. boundary traverse of binary tree
    vector<int> boundaryTraversal(TreeNode *root);
    
    //8. square root of a real number
    double squareRoot(double x);
    
    //9. division of two integers
    int divide(int x, int y);
    
    //10. find element in sorted array
    int search(vector<int> &nums, int target);
    
    //11. find subarray with maximum sum
    vector<int> maxSubarray(vector<int> &nums);
    
    //12. reverse all even nodes in a singly-linked list
    ListNode* reverseEvenNodes(ListNode* head);
    
    //13. deep copy of a singly-linked list with random pointer
    RandomListNode* copyRandom(RandomListNode* head);
    
};


#endif /* classes_h */
