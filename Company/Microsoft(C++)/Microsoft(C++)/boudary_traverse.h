//
//  boudary_travese.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef boudary_traverse_h
#define boudary_traverse_h

#include "classes.h"

void leftBoundary(vector<int> &boundary, TreeNode *root){
    if(!root) return;
    if(root->left){
        boundary.push_back(root->val);
        leftBoundary(boundary, root->left);
    }else if(root->right){
        boundary.push_back(root->val);
        leftBoundary(boundary, root->right);
    }
}

void leaves(vector<int> &boundary, TreeNode *root){
    if (!root) return;
    leaves(boundary, root->left);
    if (!root->left && !root->right)
        boundary.push_back(root->val);
    leaves(boundary, root->right);
}

void rightBoundary(vector<int> &boundary, TreeNode *root){
    if(!root) return;
    if(root->right){
        boundary.push_back(root->val);
        leftBoundary(boundary, root->right);
    }else if(root->left){
        boundary.push_back(root->val);
        leftBoundary(boundary, root->left);
    }
}

vector<int> Solution::boundaryTraversal(TreeNode *root){
    vector<int> boundary;
    if (root){
        boundary.push_back(root->val);
        leftBoundary(boundary,root->left);
        leaves(boundary, root->left);
        leaves(boundary, root->right);
        rightBoundary(boundary, root->right);
    }
    return boundary;
}

#endif /* boudary_traverse_h */
