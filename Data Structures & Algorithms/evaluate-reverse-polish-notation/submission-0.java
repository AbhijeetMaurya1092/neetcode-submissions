class Solution {
    public int evalRPN(String[] tokens) {
        int r,l;//left and right.....
        Stack<Integer> stack =new Stack<>();
        for(String token:tokens){
            if(token.equals("+")||
               token.equals("-")||
               token.equals("*")||
               token.equals("/")){
            
            r=stack.pop();
            l=stack.pop();

            if(token.equals("+")){
                stack.push(l+r);
            }
            else if(token.equals("-")){
                stack.push(l-r);
            }
            else if(token.equals("*")){
                stack.push(l*r);
            }
            else if(token.equals("/")){
                stack.push(l/r);
            }
            
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
