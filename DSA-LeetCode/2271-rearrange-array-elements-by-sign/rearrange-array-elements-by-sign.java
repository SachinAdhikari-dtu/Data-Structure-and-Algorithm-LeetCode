class Solution {
    public int[] rearrangeArray(int[] nums) {
        int index=0;
        int index2=1;
        int arr[]=new int[nums.length];
        for(int i =0 ; i < nums.length ; i++){
            if(nums[i] >=0){
                arr[index]=nums[i];
                index+=2;
            }else{
                arr[index2]=nums[i];
                index2+=2;
            }
        }
        return arr;
    }
}