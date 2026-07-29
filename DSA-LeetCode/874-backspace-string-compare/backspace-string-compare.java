class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        int n = s.length();
        int m = t.length();
        for(int i=0 ; i < Math.max(n,m) ;i++ ){
            if(i < n){
                char curr=s.charAt(i);
                if(curr=='#'){
                    if(!sb.isEmpty()) 
                        sb.delete(sb.length()-1,sb.length());
                }else{
                    sb.append(curr);
                }
            }

             if(i < m){
                char curr=t.charAt(i);
                if(curr=='#'){
                    if(!sb2.isEmpty())
                     sb2.delete(sb2.length()-1,sb2.length());
                }else{
                    sb2.append(curr);
                }
            }

        }

        return (sb.toString().equals(sb2.toString()));

    }
}