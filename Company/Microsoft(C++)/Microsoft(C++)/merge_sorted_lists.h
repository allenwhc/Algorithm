//
//  merge_sorted_lists.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef merge_sorted_lists_h
#define merge_sorted_lists_h
#include "classes.h"

ListNode* Solution::mergeTwoLists(ListNode *l1, ListNode *l2){
    if(!l1) return l2;
    if(!l2) return l1;
    ListNode *p = l1, *q = l2;
    ListNode *newHead = new ListNode(-1);
    ListNode *tail = newHead;
    while (p && q){
        if (p->val < q->val){
            tail->next = p;
            p = p->next;
        }
        else{
            tail->next = q;
            q = q->next;
        }
        tail = tail->next;
    }
    ListNode *left_nodes = (p==NULL)?q:p;
    while (left_nodes){
        tail->next = left_nodes;
        left_nodes = left_nodes->next;
        tail = tail->next;
    }
    return newHead->next;
}
#endif /* merge_sorted_lists_h */
