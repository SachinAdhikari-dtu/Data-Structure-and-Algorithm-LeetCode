class Solution {
    public static boolean check(int r , int c , boolean arr[][]){
        if( r >= arr.length || r <0 || c >= arr[0].length || c < 0  || arr[r][c] )return false;
        return true;
    }

    public static boolean helper( int r , int c , int d[][] ,boolean arr[][] ,int grid[][]){
        arr[r][c]=true;
        boolean ans=true;
        if(r==0 || r == arr.length-1 || c == 0 || c == arr[0].length-1)ans=false;
        for(int i= 0 ; i < 4 ; i++){
            int row= r+d[i][0];
            int col=c+d[i][1];

            if(check(row , col , arr) && grid[row][col] == 0){
                boolean curr=helper(row , col , d , arr, grid);
                if(!curr)ans=false;
            }
        }
        return ans;
    }


    public int closedIsland(int[][] grid) {
        int ans=0;
        boolean arr[][]=new boolean[grid.length][grid[0].length];
        int d[][]={{0,1},{0,-1},{1,0},{-1,0}};

        for(int i= 0 ; i < arr.length ; i++ ){
            for(int j = 0 ; j < arr[0].length ; j++){
                if(!arr[i][j]){
                    if(grid[i][j]==0 &&  helper(i,j,d,arr,grid))ans++;
                }
            }
        }
        return ans;

    }
}