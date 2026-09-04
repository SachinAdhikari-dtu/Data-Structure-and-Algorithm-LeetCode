class Solution {
    public int maxScore(int[] nums, int k) {
        int sum=0;
        int ans=0;
        int total=0;
        int size=nums.length-k;
        for(int i= 0 ; i< nums.length ; i++){
            total+=nums[i];
        }
        
        for(int i= 0 ; i < size ;i++){
            sum+=nums[i];
        }
       
            ans=Math.max(ans,total-sum);

        for(int i=size ; i < nums.length ;i++){
            sum+=nums[i];
            sum-=nums[i-size];
            ans=Math.max(ans,total-sum);

        }return ans;
    }
}