class Solution {
    public static boolean isNumber(char curr){
        if(curr-'0' <= 9 && curr-'0' >=0)return true;
        return false;
    }
    public int myAtoi(String s) {
        if(s.isEmpty())return 0;
       long ans=0;
       boolean sign=false;
       int i = 0 ;

       while ( i < s.length() && s.charAt(i)==' '){i++;}

        if(i < s.length() &&  s.charAt(i)=='-'){
            sign=true;
            i++;
      
        }else  if(i < s.length() &&  s.charAt(i)=='+'){
            sign=false;
            i++;
      
        }
            int max=0;


       for(; i < s.length() ;i++){
        char curr = s.charAt(i);

       if(isNumber(curr)){
            ans*=10;
            ans+=(int)(curr-'0');
        }else{
            break;
        }

         if(ans > Integer.MAX_VALUE){
                max=Integer.MAX_VALUE;
                if(sign){
                    sign=false;
                    max=Integer.MIN_VALUE;
                }
                break;
            }else{
                max=(int)(ans);
               
            }


       }

           
            if(sign)return max*-1;

            return max;

    }
}