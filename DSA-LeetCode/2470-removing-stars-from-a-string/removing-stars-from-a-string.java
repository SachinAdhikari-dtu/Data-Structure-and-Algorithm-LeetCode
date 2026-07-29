class Solution {
    public String removeStars(String str) {
        Stack<Character> s = new Stack<>();
        for(int i =0 ; i < str.length() ; i++){
            char curr=str.charAt(i);
            if(curr=='*'){
                if(!s.isEmpty()){
                    s.pop();
                }
                
            }else{
                s.push(curr);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.reverse().toString();

    }
}