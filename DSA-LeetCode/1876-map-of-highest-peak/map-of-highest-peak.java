class Solution {
    public class pair{
        int r ;
        int c;
        int d;
        pair(int r , int c , int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int[][] highestPeak(int[][] isWater) {

        int arr[][]=new int[isWater.length][isWater[0].length];

        for(int i =0 ; i < arr.length ; i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
        }

        int d[][]={{-1,0},{1,0},{0,1},{0,-1}};
         Queue<pair> q = new LinkedList<>();

        for(int i =0 ; i < arr.length; i++){
            for(int j = 0 ; j< arr[0].length ; j++){
                if(isWater[i][j]==1){
                    arr[i][j]=0;
                    q.offer(new pair(i,j,0));
                }
            }
        }




        while(!q.isEmpty()){
            pair p = q.poll();
            int r=p.r;
            int c=p.c;
            int dis=p.d;
        for(int i =0 ; i < d.length ; i++){
            int n=r+d[i][0];
            int m=c+d[i][1];

            if( isValid(n,m,r,c,arr,isWater) && isWater[n][m]==0 ){

               if(arr[n][m] > dis+1){
                arr[n][m]=Math.min(arr[n][m],dis+1);
                q.offer(new pair(n,m,dis+1));
               }
            }
        }
        }

        return arr;
    }



    
    public static boolean isValid(int r , int c  , int row , int col ,int arr[][] , int nums[][]){

        if( r < 0 || c <  0 || r >= arr.length || c >= arr[0].length )return false;

        return true;

    }





}