/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        /*
        Use a dummy before head.
        Find the kth node from the current group.
        Save the node after the group.
        Reverse the group.
        Connect the reversed group back into the list.
        Move to the next group.
        */

        // need dummy head
        ListNode dummy = new ListNode(0,head);
        // saves start of group
        ListNode groupPrev = dummy;

        while(true){
            // finds kth node after curr group only if valid; if null (size < k); that group will be left as is
            ListNode kth = getKth(groupPrev, k);

            if(kth == null){
                break;
            }

            // saves start of next group
            ListNode groupNext = kth.next;

            // prev starts as groupNext so the old group head will point
            // to the node after the group once reversal is done.
            ListNode prev = groupNext;
            // curr will be used to travese curr group starting from last group . next aka start of this group
            ListNode curr = groupPrev.next;

            // reverse curr group size until it hits kth.next 
            while(curr != groupNext){
                ListNode next = curr.next;  // save next node
                curr.next = prev;           // reverses currs ptr backward
                prev = curr;                // moves prev up
                curr = next;                // moves curr up

            }

            // reconnect reversed group
            ListNode oldGroupStart = groupPrev.next;    // saves original group start
            groupPrev.next = kth;                       // connects previos list part to new head of reversed list
            groupPrev = oldGroupStart;                  // move groupPrev to tail of reversed group
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k){
        
        // traverse k nodes if nodes valid, returns that node as kth node
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
