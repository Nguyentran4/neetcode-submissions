class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(s){
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1); //Note
                        break;

                    case "*" :
                        stack.push(num1 * num2);
                        break;

                    case "/":
                        stack.push(num2 / num1); //Note
                        break;
                }
            } else {
                stack.push(Integer.parseInt(s));
            }

        }

        return stack.peek();
    }
}
