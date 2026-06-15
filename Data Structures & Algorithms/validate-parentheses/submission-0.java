class Solution {
    public boolean isValid(String s) {
        // stack char
        // loop through s chars
        // if open bracket, push to stack
        // else, check if stack is empty, if yes, return false, edge case handler
        // pop char from stack. if currChar and popped dont match type, false
        // return is stack empty. if stack is empty, successfully found matches and is true

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);

            if(currChar == '[' || currChar == '{' || currChar == '('){
                stack.push(currChar);
            } else {
                if(stack.isEmpty()) return false; //edge case: empty string/ no open brackets

                char popped = stack.pop();
                if(popped == '[' && currChar != ']'){
                    return false;
                }

                if(popped == '{' && currChar != '}'){
                    return false;
                }

                if(popped == '(' && currChar != ')'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
        
    }
}
