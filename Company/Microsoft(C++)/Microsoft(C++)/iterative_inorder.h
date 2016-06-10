//
//  iterative_inorder.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef iterative_inorder_h
#define iterative_inorder_h

#include "classes.h"

vector<int> Solution::inorderTraversal(TreeNode *root){
    vector<int> inorder;
    stack<TreeNode*> stk;
    bool done = false;
    if (!root) return inorder;
    TreeNode *p = root;
    while (!done){
        if (p){
            stk.push(p);
            p = p->left;
        }
        else{
            if(!stk.empty()){
                p = stk.top();
                stk.pop();
                inorder.push_back(p->val);
                p = p->right;
            }
            else done = true;
        }
    }
    return inorder;
}
#endif /* iterative_inorder_h */
