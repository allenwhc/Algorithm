//
//  copy_random_pointer_list.h
//  Microsoft(C++)
//
//  Created by Haochen Wang on 6/9/16.
//  Copyright © 2016 Haochen Wang. All rights reserved.
//

#ifndef copy_random_pointer_list_h
#define copy_random_pointer_list_h


RandomListNode* Solution::copyRandom(RandomListNode *head){
    RandomListNode *newHead = NULL;
    map<RandomListNode*, RandomListNode*> mp;
    RandomListNode *p = head;
    while (p){
        newHead = new RandomListNode(p->label);
        mp[p] = newHead;
        p = p->next;
    }
    
    for (map<RandomListNode*, RandomListNode*>::iterator it = mp.begin(); it != mp.end(); it++){
        newHead = it->second;
        newHead->next = mp[it->first->next]==NULL ? NULL : mp[it->first->next];
        newHead->random = mp[it->first->random] == NULL ? NULL : mp[it->first->random];
    }
    return mp[head];
}

#endif /* copy_random_pointer_list_h */
