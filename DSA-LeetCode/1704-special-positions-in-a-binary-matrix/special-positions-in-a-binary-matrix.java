class Solution {
    public static boolean help(int r , int c , int arr[][]){
        for(int i =0 ; i < arr.length ; i++){
            if(arr[i][c]==1 && i !=r)return false;
        }
        for(int i =0 ; i < arr[0].length ; i++){
            if(arr[r][i]==1 && i !=c)return false;
        }

        return true;

    }
    public int numSpecial(int[][] arr) {
        int ans=0;
     for(int i =0 ;i < arr.length ; i++){
        for(int j =0 ; j < arr[0].length ; j++){
            if(arr[i][j]==1){
                if(help(i,j,arr))ans++;
            }
     }
     }   
     return ans;
    }
}