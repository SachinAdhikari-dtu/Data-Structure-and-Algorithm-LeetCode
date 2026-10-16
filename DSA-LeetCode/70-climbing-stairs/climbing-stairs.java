class Solution {
    public static int climbStairs2(int n , int arr[]){
         if(n==1 || n==0)return 1;
         if(arr[n]!=-1)return arr[n];
        arr[n]= climbStairs2(n-1,arr)+climbStairs2(n-2,arr);
        return arr[n];
    }
    public int climbStairs(int n) {
       int arr[]=new int[n+1];
       Arrays.fill(arr,-1);
       return climbStairs2(n,arr);
    }
}