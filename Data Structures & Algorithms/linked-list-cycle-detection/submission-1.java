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
    public boolean hasCycle(ListNode head) {
        // strat: 
        // fast and slow ptr
        // fast ptr = curr.next. next
        // slow ptr = curr.next
        // if slow == fast, theyve met due to cycle, true

        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) return true;
        }
        return false;
        
    }
}
