class Solution {
    public boolean checkString(String s) {
        int i= 0;
        for( ; i < s.length() ; i++){
            if(s.charAt(i)=='b'){
                i++;
                break;
            }
        }
        if(i==s.length())return true;

        for( ; i < s.length() ; i++){
            if(s.charAt(i)=='a')return false;
        }
        return true;
    }
}