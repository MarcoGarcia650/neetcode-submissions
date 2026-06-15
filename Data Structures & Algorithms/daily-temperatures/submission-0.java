class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // stack monotonic
        // build result arr same length as temps
        // loop through temps
        // while stack is not empty and today is hotter than some previous day we were waiting on
        // pop from stack as prev index int, and fill in result arr with popped prevday where i - prevday
        // result pos = days needed to wait for hotter day, since popping from stack means we found hotter day and need to subtract current prev indice by popping from curr indice, whoch give num of days needed
        // push i to stack if no hotter day found yet
        // return result arr

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
        
    }
}
