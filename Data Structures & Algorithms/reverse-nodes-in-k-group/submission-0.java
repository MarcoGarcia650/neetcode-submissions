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

        ListNode dummy = new ListNode(0,head);
        ListNode groupPrev = dummy;

        while(true){
            ListNode kth = getKth(groupPrev, k);

            if(kth == null){
                break;
            }

            ListNode groupNext = kth.next;

            // reverse curr group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while(curr != groupNext){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // reconnect reversed group
            ListNode oldGroupStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k){

        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
