class Solution {
    public int[] concatWithReverse(int[] nums) {
        int arr[]=new int[nums.length*2];
        int i= 0 ;
        for(;i < nums.length ; i++){
            arr[i]=nums[i];
        }
        int j = nums.length-1;
        while(j>=0){
            arr[i++]=nums[j--];
        }
        return arr;
    }
}