class Solution {

    public int getValue(char curr){
        if(curr=='I'){
            return 1;
        }else if(curr=='V'){
            return 5;
        }else if(curr=='X'){
            return 10;
        }else if(curr=='L'){
            return 50;
        }else if(curr=='C'){
            return 100;
        }else if(curr=='D'){
            return 500;
        }{
            return 1000;
        } 
    }

    public int romanToInt(String s) {
     int ans=0;
     for(int i= 0 ; i < s.length() ; i++){

        char curr=s.charAt(i);
        int val=getValue(curr);

        if(i+1 < s.length()){
            if(getValue(s.charAt(i+1)) > val){
                i++;
                val=getValue(s.charAt(i)) - val;
            }
        }
        ans+=val;

     }  
     return ans; 
    }
}