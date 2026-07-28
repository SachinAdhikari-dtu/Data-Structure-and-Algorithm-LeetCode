class Solution {
    public String makeGood(String str) {
        Stack<Character> s = new Stack<>();
        for(int i =0 ; i < str.length() ; i++){
            if(!s.isEmpty()){

                char curr=str.charAt(i);
                if(curr <='z' && curr >='a'){
                    char next=(char)((int)(curr-'a')+'A');
                    if(s.peek()==next){
                        s.pop();
                    }else{
                        s.push(curr);
                    }
                }else{
                    char next=(char)((int)(curr-'A')+'a');
                    if(s.peek()==next){
                        s.pop();
                    }else{
                        s.push(curr);
                    }
                }

            }else{
                s.push(str.charAt(i));
            }
        }


        StringBuilder sb = new  StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.reverse().toString();


    }
}