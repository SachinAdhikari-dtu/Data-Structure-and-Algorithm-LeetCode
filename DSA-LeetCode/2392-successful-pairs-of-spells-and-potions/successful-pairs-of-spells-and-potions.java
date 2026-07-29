class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n =potions.length;
        int ans[]=new int[spells.length];
        for(int i =0  ; i < spells.length ; i++){
            int curr=spells[i];
            int index=binary(curr,success,potions);
            if(index==-1)index=n;
            ans[i]=n-index;
        }
        return ans;
    }

    public int binary(long f , long key , int arr[]){
        int s=0;
        int e=arr.length -1 ;
        int ans=Integer.MAX_VALUE;
        while(s<=e){
            int  m= s + (e-s)/2;
            long curr=arr[m]*f;
            if( curr == key){
                ans=m;
                e=m-1;
            }
            else if( curr > key){
                e=m-1;
            }else{
                s=m+1;
            }
        }
        return Math.min(ans,s);
    }
}