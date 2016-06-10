//
//  reverse_list.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef reverse_list_h
#define reverse_list_h
#include "classes.h"

ListNode* Solution::reverseList(ListNode *head){
    if (!head || !head -> next)  return head;
    ListNode *pre = new ListNode(-1);
    pre->next = head;
    ListNode *curr = head;
    head = pre;
    while (curr && curr->next){
        ListNode *next = curr->next;
        curr->next = next->next;
        next->next = head->next;
        head->next = next;
    }
    head = head->next;
    delete pre;
    return head;
}

#endif /* reverse_list_h */
