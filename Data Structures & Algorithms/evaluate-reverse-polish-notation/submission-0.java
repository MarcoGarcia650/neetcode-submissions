class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            // if string equals operator, pop the last 2 ints
            // a - b
            // b must be poped first to preserve proper order
            if(token.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);

            } else if(token.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);

            } else if(token.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);

            } else if(token.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                // if not operater, push the parsed int
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
        
    }
}
