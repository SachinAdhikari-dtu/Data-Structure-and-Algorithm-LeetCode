class Solution {
    public int findChampion(int n, int[][] edges) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i,0);
        }
        for(int i =0; i < edges.length ; i++){
            int u  = edges[i][0];
            int v  = edges[i][1];
            map.put(v,map.getOrDefault(v,0)+1);
        }

        Queue<Integer> q = new LinkedList<>();

        for(Integer x:map.keySet()){
            if(map.get(x)==0){
                q.offer(x);
            }
        }

        if(q.size()==0 || q.size() >=2)return -1;

        return q.poll();

    }
}