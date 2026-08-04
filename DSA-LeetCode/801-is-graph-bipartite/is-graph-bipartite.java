class Solution {

    public boolean isBipartite(int[][] graph) {
        int arr[]=new int[graph.length];
        Queue<Integer> q = new LinkedList<>();
        int color=0;
        Arrays.fill(arr,-1);
        for(int i = 0 ; i < graph.length ; i++ ){
            if(arr[i]!=-1)continue;
            q.offer(i);
             arr[i]=color;
            while(!q.isEmpty()){
                  int prev=q.poll();
                int size=q.size();
                for(int  j = 0 ; j < graph[prev].length ; j++){
                    int curr=graph[prev][j];
                    if(-1==arr[curr]){
                        arr[curr]=arr[prev]^1;
                        q.offer(curr);
                    }else if(arr[curr]==arr[prev])return false;
                }
            }
        }
        return true;
    }
}