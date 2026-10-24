class Solution {
    public int[] plusOne(int[] arr) {
        int i=arr.length-1;
        while(i>=0 ){
            if(arr[i] < 9){
                arr[i]++;
                return arr;
            }
            arr[i--]=0;
        }
        int nums[]=new int[arr.length+1];
        nums[0]=1;
        return nums;
    }
}