class Solution {
    public int findDuplicate(int[] nums) {
        // linked list cycle in disguise
        // floyds algo, says where beginning of linked list cycle is
        // thing of ints as ptrs; since each num is within range of arr size + 1; each int basically
        // pts to another int; only one repeated ptr
        // T: O(n)
        // S: O(n)
        // 0 can never be start of cycle because range is 1 to n, so start traversal from there

        // find intersection of fast and slow ptrs; then get another slow ptr from start; move both slow 
        // ptrs the same amount; where they meet is the dupe

        int slow = nums[0];
        int fast = nums[0];

        // find intersection
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast){
                break;
            }
        }

        // find entrance to cyle
        int slow2 = nums[0];

        while(slow != slow2){
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
}
