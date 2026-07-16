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
    public ListNode mergeKLists(ListNode[] lists) {
        // two solutions: heap; divide and conquer
        // same time complexity, O(n log k)
        // space, same, but heap carries extra: O(k) vs O(1)
        // Heap says: “Always pick the smallest current node from all lists.”
        // Divide-and-conquer says: “Just keep merging two lists at a time until only one remains.”
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode node : lists){
            if(node != null){
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();

            curr.next = smallest;
            curr = curr.next;

            if(smallest.next != null){
                minHeap.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}
