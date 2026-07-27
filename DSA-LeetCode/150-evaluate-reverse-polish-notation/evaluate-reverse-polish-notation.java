class Solution {
    public int evalRPN(String[] str) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String curr = str[i];
            
            if (curr.equals("+")) {
                int a = s.pop();
                int b = s.pop();
                s.push(a + b);
            } 
            else if (curr.equals("*")) {
                int a = s.pop();
                int b = s.pop();
                s.push(a * b);
            } 
            else if (curr.equals("-")) {
                int a = s.pop();
                int b = s.pop();
                s.push(b - a);
            } 
            else if (curr.equals("/")) {
                int a = s.pop();
                int b = s.pop();
                s.push(b / a);
            } 
            else {
                s.push(Integer.valueOf(curr));
            }
        }
        return s.pop();
    }
}