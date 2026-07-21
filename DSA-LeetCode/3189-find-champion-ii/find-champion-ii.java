class Solution {
    public int findChampion(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(i,0);
            list.add(new ArrayList<>());
        }
        for(int i =0; i < edges.length ; i++){
            int u  = edges[i][0];
            int v  = edges[i][1];
            list.get(u).add(v);
            map.put(v,map.getOrDefault(v,0)+1);
        }

        boolean arr[]=new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for(Integer x:map.keySet()){
            if(map.get(x)==0){
                q.offer(x);
                arr[x]=true;
            }
        }

        if(q.size()==0 || q.size() >=2)return -1;

        return q.poll();

    }
}