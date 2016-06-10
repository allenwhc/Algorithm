//
//  main.cpp
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#include <iostream>
#include "Auxiliary.h"
#include "reverse_even_nodes.h"
#include "remove_duplicate_string.h"
#include "iterative_inorder.h"
#include "boudary_traverse.h"
#include "same_tree.h"
#include "merge_sorted_lists.h"
#include "reverse_words.h"
#include "reverse_list.h"
#include "divide.h"
#include "square_root.h"
#include "search_rotated_array.h"
#include "max_subarray.h"
#include "odd_even_list.h"
#include "copy_random_pointer_list.h"

int main(int argc, const char * argv[]) {
    Solution s;
    cout << "1. Remove duplicate characters in a string" << endl;
    string s1 = "cbwaobucwbyadwiobc";
    cout << s1 << " -> " << s.removeDuplicate(s1) << endl << endl;
    
    cout <<"2. Reverse words in a sentence" << endl;
    string sentence = "   the  sky      is  blue    ";
    cout << sentence << " -> ";
    s.reverseWords(sentence);
    cout << sentence << endl << endl;
    
    cout << "3. Reverse singly-linked list" << endl;
    ListNode *head = new ListNode(0);
    vector<int> values={1,2,3,4,5,6};
    for(auto &v:values) insertList(head, v);
    ListNode *print = head->next;
    printList(print);
    ListNode *result = s.reverseList(head->next);
    print = result;
    printList(print);
    deleteList(result);
    cout << endl;
    
    cout << "4. Merge two sorted lists" << endl;
    ListNode *l1 = new ListNode(0);
    ListNode *l2 = new ListNode(0);
    vector<int> v1 = {-3,-1,1,4,7,11};
    vector<int> v2 = {-5,-2,0,5,6,9,13};
    for (auto &v: v1) insertList(l1, v);
    for (auto &v: v2) insertList(l2, v);
    ListNode *print1 = l1->next, *print2 = l2->next;
    cout << "list 1: ";
    printList(print1);
    cout << "list 2: ";
    printList(print2);
    cout << "merged list: ";
    result = s.mergeTwoLists(l1->next, l2->next);
    print = result;
    printList(print);
    deleteList(result);
    cout << endl;
    
    cout << "5. Iterative inorder traversal" << endl;
    TreeNode *root = new TreeNode(20);
    root->left = new TreeNode(8);
    root->right = new TreeNode(22);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(12);
    root->right->right = new TreeNode(25);
    root->left->right->left = new TreeNode(10);
    root->left->right->right = new TreeNode(14);
    printTree(root, "");
    vector<int> inorder = s.inorderTraversal(root);
    cout << "inorder traverse: ";
    for(auto &i:inorder) cout<< i << " ";
    deleteTree(root);
    cout << endl << endl;
    
    cout << "6. Check identical binary trees:" << endl;
    TreeNode *t1 = new TreeNode(1);
    t1->left = new TreeNode(2);
    t1->right = new TreeNode(3);
    t1->left->right = new TreeNode(4);
    cout << "Tree 1: " << endl;
    printTree(t1, "");
    TreeNode *t2 = new TreeNode(1);
    t2->left = new TreeNode(2);
    t2->right = new TreeNode(3);
    t2->left->left = new TreeNode(4);
    cout << "Tree 2: " << endl;
    printTree(t2, "");
    if(s.isIdentical(t1, t2))
        cout << "Same tree" << endl << endl;
    else
        cout << "Different tree" << endl << endl;
    
    cout << "7. Boundary traversal of bianry tree:" << endl;
    TreeNode *root2 = new TreeNode(20);
    root2->left = new TreeNode(8);
    root2->right = new TreeNode(22);
    root2->left->left = new TreeNode(4);
    root2->left->right = new TreeNode(12);
    root2->right->right = new TreeNode(25);
    root2->left->right->left = new TreeNode(10);
    root2->left->right->right = new TreeNode(14);
    printTree(root2, "");
    cout << "Boundary traverse: " << endl;
    //vector<int> boundary = s.boundaryTraversal(root);
    //for (auto &v:boundary) cout << v << " ";
    deleteTree(root2);
    cout << endl;
    
    cout << "8. Square root" << endl;
    double x = 5.4;
    cout << "Square root of " << x << " is: " << s.squareRoot(x) << endl << endl;
    
    cout << "9. Divide two integers" << endl;
    int dividend = 8723, divisor = 342;
    cout << dividend << "/" << divisor << "=" <<s.divide(dividend, divisor) << endl << endl;
    
    cout << "10. Search element in rotated sorted array" << endl;
    vector<int> arr = {4,5,6,7,8,0,1,2};
    int target = 8;
    cout << "Index of " << target << " in [";
    for (auto & e:arr) cout << e <<" ";
    cout << "] is: " << s.search(arr, target) << endl << endl;
    
    cout << "11. Maximum subarray" << endl;
    arr = {-2,1,-3,4,-1,2,1,-5,4};
    vector<int> max_sub = s.maxSubarray(arr);
    cout << "Subarry [";
    for (auto &e :max_sub) cout << e <<" ";
    cout << "]" << endl << endl;
    
    cout << "12. Reverse even nodes in linked list" << endl;
    head = new ListNode(0);
    for (auto &v: values) insertList(head, v);
    print = head->next;
    cout << "original list: ";
    printList(print);
    cout << "Evenly reversed list: ";
    result = s.reverseEvenNodes(head->next);
    printList(result);
    deleteList(result);
    cout << endl;
    
    cout << "13. Deep copy of random pointer list" << endl;
    RandomListNode *rHead = new RandomListNode(1);
    RandomListNode *rPrint = rHead, *tail = rHead;
    RandomListNode *r1 = new RandomListNode(2);
    tail->next = r1;
    tail = tail->next;
    RandomListNode *r2 = new RandomListNode(3);
    tail->next = r2;
    tail = tail->next;
    RandomListNode *r3 = new RandomListNode(4);
    tail->next = r3;
    tail = tail->next;
    RandomListNode *r4 = new RandomListNode(5);
    tail->next = r4;
    tail = tail->next;
    RandomListNode *r5 = new RandomListNode(6);
    tail->next = r5;
    tail = tail->next;
    
    rHead->random = r4;
    r1->random = rHead;
    r2->random = r3;
    r3->random = NULL;
    r4->random = r2;
    r5->random = r1;
    cout << "original: ";
    printRandomList(rPrint);
    cout << "copied: ";
    RandomListNode *rResult = s.copyRandom(rHead);
    printRandomList(rResult);
    return 0;
}
