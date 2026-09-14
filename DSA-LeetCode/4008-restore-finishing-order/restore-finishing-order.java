class Solution {
    public static boolean istrue(int arr[] , int key){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(arr[m]==key)return true;
            else if(arr[m] > key){
                e=m-1;
            }else{
                s=m+1;
            }
            
        }
        return false;
    }
    public int[] recoverOrder(int[] arr, int[] friends) {
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = 0 ;i < arr.length ; i++){
            if(istrue(friends,arr[i]))l.add(arr[i]);
        }

        int nums[]=new int[l.size()];
        for(int i =0 ; i < nums.length ; i++){
            nums[i]=l.get(i);
        }
        return nums;
        
    }
}