//
//  reverse_even_nodes.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef reverse_even_nodes_h
#define reverse_even_nodes_h

ListNode* Solution::reverseEvenNodes(ListNode *head){
    if(!head || !head->next) return head;
    
    ListNode* evenHead = new ListNode(-1);
    ListNode* evenTail = evenHead;
    ListNode* even = head->next;
    while(even){
        evenTail->next = new ListNode(even->val);
        evenTail = evenTail->next;
        if(even->next)
            even = even->next->next;
        else break;
    }
    ListNode* curr = evenHead->next;
    while (curr && curr->next){
        ListNode *next = curr->next;
        curr->next = next->next;
        next->next = evenHead->next;
        evenHead->next = next;
    }
    ListNode* p = head, *q = evenHead->next;
    while (p && q){
        ListNode *curr_even = q, *curr_odd = p, *next_odd = p->next->next,  *next_even = q->next;
        curr_even->next = NULL;
        curr_odd->next = curr_even;
        curr_even->next = next_odd;
        p = next_odd;
        q = next_even;
    }
    return head;
}

#endif /* reverse_even_nodes_h */
