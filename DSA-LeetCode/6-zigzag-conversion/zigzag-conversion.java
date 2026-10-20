class Solution {
    public String convert(String s, int n) {
        if(n==1)return s;
      char arr[][]=new char[n][s.length()];  
      int index=0;
      int r=0;
      int c=0;
      while(index < s.length()){

           while(r < n && index < s.length()){
                arr[r++][c]=s.charAt(index++);
            }

            //2 
            r-=2;
            c++;
            while(r >= 0 && index < s.length()){
                arr[r--][c++]=s.charAt(index++);
            }

            r+=2;
            c--;

      }

      StringBuilder sb = new StringBuilder();
      for(int i= 0 ; i < arr.length ; i++){
        for(int j =0 ; j < arr[0].length ; j++){
            if(check(arr[i][j])) sb.append(arr[i][j]);
        }
      }
      return sb.toString();

    }
    public static boolean check(char curr){
        if(curr-'a'>= 0 && curr-'a' <= 26)return true;
        if(curr-'A'>= 0 && curr-'A' <= 26)return true;
        if(curr==',' || curr =='.')return true;
        return false;
    }
}