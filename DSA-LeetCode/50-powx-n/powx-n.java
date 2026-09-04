class Solution {
        public double help(double x, int n){
            if(n==1)return x;
            if(n==0)return 1;

            double half=help(x,n/2);
            double full=half*half;
            if(n%2!=0){
                full*=x;
            }
            return full;
            
        }
    public double myPow(double x, int n) {
        int sign=1;
       
        double ans=help(x,Math.abs(n));
        if(n<0)return 1.0/ans;
        return ans;
    }
}