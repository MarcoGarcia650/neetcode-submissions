class Solution {
    public int[] plusOne(int[] digits) {
        // math; do addition normally, right to left
        // if digits[i] < 9; add 1 to digits[i] and return digits
        // if all digits = 9, make new res arr size digits.len + 1; fill res[0] with 1 and return

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // if we reach here, it means we didn't hit the above return statement because
        // every digit was 9
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
