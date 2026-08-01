class Solution {
    public int[] singleNumber(int[] nums) {
        int ans=0;
        for(int i =0 ; i < nums.length ;i++){
            ans^=nums[i];
        }

        int n=ans&(-ans);
       
        int a=0;
        int b=0;
        for(int i =0 ; i < nums.length ; i++){
            if((n&nums[i])==0){
                a^=nums[i];
            }else{
                b^=nums[i];
            }
        }
        return new int[]{ans^a,ans^b};
    }
}