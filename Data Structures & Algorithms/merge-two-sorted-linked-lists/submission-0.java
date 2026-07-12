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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // need dummy ptr node to purely pt to start of new merged list
        ListNode dummy = new ListNode();

        // curr will pt to dummy, will be used the a walking var
        ListNode curr = dummy;

        while(list1 != null && list2 != null){
            // attach smallest of the 2 nodes first
            if(list1.val <= list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;  
            }
            // walks forward after smallest node from comparison attached, so no next loop's result is ready
            // to be input ti list
            curr = curr.next;
        }

        // if there's leftover node, attach it to end (sorted so it works logically)
        if(list1 != null){
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        // returns the start
        return dummy.next;
    }
}