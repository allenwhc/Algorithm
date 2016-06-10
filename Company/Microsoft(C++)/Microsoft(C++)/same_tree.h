//
//  same_tree.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef same_tree_h
#define same_tree_h
#include "classes.h"

bool Solution::isIdentical(TreeNode *t1, TreeNode *t2){
    if (!t1 && !t2) return true;
    if (t1 && t2)
        return (t1->val == t2->val) && isIdentical(t1->left, t2->left) && isIdentical(t1->right, t2->right);
    return false;
}
#endif /* same_tree_h */
