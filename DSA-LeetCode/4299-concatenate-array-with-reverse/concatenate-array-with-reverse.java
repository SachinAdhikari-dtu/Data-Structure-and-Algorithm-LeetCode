class Solution {
    public int[] concatWithReverse(int[] nums) {
        int arr[]=new int[nums.length*2];
        int i=0 ;
        int j = nums.length-1;
        int i2=0;
        int j2=nums.length;
        while(i < nums.length){
            arr[i2++]=nums[i++];
            arr[j2++]=nums[j--];
        }
        return arr;
    }
}