class Solution {
    public String addSpaces(String s, int[] sp) {
        int index=0;
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i < s.length() ; i++){
            if( index < sp.length && i==sp[index]){
                sb.append(' ');
                index++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}