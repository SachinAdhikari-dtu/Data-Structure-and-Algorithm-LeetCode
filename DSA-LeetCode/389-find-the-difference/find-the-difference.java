class Solution {
    public char findTheDifference(String s, String t) {
        int ans=0;
        for(int i=0; i < Math.max(s.length() , t.length()) ;i++){
            if(i <s.length()){
                ans^=(s.charAt(i)-'a');
            }
            if( i < t.length()){
                ans^=(t.charAt(i)-'a');
            }
        }
        return (char)(ans+'a');
    }
}