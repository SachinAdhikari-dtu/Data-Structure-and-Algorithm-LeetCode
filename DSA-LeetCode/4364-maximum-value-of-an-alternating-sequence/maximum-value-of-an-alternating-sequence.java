class Solution {
    public long maximumValue(int n, int s, int m) {
       
        long i=n/2 -1;
        long j = n/2;
        if(i<0)i=0;

        long ans= s+ i*m -j;
        long temp= s + j*m-i;
        if(ans > temp)return ans;
        return temp;
    }
}