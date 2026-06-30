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
            // walke backwards through arr
            // get time to target: distance needed / speed
            double time = (double) (target - cars[i][0]) / cars[i][1];

            stack.push(time);

            // if stack gets to size 2 or bigger
            if(stack.size() >= 2){
                // curr is last time to target
                double current = stack.pop();
                // ahead is next time to target
                double ahead = stack.peek();

                if(current <= ahead){
                    // current car joins the fleet ahead as it would've arrive faster if not for single lane
                    // already been popped so no need for anything else
                } else {
                    stack.push(current);
                    // curr car arrives later other fleet, make new fleet
                }
            }
        }
        return stack.size();
    }
}
