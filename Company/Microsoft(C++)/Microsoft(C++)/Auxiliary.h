//
//  Auxiliary.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef Auxiliary_h
#define Auxiliary_h
#include "classes.h"
void insertList(ListNode *head, int val){
    while (head->next) {
        head = head->next;
    }
    head->next = new ListNode(val);
    head = head->next;
}

void printList(ListNode *head){
    while (head){
        cout << head->val;
        head = head->next;
        if (head) cout << "->";
    }
    cout << endl;
}

void deleteList(ListNode *head){
    while (head){
        delete head;
        head = head->next;
    }
}

void printTree(TreeNode *root, string indent){
    if(!root) return;
    printTree(root->right, indent + "   ");
    cout << indent << root->val << endl;
    printTree(root->left, indent + "   ");
}

void deleteTree(TreeNode* root){
    if (root){
        deleteTree(root->left);
        deleteTree(root->right);
        delete root;
    }
}

void printRandomList(RandomListNode* head){
    while (head){
        cout << head->label << "(";
        if(head->random) cout << head->random->label;
        else cout << "NULL";
        cout << ")";
        head = head->next;
        if (head) cout <<"->";
    }
    cout << endl;
}

#endif /* Auxiliary_h */
