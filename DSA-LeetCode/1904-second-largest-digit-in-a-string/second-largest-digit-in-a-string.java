class Solution {
    public boolean isNumber(char curr){
        if((curr-'0') <= 9 && (curr - '0') >= 0)return true;
        return false;
    }
    public int secondHighest(String s) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MIN_VALUE;
        for(int i=0 ; i  < s.length() ; i++){
            char curr= s.charAt(i);

            if(isNumber(curr)){
                int val=curr-'0';

                if(val > max){
                    min=max;
                    max=val;

                }else if (val > min && val != max){
                    min=val;
                }
            }
        }
        if(min==Integer.MIN_VALUE)return  -1;
        return min;
    }
}