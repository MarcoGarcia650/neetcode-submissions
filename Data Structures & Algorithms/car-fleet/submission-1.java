class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int[][] cars = new int[position.length][2];

        // pos/ speed pairing
        for(int i = 0; i < position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // sort in by position ascending
        Arrays.sort(cars, (a,b) -> Integer.compare(a[0], b[0]));
        Stack<Double> stack = new Stack<>();

        for(int i = position.length - 1; i >= 0; i--){
            // walk backwards through arr
            // get time to target: distance needed / speed
            double currTime = (double) (target - cars[i][0]) / cars[i][1];

            // if stack is empty or currTime is greater than time of prev fleet time
            // means new fleet made since curr car/ fleet wont catch up to other fleets
            if(stack.isEmpty() || currTime > stack.peek()){
                stack.push(currTime);
            }
        }
        return stack.size();
    }
}
