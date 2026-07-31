class Solution {
   
    public int numSpecial(int[][] arr) {
        int ans=0;
        int row[]=new int[arr.length];
        int col[]=new int[arr[0].length];
     for(int i =0 ;i < arr.length ; i++){
        for(int j =0 ; j < arr[0].length ; j++){
            if(arr[i][j]==1){
                row[i]++;
                col[j]++;
            }
     }
     }   


        for(int i =0 ; i < arr.length ; i++){
            for(int j =0 ; j  < arr[0].length ; j++){
                if(arr[i][j]==1 && row[i]==1 && col[j]==1)ans++;
            }
        }

     return ans;
    }
}