class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        // 32 bit integer
        for(int i = 0; i < 32; i++){
            // increment count if rightmost bit is 1
            count += n & 1;
            // move the next bit into the rightmost position
            n = n >>> 1;
        }
        return count;
    }
}
