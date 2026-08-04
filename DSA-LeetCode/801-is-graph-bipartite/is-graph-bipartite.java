class Solution {
    public static boolean helper(int arr[][] , int visited[] , int color , int curr){
        visited[curr]=color;

        for(int i  =0  ; i < arr[curr].length ; i++){
            int val=arr[curr][i];
            if(visited[val]==-1){
            if(!helper(arr,visited,color^1,val) )return false;

            } else if(visited[val]==visited[curr])return false;
        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        int arr[]=new int[graph.length];
        int color=0;
        Arrays.fill(arr,-1);
        for(int i = 0 ; i < graph.length ; i++ ){
            if(arr[i]!=-1)continue;
            if(!helper(graph,arr,0,i)     )return false;
        }
        return true;
    }
}